package ua.nure.shopynskyi.Task1;

public class Part7 {

    public static void main(String[] args) {
        int[] array;

        if (args.length < 1) {
            System.out.println("Wrong input data");
            return;
        }

        try {
            array = new int[Integer.parseInt(args[0])];

            fillPrimes(array);
            Part6.printArray(array);

            System.out.println();
        } catch (NumberFormatException e) {
            System.out.println("Wrong input data");
        }
    }

    private static void fillPrimes(int[] n) {
        int firstPrime = 2;

        for (int i = 0; i < n.length; ) {
            if (Part3.isPrime(firstPrime)) {
                n[i] = firstPrime;
                i++;
            }

            firstPrime++;
        }
    }
}