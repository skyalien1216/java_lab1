package com.labs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void isNOTInitialised() {
        var matrix = new Matrix();
        assertFalse(matrix.isInitialised());
    }

    @Test
    void isInitialised() {
        var matrix = new Matrix(2,2);
        assertTrue(matrix.isInitialised());
    }

    @Test
    void testEquals() {
        double[][] tmp = {{2,5,7},{6,3,4},{5,-2,-3}};
        Matrix matrix2 = new Matrix(tmp);
        Matrix matrix1 = new Matrix();
        assertFalse(matrix1.equals(matrix2));
        matrix1.setElements(tmp);
        assertTrue(matrix1.equals(matrix2));
        matrix1.setElementAt(0,0,-1);
        assertFalse(matrix1.equals(matrix2));
        matrix2.setElements(new double[0][0]);
        assertFalse(matrix1.equals(matrix2));
    }

    @Test
    void findElement() {
        double[][] tmp = {{2,5,7},{6,3,4},{5,-2,-3}};
        Matrix matrix = new Matrix(tmp);
        assertFalse(matrix.findElement(-1));
        assertTrue(matrix.findElement(-3));
    }

    @Test
    void setElementAt() {
        var matrix = new Matrix(2,2);
        assertFalse(matrix.setElementAt(-1,0, 4));
        assertTrue(matrix.setElementAt(1,0,4));
    }

    @Test
    void getElementAt() {
        var matrix = new Matrix(2,2);
        assertNull(matrix.getElementAt(-1,0));
        assertEquals(0.0,matrix.getElementAt(1,0));
    }

    @Test
    void swapElements() {
        double[][] tmp = {{2,5,7},{6,3,4},{5,-2,-3}};
        var matrix = new Matrix(tmp);
        // swapping 2 and 4
        matrix.swapElements(0,0,1,2);
        assertEquals(2.0, matrix.getElementAt(1,2));
        assertEquals(4.0, matrix.getElementAt(0,0));
    }

    @Test
    void resize() {
        var matrix = new Matrix(5,5);
        assertEquals(5,matrix.getColumns());
        matrix.resize(-1,0);
        assertEquals(5,matrix.getColumns());
        matrix.resize(6,2);
        assertEquals(6,matrix.getRows());
        assertEquals(2,matrix.getColumns());
    }
}