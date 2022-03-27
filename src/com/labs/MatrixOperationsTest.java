package com.labs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MatrixOperationsTest {

    @Test
    void cofactor() {
        double[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        var newMatrix = MatrixOperations.cofactor(matrix, 1,1);
        System.out.println(Arrays.deepToString(newMatrix));
        assertArrayEquals(new double[]{5, 6}, newMatrix[0]);
        assertArrayEquals(new double[]{8,9}, newMatrix[1]);
    }

    @Test
    void determinant() {
        double[][] matrix = {{2,2,3},{4,5,6},{7,8,9}};
        assertEquals(-3,MatrixOperations.determinant(matrix));
    }

    @Test
    void inverseMatrix() {
        double[][] matrix = {{-1,1,1},{1,-1,1},{1,1,-1}};
        var newMatrix = MatrixOperations.inverseMatrix(matrix);
        assertArrayEquals(new double[]{0, 0.5, 0.5}, newMatrix[0]);
        assertArrayEquals(new double[]{0.5, 0, 0.5}, newMatrix[1]);
        assertArrayEquals(new double[]{0.5, 0.5, 0}, newMatrix[2]);
    }

    @Test
    void transpose() {
        double[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        var newMatrix = MatrixOperations.transpose(matrix);
        assertArrayEquals(new double[]{1,4,7}, newMatrix[0]);
        assertArrayEquals(new double[]{2,5,8}, newMatrix[1]);
        assertArrayEquals(new double[]{3,6,9}, newMatrix[2]);
    }

    @Test
    void addNum() {
        double[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        var newMatrix = MatrixOperations.add(matrix, -2);
        assertArrayEquals(new double[]{-1,2,3}, newMatrix[0]);
        assertArrayEquals(new double[]{4,3,6}, newMatrix[1]);
        assertArrayEquals(new double[]{7,8,7}, newMatrix[2]);
    }

    @Test
    void addMatrices() {
        double[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        var newMatrix = MatrixOperations.add(matrix, MatrixOperations.transpose(matrix));
        assertArrayEquals(new double[]{2,6,10}, newMatrix[0]);
        assertArrayEquals(new double[]{6,10,14}, newMatrix[1]);
        assertArrayEquals(new double[]{10,14,18}, newMatrix[2]);
    }

    @Test
    void multiplyNum() {
        double[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        var newMatrix = MatrixOperations.multiply(-2, matrix);
        assertArrayEquals(new double[]{-2,-4,-6}, newMatrix[0]);
        assertArrayEquals(new double[]{-8,-10,-12}, newMatrix[1]);
        assertArrayEquals(new double[]{-14,-16,-18}, newMatrix[2]);
    }

    @Test
    void MultiplyMatrices() {
        double[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        var newMatrix = MatrixOperations.multiply(matrix, MatrixOperations.transpose(matrix));
        assertArrayEquals(new double[]{14,32,50}, newMatrix[0]);
        assertArrayEquals(new double[]{32,77,122}, newMatrix[1]);
        assertArrayEquals(new double[]{50,122,194}, newMatrix[2]);
    }
}