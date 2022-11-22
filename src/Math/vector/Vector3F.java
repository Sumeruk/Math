package Math.vector;

public class Vector3F extends AbstractVector implements Vector {

    public Vector3F() {
    }

    public Vector3F(double[] values) {
        if (checkLengthInputValues(values)) {
            super.values = values;
        }
    }

    public Vector3F(int v1, int v2, int v3) {
        super.values = new double[3];

        super.size = 3;

        super.values[0] = v1;
        super.values[1] = v2;
        super.values[2] = v3;
    }

    @Override
    public void setValues(double[] values) {
        if (checkLengthInputValues(values)) {
            this.values = values;
        }
    }

    public Vector vectorProduct(Vector v1, Vector v2){
        Vector vRes = new Vector3F();
        double[] tmp = new double[3];
        if(v1.getSize() == v2.getSize()){
            tmp[0] = v1.getValues()[1] * v2.getValues()[2] - v1.getValues()[2] * v2.getValues()[1];
            tmp[1] = -(v1.getValues()[0] * v2.getValues()[2] - v1.getValues()[2] * v2.getValues()[0]);
            tmp[2] = v1.getValues()[0] * v2.getValues()[1] - v1.getValues()[1] * v2.getValues()[0];
        }
        vRes.setValues(tmp);
        return vRes;
    }

    private boolean checkLengthInputValues(double[] values) {
        return values.length == 3;
    }

}
