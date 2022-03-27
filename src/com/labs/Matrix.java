package com.labs;

import java.util.Arrays;

/**
 * Matrix wrapper class.
 */
public class Matrix {
    private double[][] elements;

    /**
     * Creates a matrix and sets the elements.
     * @param elements elements of the new matrix
     */
    public Matrix(double[][] elements) {
        var n = elements.length;
        if(n == 0)
        {
            this.elements = new double[0][0];
            return;
        }
        this.elements = new double[elements.length][elements[0].length];
        for(var i = 0; i < n; i++)
            this.elements[i] = Arrays.copyOf(elements[i], elements[i].length);
    }

    /**
     * Creates an empty matrix, size 0x0.
     */
    public Matrix() {
        this.elements = new double[0][0];
    }

    /**
     * Creates an empty matrix, size ixj.
     * @param i - number of rows
     * @param j - number of columns
     */
    public Matrix(int i, int j)  { this.elements = new double[i][j];}

    public boolean isInitialised() {
        return elements.length != 0;
    }

    /**
     *
     * @return int - number of rows
     */
    public int getRows() { return elements.length; }

    /**
     *
     * @return int - number of columns
     */
    public int getColumns() {
        if (isInitialised())
            return elements[0].length;
        else
            return 0;
    }

    /**
     *Resize the matrix.
     * @param iNew new number of rows
     * @param jNew new number of columns
     */
    public void resize(int iNew, int jNew){
        if(!isInitialised()) {
            elements = new double[iNew][jNew];
            return;
        }
        if (iNew < 0 || jNew < 0)
            return;

        double newElements[][] = new double[iNew][jNew];
        int n = elements.length;
        int m = elements[0].length;

        int nNew = Math.min(iNew, n);
        int mNew = Math.min(jNew, m);

        for (int i =0; i < nNew; i++)
            System.arraycopy(elements[i], 0, newElements[i], 0, mNew);

        elements = newElements;

    }

    /**
     * Compares 2 matrices by their elements.
     * @param m2 second matrix
     * @return true if matrices are equal, false otherwise
     */
    public boolean equals(Matrix m2)
    {
        double[][] m2Elems = m2.getElements();
        if(!isInitialised() || !m2.isInitialised())
            return false;

        int n = elements.length, m = elements[0].length;

        if(n != m2.getRows() || m != m2.getColumns())
            return false;

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(elements[i][j] != m2Elems[i][j])
                    return false;

        return true;
    }

    /**
     * Makes all the elements of the matrix equal to 0
     */
    public void clearAllElements()
    {
        if(isInitialised())
            elements = new double[elements.length][elements[0].length];
    }

    /**
     * Swaps 2 elements of the matrix
     * @param i1 row index of the first element
     * @param j1 column index of the first element
     * @param i2 row index of the second element
     * @param j2 column index of the second element
     */
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

        return "Matrix{" +
                "elements=" + sEl +
                '}';
    }

    /**
     * Searches for an element in the matrix
     * @param a element that we are searching for
     * @return false if the element isn't in the matrix, true otherwise
     */
    public boolean findElement(double a) {
        for (double[] element : elements)
            if (Arrays.stream(element).anyMatch(x -> x == a))
                return true;
        return false;
    }

    /**
     * Sets an element at a certain index
     * @param indexI row index
     * @param indexJ column index
     * @param element element to set
     * @return true if the element is set successfully, false otherwise
     */
    public boolean setElementAt(int indexI, int indexJ, double element) {
        try {
            elements[indexI][indexJ] = element;
            return true;
        }
        catch (RuntimeException re) {
            return false;
        }
    }

    /**
     * Gets an element at a certain index
     * @param indexI row index
     * @param indexJ column index
     * @return null if the index is out of range, double otherwise
     */
    public Object getElementAt(int indexI, int indexJ) {
        try {
            return elements[indexI][indexJ];
        }
        catch (RuntimeException re) {
            return null;
        }
    }

    /**
     * Sets all the elements of the matrix
     * @param elems elements to set
     */
    public void setElements(double[][] elems) {
        var n = elems.length;
        if(n == 0)
        {
            this.elements = new double[0][0];
            return;
        }
        this.elements = new double[elems.length][elems[0].length];
        for(var i = 0; i < n; i++)
            this.elements[i] = Arrays.copyOf(elems[i], elems[i].length);
    }

    /**
     * Gets all the elements of the matrix
     * @return the matrix
     */
    public double[][] getElements() {
        return elements;
    }

    /**
     * Transposes the matrix
     * @return transposed matrix
     */
    public double[][] transpose()
    {
        return MatrixOperations.transpose(elements);
    }

    /**
     * Inverts the matrix
     * @return inverted matrix
     */
    public double[][] inverseMatrix()
    {
        return MatrixOperations.inverseMatrix(elements);
    }

    /**
     * Сalculates the determinant
     * @return double - determinant
     */
    public double determinant() {
        return MatrixOperations.determinant(elements);
    }

    /**
     * Adds the identity matrix multiplied by the number.
     * @param num number that identity matrix will be multiplied by
     * @return matrix after addition
     */
    public double[][] add(double num){
        return MatrixOperations.add(elements, num);
    }

    /**
     * Add 2 matrices together
     * @param b second matrix
     * @return matrix after addition
     */
    public double[][] add(Matrix b){
        return MatrixOperations.add(elements, b.getElements());
    }

    /**
     * Multiply matrix by number
     * @param num number to be multiplied by
     * @return matrix after multiplication
     */
    public double[][] multiply(double num){
        return MatrixOperations.multiply(num, elements);
    }

    /**
     * Multiply 2 matrices
     * @return matrix after multiplication
     */
    public double[][] multiply(Matrix b){
        return MatrixOperations.multiply(elements, b.getElements());
    }
}
