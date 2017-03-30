package ua.nure.shopynskyi.Task1;

public class Part3 {

    public static void main(String[] args) {
        int num;

        if (args.length < 1) {
            System.out.println("Wrong input data");
            return;
        }

        try {
            num = Integer.parseInt(args[0]);

            System.out.println(isPrime(num));
        } catch (NumberFormatException e) {
            System.out.println("Wrong input data");
        }
    }

    static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
