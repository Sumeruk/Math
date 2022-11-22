package Math;

public class Vector2F extends AbstractVector implements Vector {

    public Vector2F(double[] values) {
        if (checkLengthInputValues(values)) {
            super.values = values;
        }
    }

    public Vector2F(int v1, int v2) {
        super.values = new double[2];

        super.size = 2;

        super.values[0] = v1;
        super.values[1] = v2;
    }

    public Vector2F() {
    }

    @Override
    public void setValues(double[] values) {
        if (checkLengthInputValues(values)) {
            this.values = values;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public double[] getValues() {
        return values;
    }

    private boolean checkLengthInputValues(double[] values) {
        return values.length == 2;
    }
}
