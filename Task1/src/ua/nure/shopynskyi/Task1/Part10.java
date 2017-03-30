package ua.nure.shopynskyi.Task1;

public class Part10 {

    public static void main(String[] args) {
        int[][] array;

        if (args.length < 1) {
            System.out.println("Wrong input data");
            return;
        }

        try {
            array = new int[Integer.parseInt(args[0])][];

            fillArray(array);
            printArray(array);
        } catch (NumberFormatException e) {
            System.out.println("Wrong input data");
        }

    }

    private static void fillArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = new int[i+1];
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if ((j == 0) || (j == array[i].length - 1)) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
                }
            }
        }
    }

    private static void printArray(int[][] arr) {
        for (int[] elem: arr) {
            for (int e: elem) {
                System.out.print(e + " ");
            }

            System.out.println();
        }
    }
}