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
            double[] vectorFirst = new double[]{-3.333, 0.898};
            double[] vectorSecond = new double[]{-4.21, 2.34, 1};
            Vector v1 = new Vector2F(vectorFirst);
            Vector v2 = new Vector3F(vectorSecond);
            v1.vectorProduct(v1, v2);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            double[] vectorFirst = new double[]{-3.333, 0.898};
            double[] vectorSecond = new double[]{-4.21, 2.34};
            Vector v1 = new Vector2F(vectorFirst);
            Vector v2 = new Vector2F(vectorSecond);
            v1.vectorProduct(v1, v2);
        });
        Assertions.assertEquals("Ошибка в вводимых данных!", thrown.getMessage());

        double[] vectorFirst = new double[]{-3.333, 0.898, 1.87};
        double[] vectorSecond = new double[]{-4.21, 2.34, 0.22};
        Vector v1 = new Vector3F(vectorFirst);
        Vector v2 = new Vector3F(vectorSecond);

        double[] expected = new double[]{-4.17824, -7.13944, -4.01864};
        assertArrayEquals(expected,v1.vectorProduct(v1, v2).getValues(), 0.000001);
    }
}