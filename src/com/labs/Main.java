package com.labs;

public class Main {

    public static void main(String[] args) {
	    System.out.println("");

//        ArrayWrapper aw = new ArrayWrapper();
//        aw.resize(3,4);
//
//        aw.SetElementAt(2,3,1);
//        System.out.println(aw.GetElementAt(2,3));

/*        Matrix aw = new Matrix(2,5);

        if (!aw.setElementAt(1,3,4))
            System.out.println("ffdsdad");

        System.out.println(aw.getElementAt(1,3));

        aw.setElementAt(3,1,44);
        aw.setElementAt(2,2,444);

        System.out.println(aw.toString());
        System.out.println();
        aw.setElements(aw.transpose());
        System.out.println(aw.toString());

        System.out.println(aw.getElementAt(2,2));
        aw.swapElements(2,2,1,2);
        System.out.println(aw.toString());*/

        double[][] tmp = {{2,5,7},{6,3,4},{5,-2,-3}};
        //double[][] tmp2 = {{2.5,3,4},{5,8,9},{4,4,4}};
        Matrix m = new Matrix(tmp);
        m.setElements(m.inverseMatrix());
        //System.out.println(m.determinant());
        System.out.println(m.toString());

    }
}
