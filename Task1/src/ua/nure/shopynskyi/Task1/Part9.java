package ua.nure.shopynskyi.Task1;

public class Part9 {

    public static void main(String[] args) {
        int[][][][][] array = new int[2][2][2][2][2];

        fillArray(array);
        System.out.println();
    }

    private static void fillArray(int[][][][][] array) {
        for (int i = 0; i < 32; i++) {
            array[(i >> 4) % 2][(i >> 3) % 2]
                    [(i >> 2) % 2][(i >> 1) % 2]
                    [i % 2] = i + 1;
            System.out.print(i + 1 + " ");
        }
    }
}