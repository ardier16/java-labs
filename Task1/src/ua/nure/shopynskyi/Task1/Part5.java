package ua.nure.shopynskyi.Task1;

public class Part5 {

    public static void main(String[] args) {
        int num;

        if (args.length < 1) {
            System.out.println("Wrong input data");
            return;
        }

        try {
            num = Integer.parseInt(args[0]);

            System.out.println(happyNumsCount(num));
        } catch (NumberFormatException e) {
            System.out.println("Wrong input data");
        }

    }

    private static int happyNumsCount(int num) {
        if (num < 1 || num % 2 != 0) {
            return -1;
        }

        int count = 0;

        for (int i = powerDecimal(num-1); i < powerDecimal(num); i++) {
            int b = i % powerDecimal(num/2);
            int a = (i - b) / powerDecimal(num/2);

            if (Part2.sumDigits(a) == Part2.sumDigits(b)) {
                count++;
            }
        }

        return count;
    }

    private static int powerDecimal(int power) {
        int result = 1;

        for (int i = 0; i < power; i++) {
            result *= 10;
        }

        return  result;
    }
}