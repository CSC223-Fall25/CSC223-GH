package csc223.gh;

public class FUber {
    public static float euclidean(float x1, float y1, float x2, float y2) {
        // Implement the method here


        double xs = Math.pow(x2-x1, 2);
        double ys = Math.pow(y2-y1, 2);
        return (float) Math.sqrt(xs + ys);
    }

    public static float manhattan(float x1, float y1, float x2, float y2) {
        // Implement the method here
        return (float) (Math.abs(x2-x1) + Math.abs(y2-y1));
    }

    public static void main(String[] args){
        System.out.println(FUber.euclidean(0, 0, 6, 6));
        System.out.println(FUber.manhattan(0, 0, 6, 6));
    }
}

