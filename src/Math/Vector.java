package Math;

public interface Vector {

    void setValues(double[] values);

    Vector plusTwoVectors(Vector v1, Vector v2);

    Vector minusTwoVectors(Vector v1, Vector v2);

    Vector multiplyVectorOnScalar(Vector v1, double scalar);

    Vector divisionVectorOnScalar(Vector v1, double scalar);

    double vectorLength(Vector v1);

    Vector vectorNormalization(Vector v1);

    double scalarMultiplyVectorOnVector(Vector v1, Vector v2);

    double[] getValues();

    int getSize();

}
