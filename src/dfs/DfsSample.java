package dfs;

import java.util.*;

public class DfsSample {
    private static int N;
    private static boolean[][] adj = new boolean[1001][1001];
    private static boolean[] visited = new boolean[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        for(int i = 0; i < M; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u][v] = adj[v][u] = true;
        }

        printDFS(V);
    }

    private static void printDFS(int cur){
        System.out.print(cur + " ");
        visited[cur] = true;
        for(int i = 1; i <= N; i++)
            if(adj[cur][i] && !visited[i]) printDFS(i);
    }
}