package Math;

public class Vector2 implements Vector {
    private int[] values = new int[2];
    private final int size = values.length;

    public Vector2(int[] values) {
        if (checkLengthInputValues(values)) {
            this.values = values;
        }
    }

    public Vector2(int v1, int v2) {
        this.values[0] = v1;
        this.values[1] = v2;
    }

    public Vector2() {
    }

    @Override
    public void setValues(int[] values) {
        if (checkLengthInputValues(values)) {
            this.values = values;
        }
    }

    @Override
    public Vector plusTwoVectors(Vector v1, Vector v2) {
        Vector vRes = new Vector2();
        int[] tmp = new int[2];
        if (v1.getSize() == v2.getSize()) {
            tmp[0] = v1.getValues()[0] + v2.getValues()[1];
            tmp[1] = v1.getValues()[1] + v2.getValues()[1];

            vRes.setValues(tmp);
        }
        return vRes;
    }

    @Override
    public Vector minusTwoVectors(Vector v1, Vector v2){
        Vector vRes = new Vector2();
        int[] tmp = new int[2];
        if (v1.getSize() == v2.getSize()) {
            tmp[0] = v1.getValues()[0] - v2.getValues()[1];
            tmp[1] = v1.getValues()[1] - v2.getValues()[1];

            vRes.setValues(tmp);
        }
        return vRes;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int[] getValues() {
        return values;
    }

    private boolean checkLengthInputValues(int[] values){
        return values.length == 2;
    }
}
