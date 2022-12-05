package tests;

import Math.exception.MathExceptions;
import Math.matrix.Matrix;
import Math.matrix.Matrix3F;
import Math.matrix.Matrix4F;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractMatrixTest {

    @Test
    void getSize() {
        Matrix m = new Matrix3F();
        assertEquals(0, m.getSize());

        m = new Matrix4F();
        assertEquals(0, m.getSize());

        double[][] matrix = new double[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        m = new Matrix3F(matrix);
        assertEquals(3, m.getSize());

        matrix = new double[][]{
                {1, 2, 3, 9},
                {4, 5, 6, 9},
                {7, 8, 9, 9},
                {7, 8, 9, 9}
        };
        m = new Matrix4F(matrix);
        assertEquals(4, m.getSize());
    }

    @Test
    void getValue() {
        Matrix m = new Matrix3F();
        assertNull(m.getValue());

        double[][] matrix = new double[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        m = new Matrix3F(matrix);
        for (int i = 0; i < matrix.length; i++) {
            assertArrayEquals(matrix[i], m.getValue()[i]);
        }

        matrix = new double[][]{
                {1, 2, 3, 3},
                {4, 5, 6, 3},
                {7, 8, 9, 3},
                {10, 20, 30, 3}
        };
        m = new Matrix4F(matrix);
        for (int i = 0; i < matrix.length; i++) {
            assertArrayEquals(matrix[i], m.getValue()[i]);
        }
    }

    @Test
    void setValue() {
        Matrix m;
        double[][] matrix = new double[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        m = new Matrix3F();
        m.setValue(matrix);
        for (int i = 0; i < matrix.length; i++) {
            assertArrayEquals(matrix[i], m.getValue()[i]);
        }

        matrix = new double[][]{
                {1, 2, 3, 3},
                {4, 5, 6, 3},
                {7, 8, 9, 3},
                {1, 2, 3, 3}
        };
        m = new Matrix4F();
        m.setValue(matrix);
        for (int i = 0; i < matrix.length; i++) {
            assertArrayEquals(matrix[i], m.getValue()[i]);
        }

        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[][] matrixInput = new double[][]{
                    {1, 2, 3},
                    {4, 5, 6},
            };
            Matrix m1 = new Matrix3F();
            m1.setValue(matrixInput);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[][] matrixInput = new double[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };
            Matrix m1 = new Matrix4F();
            m1.setValue(matrixInput);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

    }

    @Test
    void plusMatrix() {

        //for 3matrix
        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[][] matrix3Input = new double[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {3, 4, 5}
            };
            Matrix m3 = new Matrix3F(matrix3Input);

            double[][] matrix4Input = new double[][]{
                    {1, 2, 3, 5},
                    {4, 5, 6, 5},
                    {3, 4, 5, 5},
                    {3, 4, 5, 5}
            };
            Matrix m4 = new Matrix4F(matrix4Input);

            m3.plusMatrix(m3, m4);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

        //for 4matrix
        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[][] matrix3Input = new double[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {3, 4, 5}
            };
            Matrix m3 = new Matrix3F(matrix3Input);

            double[][] matrix4Input = new double[][]{
                    {1, 2, 3, 5},
                    {4, 5, 6, 5},
                    {3, 4, 5, 5},
                    {3, 4, 5, 5}
            };
            Matrix m4 = new Matrix4F(matrix4Input);

            m4.plusMatrix(m3, m4);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

        //for 3matrix
        double[][] expected = new double[][]{
                {10, 10, 3},
                {81, 3, 7},
                {7, 8, 9}
        };

        double[][] m1 = new double[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        double[][] m2 = new double[][]{
                {9, 8, 0},
                {77, -2, 1},
                {0, 0, 0}
        };

        Matrix matrix1 = new Matrix3F(m1);
        Matrix matrix2 = new Matrix3F(m2);

        matrix1 = matrix1.plusMatrix(matrix1, matrix2);

        for (int i = 0; i < 3; i++) {
            assertArrayEquals(expected[i], matrix1.getValue()[i], 0.000001);
        }

        //for 4matrix
        expected = new double[][]{
                {10, 10, 3, 0},
                {81, 3, 7, 22},
                {7, 8, 9, 0},
                {20, -100, 12, 9},
        };

        m1 = new double[][]{
                {1, 2, 3, 0},
                {4, 5, 6, 10},
                {7, 8, 9, 0},
                {-1, -100, 0, 9}
        };

        m2 = new double[][]{
                {9, 8, 0, 0},
                {77, -2, 1, 12},
                {0, 0, 0, 0},
                {21, 0, 12, 0}
        };

        matrix1 = new Matrix4F(m1);
        matrix2 = new Matrix4F(m2);

        matrix1 = matrix1.plusMatrix(matrix1, matrix2);

        for (int i = 0; i < 4; i++) {
            assertArrayEquals(expected[i], matrix1.getValue()[i], 0.000001);
        }


    }

    @Test
    void minusMatrix() {
        //for 3matrix
        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[][] matrix3Input = new double[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {3, 4, 5}
            };
            Matrix m3 = new Matrix3F(matrix3Input);

            double[][] matrix4Input = new double[][]{
                    {1, 2, 3, 5},
                    {4, 5, 6, 5},
                    {3, 4, 5, 5},
                    {3, 4, 5, 5}
            };
            Matrix m4 = new Matrix4F(matrix4Input);

            m3.plusMatrix(m3, m4);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

        //for 3matrix
        double[][] expected = new double[][]{
                {-7.6, -5.5, 3.5},
                {-73, 7, 5},
                {7, 8, 9}
        };

        double[][] m1 = new double[][]{
                {1.4, 2.5, 3.5},
                {4, 5, 6},
                {7, 8, 9}
        };

        double[][] m2 = new double[][]{
                {9, 8, 0},
                {77, -2, 1},
                {0, 0, 0}
        };

        Matrix matrix1 = new Matrix3F(m1);
        Matrix matrix2 = new Matrix3F(m2);

        matrix1 = matrix1.minusMatrix(matrix1, matrix2);

        for (int i = 0; i < 3; i++) {
            assertArrayEquals(expected[i], matrix1.getValue()[i], 0.000001);
        }


        //for 4matrix
        expected = new double[][]{
                {-7.6, -5.5, 0, -6},
                {-73, 7, 5, 0},
                {7, -4.004, 9, 0},
                {0, -56, 1.03, 4},
        };

        m1 = new double[][]{
                {1.4, 2.5, 3.5, 0},
                {4, 5, 6, 0},
                {7, 8, 9, -5.86},
                {0, 0, 3.33, 0}
        };

        m2 = new double[][]{
                {9, 8, 3.5, 6},
                {77, -2, 1, 0},
                {0, 12.004, 0, -5.86},
                {0, 56, 2.3, -4}
        };

        matrix1 = new Matrix4F(m1);
        matrix2 = new Matrix4F(m2);

        matrix2 = matrix1.minusMatrix(matrix1, matrix2);

        for (int i = 0; i < 4; i++) {
            assertArrayEquals(expected[i], matrix2.getValue()[i], 0.000001);
        }
    }

    @Test
    void multiplyTwoMatrix() {
        //for 3matrix
        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[][] matrix3Input = new double[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {3, 4, 5}
            };
            Matrix m3 = new Matrix3F(matrix3Input);

            double[][] matrix4Input = new double[][]{
                    {1, 2, 3, 5},
                    {4, 5, 6, 5},
                    {3, 4, 5, 5},
                    {3, 4, 5, 5}
            };
            Matrix m4 = new Matrix4F(matrix4Input);

            m3.plusMatrix(m3, m4);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

        //for 4matrix
        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[][] matrix3Input = new double[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {3, 4, 5}
            };
            Matrix m3 = new Matrix3F(matrix3Input);

            double[][] matrix4Input = new double[][]{
                    {1, 2, 3, 5},
                    {4, 5, 6, 5},
                    {3, 4, 5, 5},
                    {3, 4, 5, 5}
            };
            Matrix m4 = new Matrix4F(matrix4Input);

            m4.plusMatrix(m3, m4);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

        //for 3matrix
        double[][] expected = new double[][]{
                {-13.879, 42.7, 29.15},
                {-30.79, 86, 53.9},
                {-50.38, 137, 83.24}
        };

        double[][] m1 = new double[][]{
                {1.4, 2.5, 3.5},
                {4, 5, 6},
                {7, 8, 9}
        };

        double[][] m2 = new double[][]{
                {-5.86, 8, 3},
                {3.33, 0, -1.22},
                {-4, 9, 8}
        };

        Matrix matrix1 = new Matrix3F(m1);
        Matrix matrix2 = new Matrix3F(m2);

        matrix1 = matrix1.multiplyTwoMatrix(matrix1, matrix2);

        for (int i = 0; i < 3; i++) {
            assertArrayEquals(expected[i], matrix1.getValue()[i], 0.000001);
        }

        expected = new double[][]{
                {6.925, 53.214, 1.85, -12.11},
                {28.65, 104.024, 7.9, -11.16},
                {53.64, -164.124, 1.262, 12.7},
                {-13.32, 39.97332, 0, -19.5138}
        };

        m1 = new double[][]{
                {1.4, 2.5, 3.5, 0},
                {4, 5, 6, 0},
                {7, 8, 9, -5.86},
                {0, 0, 3.33, 0}
        };

        m2 = new double[][]{
                {9, 8, 3.5, 6},
                {3.33, 0, -1.22, 0},
                {-4, 12.004, 0, -5.86},
                {0, 56, 2.3, -4}
        };

        matrix1 = new Matrix4F(m1);
        matrix2 = new Matrix4F(m2);

        matrix2 = matrix1.multiplyTwoMatrix(matrix1, matrix2);

        for (int i = 0; i < 4; i++) {
            assertArrayEquals(expected[i], matrix2.getValue()[i], 0.000001);
        }


    }

    @Test
    void transposition() {
        double[][] expected = new double[][]{
                {1.4, 4, 7},
                {2.5, 5, 8},
                {3.5, 6, 9}
        };

        double[][] m1 = new double[][]{
                {1.4, 2.5, 3.5},
                {4, 5, 6},
                {7, 8, 9}
        };

        Matrix matrix1 = new Matrix3F(m1);

        matrix1 = matrix1.transposition(matrix1);

        for (int i = 0; i < matrix1.getSize(); i++) {
            assertArrayEquals(expected[i], matrix1.getValue()[i], 0.000001);
        }

        expected = new double[][]{
                {9, 3.33, -4, 0},
                {8, 0, 12.004, 56},
                {3.5, -1.22, 0, 2.3},
                {6, 0, -5.86, -4}
        };

        m1 = new double[][]{
                {9, 8, 3.5, 6},
                {3.33, 0, -1.22, 0},
                {-4, 12.004, 0, -5.86},
                {0, 56, 2.3, -4}
        };

        matrix1 = new Matrix4F(m1);

        matrix1 = matrix1.transposition(matrix1);

        for (int i = 0; i < matrix1.getSize(); i++) {
            assertArrayEquals(expected[i], matrix1.getValue()[i], 0.000001);
        }
    }
}