package bfs;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 문제
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
 * 정점 번호는 1번부터 N번까지이다.
 * */
public class BfsSolution1 {

    /*
     * pointCount : 모든 점의 갯수
     * adjPointCount : 인접한 점의 갯수
     * startPoint : 시작점
     * adjList : 인접한 점의 관계 표시
     * visited : 방문한 적 있는지 기록
     * */
    private static int pointCount = 0;

    private static boolean[][] adjList;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        pointCount = scanner.nextInt();
        int adjPointCount = scanner.nextInt();
        int startPoint = scanner.nextInt();

        adjList = new boolean[pointCount + 1][pointCount + 1];
        visited = new boolean[pointCount + 1];

        for (int i = 0; i < adjPointCount; i++) {
            int adj1 = scanner.nextInt();
            int adj2 = scanner.nextInt();

            adjList[adj1][adj2] = adjList[adj2][adj1] = true;
        }

        printDFS(startPoint);
        System.out.println();
        printBFS(startPoint);
    }

    private static void printBFS(int currentPoint) {
        //visited array init
        Arrays.fill(visited, false);

        Queue<Integer> visitQueue = new LinkedList<>();
        visitQueue.add(currentPoint);
        visited[currentPoint] = true;

        while (!visitQueue.isEmpty()) {
            int current = visitQueue.peek();
            visitQueue.poll();
            System.out.print(current + " ");

            for (int i = 1; i <= pointCount; i++) {
                if(adjList[current][i] && !visited[i]) {
                    visitQueue.add(i);
                    visited[i] = true;
                }
            }

        }
    }

    private static void printDFS(int currentPoint) {
        System.out.print(currentPoint + " ");
        //currentPoint 는 방문했다
        visited[currentPoint] = true;

        for (int i = 1; i <= pointCount; i++) {
            //currentPoint 와 인접해있고 방문한적이 없다면
            if (adjList[currentPoint][i] && !visited[i])
                printDFS(i);
        }

    }
}
