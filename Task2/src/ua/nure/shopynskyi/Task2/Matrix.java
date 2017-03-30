package ua.nure.shopynskyi.Task2;

import java.lang.*;

public class Matrix {

    private int rows;
    private int cols;
    private double[][] array;

    public Matrix(double[][] array) {
        this.rows = array.length;
        this.cols = array[0].length;
        this.array = array.clone();
    }

    public static void main(String[] args) {

        Matrix m = new Matrix(new double[][]{{1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0}});

        Matrix m2 = new Matrix(new double[][]{{1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0}});
        System.out.println("~~~ m");
        m.print();
        System.out.println("~~~ m2");
        m2.print();
        System.out.println("~~~ transpose m");
        m.transpose();
        m.print();
        System.out.println("~~~ mul m on m2");
        m.mul(m2);
        m.print();
        System.out.println("~~~ mul m2 on 2");
        m2.mul(2);
        m2.print();
        System.out.println("~~~ add m2 to m2");
        m2.add(m2);
        m2.print();

    }

    public void print() {
        System.out.println(this);
    }

    public void transpose() {
        double[][] temp = new double[this.cols][this.rows];

        for (int i = 0; i < this.rows; i++)
            for (int j = 0; j < this.cols; j++)
                temp[j][i] = this.array[i][j];

        this.array = temp.clone();
        this.rows = this.array.length;
        this.cols = this.array[0].length;
    }

    public void mul(double x) {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.array[i][j] *= x;
            }
        }
    }

    public void mul(Matrix m) throws IllegalArgumentException {
        if (this.cols == m.rows) {
            double[][] temp = new double[this.rows][m.cols];

            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < m.cols; j++) {
                    for (int k = 0; k < m.rows; k++) {
                        temp[i][j] += this.array[i][k] * m.array[k][j];
                    }
                }
            }

            this.array = temp.clone();
        } else {
            throw new IllegalArgumentException("First matrix columns count is " +
                    "not equal to second matrix rows count");
        }
    }

    public void add(Matrix m) throws IllegalArgumentException {
        if (this.cols == m.cols && this.rows == m.rows) {
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.cols; j++) {
                    this.array[i][j] += m.array[i][j];
                }
            }
        } else {
            throw new IllegalArgumentException("Matrices sizes are not equal");
        }
    }

    @Override
    public String toString() {
        String result = "";

        for (double[] arr : this.array) {
            for (double num : arr) {
                result += num + " ";
            }
            result += "\n";
        }

        return result;
    }
}
