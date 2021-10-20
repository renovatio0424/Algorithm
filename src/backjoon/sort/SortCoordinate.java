package backjoon.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortCoordinate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        ArrayList<Point> pointList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            pointList.add(new Point(x, y));
        }

        Collections.sort(pointList);

        for (Point current : pointList) {
            System.out.println(current.x + " " + current.y);
        }
    }

    static class Point implements Comparable{
        int x,y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            Point other = (Point) o;

            if (x > other.x)
                return 1;
            else if (x < other.x)
                return -1;
            else {
                if (y > other.y)
                    return 1;
                else if (y < other.y)
                    return -1;
            }
            return 0;
        }
    }
}
