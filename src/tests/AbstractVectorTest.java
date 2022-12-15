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
    
    private final float exp = (float) 0.00001;

    @Test
    void getValues() {

        float[] vectorValue = new float[]{1, 2};
        Vector vector = new Vector2F(vectorValue);
        assertArrayEquals(vectorValue, vector.getValues());

        vectorValue = new float[]{1, 2, 3};
        vector = new Vector3F(vectorValue);
        assertArrayEquals(vectorValue, vector.getValues());

        vectorValue = new float[]{1, 2, 3, 4};
        vector = new Vector4F(vectorValue);
        assertArrayEquals(vectorValue, vector.getValues());

        vector = new Vector3F();
        assertNull(vector.getValues());
    }

    @Test
    void getSize() {
        float[] vectorValue = new float[]{1, 2};
        Vector vector = new Vector2F(vectorValue);
        assertEquals(2, vector.getSize());

        vectorValue = new float[]{1, 2, 3};
        vector = new Vector3F(vectorValue);
        assertEquals(3, vector.getSize());

        vectorValue = new float[]{1, 2, 3, 4};
        vector = new Vector4F(vectorValue);
        assertEquals(4, vector.getSize());

        vector = new Vector2F();
        assertEquals(0, vector.getSize());

    }

    @Test
    void setValues() {

        float[] vectorValue = new float[]{1, 2};
        Vector vector = new Vector2F();
        vector.setValues(vectorValue);
        assertArrayEquals(vectorValue, vector.getValues());

        vectorValue = new float[]{1, 2, 3};
        vector = new Vector3F(vectorValue);
        vector.setValues(vectorValue);
        assertArrayEquals(vectorValue, vector.getValues());

        vectorValue = new float[]{1, 2, 3, 4};
        vector = new Vector4F(vectorValue);
        vector.setValues(vectorValue);
        assertArrayEquals(vectorValue, vector.getValues());

        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[] matrixInput = new float[]{1, 2, 3, 4, 5};
            Vector v = new Vector3F();
            v.setValues(matrixInput);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

    }

    @Test
    void plusTwoVectors() {

        float[] vectorValueFirst = new float[]{-3.333f, 0.898f};
        float[] vectorValueSecond = new float[]{-4.21f, 2.34f};
        Vector vector1 = new Vector2F(vectorValueFirst);
        Vector vector2 = new Vector2F(vectorValueSecond);

        float[] expected = new float[]{-7.543f, 3.238f};

        vector1 = vector1.sumVectors(vector1, vector2);
        assertArrayEquals(expected, vector1.getValues());

        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[] vectorFirst = new float[]{-3.333f, 0.898f};
            float[] vectorSecond = new float[]{-4.21f, 2.34f, 1};
            Vector v1 = new Vector2F(vectorFirst);
            Vector v2 = new Vector3F(vectorSecond);
            v1.sumVectors(v1, v2);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());
    }

    @Test
    void minusTwoVectors() {
        float[] vectorValueFirst = new float[]{-3.333f, 0.898f};
        float[] vectorValueSecond = new float[]{-4.21f, 2.34f};
        Vector vector1 = new Vector2F(vectorValueFirst);
        Vector vector2 = new Vector2F(vectorValueSecond);

        float[] expected = new float[]{0.877f, -1.442f};
        vector1 = vector1.minusTwoVectors(vector1, vector2);
        assertArrayEquals(expected, vector1.getValues(), exp);

        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[] vectorFirst = new float[]{-3.333f, 0.898f};
            float[] vectorSecond = new float[]{-4.21f, 2.34f, 1};
            Vector v1 = new Vector2F(vectorFirst);
            Vector v2 = new Vector3F(vectorSecond);
            v1.minusTwoVectors(v1, v2);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());
    }

    @Test
    void multiplyVectorOnScalar() {

        float[] vectorValueFirst = new float[]{-3.333f, 0.898f};
        Vector vector1 = new Vector2F(vectorValueFirst);
        float scalar = -0.18f;

        float[] expected = new float[]{0.59994f,-0.16164f};
        vector1 = vector1.productVectorOnScalar(vector1, scalar);
        assertArrayEquals(expected, vector1.getValues(), exp);

    }

    @Test
    void divisionVectorOnScalar() {

    }

    @Test
    void vectorLength() {

        float[] vectorValue = new float[]{-3.3f, 0.89f};
        Vector vector = new Vector2F(vectorValue);
        assertEquals(3.41790, vector.vectorLength(vector), exp);

        vectorValue = new float[]{-3.3f, 0.89f, 2};
        vector = new Vector3F(vectorValue);
        assertEquals(3.96006, vector.vectorLength(vector), exp);

        vectorValue = new float[]{-3.3f, 0.89f, 2, -3};
        vector = new Vector4F(vectorValue);
        assertEquals(4.96810, vector.vectorLength(vector), exp);

        vectorValue = new float[]{0,0};
        vector = new Vector2F(vectorValue);
        assertEquals(0, vector.vectorLength(vector), exp);

    }

    @Test
    void vectorNormalization() {

        float[] vectorValue = new float[]{-1,0.66f};
        Vector vector = new Vector2F(vectorValue);
        float[] expected = new float[]{-0.834609f, 0.550842f};
        assertArrayEquals(expected, vector.vectorNormalization(vector).getValues(), exp);

        vectorValue = new float[]{0,0.66f,6.01f};
        vector = new Vector3F(vectorValue);
        expected = new float[]{0, 0.109161f, 0.994024f};
        assertArrayEquals(expected, vector.vectorNormalization(vector).getValues(), exp);

        vectorValue = new float[]{-2,0.49f,0.00f,1};
        vector = new Vector4F(vectorValue);
        expected = new float[]{-0.873696f, 0.214055f, 0, 0.436848f};
        assertArrayEquals(expected, vector.vectorNormalization(vector).getValues(), exp);

    }

    @Test
    void scalarMultiplyVectorOnVector() {
        float[] vectorValueFirst = new float[]{2.22f, 0.43f};
        float[] vectorValueSecond = new float[]{-4.21f, 2.34f};
        Vector vector1 = new Vector2F(vectorValueFirst);
        Vector vector2 = new Vector2F(vectorValueSecond);

        assertEquals(-8.34,vector1.vectorDotProduct(vector1, vector2), exp);

        vectorValueFirst = new float[]{0.56f, 1.22f, -0.11f};
        vectorValueSecond = new float[]{-2.87f, 0.72f, 2.2f};
        vector1 = new Vector3F(vectorValueFirst);
        vector2 = new Vector3F(vectorValueSecond);

        assertEquals(-0.9708,vector1.vectorDotProduct(vector1, vector2), exp);

        vectorValueFirst = new float[]{2, -0.002f,6.5f,0.03f};
        vectorValueSecond = new float[]{1.001f, -4.87f, 0.08f, 1};
        vector1 = new Vector4F(vectorValueFirst);
        vector2 = new Vector4F(vectorValueSecond);

        assertEquals(2.56174,vector1.vectorDotProduct(vector1, vector2), exp);


    }
}