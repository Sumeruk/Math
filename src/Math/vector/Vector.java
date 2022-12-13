package Math.vector;

public interface Vector {

    Vector vectorProduct(Vector v1, Vector v2);

    void setValues(float[] values);

    Vector plusTwoVectors(Vector v1, Vector v2);

    Vector minusTwoVectors(Vector v1, Vector v2);

    Vector multiplyVectorOnScalar(Vector v1, float scalar);

    Vector divisionVectorOnScalar(Vector v1, float scalar);

    float vectorLength(Vector v1);

    Vector vectorNormalization(Vector v1);

    float scalarMultiplyVectorOnVector(Vector v1, Vector v2);

    float[] getValues();

    int getSize();

}
