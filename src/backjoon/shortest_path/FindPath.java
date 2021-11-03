package backjoon.shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindPath {

    private static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int distance = Integer.parseInt(input[j]);
                graph[i][j] = distance == 0 ? INF : distance;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                System.out.print((graph[a][b] == INF ? 0 : 1) + " ");
            }
            System.out.println();
        }
    }
}
