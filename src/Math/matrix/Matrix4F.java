package Math.matrix;

import Math.exception.MathExceptions;
import Math.vector.Vector;
import Math.vector.Vector4F;

public class Matrix4F extends AbstractSquareMatrix implements Matrix {

    public Matrix4F(float[][] values) {
        if (checkLengthInputValues(values)) {
            super.value = values;
            super.size = values.length;
        } else {
            throw new MathExceptions();
        }
    }

    public Matrix4F() {
    }

    @Override
    public void setZeroMatrix() {
        super.size = 4;
        super.value = new float[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
    }

    @Override
    public void setSingleMatrix() {
        super.size = 4;
        super.value = new float[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };

    }

    @Override
    protected boolean checkLengthInputValues(final float[][] values) {
        return values.length == 4 && values[0].length == 4 && values[1].length == 4 &&
                values[2].length == 4 && values[3].length == 4;
    }


    @Override
    public Vector productMatrixOnVector(final Matrix m1, final Vector v1) {
        Vector vRes = new Vector4F();

        float[] tmp = super.getMatrixAfterProductMatrixOnVector(m1, v1);

        vRes.setValues(tmp);
        return vRes;

    }

}
