package programmers.dfs;

// 문제 설명
// 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다. 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고,
// 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다.
// 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
//
// 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
//
// 제한사항
// 1. 컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
// 2. 각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
// 3. i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
// 4. computer[i][i]는 항상 1입니다.
public class Network {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};//{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};//

        int result = solution(n, computers);
        System.out.println("result: " + result);
    }

    private static boolean[][] visited;
    private static boolean[] visitNumber;

    private static int solution(int n, int[][] computers) {
        visited = new boolean[n][n];
        visitNumber = new boolean[n];

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    visited[i][j] = true;
                    continue;
                }

                if (!visited[i][j] && !visited[j][i]) {
                    visited[i][j] = true;
                    visited[j][i] = true;

                    if (computers[i][j] == 1) {
                        visitNumber[i] = true;
                        visitNumber[j] = true;
                        count++;
                        visitAdjustNode(j, true, computers);
                    }
                }
            }
        }

        for (int i = 0; i < visitNumber.length; i++) {
            if (!visitNumber[i])
                count++;
        }

        return count;
    }

    private static void visitAdjustNode(int j, boolean isConnected, int[][] computers) {
        for (int k = 0; k < computers[j].length; k++) {
            if (!visited[j][k] && computers[j][k] == (isConnected ? 1 : 0)) {
                visited[j][k] = true;
                visited[k][j] = true;
                visitNumber[j] = true;
                visitNumber[k] = true;
                visitAdjustNode(k, isConnected, computers);
            }
        }
    }
}
