package this_is_coding_test.dfs;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class MazeEscape {
    private static boolean[][] visited;

    public static void main(String[] args) {
        int N = 5;
        int M = 6;

        visited = new boolean[N][M];

        int[][] mazeArr = new int[][]{
                {1, 0, 1, 0, 1, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}
        };

        int result = getMinimumMove(mazeArr);

        System.out.println(result);
    }

    private static int getMinimumMove(int[][] mazeArr) {
        Queue<Point> pointQueue = new LinkedList<>();
        pointQueue.offer(new Point(0, 0));
        visited[0][0] = true;
        int[][] moveArr = new int[][]{
                {1, 0},//우
                {0, 1},//상
                {-1, 0},//좌
                {0, -1}//하
        };
        Point end = new Point(5, 4);

        while (!pointQueue.isEmpty()) {
            Point current = pointQueue.poll();

            if (current.equals(end)) {
                break;
            }

            for (int[] move : moveArr) {
                int moveX = current.x + move[0];
                int moveY = current.y + move[1];

                if (moveX < 0 || moveX >= mazeArr[0].length || moveY >= mazeArr.length || moveY < 0) {
                    continue;
                }

                if (mazeArr[moveY][moveX] == 1 && !visited[moveY][moveX]) {
                    pointQueue.offer(new Point(moveX, moveY));
                    mazeArr[moveY][moveX] = mazeArr[current.y][current.x] + 1;
                    visited[moveY][moveX] = true;
                }
            }

        }

        return mazeArr[end.y - 1][end.x - 1];
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
