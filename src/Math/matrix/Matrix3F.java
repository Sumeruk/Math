package Math.matrix;

import Math.exception.MathExceptions;
import Math.vector.Vector;
import Math.vector.Vector3F;

public class Matrix3F extends AbstractSquareMatrix implements Matrix {

    public Matrix3F(float[][] values) {
        if (checkLengthInputValues(values)) {
            super.value = values;
            super.size = values.length;
        } else {
            throw new MathExceptions();
        }
    }

    public Matrix3F() {
    }

    @Override
    protected boolean checkLengthInputValues(float[][] values) {
        return values.length == 3 && values[0].length == 3 && values[1].length == 3 && values[2].length == 3;
    }

    // todo все в абстракцию
    @Override
    public Vector multiplyMatrixOnVector(Matrix m1, Vector v1) {

        Vector vRes = new Vector3F();

        float[] tmp = new float[m1.getSize()];

        if (m1.getSize() == v1.getSize()) {
            for (int i = 0; i < m1.getSize(); i++) {
                for (int j = 0; j < m1.getSize(); j++) {
                    tmp[i] = (float) (tmp[i] + m1.getValues()[i][j] * v1.getValues()[j]);
                }
            }
        } else throw new MathExceptions();

        vRes.setValues(tmp);
        return vRes;
    }

}