package ua.nure.shopynskyi.Task1;

public class Part4 {

    public static void main(String[] args) {
        int num;

        if (args.length < 1) {
            System.out.println("Wrong input data");
            return;
        }

        try {
            num = Integer.parseInt(args[0]);

            System.out.println(sumFactorial(num));
        }
        catch (NumberFormatException e) {
            System.out.println("Wrong input data");
        }

    }

    private static int sumFactorial(int num) {
        if (num < 1) {
            return -1;
        }

        int sum = 0;
        int switcher = -1;

        for (int i = 1; i <= num; i++) {
            switcher *= -i;
            sum += switcher;
        }

        return sum;
    }
}