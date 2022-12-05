package Math.matrix;

import Math.exception.MathExceptions;
import Math.vector.Vector;
import Math.vector.Vector3F;

public class Matrix3F extends AbstractMatrix implements Matrix {

    public Matrix3F(double[][] values) {
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
    protected boolean checkLengthInputValues(double[][] values) {
        return values.length == 3 && values[0].length == 3 && values[1].length == 3 && values[2].length == 3;
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
        } else throw new MathExceptions();

        vRes.setValues(tmp);
        return vRes;
    }

}