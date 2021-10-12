package this_is_coding_test.dfs;

public class FrozenDrinks {
    private static boolean[][] visited;

    public static void main(String[] args) {
        int N = 4;
        int M = 5;

        int[][] frozenArr = new int[][]{
                {0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };

        visited = new boolean[N][M];

        int result = getIceCream(frozenArr);

        System.out.println(result);
    }

    private static int getIceCream(int[][] frozenArr) {
        int total = 0;

        for (int i = 0; i < frozenArr.length; i++) {
            for (int j = 0; j < frozenArr[0].length; j++) {
                if (frozenArr[i][j] == 0 && !visited[i][j]) {
                    findIceCream(i, j, frozenArr);
                    total++;
                }
            }
        }
        return total;
    }

    private static void findIceCream(int i, int j, int[][] frozenArr) {
        if (i >= frozenArr.length || j >= frozenArr[0].length)
            return;

        if (frozenArr[i][j] == 1 || visited[i][j])
            return;

        visited[i][j] = true;

        findIceCream(i + 1, j, frozenArr);
        findIceCream(i , j+1, frozenArr);
    }
}
