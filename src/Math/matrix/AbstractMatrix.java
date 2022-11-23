package Math.matrix;

import Math.vector.Vector;
import Math.vector.Vector3F;

public abstract class AbstractMatrix implements Matrix{
    double[][] value;
    int size = 0;

    protected abstract boolean checkLengthInputValues(double[][] values);

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public double[][] getValue() {
        return value;
    }

    @Override
    public void setValue(double[][] value) {

        if(checkLengthInputValues(value)) {
            this.value = value;
            this.size = value.length;
        }
    }

    @Override
    public Matrix plusMatrix(Matrix m1, Matrix m2) {
        Matrix mRes = new Matrix3F();

        double[][] tmp = new double[m1.getSize()][m1.getSize()];

        if (m1.getSize() == m2.getSize()) {
            for (int i = 0; i < m1.getSize(); i++) {
                for (int j = 0; j < m1.getSize(); j++) {
                    tmp[i][j] = m1.getValue()[i][j] + m2.getValue()[i][j];
                }
            }
        }

        mRes.setValue(tmp);

        return mRes;
    }

    @Override
    public Matrix minusMatrix(Matrix m1, Matrix m2) {
        Matrix mRes = new Matrix3F();

        double[][] tmp = new double[m1.getSize()][m1.getSize()];

        if (m1.getSize() == m2.getSize()) {
            for (int i = 0; i < m1.getSize(); i++) {
                for (int j = 0; j < m1.getSize(); j++) {
                    tmp[i][j] = m1.getValue()[i][j] - m2.getValue()[i][j];
                }
            }
        }

        mRes.setValue(tmp);

        return mRes;
    }

    @Override
    public Vector multiplyMatrixOnVector(Matrix m1, Vector v1) {
        Vector vRes = new Vector3F();

        double[] tmp = new double[m1.getSize()];

        if (m1.getSize() == v1.getSize()) {
            for (int i = 0; i < m1.getSize(); i++) {
                for (int j = 0; j < m1.getSize(); j++) {
                    tmp[i] = tmp[i] + m1.getValue()[i][j] * v1.getValues()[j];
                }
            }
        }
        vRes.setValues(tmp);

        return vRes;
    }

    @Override
    public Matrix multiplyTwoMatrix(Matrix m1, Matrix m2) {

        Matrix mRes = new Matrix3F();

        double[][] tmp = new double[m1.getSize()][m1.getSize()];

        if (m1.getSize() == m2.getSize()) {
            for (int i = 0; i < m1.getSize(); i++) {
                for (int j = 0; j < m1.getSize(); j++) {
                    for (int k = 0; k < m1.getSize(); k++) {
                        tmp[i][j] += m1.getValue()[i][k] * m2.getValue()[k][j];
                    }
                }
            }
        }

        mRes.setValue(tmp);
        return mRes;
    }

    @Override
    public Matrix transposition(Matrix m) {
        return null;
    }

}
