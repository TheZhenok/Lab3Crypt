import java.util.Scanner;

public class Main {

    static int modInverse(int a, int m)
    {
        a = a % m;
        for (int x = 1; x < m; x++)
            if ((a * x) % m == 1)
                return x;
        return 1;
    }

    public static int[] evclid(int firstInt, int secondInt){
        if (secondInt == 0)
            return new int[] { firstInt, 1, 0 };
        int[] vals = evclid(secondInt, firstInt % secondInt);
        int x = vals[0];
        int y = vals[2];
        int c = vals[1] - (firstInt / secondInt) * vals[2];
        return new int[] { x, y, c };
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter first number: ");
            int firstInt = scanner.nextInt();
            if(firstInt != 0 || firstInt < 0){
                System.out.println("Enter second number: ");
                int secondInt = scanner.nextInt();
                if(secondInt != 0 || secondInt < 0){
                    int values[] = evclid(firstInt, secondInt);
                    System.out.println("NOD " + firstInt + ", and " + secondInt + " = " + values[0]);
                    System.out.println("x = " + values[1] + " y = " + values[2]);
                    System.out.println("-----------------");
                    if(modInverse(firstInt, secondInt) == 1)
                        System.err.println("The numbers must be simple");
                    else
                        System.out.println("Inversion: " + modInverse(firstInt, secondInt));
                }
                else System.err.println("Please, enter number > 0");
            }
            else System.out.println("Please, enter number < 0");


        }catch (Exception e){
            System.err.println("Enter number!");
        }
    }
}
