package backjoon.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DfsNBfs {
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int V = scanner.nextInt() - 1;

        visited = new boolean[N];
        boolean[][] graphs = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            int start = scanner.nextInt() - 1;
            int end = scanner.nextInt() - 1;
            graphs[start][end] = true;
            graphs[end][start] = true;
        }

        printDfs(graphs, V);
        visited = new boolean[N];
        printBfs(graphs, V);
    }

    //재귀 = recursive
    private static void printDfsRecursive(boolean[][] graphs, int start) {
        if (start >= graphs.length) {
            return;
        }

        System.out.print(start + 1 + " ");
        visited[start] = true;

        for (int i = start; i < graphs[0].length; i++) {
            if (graphs[start][i] && !visited[i]) {
                printDfsRecursive(graphs, i);
            }
        }
    }

    private static void printDfs(boolean[][] graphs, int start) {
        // 1. 탐색 시작 노드를 스택에 삽입하고 방문 처리를 한다.
        Stack<Integer> nodeStack = new Stack<>();
        nodeStack.push(start);
        visited[start] = true;
        StringBuilder sb = new StringBuilder();
        sb.append(start + 1);
        sb.append(" ");

        //sb.append("1 ")
        //sb.append("2 ")
        //sb.append("3 ")
        //sb.append("4 ")
        //sb.toString() = "1 2 3 4 "


        //3. 더 이상 수행할 수 없을때까지 반복한다.
        while (!nodeStack.isEmpty()) {
            int current = nodeStack.pop();

            for (int i = 0; i < graphs.length; i++) {
                //2. 스택의 최상단 노드에 방문하지 않은 인접 노드가 있으면
                if (!visited[i] && graphs[current][i]) {
                    // 그 인접 노드를 스택에 넣고 방문 처리를 한다.
                    visited[i] = true;
                    nodeStack.push(i);
                    sb.append(i + 1);
                    sb.append(" ");
                    break;
                }
                //인접 노드가 없으면 스택에서 최상단 노드를 꺼낸다.
            }
        }

        System.out.println(sb.toString());
    }


    private static void printBfs(boolean[][] graphs, int start) {
        Queue<Integer> nodeQueue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        nodeQueue.offer(start);
        visited[start] = true;
        sb.append(start + 1);
        sb.append(" ");

        while (!nodeQueue.isEmpty()) {
            int current = nodeQueue.poll();

            for (int i = 0; i < graphs.length; i++) {
                if (!visited[i] && graphs[current][i]) {
                    visited[i] = true;
                    nodeQueue.offer(i);
                    sb.append(i + 1);
                    sb.append(" ");
                }
            }
        }

        System.out.println(sb.toString());
    }
}
