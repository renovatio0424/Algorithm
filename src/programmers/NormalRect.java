package programmers;

public class NormalRect {
    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        long result = solution(w, h);
        System.out.println(result);
    }

    private static long solution(int w, int h) {
        int gcd = getGCD(h, w);
        int gcdH = h / gcd;
        int gcdW = w / gcd;

        long unusableRectCount = getUnusableRect(gcdW, gcdH) * gcd;

        return (long) w * h - unusableRectCount;
    }

    private static long getUnusableRect(int w, int h) {
        double slope = (double) h / w;
        int count = 0;
        for (int i = 1; i < w; i++) {
            double moveW = i * slope;
            if (moveW != (long) moveW) {
                count++;
            }
        }
        double inverseSlope = (double) w / h;
        for (int j = 1; j < h; j++) {
            double moveH = j * inverseSlope;
            if (moveH != (long) moveH) {
                count++;
            }
        }
        return count + 1;
    }

    public static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1 % num2);
    }
}
