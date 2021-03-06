package dfs;

public class IceCream {

    public static void main(String[] args) {
        int N = 4;
        int M = 5;
        int[][] icePlane = {
                {0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };

        int result = solution(icePlane);

        System.out.println("result: " + result);
    }

    private static boolean[][] visited = new boolean[4][5];

    private static int solution(int[][] icePlane) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (icePlane[i][j] == 0 && !visited[i][j]) {
                    visitIcePlane(icePlane, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void visitIcePlane(int[][] icePlane, int i, int j) {
        if (0 <= i && i < icePlane.length && 0 <= j && j < icePlane[i].length) {
            if (icePlane[i][j] != 0 || visited[i][j])
                return;

            visited[i][j] = true;

            visitIcePlane(icePlane, i + 1, j);
            visitIcePlane(icePlane, i - 1, j);
            visitIcePlane(icePlane, i, j + 1);
            visitIcePlane(icePlane, i, j - 1);
        }
    }

}
