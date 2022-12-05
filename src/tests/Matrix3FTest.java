package tests;

import Math.exception.MathExceptions;
import Math.matrix.Matrix;
import Math.matrix.Matrix3F;
import Math.vector.Vector;
import Math.vector.Vector2F;
import Math.vector.Vector3F;
import Math.vector.Vector4F;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Matrix3FTest {

    @Test
    void testInputValuesExpectedException() {

        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[][] expected = new double[][]{{1, 2, 3},
                    {4, 5, 6}};
            Matrix m = new Matrix3F(expected);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[][] expected = new double[][]{{1, 2, 3},
                    {4, 5},
                    {6, 7, 8}};
            Matrix m = new Matrix3F(expected);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[][] expected = new double[][]{{1, 2, 3},
                    {4, 5, 6},
                    {6, 7}};
            Matrix m = new Matrix3F(expected);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[][] expected = new double[0][0];
            Matrix m = new Matrix3F(expected);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

    }

    @Test
    void testMultiplyMatrixOnVector() {
        double[][] m = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        double[] v = {2, 3, 4};

        Matrix m1 = new Matrix3F(m);
        Vector v1 = new Vector3F(v);

        Vector vectorResult = m1.multiplyMatrixOnVector(m1, v1);
        double[] actual = vectorResult.getValues();
        double[] expected = {20, 47, 74};

        assertArrayEquals(expected, actual, 0.000001);


        v = new double[]{0, 0, 0};
        v1 = new Vector3F(v);
        vectorResult = m1.multiplyMatrixOnVector(m1, v1);
        actual = vectorResult.getValues();
        expected = new double[]{0, 0, 0};
        assertArrayEquals(expected, actual);

        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[][] mInput = {{1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}};
            double[] vInput = {2, 3};

            Matrix matrix = new Matrix3F(mInput);
            Vector vector = new Vector2F(vInput);

            Vector vectorRes = matrix.multiplyMatrixOnVector(matrix, vector);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[][] mInput = {{1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}};
            double[] vInput = {2, 3, 4, 5};

            Matrix matrix = new Matrix3F(mInput);
            Vector vector = new Vector4F(vInput);

            Vector vectorRes = matrix.multiplyMatrixOnVector(matrix, vector);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());



    }
}