package programmers.example;

public class Nation124 {
    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            String result = solution(i);
            System.out.println(i + "] " + result);
        }
    }

    //9 -> 3^2
    private static String solution(int n) {
        int remain;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            remain = n % 3;
            n = n / 3;
            if (remain == 0) {
                n -= 1;
                remain = 4;
            }
            sb.insert(0, remain);
        }
        return sb.toString();
    }
}
