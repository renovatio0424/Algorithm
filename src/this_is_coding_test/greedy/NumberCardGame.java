package this_is_coding_test.greedy;

import java.util.Scanner;

public class NumberCardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] cardArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cardArr[i][j] = scanner.nextInt();
            }
        }

        int result = playNumberCardGame(cardArr);

        System.out.println(result);
    }

    private static int playNumberCardGame(int[][] cardArr) {
        int result = 0;

        for (int i = 0; i < cardArr.length; i++) {
            int rowMin = 100;
            for (int j = 0; j < cardArr[0].length; j++) {
                rowMin = Math.min(rowMin, cardArr[i][j]);
            }

            result = Math.max(result, rowMin);
        }

        return result;
    }
}
