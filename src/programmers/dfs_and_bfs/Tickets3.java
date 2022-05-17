package programmers.dfs_and_bfs;

import java.util.Arrays;

public class Tickets3 {
    public static void main(String[] args) {
        String[][] tickets = new String[][]{
//                {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}
                {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}
//                {"ICN", "ATL"}, {"ICN", "JFK"}, {"JFK", "ICN"}
        };

        String[] result = solution(tickets);

        System.out.println(Arrays.toString(result));
    }

    private static String[] solution(String[][] tickets) {
        String pastPath = null;

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                String start = tickets[i][0] + " " + tickets[i][1];

                boolean[] visited = new boolean[tickets.length];
                visited[i] = true;

                findPath(tickets, 1, visited, start);
                String path = start;

                if (pastPath == null) pastPath = path;

                if (path.split(" ").length == tickets.length) {
                    if (pastPath.compareTo(path) > 0) {
                        pastPath = path;
                    }
                }
            }
        }

        if (pastPath == null) return new String[1];
        return  pastPath.split(" ");
    }

    private static void findPath(String[][] tickets, int visitCount, boolean[] visited, String path) {
        if (visitCount == tickets.length) return;

        String[] pathArr = path.split(" ");
        String last = pathArr[pathArr.length - 1];

        for (int i = 0 ; i < tickets.length; i++) {
            if (!visited[i] && last.equals(tickets[i][0])) {
                visited[i] = true;
                path += " " + tickets[i][1];
                findPath(tickets, visitCount + 1, visited, path);
                visited[i] = false;
            }
        }
    }
}
