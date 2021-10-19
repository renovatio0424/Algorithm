package backjoon.implementation;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        boolean[][] appArr = new boolean[N][N];

        for (int i = 0; i < K; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            appArr[x][y] = true;
        }

        int L = scanner.nextInt();
        scanner.nextLine();

        String[] directionArr = new String[L];
        for (int i = 0; i < L; i++) {
            directionArr[i] = scanner.nextLine();
        }

        int result = getEndTime(N, appArr, directionArr);

        System.out.println(result);
    }

    private static int getEndTime(int n, boolean[][] appArr, String[] directionArr) {
        Deque<Point> snakeQueue = new LinkedList<>();
        snakeQueue.add(new Point(0, 0));

        int time = 0;

        int directionIdx = 0;
        String[] splitDirectionArr = directionArr[directionIdx].split(" ");
        int changeTime = Integer.parseInt(splitDirectionArr[0]);
        String direction = splitDirectionArr[1];

        int angleIdx = 0;
        int[][] angleArr = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (true) {
            Point head = snakeQueue.getLast().clone();

            if (time == changeTime) {
                //이동하기
                if (direction.equals("L")) {
                    angleIdx--;
                    if (angleIdx < 0) {
                        angleIdx = angleArr.length - 1;
                    }
                } else if (direction.equals("D")) {
                    angleIdx++;
                    angleIdx %= 4;
                }
                // 다음 change time , direction update 하기
                directionIdx++;
                if (directionIdx < directionArr.length) {
                    splitDirectionArr = directionArr[directionIdx].split(" ");
                    changeTime = Integer.parseInt(splitDirectionArr[0]);
                    direction = splitDirectionArr[1];
                }
            }

            int[] angle = angleArr[angleIdx];

            head.x += angle[0];
            head.y += angle[1];

            //게임 밖으로 나갔는지 ?
            if (head.x >= n || head.y >= n || head.x < 0 || head.y < 0) {
                time++;
                break;
            }

            //몸과 부딪혔는지?
            if (snakeQueue.contains(head)) {
                time++;
                break;
            }

            //사과 없다면?
            if (!appArr[head.y][head.x] && snakeQueue.size() > 2) {
                snakeQueue.pop();
            } else {
                appArr[head.y][head.x] = false;
            }

            snakeQueue.add(head);
            time++;
        }

        return time;
    }

    static class Point {
        int x = 0;
        int y = 0;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point clone() {
            return new Point(x, y);
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

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
