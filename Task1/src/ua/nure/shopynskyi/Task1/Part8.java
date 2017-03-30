package ua.nure.shopynskyi.Task1;

public class Part8 {

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
            char[][] arr = new char[num1][num2];

            fillArray(arr);
            printArray(arr);
        } catch (NumberFormatException e) {
            System.out.println("Wrong input data");
        }
    }

    private static void fillArray(char[][] array) {
        boolean switcher = true;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (switcher) {
                    array[i][j] = 'Ч';
                } else {
                    array[i][j] = 'Б';
                }
                switcher = !switcher;
            }
        if (array[i].length % 2 == 0) {
            switcher = !switcher;
        }
        }
    }

    private static void printArray(char[][] array) {
        for (char[] arr1: array) {
            for (char el: arr1) {
                System.out.print(el);
            }
            System.out.println();
        }
    }
}