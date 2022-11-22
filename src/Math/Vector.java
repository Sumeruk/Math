package Math;

public interface Vector {

    void setValues(int[] values);

    Vector plusTwoVectors(Vector v1, Vector v2);

    Vector minusTwoVectors(Vector v1, Vector v2);

    int[] getValues();

    int getSize();

}
