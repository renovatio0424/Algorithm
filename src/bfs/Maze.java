package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    public static int n = 5;
    public static int m = 6;
    public static int[][] maze = {
            {1, 0, 1, 0, 1, 0},
            {1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1}
    };

    public static void main(String[] args) {
        int result = bfs(0, 0);

        System.out.println("result: " + result);
    }

    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};


    private static int bfs(int x, int y) {
        Queue<MazePoint> queue = new LinkedList<>();
        queue.offer(new MazePoint(x, y));

        while (!queue.isEmpty()) {
            MazePoint point = queue.poll();
            x = point.getX();
            y = point.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if (maze[nx][ny] == 1) {
                    maze[nx][ny] = maze[x][y] + 1;
                    queue.offer(new MazePoint(nx, ny));
                }
            }
        }

        return maze[n - 1][m - 1];
    }

    public static class MazePoint {
        private int x, y;

        public MazePoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }


    private static void move(MazePoint startPoint) {
        Queue<MazePoint> queue = new LinkedList<>();
        queue.offer(new MazePoint(1, 1));
    }
}
