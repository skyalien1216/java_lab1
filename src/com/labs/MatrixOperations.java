package com.labs;

import java.util.Arrays;

public class MatrixOperations {

    public static double[][] cofactor(double[][] matrix, int n, int m) {
        int N = matrix.length;
        int M = matrix[0].length;

        double[][] newElements = new double[N - 1][M - 1];

        for (int i = 0; i < newElements.length; i++) {
            if (i < n - 1) {
                for (int j = 0; j < newElements[i].length; j++) {
                    if (j < m - 1)
                        newElements[i][j] = matrix[i][j];
                    else
                        newElements[i][j] = matrix[i][j + 1];
                }
            } else {
                for (int j = 0; j < newElements[i].length; j++) {
                    if (j < m - 1)
                        newElements[i][j] = matrix[i + 1][j];
                    else
                        newElements[i][j] = matrix[i + 1][j + 1];
                }
            }
        }
        return newElements;
    }

    public static double determinant(double[][] matrix){
        if (matrix.length == 2)
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        double result = 0;
        int num = matrix.length;
        double[] nums = new double[num];

        for (int i = 0; i < num; i++) {
            if (i % 2 == 0)
                nums[i] = matrix[0][i] * determinant(cofactor(matrix, 1, i + 1));
            else
                nums[i] = -matrix[0][i] * determinant(cofactor(matrix, 1, i + 1));
        }
        for (int i = 0; i < num; i++)
            result += nums[i];

        return result;
    }

    public static double[][] inverseMatrix(double[][] matrix){
        double A = determinant(matrix);
        if(A == 0) return null;
        int n = matrix.length;
        double[][] newElements = new double[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                double num;
                if ((i + j) % 2 == 0)
                    num = determinant(cofactor(matrix, i + 1, j + 1));
                else
                    num = -determinant(cofactor(matrix, i + 1, j + 1));
                newElements[i][j] = num / A;
            }

        newElements = transpose(newElements);
        return newElements;
    }

    public static double[][] transpose(double[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        double newElements[][] = new double[m][n];

        for (int i =0; i < n; i++)
            for(int j =0; j < m; j++)
                newElements[j][i] = matrix[i][j];

        return newElements;
    }

    public static double[][] add(double[][] a, double[][] b) {
        if (a.length == 0) return b;
        if (b.length == 0) return a;

        int n = a.length;
        int m = a[0].length;

        double[][] c = new double[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                c[i][j] = a[i][j] + b[i][j];

        return c;
    }

    public static double[][] add(double[][] a, double num) {
        if (a.length == 0) return null;
        int n = Math.min(a.length, a[0].length);
        double[][] c = Arrays.copyOf(a, a.length);

        for(int i = 0; i < n; i++)
            c[i][i] += num;

        return c;
    }

    public static double[][] multiply(double num, double[][] a){
        if (a.length == 0) return null;
        double[][] newA = new double[a.length][a[0].length];

        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                newA[i][j] = num * a[i][j];

        return  newA;
    }

    public static double[][] multiply(double[][] a, double[][] b) {
        if (a.length == 0) return null;
        if (b.length == 0) return null;
        int aRows = a.length;
        int aColumns = a[0].length;
        int bRows = b.length;
        int bColumns = b[0].length;

        if (aColumns != bRows)
            return null;

        double[][] c = new double[aRows][bColumns];
        for (int i = 0; i < aRows; i++)
            for (int j = 0; j < bColumns; j++)
                for (int k = 0; k < aColumns; k++)
                    c[i][j] += a[i][k] * b[k][j];
        return c;
    }
}
