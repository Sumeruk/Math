package Math;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Vector v1 = new Vector2(2,3);
        Vector v2 = new Vector2(5,5);

        Vector vRes = new Vector2();
        vRes = vRes.plusTwoVectors(v1, v2);
        System.out.println(Arrays.toString(vRes.getValues()));
    }
}
