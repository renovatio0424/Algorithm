package programmers.monthly_code_challenge3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LightPathCycle {
    public static void main(String[] args) {
        String[] grid = new String[]{
                //1
                "SL",
                "LR"
                //2
//                "S"
                //3
//                "R",
//                "R"
        };
        int[] result = solution(grid);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(String[] grid) {
        LightPath lightPath = new LightPath(grid);
        ArrayList<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (lightPath.isFinished()) break;

                for (Direction direction : Direction.values()) {
                    int count = lightPath.move(j, i, direction);

                    if (count != -1) {
                        resultList.add(count);
                    }
                }
            }
        }

        Collections.sort(resultList);
        int[] resultArr = new int[resultList.size()];

        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = resultList.get(i);
        }
        return resultArr;
    }

    public enum Direction {
        UP(0, 1),
        RIGHT(1, 0),
        DOWN(0, -1),
        LEFT(-1, 0);

        private int dx, dy;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        public int moveX(int currentX) {
            return currentX + dx;
        }

        public int prevX(int currentX) {
            return currentX - dx;
        }

        public int moveY(int currentY) {
            return currentY + dy;
        }

        public int prevY(int currentY) {
            return currentY - dy;
        }

        public Direction turnRight() {
            if (this == UP) {
                return RIGHT;
            } else if (this == RIGHT) {
                return DOWN;
            } else if (this == DOWN) {
                return LEFT;
            } else {
                return UP;
            }
        }

        public Direction prevRight() {
            return turnLeft();
        }

        public Direction turnLeft() {
            if (this == UP) {
                return LEFT;
            } else if (this == LEFT) {
                return DOWN;
            } else if (this == DOWN) {
                return RIGHT;
            } else {
                return UP;
            }
        }

        public Direction prevLeft() {
            return turnRight();
        }
    }

    static class Point {
        int x, y;
        Direction direction;

        Point(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public Point moveNext(String grid) {
            switch (grid) {
                case "S":
                    return new Point(direction.moveX(x), direction.moveY(y), direction);
                case "L":
                    Direction turnLeft = direction.turnLeft();
                    return new Point(turnLeft.moveX(x), turnLeft.moveY(y), turnLeft);
                case "R":
                    Direction turnRight = direction.turnRight();
                    return new Point(turnRight.moveX(x), turnRight.moveY(y), turnRight);
                default:
                    //do nothing
                    return null;
            }
        }

        public Point movePrev(String grid) {
            switch (grid) {
                case "S":
                    return new Point(direction.prevX(x), direction.prevY(y), direction);
                case "L":
                    Direction prevLeft = direction.prevLeft();
                    return new Point(prevLeft.prevX(x), prevLeft.prevY(y), prevLeft);
                case "R":
                    Direction prevRight = direction.prevRight();
                    return new Point(prevRight.moveX(x), prevRight.moveY(y), prevRight);
                default:
                    //do nothing
                    return null;
            }
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Point point = (Point) o;
            return x == point.x && y == point.y && direction == point.direction;
        }
    }

    static class LightPath {
        String[] grid;
        int width, height;
        ArrayList<Point> lightPathList;

        LightPath(String[] grid) {
            this.grid = grid;
            this.width = grid[0].length() - 1;
            this.height = grid.length - 1;
            lightPathList = new ArrayList<>();
        }

        //0,0 up, down, left, right
        public int move(int x, int y, Direction direction) {
            if (lightPathList.contains(new Point(x, y, direction))) {
                return -1;
            }

            Point start = new Point(x, y, direction);

            if (!lightPathList.add(start)) return -1;

            int cycleCount = 0;

            //move
            while (true) {
//                cycleCount++;
//                cycleCount += 2;
                Point last = lightPathList.get(lightPathList.size() - 1);
                Point next = last.moveNext(getGrid(last));
                Point prev = last.movePrev(getGrid(last));

                requireBoundary(next);
                requirePrevBoundary(prev);

//                if (isCycle(next)) break;
                boolean isCycled = false;

                if (!isCycle(next)) {
                    lightPathList.add(next);
                    cycleCount++;
                } else {
                    isCycled = true;
                }

                if (!isCycle(prev)) {
                    lightPathList.add(prev);
                    cycleCount++;
                } else {
                    isCycled = true;
                }

                if (isCycled) break;

//                lightPathList.add(next);
//                lightPathList.add(prev);
            }

            return cycleCount;
        }

        private void requireBoundary(Point next) {
            if (next.x < 0) {
                next.setX(width);
            } else if (next.x > width) {
                next.setX(0);
            }

            if (next.y < 0) {
                next.setY(height);
            } else if (next.y > height) {
                next.setY(0);
            }
        }

        private void requirePrevBoundary(Point next) {
            if (next.x < 0) {
                next.setX(0);
            } else if (next.x > width) {
                next.setX(width);
            }

            if (next.y < 0) {
                next.setY(0);
            } else if (next.y > height) {
                next.setY(height);
            }
        }

        public String getGrid(Point current) {
            return "" + grid[current.y].charAt(current.x);
        }

        private boolean isCycle(Point next) {
            return lightPathList.contains(next);
        }

        private int totalPath() {
            return 8 * (width + 1) * (height + 1) - 2 * ((width) * (height + 1) + (width + 1) * (height));
        }

        public boolean isFinished() {
            return lightPathList.size() == totalPath();
        }
    }
}
