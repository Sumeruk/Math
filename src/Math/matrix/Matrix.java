package Math.matrix;

import Math.vector.Vector;

public interface Matrix {
    Matrix plusMatrix(Matrix m1, Matrix m2);

    Matrix minusMatrix(Matrix m1, Matrix m2);

    Vector multiplyMatrixOnVector(Matrix m1, Vector v1);

    Matrix multiplyTwoMatrix(Matrix m1, Matrix m2);

    Matrix transposition(Matrix m);

    int getSize();

    float[][] getValues();

    void setValue(float[][] value);
}
