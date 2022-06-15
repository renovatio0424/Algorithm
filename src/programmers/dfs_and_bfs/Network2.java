package programmers.dfs_and_bfs;

public class Network2 {
    public static void main(String[] args) {
        //ex 1
//        int n = 3;
//        int[][] computers = new int[][]{
//                {1, 1, 0},
//                {1, 1, 0},
//                {0, 0, 1}
//        };

        //ex 2
        int n = 3;
        int[][] computers = new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        int result = solution(n, computers);
        System.out.println(result);
    }

    public static int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int networkCount = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            visitNetworks(i, visited, computers);
            networkCount++;
        }

        return networkCount;
    }

    public static void visitNetworks(int start, boolean[] visited, int[][] computers) {
        if (visited[start]) return;

        visited[start] = true;
        int[] computerNetworkArr = computers[start];

        for (int i = 0; i < computerNetworkArr.length; i++) {
            if (i == start) continue;

            boolean isConnected = computerNetworkArr[i] == 1;
            if (isConnected) {
                visitNetworks(i, visited, computers);
            }
        }
    }
}
