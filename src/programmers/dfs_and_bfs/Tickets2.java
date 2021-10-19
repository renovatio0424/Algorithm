package programmers.dfs_and_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Tickets2 {
    public static void main(String[] args) {
        String[][] tickets = new String[][]{
//                {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}
//                {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}
                {"ICN", "ATL"}, {"ICN", "JFK"}, {"JFK", "ICN"}


        };

        String[] result = solution(tickets);

        System.out.println(Arrays.toString(result));
    }

    private static String[] solution(String[][] tickets) {
        ArrayList<String> resultList = new ArrayList<>();

        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].equals(o2[0]))
                    return o1[1].compareTo(o2[1]);
                else
                    return o1[0].compareTo(o2[0]);
            }
        });

        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];

            if (ticket[0].equals("ICN")) {
                boolean[] visited = new boolean[tickets.length];
                ArrayList<String> pathList = new ArrayList<>();

                pathList.add("ICN");
                visited[i] = true;

                findPath(ticket, tickets, pathList, visited);

                if (pathList.size() != ticket.length + 1)
                    continue;

                StringBuilder sb = new StringBuilder();
                for (String result : pathList) {
                    sb.append(result);
                    sb.append(" ");
                }

                resultList.add(sb.toString());
                break;
            }
        }

        Collections.sort(resultList);

        return resultList.get(0).split(" ");
    }

    private static void findPath(String[] startsTicket, String[][] tickets, ArrayList<String> resultList, boolean[] visited) {
        if (resultList.size() == tickets.length) {
            resultList.add(startsTicket[1]);
            return;
        }

        resultList.add(startsTicket[1]);

        //방문 처리
        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];

            if (ticket[0].equals(startsTicket[0]) && ticket[1].equals(startsTicket[1])) {
                visited[i] = true;
            }
        }

        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            if (!visited[i] && startsTicket[1].equals(ticket[0])) {
                findPath(ticket, tickets, resultList, visited);
                break;
            }
        }
    }
}
