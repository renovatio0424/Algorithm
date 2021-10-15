package backjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Virus {
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        visited = new boolean[n];

        boolean[][] computerArr = new boolean[n][n];

        for (int i = 0; i < m; i++) {
            int computer1 = scanner.nextInt() - 1;
            int computer2 = scanner.nextInt() - 1;

            computerArr[computer1][computer2] = true;
            computerArr[computer2][computer1] = true;
        }

        int result = countInfectedComputer(computerArr);

        System.out.println(result);
    }

    private static int countInfectedComputer(boolean[][] computerArr) {
        Queue<Integer> computerQueue = new LinkedList<>();
        computerQueue.offer(0);
        visited[0] = true;

        int totalInfected = 0;

        while (!computerQueue.isEmpty()) {
            int current = computerQueue.poll();

            if (current < 0 || current >= computerArr.length)
                continue;

            for (int i = 0; i < computerArr.length; i++) {
                if (!visited[i] && computerArr[current][i]) {
                    computerQueue.offer(i);
                    visited[i] = true;
                    totalInfected++;
                }

            }

        }

        return totalInfected;
    }
}
