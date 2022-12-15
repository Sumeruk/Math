package tests;

import Math.exception.MathExceptions;
import Math.matrix.Matrix;
import Math.matrix.Matrix3F;
import Math.matrix.Matrix4F;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractSquareMatrixTest {

    private final float exp = (float) 0.00001;

    @Test
    void testGetSize() {
        Matrix m = new Matrix3F();
        assertEquals(0, m.getSize());

        m = new Matrix4F();
        assertEquals(0, m.getSize());

        float[][] matrix = new float[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        m = new Matrix3F(matrix);
        assertEquals(3, m.getSize());

        matrix = new float[][]{
                {1, 2, 3, 9},
                {4, 5, 6, 9},
                {7, 8, 9, 9},
                {7, 8, 9, 9}
        };
        m = new Matrix4F(matrix);
        assertEquals(4, m.getSize());
    }

    @Test
    void testGetValue() {
        Matrix m = new Matrix3F();
        assertNull(m.getValues());

        float[][] matrix = new float[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        m = new Matrix3F(matrix);
        for (int i = 0; i < matrix.length; i++) {
            assertArrayEquals(matrix[i], m.getValues()[i]);
        }

        matrix = new float[][]{
                {1, 2, 3, 3},
                {4, 5, 6, 3},
                {7, 8, 9, 3},
                {10, 20, 30, 3}
        };
        m = new Matrix4F(matrix);
        for (int i = 0; i < matrix.length; i++) {
            assertArrayEquals(matrix[i], m.getValues()[i]);
        }
    }

    @Test
    void testSetValue() {
        Matrix m;
        float[][] matrix = new float[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        m = new Matrix3F();
        m.setValue(matrix);
        for (int i = 0; i < matrix.length; i++) {
            assertArrayEquals(matrix[i], m.getValues()[i]);
        }

        matrix = new float[][]{
                {1, 2, 3, 3},
                {4, 5, 6, 3},
                {7, 8, 9, 3},
                {1, 2, 3, 3}
        };
        m = new Matrix4F();
        m.setValue(matrix);
        for (int i = 0; i < matrix.length; i++) {
            assertArrayEquals(matrix[i], m.getValues()[i]);
        }

        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[][] matrixInput = new float[][]{
                    {1, 2, 3},
                    {4, 5, 6},
            };
            Matrix m1 = new Matrix3F();
            m1.setValue(matrixInput);
        });
        Assertions.assertEquals("Error in values!", thrown.getMessage());

        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[][] matrixInput = new float[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };
            Matrix m1 = new Matrix4F();
            m1.setValue(matrixInput);
        });
        Assertions.assertEquals("Error in values!", thrown.getMessage());

    }

    @Test
    void testSumMatrix() {

        //for 3matrix
        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[][] matrix3Input = new float[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {3, 4, 5}
            };
            Matrix m3 = new Matrix3F(matrix3Input);

            float[][] matrix4Input = new float[][]{
                    {1, 2, 3, 5},
                    {4, 5, 6, 5},
                    {3, 4, 5, 5},
                    {3, 4, 5, 5}
            };
            Matrix m4 = new Matrix4F(matrix4Input);

            m3.sumMatrix(m3, m4);
        });
        Assertions.assertEquals("Error in values!", thrown.getMessage());

        //for 4matrix
        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[][] matrix3Input = new float[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {3, 4, 5}
            };
            Matrix m3 = new Matrix3F(matrix3Input);

            float[][] matrix4Input = new float[][]{
                    {1, 2, 3, 5},
                    {4, 5, 6, 5},
                    {3, 4, 5, 5},
                    {3, 4, 5, 5}
            };
            Matrix m4 = new Matrix4F(matrix4Input);

            m4.sumMatrix(m3, m4);
        });
        Assertions.assertEquals("Error in values!", thrown.getMessage());

        //for 3matrix
        float[][] expected = new float[][]{
                {10, 10, 3},
                {81, 3, 7},
                {7, 8, 9}
        };

        float[][] m1 = new float[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        float[][] m2 = new float[][]{
                {9, 8, 0},
                {77, -2, 1},
                {0, 0, 0}
        };

        Matrix matrix1 = new Matrix3F(m1);
        Matrix matrix2 = new Matrix3F(m2);

        matrix1 = matrix1.sumMatrix(matrix1, matrix2);

        for (int i = 0; i < 3; i++) {
            assertArrayEquals(expected[i], matrix1.getValues()[i], exp);
        }

        //for 4matrix
        expected = new float[][]{
                {10, 10, 3, 0},
                {81, 3, 7, 22},
                {7, 8, 9, 0},
                {20, -100, 12, 9},
        };

        m1 = new float[][]{
                {1, 2, 3, 0},
                {4, 5, 6, 10},
                {7, 8, 9, 0},
                {-1, -100, 0, 9}
        };

        m2 = new float[][]{
                {9, 8, 0, 0},
                {77, -2, 1, 12},
                {0, 0, 0, 0},
                {21, 0, 12, 0}
        };

        matrix1 = new Matrix4F(m1);
        matrix2 = new Matrix4F(m2);

        matrix1 = matrix1.sumMatrix(matrix1, matrix2);

        for (int i = 0; i < 4; i++) {
            assertArrayEquals(expected[i], matrix1.getValues()[i], exp);
        }


    }

    @Test
    void testMinusMatrix() {
        //for 3matrix
        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[][] matrix3Input = new float[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {3, 4, 5}
            };
            Matrix m3 = new Matrix3F(matrix3Input);

            float[][] matrix4Input = new float[][]{
                    {1, 2, 3, 5},
                    {4, 5, 6, 5},
                    {3, 4, 5, 5},
                    {3, 4, 5, 5}
            };
            Matrix m4 = new Matrix4F(matrix4Input);

            m3.sumMatrix(m3, m4);
        });
        Assertions.assertEquals("Error in values!", thrown.getMessage());

        //for 3matrix
        float[][] expected = new float[][]{
                {-7.6f, -5.5f, 3.5f},
                {-73, 7, 5},
                {7, 8, 9}
        };

        float[][] m1 = new float[][]{
                {1.4f, 2.5f, 3.5f},
                {4, 5, 6},
                {7, 8, 9}
        };

        float[][] m2 = new float[][]{
                {9, 8, 0},
                {77, -2, 1},
                {0, 0, 0}
        };

        Matrix matrix1 = new Matrix3F(m1);
        Matrix matrix2 = new Matrix3F(m2);

        matrix1 = matrix1.minusMatrix(matrix1, matrix2);

        for (int i = 0; i < 3; i++) {
            assertArrayEquals(expected[i], matrix1.getValues()[i], exp);
        }


        //for 4matrix
        expected = new float[][]{
                {-7.6F, -5.5f, 0, -6},
                {-73, 7, 5, 0},
                {7, -4.004f, 9, 0},
                {0, -56, 1.03f, 4},
        };

        m1 = new float[][]{
                {1.4f, 2.5f, 3.5f, 0},
                {4, 5, 6, 0},
                {7, 8, 9, -5.86f},
                {0, 0, 3.33f, 0}
        };

        m2 = new float[][]{
                {9, 8, 3.5f, 6},
                {77, -2, 1, 0},
                {0, 12.004f, 0, -5.86f},
                {0, 56, 2.3f, -4}
        };

        matrix1 = new Matrix4F(m1);
        matrix2 = new Matrix4F(m2);

        matrix2 = matrix1.minusMatrix(matrix1, matrix2);

        for (int i = 0; i < 4; i++) {
            assertArrayEquals(expected[i], matrix2.getValues()[i], exp);
        }
    }

    @Test
    void testProductTwoMatrix() {
        //for 3matrix
        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[][] matrix3Input = new float[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {3, 4, 5}
            };
            Matrix m3 = new Matrix3F(matrix3Input);

            float[][] matrix4Input = new float[][]{
                    {1, 2, 3, 5},
                    {4, 5, 6, 5},
                    {3, 4, 5, 5},
                    {3, 4, 5, 5}
            };
            Matrix m4 = new Matrix4F(matrix4Input);

            m3.sumMatrix(m3, m4);
        });
        Assertions.assertEquals("Error in values!", thrown.getMessage());

        //for 4matrix
        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[][] matrix3Input = new float[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {3, 4, 5}
            };
            Matrix m3 = new Matrix3F(matrix3Input);

            float[][] matrix4Input = new float[][]{
                    {1, 2, 3, 5},
                    {4, 5, 6, 5},
                    {3, 4, 5, 5},
                    {3, 4, 5, 5}
            };
            Matrix m4 = new Matrix4F(matrix4Input);

            m4.sumMatrix(m3, m4);
        });
        Assertions.assertEquals("Error in values!", thrown.getMessage());

        //for 3matrix
        float[][] expected = new float[][]{
                {-13.879f, 42.7f, 29.15f},
                {-30.79f, 86, 53.9f},
                {-50.38f, 137, 83.24f}};

        float[][] m1 = new float[][]{
                {1.4f, 2.5f, 3.5f},
                {4, 5, 6},
                {7, 8, 9}
        };

        float[][] m2 = new float[][]{
                {-5.86f, 8, 3},
                {3.33f, 0, -1.22f},
                {-4, 9, 8}
        };

        Matrix matrix1 = new Matrix3F(m1);
        Matrix matrix2 = new Matrix3F(m2);

        matrix1 = matrix1.productTwoMatrix(matrix1, matrix2);

        for (int i = 0; i < 3; i++) {
            assertArrayEquals(expected[i], matrix1.getValues()[i], exp);
        }

        expected = new float[][]{
                {6.925f, 53.214f, 1.85f, -12.11f},
                {28.65f, 104.024f, 7.9f, -11.16f},
                {53.64f, -164.12401f, 1.262f, 12.7f},
                {-13.32f, 39.97332f, 0, -19.5138f}
        };

        m1 = new float[][]{
                {1.4f, 2.5f, 3.5f, 0},
                {4, 5, 6, 0},
                {7, 8, 9, -5.86f},
                {0, 0, 3.33f, 0}
        };

        m2 = new float[][]{
                {9, 8, 3.5f, 6},
                {3.33f, 0, -1.22f, 0},
                {-4, 12.004f, 0, -5.86f},
                {0, 56, 2.3f, -4}
        };

        matrix1 = new Matrix4F(m1);
        matrix2 = new Matrix4F(m2);

        matrix2 = matrix1.productTwoMatrix(matrix1, matrix2);

        for (int i = 0; i < 4; i++) {
            assertArrayEquals(expected[i], matrix2.getValues()[i], exp);
        }


    }

    @Test
    void testTransposition() {
        float[][] expected = new float[][]{
                {1.4f, 4, 7},
                {2.5f, 5, 8},
                {3.5f, 6, 9}
        };

        float[][] m1 = new float[][]{
                {1.4f, 2.5f, 3.5f},
                {4, 5, 6},
                {7, 8, 9}
        };

        Matrix matrix1 = new Matrix3F(m1);

        matrix1 = matrix1.transpose(matrix1);

        for (int i = 0; i < matrix1.getSize(); i++) {
            assertArrayEquals(expected[i], matrix1.getValues()[i], exp);
        }

        expected = new float[][]{
                {9, 3.33f, -4, 0},
                {8, 0, 12.004f, 56},
                {3.5f, -1.22f, 0, 2.3f},
                {6, 0, -5.86f, -4}
        };

        m1 = new float[][]{
                {9, 8, 3.5f, 6},
                {3.33f, 0, -1.22f, 0},
                {-4, 12.004f, 0, -5.86f},
                {0, 56, 2.3f, -4}
        };

        matrix1 = new Matrix4F(m1);

        matrix1 = matrix1.transpose(matrix1);

        for (int i = 0; i < matrix1.getSize(); i++) {
            assertArrayEquals(expected[i], matrix1.getValues()[i], exp);
        }
    }
}