package ua.nure.shopynskyi.Task1;

public class Part6 {

    public static void main(String[] args) {
        int[] array;

        if (args.length < 1) {
            System.out.println("Wrong input data");
            return;
        }

        try {
            array = new int[Integer.parseInt(args[0])];
            fibbonaci(array);
            printArray(array);
            System.out.println();
        }
        catch (NumberFormatException e) {
            System.out.println("Wrong input data");
        }

    }

    private static void fibbonaci(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i < 2) {
                array[i] = 1;
            } else {
                array[i] = array[i-1] + array[i-2];
            }
        }
    }

    static void printArray(int[] arr) {
        for (int el: arr) {
            System.out.print(el + " ");
        }
    }
}