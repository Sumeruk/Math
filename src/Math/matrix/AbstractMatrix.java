package Math.matrix;

import Math.exception.MathExceptions;
import Math.vector.Vector;


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
        return this.value;
    }

    @Override
    public void setValue(double[][] value) {

        if(checkLengthInputValues(value)) {
            this.value = value;
            this.size = value.length;
        } else throw new MathExceptions();
    }

    @Override
    public Matrix plusMatrix(Matrix m1, Matrix m2) {

        double[][] tmp = new double[m1.getSize()][m1.getSize()];

        if (m1.getSize() == m2.getSize()) {
            for (int i = 0; i < m1.getSize(); i++) {
                for (int j = 0; j < m1.getSize(); j++) {
                    tmp[i][j] = m1.getValue()[i][j] + m2.getValue()[i][j];
                }
            }
        }
        this.value = tmp;
        return this;
    }

    @Override
    public Matrix minusMatrix(Matrix m1, Matrix m2) {

        double[][] tmp = new double[m1.getSize()][m1.getSize()];

        if (m1.getSize() == m2.getSize()) {
            for (int i = 0; i < m1.getSize(); i++) {
                for (int j = 0; j < m1.getSize(); j++) {
                    tmp[i][j] = m1.getValue()[i][j] - m2.getValue()[i][j];
                }
            }
        }

        this.value = tmp;
        return this;
    }

    @Override
    public abstract Vector multiplyMatrixOnVector(Matrix m1, Vector v1);

    @Override
    public Matrix multiplyTwoMatrix(Matrix m1, Matrix m2) {

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

        this.value = tmp;
        return this;
    }

    @Override
    public Matrix transposition(Matrix m) {
        double[][] tmp = new double[m.getSize()][m.getSize()];

        for(int i = 0; i < m.getSize(); i++){
            for(int j = 0; j < m.getSize(); j++){
                tmp[j][i] = m.getValue()[i][j];
            }
        }

        this.value = tmp;
        return this;
    }

}
