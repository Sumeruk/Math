package Math.vector;

import Math.exception.MathExceptions;

public abstract class AbstractVector implements Vector {
    protected int size;
    protected double[] values;

    @Override
    public abstract Vector vectorProduct(Vector v1, Vector v2);

    protected abstract boolean checkLengthInputValues(double[] values);

    @Override
    public double[] getValues() {
        return values;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setValues(double[] values){
        if(checkLengthInputValues(values)){
            this.values = values;
            this.size = values.length;
        } else throw new MathExceptions();
    }

    @Override
    public Vector plusTwoVectors(Vector v1, Vector v2) {

        if (v1.getSize() == v2.getSize()) {
            double[] tmp = new double[v1.getSize()];

            for (int i = 0; i < v1.getSize(); i++) {
                tmp[i] = v1.getValues()[i] + v2.getValues()[i];
            }

            this.values = tmp;
        } else throw new MathExceptions();
        return this;
    }

    @Override
    public Vector minusTwoVectors(Vector v1, Vector v2) {

        if (v1.getSize() == v2.getSize()) {
            double[] tmp = new double[v1.getSize()];

            for (int i = 0; i < v1.getSize(); i++) {
                tmp[i] = v1.getValues()[i] - v2.getValues()[i];
            }

            this.values = tmp;
        } else throw new MathExceptions();
        return this;
    }

    @Override
    public Vector multiplyVectorOnScalar(Vector v1, double scalar) {

        double[] tmp = new double[v1.getSize()];

        for (int i = 0; i < v1.getSize(); i++) {
            tmp[i] = v1.getValues()[i] * scalar;
        }

        this.values = tmp;

        return this;
    }

    @Override
    public Vector divisionVectorOnScalar(Vector v1, double scalar){

        double[] tmp = new double[v1.getSize()];

        for (int i = 0; i < v1.getSize(); i++) {
            tmp[i] = v1.getValues()[i] / scalar;
        }

        this.values = tmp;

        return this;
    }

    @Override
    public double vectorLength(Vector v1){
        double tmp = 0;

        for (int i = 0; i < v1.getSize(); i++) {
            tmp = tmp + v1.getValues()[i] * v1.getValues()[i];
        }

        return Math.sqrt(tmp);
    }

    @Override
    public Vector vectorNormalization(Vector v1){

        double[] tmp = new double[v1.getSize()];

        double length = v1.vectorLength(v1);
        for (int i = 0; i < v1.getSize(); i++){
            tmp[i] = v1.getValues()[i] / length;
        }

        this.values = (tmp);

        return this;
    }

    @Override
    public double scalarMultiplyVectorOnVector(Vector v1, Vector v2){
        double tmp = 0;
        if(v1.getSize() == v2.getSize()){
            for (int i = 0; i < v1.getSize(); i++){
                tmp = tmp + v1.getValues()[i] * v2.getValues()[i];
            }
        } else throw new MathExceptions();
        return tmp;
    }
}
