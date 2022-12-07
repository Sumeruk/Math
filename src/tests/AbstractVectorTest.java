package tests;

import Math.exception.MathExceptions;
import Math.vector.Vector;
import Math.vector.Vector2F;
import Math.vector.Vector3F;
import Math.vector.Vector4F;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractVectorTest {

    @Test
    void getValues() {

        double[] vectorValue = new double[]{1, 2};
        Vector vector = new Vector2F(vectorValue);
        assertArrayEquals(vectorValue, vector.getValues());

        vectorValue = new double[]{1, 2, 3};
        vector = new Vector3F(vectorValue);
        assertArrayEquals(vectorValue, vector.getValues());

        vectorValue = new double[]{1, 2, 3, 4};
        vector = new Vector4F(vectorValue);
        assertArrayEquals(vectorValue, vector.getValues());

        vector = new Vector3F();
        assertNull(vector.getValues());
    }

    @Test
    void getSize() {
        double[] vectorValue = new double[]{1, 2};
        Vector vector = new Vector2F(vectorValue);
        assertEquals(2, vector.getSize());

        vectorValue = new double[]{1, 2, 3};
        vector = new Vector3F(vectorValue);
        assertEquals(3, vector.getSize());

        vectorValue = new double[]{1, 2, 3, 4};
        vector = new Vector4F(vectorValue);
        assertEquals(4, vector.getSize());

        vector = new Vector2F();
        assertEquals(0, vector.getSize());

    }

    @Test
    void setValues() {

        double[] vectorValue = new double[]{1, 2};
        Vector vector = new Vector2F();
        vector.setValues(vectorValue);
        assertArrayEquals(vectorValue, vector.getValues());

        vectorValue = new double[]{1, 2, 3};
        vector = new Vector3F(vectorValue);
        vector.setValues(vectorValue);
        assertArrayEquals(vectorValue, vector.getValues());

        vectorValue = new double[]{1, 2, 3, 4};
        vector = new Vector4F(vectorValue);
        vector.setValues(vectorValue);
        assertArrayEquals(vectorValue, vector.getValues());

        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[] matrixInput = new double[]{1, 2, 3, 4, 5};
            Vector v = new Vector3F();
            v.setValues(matrixInput);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

    }

    @Test
    void plusTwoVectors() {

        double[] vectorValueFirst = new double[]{-3.333, 0.898};
        double[] vectorValueSecond = new double[]{-4.21, 2.34};
        Vector vector1 = new Vector2F(vectorValueFirst);
        Vector vector2 = new Vector2F(vectorValueSecond);

        double[] expected = new double[]{-7.543, 3.238};

        vector1 = vector1.plusTwoVectors(vector1, vector2);
        assertArrayEquals(expected, vector1.getValues());

        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[] vectorFirst = new double[]{-3.333, 0.898};
            double[] vectorSecond = new double[]{-4.21, 2.34, 1};
            Vector v1 = new Vector2F(vectorFirst);
            Vector v2 = new Vector3F(vectorSecond);
            v1.plusTwoVectors(v1, v2);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());
    }

    @Test
    void minusTwoVectors() {
        double[] vectorValueFirst = new double[]{-3.333, 0.898};
        double[] vectorValueSecond = new double[]{-4.21, 2.34};
        Vector vector1 = new Vector2F(vectorValueFirst);
        Vector vector2 = new Vector2F(vectorValueSecond);

        double[] expected = new double[]{0.877, -1.442};
        vector1 = vector1.minusTwoVectors(vector1, vector2);
        assertArrayEquals(expected, vector1.getValues(), 0.000001);

        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[] vectorFirst = new double[]{-3.333, 0.898};
            double[] vectorSecond = new double[]{-4.21, 2.34, 1};
            Vector v1 = new Vector2F(vectorFirst);
            Vector v2 = new Vector3F(vectorSecond);
            v1.minusTwoVectors(v1, v2);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());
    }

    @Test
    void multiplyVectorOnScalar() {

        double[] vectorValueFirst = new double[]{-3.333, 0.898};
        Vector vector1 = new Vector2F(vectorValueFirst);
        double scalar = -0.18;

        double[] expected = new double[]{0.59994,-0.16164};
        vector1 = vector1.multiplyVectorOnScalar(vector1, scalar);
        assertArrayEquals(expected, vector1.getValues(), 0.000001);

    }

    @Test
    void divisionVectorOnScalar() {

    }

    @Test
    void vectorLength() {

        double[] vectorValue = new double[]{-3.3, 0.89};
        Vector vector = new Vector2F(vectorValue);
        assertEquals(3.41790, vector.vectorLength(vector), 0.00001);

        vectorValue = new double[]{-3.3, 0.89, 2};
        vector = new Vector3F(vectorValue);
        assertEquals(3.96006, vector.vectorLength(vector), 0.00001);

        vectorValue = new double[]{-3.3, 0.89, 2, -3};
        vector = new Vector4F(vectorValue);
        assertEquals(4.96810, vector.vectorLength(vector), 0.00001);

        vectorValue = new double[]{0,0};
        vector = new Vector2F(vectorValue);
        assertEquals(0, vector.vectorLength(vector), 0.00001);

    }

    @Test
    void vectorNormalization() {

        double[] vectorValue = new double[]{-1,0.66};
        Vector vector = new Vector2F(vectorValue);
        double[] expected = new double[]{-0.834609, 0.550842};
        assertArrayEquals(expected, vector.vectorNormalization(vector).getValues(), 0.000001);

        vectorValue = new double[]{0,0.66,6.01};
        vector = new Vector3F(vectorValue);
        expected = new double[]{0, 0.109161, 0.994024};
        assertArrayEquals(expected, vector.vectorNormalization(vector).getValues(), 0.000001);

        vectorValue = new double[]{-2,0.49,0.00,1};
        vector = new Vector4F(vectorValue);
        expected = new double[]{-0.873696, 0.214055, 0, 0.436848};
        assertArrayEquals(expected, vector.vectorNormalization(vector).getValues(), 0.000001);

    }

    @Test
    void scalarMultiplyVectorOnVector() {
        double[] vectorValueFirst = new double[]{2.22, 0.43};
        double[] vectorValueSecond = new double[]{-4.21, 2.34};
        Vector vector1 = new Vector2F(vectorValueFirst);
        Vector vector2 = new Vector2F(vectorValueSecond);

        assertEquals(-8.34,vector1.scalarMultiplyVectorOnVector(vector1, vector2), 0.000001);

        vectorValueFirst = new double[]{0.56, 1.22, -0.11};
        vectorValueSecond = new double[]{-2.87, 0.72, 2.2};
        vector1 = new Vector3F(vectorValueFirst);
        vector2 = new Vector3F(vectorValueSecond);

        assertEquals(-0.9708,vector1.scalarMultiplyVectorOnVector(vector1, vector2), 0.000001);

        vectorValueFirst = new double[]{2, -0.002,6.5,0.03};
        vectorValueSecond = new double[]{1.001, -4.87, 0.08, 1};
        vector1 = new Vector4F(vectorValueFirst);
        vector2 = new Vector4F(vectorValueSecond);

        assertEquals(2.56174,vector1.scalarMultiplyVectorOnVector(vector1, vector2), 0.000001);


    }
}