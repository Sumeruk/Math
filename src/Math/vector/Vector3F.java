package Math.vector;

import Math.exception.MathExceptions;

public class Vector3F extends AbstractVector implements Vector {

    public Vector3F() {
    }

    public Vector3F(float[] values) {
        if (checkLengthInputValues(values)) {
            super.values = values;
            super.size = values.length;
        } else throw new MathExceptions();
    }

    public Vector3F(int v1, int v2, int v3) {
        super.values = new float[3];

        super.size = 3;

        super.values[0] = v1;
        super.values[1] = v2;
        super.values[2] = v3;
    }

    public Vector vectorProduct(Vector v1, Vector v2){
        Vector vRes = new Vector3F();
        float[] tmp = new float[3];
        if(v1.getSize() == v2.getSize() && checkLengthInputValues(v1.getValues())
                && checkLengthInputValues(v2.getValues())){
            tmp[0] = v1.getValues()[1] * v2.getValues()[2] - v1.getValues()[2] * v2.getValues()[1];
            tmp[1] = -(v1.getValues()[0] * v2.getValues()[2] - v1.getValues()[2] * v2.getValues()[0]);
            tmp[2] = v1.getValues()[0] * v2.getValues()[1] - v1.getValues()[1] * v2.getValues()[0];
        }
        vRes.setValues(tmp);
        return vRes;
    }

    @Override
    protected boolean checkLengthInputValues(float[] values) {
        return values.length == 3;
    }

}
