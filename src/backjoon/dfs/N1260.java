package backjoon.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N1260 {

    public static boolean[][] graph;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputValues = sc.nextLine();
        String[] inputValueArr = inputValues.split(" ");

        int N = Integer.parseInt(inputValueArr[0]);
        int M = Integer.parseInt(inputValueArr[1]);
        int V = Integer.parseInt(inputValueArr[2]);

        graph = new boolean[N][N];
        visited = new boolean[N];

        for (int n = 0; n < N; n++) {
            graph[n][n] = true;
        }

        for (int j = 0; j < M; j++) {
            String input = sc.nextLine();
            String[] inputArr = input.split(" ");

            int a = Integer.parseInt(inputArr[0]) - 1;
            int b = Integer.parseInt(inputArr[1]) - 1;

            graph[a][b] = true;
            graph[b][a] = true;

            if (a == b) {
                graph[a][b] = true;
            }
        }

        StringBuilder result = new StringBuilder();
        visited[V - 1] = true;
        dfs(graph, V - 1, result);
        System.out.println(result);

        StringBuilder bfs = new StringBuilder();
        visited = new boolean[N];
        bfs(graph, V - 1, bfs);
        System.out.println(bfs.toString());
    }

    private static void bfs(boolean[][] graph, int startNode, StringBuilder sb) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;
        sb.append(startNode + 1).append(" ");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            boolean[] adjust = graph[node];

            for (int i = 0; i < adjust.length; i++) {
                if (adjust[i] && !visited[i]) {
                    visited[i] = true;
                    sb.append(i + 1).append(" ");
                    queue.add(i);
                }
            }
        }
    }

    private static void dfs(boolean[][] graph, int startNode, StringBuilder sb) {
        boolean[] adjust = graph[startNode];

        sb.append(startNode + 1).append(" ");

        for (int i = 0; i < adjust.length; i++) {
            if (i == startNode) continue;

            if (adjust[i] && !visited[i]) {
                visited[i] = true;
                dfs(graph, i, sb);
            }
        }
    }


}
