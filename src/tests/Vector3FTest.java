package tests;

import Math.exception.MathExceptions;
import Math.vector.Vector;
import Math.vector.Vector2F;
import Math.vector.Vector3F;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector3FTest {

    @Test
    void vectorProduct() {
        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[] vectorFirst = new float[]{-3.333f, 0.898f};
            float[] vectorSecond = new float[]{-4.21f, 2.34f, 1};
            Vector v1 = new Vector2F(vectorFirst);
            Vector v2 = new Vector3F(vectorSecond);
            v1.vectorProduct(v1, v2);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[] vectorFirst = new float[]{-3.333f, 0.898f};
            float[] vectorSecond = new float[]{-4.21f, 2.34f};
            Vector v1 = new Vector2F(vectorFirst);
            Vector v2 = new Vector2F(vectorSecond);
            v1.vectorProduct(v1, v2);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

        float[] vectorFirst = new float[]{-3.333f, 0.898f, 1.87f};
        float[] vectorSecond = new float[]{-4.21f, 2.34f, 0.22f};
        Vector v1 = new Vector3F(vectorFirst);
        Vector v2 = new Vector3F(vectorSecond);

        float[] expected = new float[]{-4.17824f, -7.13944f, -4.01864f};
        assertArrayEquals(expected,v1.vectorProduct(v1, v2).getValues(), 0.000001f);
    }
}