package com.labs;

import java.util.Arrays;

public class Matrix {
    private double[][] elements;

    public Matrix(double[][] elements) {
        this.elements = elements;
    }

    public Matrix() {
        this.elements = new double[0][0];
    }

    public Matrix(int i, int j)  { this.elements = new double[i][j];}

    public boolean isInitialised() {
        return elements.length != 0;
    }

    public int getRows() { return elements.length; }

    public int getColumns() {
        if (isInitialised())
            return elements[0].length;
        else
            return 0;
    }

    public void resize(int iNew, int jNew){
        if(!isInitialised()) {
            elements = new double[iNew][jNew];
        }
        else {
            double newElements[][] = new double[iNew][jNew];
            int n = elements.length;
            int m = elements[0].length;

            int nNew = Math.min(iNew, n);
            int mNew = Math.min(jNew, m);

            for (int i =0; i < nNew; i++)
                for(int j = 0; j < mNew; j++)
                    newElements[i][j] = elements[i][j];

            elements = newElements;
        }
    }

    public void clearAllElements()
    {
        if(isInitialised())
            elements = new double[elements.length][elements[0].length];
    }

    public void swapElements(int i1, int j1, int i2, int j2)
    {
        try {
            double el1 = elements[i1][j1];
            double el2 = elements[i2][j2];
            elements[i1][j1] = el2;
            elements[i2][j2] = el1;
        }
        catch (RuntimeException re) {
            return;
        }
    }

    public boolean findElement(double a) {
        for (double[] element : elements)
            if (Arrays.stream(element).anyMatch(x -> x == a))
                return true;
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sEl= new StringBuilder();
        if(isInitialised())
        {
            int n = elements.length, m = elements[0].length;
            for (double[] element : elements) {
                sEl.append("\n");
                for (int j = 0; j < m; j++)
                    sEl.append(element[j]).append(" \t");
            }
        }

        return "ArrayWrapper{" +
                "elements=" + sEl +
                '}';
    }

    public boolean setElementAt(int indexI, int indexJ, double element) {
        try {
            elements[indexI][indexJ] = element;
            return true;
        }
        catch (RuntimeException re) {
            return false;
        }
    }

    public Object getElementAt(int indexI, int indexJ) {
        try {
            return elements[indexI][indexJ];
        }
        catch (RuntimeException re) {
            return null;
        }
    }

    public void setElements(double[][] elems) {
        this.elements = elems;
    }

    public double[][] getElements() {
        return elements;
    }

    public double[][] transpose()
    {
        return MatrixOperations.transpose(elements);
    }

    public double[][] inverseMatrix()
    {
        return MatrixOperations.inverseMatrix(elements);
    }

    public double determinant() {
        return MatrixOperations.determinant(elements);
    }

    public double[][] add(double num){
        return MatrixOperations.add(elements, num);
    }

    public double[][] add(double[][] b){
        return MatrixOperations.add(elements, b);
    }

    public double[][] multiply(double num){
        return MatrixOperations.multiply(num, elements);
    }

    public double[][] multiply(double[][] b){
        return MatrixOperations.multiply(elements, b);
    }
}
