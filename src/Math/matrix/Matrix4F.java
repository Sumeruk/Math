package Math.matrix;

import Math.exception.MathExceptions;
import Math.vector.Vector;
import Math.vector.Vector4F;

public class Matrix4F extends AbstractMatrix implements Matrix{

    public Matrix4F(double[][] values) {
        if(checkLengthInputValues(values)) {
            super.value = values;
            super.size = values.length;
        } else {
            throw new MathExceptions();
        }
    }

    public Matrix4F() {
    }

    @Override
    protected boolean checkLengthInputValues(double[][] values) {
        return values.length == 4 && values[0].length == 4;
    }


    @Override
    public Vector multiplyMatrixOnVector(Matrix m1, Vector v1) {
        Vector vRes = new Vector4F();

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
}
