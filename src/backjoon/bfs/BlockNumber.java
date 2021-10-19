package backjoon.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BlockNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        boolean[][] map = new boolean[N][N];

        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < N; j++) {
                int inputNumber = input.charAt(j) - '0';
                map[i][j] = inputNumber == 1;
            }
        }

        ArrayList<Integer> resultList = countBlock(map);
        Collections.sort(resultList);

        System.out.println(resultList.size());

        for (int result : resultList) {
            System.out.println(result);
        }
    }

    private static ArrayList<Integer> countBlock(boolean[][] map) {
        ArrayList<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                int result = searchBlock(i, j, map);
                if (result != 0)
                    resultList.add(result);
            }
        }

        return resultList;
    }

    private static int searchBlock(int i, int j, boolean[][] map) {
        if (i < 0 || i >= map.length || j < 0 || j >= map.length)
            return 0;

        if (!map[i][j])
            return 0;

        map[i][j] = false;

        int up = searchBlock(i + 1, j, map);
        int down = searchBlock(i - 1, j, map);
        int right = searchBlock(i, j + 1, map);
        int left = searchBlock(i, j - 1, map);

        return up + down + right + left + 1;
    }
}
