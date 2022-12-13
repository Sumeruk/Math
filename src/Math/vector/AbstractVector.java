package Math.vector;

import Math.exception.MathExceptions;

public abstract class AbstractVector implements Vector {
    protected int size;
    protected float[] values;

    @Override
    public abstract Vector vectorProduct(Vector v1, Vector v2);

    protected abstract boolean checkLengthInputValues(float[] values);

    @Override
    public float[] getValues() {
        return values;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setValues(float[] values){
        if(checkLengthInputValues(values)){
            this.values = values;
            this.size = values.length;
        } else throw new MathExceptions();
    }

    @Override
    public Vector plusTwoVectors(Vector v1, Vector v2) {

        if (v1.getSize() == v2.getSize()) {
            float[] tmp = new float[v1.getSize()];

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
            float[] tmp = new float[v1.getSize()];

            for (int i = 0; i < v1.getSize(); i++) {
                tmp[i] = v1.getValues()[i] - v2.getValues()[i];
            }

            this.values = tmp;
        } else throw new MathExceptions();
        return this;
    }

    @Override
    public Vector multiplyVectorOnScalar(Vector v1, float scalar) {

        float[] tmp = new float[v1.getSize()];

        for (int i = 0; i < v1.getSize(); i++) {
            tmp[i] = v1.getValues()[i] * scalar;
        }

        this.values = tmp;

        return this;
    }

    @Override
    public Vector divisionVectorOnScalar(Vector v1, float scalar){

        float[] tmp = new float[v1.getSize()];

        // todo check 0
        if (scalar != 0) {

            for (int i = 0; i < v1.getSize(); i++) {
                tmp[i] = v1.getValues()[i] / scalar;
            }

            this.values = tmp;
        } else {
            throw new MathExceptions();
        }

        return this;
    }

    @Override
    public float vectorLength(Vector v1){
        float tmp = 0;

        for (int i = 0; i < v1.getSize(); i++) {
            tmp = tmp + v1.getValues()[i] * v1.getValues()[i];
        }

        return (float) Math.sqrt(tmp);
    }

    @Override
    public Vector vectorNormalization(Vector v1){

        float[] tmp = new float[v1.getSize()];

        float length = v1.vectorLength(v1);
        for (int i = 0; i < v1.getSize(); i++){
            tmp[i] = v1.getValues()[i] / length;
        }

        this.values = (tmp);

        return this;
    }

    @Override
    public float scalarMultiplyVectorOnVector(Vector v1, Vector v2){
        float tmp = 0;
        if(v1.getSize() == v2.getSize()){
            for (int i = 0; i < v1.getSize(); i++){
                tmp = tmp + v1.getValues()[i] * v2.getValues()[i];
            }
        } else throw new MathExceptions();
        return tmp;
    }
}
