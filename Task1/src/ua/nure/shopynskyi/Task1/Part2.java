package ua.nure.shopynskyi.Task1;

public class Part2 {

    public static void main(String[] args) {
        int num;

        if (args.length < 1) {
            System.out.println("Wrong input data");
            return;
        }

        try {
            num = Integer.parseInt(args[0]);

            System.out.println(sumDigits(num));
        } catch (NumberFormatException e) {
            System.out.println("Wrong input data");
        }

    }

    static int sumDigits(int number) {
        int sum = 0;
        int num = number;

        if (num < 0) {
            num = -num;
        }

        while (num > 0) {
            sum += num % 10;
            num = (num) / 10;
        }

        return sum;
    }
}