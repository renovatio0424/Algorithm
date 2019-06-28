package bfs;

/*
철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.
토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다.

창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다.
보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다.
대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다.
철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.

토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라.
단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.

첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다.
M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다.
단, 2 ≤ M,N ≤ 1,000 이다. 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.
즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다.
하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다.
정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.

sample 1

6 4
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1

8

sample 2

6 4
0 -1 0 0 0 0
-1 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1

-1

sample 3

6 4
1 -1 0 0 0 0
0 -1 0 0 0 0
0 0 0 0 -1 0
0 0 0 0 -1 1

6

sample 4

5 5
-1 1 0 0 0
0 -1 -1 -1 0
0 -1 -1 -1 0
0 -1 -1 -1 0
0 0 0 0 0

14

sample 5

2 2
1 -1
-1 1

0
*/

import java.util.*;

public class BfsSolution7 {
    private static int N,M;
    private static ArrayList<Position> startPositionList = new ArrayList<>();
    private static HashMap<Position, Integer> timeMap = new HashMap<>();
    private static int[][] tomatoMap;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        tomatoMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tomatoMap[i][j] = scanner.nextInt();
                if (tomatoMap[i][j] == 1)
                    startPositionList.add(new Position(i, j));
            }
        }

        countTimeAllRipedTomato();
    }

    private static void countTimeAllRipedTomato() {
        if (isAlreadyRipe()) {
            System.out.print(0 + "");
            return;
        }

        Queue<Position> queue = new LinkedList<>(startPositionList);
        for (Position start : startPositionList)
            timeMap.put(start, 1);

        Position currentPosition = null;

        while (!queue.isEmpty()) {
            currentPosition = queue.poll();

            Position[] nextPositionArr = {
                    new Position(currentPosition.x - 1, currentPosition.y),
                    new Position(currentPosition.x + 1, currentPosition.y),
                    new Position(currentPosition.x, currentPosition.y - 1),
                    new Position(currentPosition.x, currentPosition.y + 1)
            };

            for(Position nextPosition: nextPositionArr){
                if (nextPosition.x < 0 || nextPosition.x >= N || nextPosition.y < 0 || nextPosition.y >= M) continue;

                if(tomatoMap[nextPosition.x][nextPosition.y] == 0 && !isVisitedPosition(nextPosition)){
                    queue.add(nextPosition);
                    int currentTime = timeMap.get(currentPosition);
                    timeMap.put(nextPosition, currentTime + 1);
                }
            }
        }
        if (isAllRipe()&& currentPosition != null) {
            System.out.print(timeMap.get(currentPosition) + "");
        } else {
            System.out.print("-1");
        }
    }

    private static boolean isVisitedPosition(Position position) {
        for(Position visitedPosition: timeMap.keySet()){
            if(visitedPosition.isEqualPosition(position))
                return true;
        }
        return false;
    }

    private static boolean isAlreadyRipe() {
        return isAllRipe();
    }

    private static boolean isAllRipe() {
        for (int i = 0; i < tomatoMap.length; i++) {
            for (int j = 0; j < tomatoMap.length; j++) {
                if (tomatoMap[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    static class Position {
        /*
        1 : 익은 상태
        0 : 덜 익은 상태
        -1 : 썩은 상태
        */
        int x, y;

        Position(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        boolean isEqualPosition(Position position) {
            return x == position.x && y == position.y;
        }
    }
}
