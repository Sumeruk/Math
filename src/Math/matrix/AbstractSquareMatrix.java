package Math.matrix;

import Math.exception.MathExceptions;
import Math.vector.Vector;
import Math.vector.Vector3F;

// todo переделать названия

public abstract class AbstractSquareMatrix implements Matrix{
    float[][] value;
    int size = 0;

    @Override
    public abstract void setZeroMatrix();

    @Override
    public abstract void setSingleMatrix();

    protected abstract boolean checkLengthInputValues(float[][] values);

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public float[][] getValues() {
        return this.value;
    }

    @Override
    public void setValue(float[][] value) {

        if(checkLengthInputValues(value)) {
            this.value = value;
            this.size = value.length;
        } else throw new MathExceptions();
    }

    @Override
    public Matrix sumMatrix(final Matrix m1, final Matrix m2) {

        float[][] tmp = new float[m1.getSize()][m1.getSize()];

        if (m1.getSize() == m2.getSize()) {
            for (int i = 0; i < m1.getSize(); i++) {
                for (int j = 0; j < m1.getSize(); j++) {
                    tmp[i][j] = m1.getValues()[i][j] + m2.getValues()[i][j];
                }
            }
        } else throw new MathExceptions();
        this.value = tmp;
        return this;
    }

    @Override
    public Matrix minusMatrix(final Matrix m1, final Matrix m2) {

        float[][] tmp = new float[m1.getSize()][m1.getSize()];

        if (m1.getSize() == m2.getSize()) {
            for (int i = 0; i < m1.getSize(); i++) {
                for (int j = 0; j < m1.getSize(); j++) {
                    tmp[i][j] = m1.getValues()[i][j] - m2.getValues()[i][j];
                }
            }
        } else throw new MathExceptions();

        this.value = tmp;
        return this;
    }

    @Override
    public abstract Vector productMatrixOnVector(final Matrix m1, final Vector v1);

    protected float[] getMatrixAfterProductMatrixOnVector(final Matrix m1, final Vector v1){

        float[] tmp = new float[m1.getSize()];

        if (m1.getSize() == v1.getSize()) {
            for (int i = 0; i < m1.getSize(); i++) {
                for (int j = 0; j < m1.getSize(); j++) {
                    tmp[i] = tmp[i] + m1.getValues()[i][j] * v1.getValues()[j];
                }
            }
        } else throw new MathExceptions();

        return tmp;

    }


    @Override
    public Matrix productTwoMatrix(final Matrix m1, final Matrix m2) {

        float[][] tmp = new float[m1.getSize()][m1.getSize()];

        if (m1.getSize() == m2.getSize()) {
            for (int i = 0; i < m1.getSize(); i++) {
                for (int j = 0; j < m1.getSize(); j++) {
                    for (int k = 0; k < m1.getSize(); k++) {
                        tmp[i][j] += m1.getValues()[i][k] * m2.getValues()[k][j];
                    }
                }
            }
        } else throw new MathExceptions();

        this.value = tmp;
        return this;
    }

    @Override
    public Matrix transpose(final Matrix m) {
        float[][] tmp = new float[m.getSize()][m.getSize()];

        for(int i = 0; i < m.getSize(); i++){
            for(int j = 0; j < m.getSize(); j++){
                tmp[j][i] = m.getValues()[i][j];
            }
        }

        this.value = tmp;
        return this;
    }

}
