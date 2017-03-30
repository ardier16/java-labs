package ua.nure.shopynskyi.Task1;

public class Part1 {

    public static void main(String[] args) {
        int num1;
        int num2;

        if (args.length < 2) {
            System.out.println("Wrong input data");
            return;
        }

        try {
            num1 = Integer.parseInt(args[0]);
            num2 = Integer.parseInt(args[1]);

            System.out.println(gcd(num1, num2));
        } catch (NumberFormatException e) {
            System.out.println("Wrong input data");
        }
    }

    private static int gcd(int num1, int num2) {
        int firstNum = num1;
        int secondNum = num2;

        while (secondNum != 0) {
            int temp = firstNum % secondNum;
            firstNum = secondNum;
            secondNum = temp;
        }

        return firstNum;
    }
}