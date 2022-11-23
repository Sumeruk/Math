package Math.vector;

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
    public Vector vectorProduct(Vector v1, Vector v2) {
        return null;
    }

    @Override
    protected boolean checkLengthInputValues(double[] values) {
        return values.length == 2;
    }
}
