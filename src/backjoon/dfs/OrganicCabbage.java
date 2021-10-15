package backjoon.dfs;

import java.util.Scanner;

public class OrganicCabbage {

    private static int[][] moveArr = new int[][]{
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            boolean[][] map = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                map[y][x] = true;
            }

            int count = 0;

            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (countWorm(m, n, map))
                        count++;
                }
            }

            System.out.println(count);
        }
    }

    private static boolean countWorm(int x, int y, boolean[][] map) {
        if (x < 0 || x >= map[0].length || y < 0 || y >= map.length)
            return false;

        if (!map[y][x])
            return false;

        map[y][x] = false;

        for (int[] move : moveArr) {
            int moveX = x + move[0];
            int moveY = y + move[1];

            countWorm(moveX, moveY, map);
        }

        return true;
    }

}
