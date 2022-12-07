package tests;

import Math.exception.MathExceptions;
import Math.matrix.Matrix;
import Math.matrix.Matrix3F;
import Math.matrix.Matrix4F;
import Math.vector.Vector;
import Math.vector.Vector2F;
import Math.vector.Vector3F;
import Math.vector.Vector4F;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Matrix4FTest {

    @Test
    void testInputValuesExpectedException() {

        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[][] expected = new double[][]{{1, 2, 3},
                    {4, 5, 6}};
            Matrix m = new Matrix4F(expected);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[][] expected = new double[][]{{1, 2, 3},
                    {4, 5},
                    {6, 7, 8}};
            Matrix m = new Matrix4F(expected);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[][] expected = new double[][]{{1, 2, 3},
                    {4, 5, 6},
                    {6, 7}};
            Matrix m = new Matrix4F(expected);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[][] expected = new double[0][0];
            Matrix m = new Matrix4F(expected);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

    }

    @Test
    void testMultiplyMatrixOnVector() {

        double[] expected = new double[]{62.5405,
                409.7973,
                116.976,
                107};

        double[][] m = {{0, -2, 3.009, 11},
                {4.9, 5, -0.0006, 77},
                {7, -0.008, 9, 12.5},
                {10, 11, 12, 0}
        };
        double[] v = {2, 3, 4.5, 5};

        Matrix matrix = new Matrix4F(m);
        Vector vector = new Vector4F(v);

        vector = matrix.multiplyMatrixOnVector(matrix, vector);

        assertArrayEquals(expected, vector.getValues(), 0.000001);

        v = new double[]{0, 0, 0, 0};
        vector = new Vector4F(v);
        vector = matrix.multiplyMatrixOnVector(matrix, vector);
        vector.getValues();
        expected = new double[]{0, 0, 0, 0};
        assertArrayEquals(expected, vector.getValues());

        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[][] mInput = {{1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9},
                    {10, 11, 12}
            };
            double[] vInput = {2, 3};

            Matrix mIn = new Matrix4F(mInput);
            Vector vIn = new Vector2F(vInput);

            Vector vectorRes = mIn.multiplyMatrixOnVector(mIn, vIn);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[][] mInput = {{1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9},
                    {10, 11, 12}
            };
            double[] vInput = {2, 3, 4};

            Matrix mIn = new Matrix4F(mInput);
            Vector vIn = new Vector3F(vInput);

            Vector vectorRes = mIn.multiplyMatrixOnVector(mIn, vIn);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());
    }
}