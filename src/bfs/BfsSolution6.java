package bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 *
 * N×M크기의 배열로 표현되는 미로가 있다.
 * 1	 0	1	1	1	1
 * 1	 0	1	0	1	0
 * 1	 0	1	0	1	1
 * 1	 1	1	0	1	1
 * 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
 * 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. => BFS
 * 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
 * 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다.
 * 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 * */
public class BfsSolution6 {
    private static int N;
    private static int M;
    private static int[][] map;
    private static HashMap<Position, Integer> moveCount;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new int[N + 1][M + 1];
        moveCount = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String mapLine = String.format("%0" + M + "d", scanner.nextInt());
            for (int j = 0; j < M; j++) {
                map[i][j] = mapLine.charAt(j) - 48;
            }
        }

        printFastEscapeCount();
    }

    static class Position {
        int x, y;

        Position(int a, int b) {
            x = a;
            y = b;
        }

        boolean isEqualPosition(Position position) {
            return x == position.x && y == position.y;
        }
    }

    private static void printFastEscapeCount() {
        Queue<Position> queue = new LinkedList<>();
        Position start = new Position(1, 1);
        Position end = new Position(N, M);
        queue.add(start);
        moveCount.put(start, 0);

        while (!queue.isEmpty()) {
            Position currentPosition = queue.poll();

            if (currentPosition.isEqualPosition(end)) {
                System.out.print(moveCount.get(currentPosition) + "");
                return;
            }

            Position[] nextPositionArr = {
                    new Position(currentPosition.x - 1, currentPosition.y),
                    new Position(currentPosition.x + 1, currentPosition.y),
                    new Position(currentPosition.x, currentPosition.y - 1),
                    new Position(currentPosition.x, currentPosition.y + 1)
            };
            for (Position nextPosition : nextPositionArr) {
                if (nextPosition.x < 0 || nextPosition.x > N || nextPosition.y < 0 || nextPosition.y > M) continue;

                if(map[nextPosition.x][nextPosition.y] == 1 && !moveCount.containsKey(nextPosition)){
                    queue.add(nextPosition);
                    int currentCount = moveCount.get(currentPosition);
                    moveCount.put(nextPosition, currentCount + 1);
                }
            }
        }

        System.out.print("NO");
    }
}
