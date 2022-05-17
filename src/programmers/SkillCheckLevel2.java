package programmers;

import java.util.*;

public class SkillCheckLevel2 {
    public static void main(String[] args) {
        int result = solution("baabaa");
        String[] result2 = solution(new int[][]{
                {2, -1, 4},
                {-2, -1, 4},
                {0, -1, 1},
                {5, -8, -12},
                {5, 8, 12}
//                {1, -1, 0}, {2, -1, 0}
//                {0, 1, -1}, {1, 0, -1}, {1, 0, 1}
        });
//        System.out.println(result);
        System.out.println(Arrays.toString(result2));
    }

    public static int solution(String s) {
        HashSet<Character> characterSet = new HashSet<Character>();
        for (char character : s.toCharArray()) {
            characterSet.add(character);
        }
        ArrayList<Character> a = new ArrayList(characterSet);

        int idx = 0;

        while (idx < a.size()) {
            char current = a.get(idx);
            StringBuilder sb = new StringBuilder();
            String duplicate = sb.append(current).append(current).toString();

            if (!s.contains(duplicate)) {
                idx++;
                continue;
            }

            s = s.replaceAll(duplicate, "");
            idx = 0;
        }

        if (s.length() == 0) return 1;
        return 0;
    }

    public static String[] solution(int[][] line) {
        String[] answer = {};

        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                int[] line1 = line[i];
                int[] line2 = line[j];

                Point point = findPoint(line1[0], line1[1], line1[2], line2[0], line2[1], line2[2]);
                if (point != null) points.add(point);
            }
        }

        System.out.println(Collections.unmodifiableList(points));
        return answer;
    }

    public static class Point {
        private int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static Point findPoint(int a1, int b1, int c1, int a2, int b2, int c2) {
        if (a1 * b2 - a2 * b1 == 0) return null;

        int topX = (b1 * c2 - b2 * c1);
        int bottomX = (a1 * b2 - a2 * b1);
        if (topX % bottomX != 0) return null;
        int x = topX / bottomX;

        int topY = - (a1 * b1 * c2) + (a1 * b2 * c1) + (a1 * b2 * c1) - (a2 * b1 * c1);
        int bottomY = a1 * b1 * b2 - a2 * b1 * b1;
        if (topY % bottomY != 0) return null;
        int y = topY / bottomY;

        return new Point(x, y);
    }
}
