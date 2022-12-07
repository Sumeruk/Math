package Math;

import Math.matrix.Matrix;
import Math.matrix.Matrix4F;
import Math.vector.Vector;
import Math.vector.Vector2F;
import Math.vector.Vector3F;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Vector v1 = new Vector2F(0, -7);
        Vector v2 = new Vector2F(5, 5);

        Vector v3 = new Vector3F(2,-3,-1);
        Vector v4 = new Vector3F();


        System.out.println(Arrays.toString(v3.divisionVectorOnScalar(v3, 3).getValues()));
        System.out.println(Arrays.toString(v3.getValues()));

        double[][] test = {{1,2,3, 4},
                            {5,6,7,8},
                            {9,10,11,12},
                            {13,14,15,16}};

        Matrix matrix = new Matrix4F(test);

        for(int i = 0; i < test.length; i++){
            for (int j = 0; j < test.length; j++){
                System.out.print(matrix.getValues()[i][j] + " ");
            }
            System.out.println();
        }

        matrix = matrix.transposition(matrix);
        for(int i = 0; i < test.length; i++){
            for (int j = 0; j < test.length; j++){
                System.out.print(matrix.getValues()[i][j] + " ");
            }
            System.out.println();
        }


//
//
//        Vector vRes = new Vector2F();
//        vRes = vRes.plusTwoVectors(v1, v2);
//        System.out.println(Arrays.toString(vRes.getValues()));
//
//        vRes = vRes.multiplyVectorOnScalar(v1, -0.15);
//        System.out.println(Arrays.toString(vRes.getValues()));
//
//        vRes = vRes.divisionVectorOnScalar(v1, 2);
//        System.out.println(Arrays.toString(vRes.getValues()));
//
//        vRes = vRes.vectorNormalization(v2);
//        System.out.println(Arrays.toString(vRes.getValues()));
//
//        System.out.println(vRes.scalarMultiplyVectorOnVector(v1, v2));
    }
}
