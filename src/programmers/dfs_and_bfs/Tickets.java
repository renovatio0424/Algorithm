package programmers.dfs_and_bfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tickets {
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO" }, {"ICN", "ATL" }, {"SFO", "ATL" }, {"ATL", "ICN" }, {"ATL", "SFO" }};//{{"ICN", "JFK" }, {"HND", "IAD" }, {"JFK", "HND" }};

        String[] result = solution(tickets);

        StringBuilder sb = new StringBuilder();
        for (String s : result) {
            sb.append(s).append(" ");
        }

        System.out.println(sb.toString());
    }


    private static String[] solution(String[][] tickets) {
        String[][] startTickets = findStartTickets(tickets);
        List<List<String[]>> availablePathList = new ArrayList<>();

        for (String[] startTicket : startTickets) {
            List<String[]> ticketList = new ArrayList<>();

            ticketList.add(startTicket);
            availablePathList.add(ticketList);

            addAirPlanePath(tickets, availablePathList, availablePathList.indexOf(ticketList));
        }

        availablePathList.sort(new PathComparator());

        return ticketListToPath(availablePathList.get(0));
    }

    private static String[][] findStartTickets(String[][] tickets) {
        ArrayList<Integer> startIdxList = new ArrayList<>();

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                startIdxList.add(i);
            }
        }

        String[][] result = new String[startIdxList.size()][2];

        for (int idx : startIdxList) {
            result[idx] = tickets[idx];
        }

        return result;
    }

    private static String[] ticketListToPath(List<String[]> ticketList) {
        String[] result = new String[ticketList.size() + 1];
        result[0] = ticketList.get(0)[0];

        for (int i = 0; i < ticketList.size(); i++) {
            String[] ticket = ticketList.get(i);
            result[i + 1] = ticket[1];
        }

        return result;
    }

    private static void addAirPlanePath(String[][] tickets, List<List<String[]>> availablePathList, int pathIdx/*List<String[]> path*/) {
        List<String[]> path = availablePathList.get(pathIdx);

        if (path.size() == tickets.length + 1)
            return;

        ArrayList<String[]> availableTicketList = new ArrayList<>();
        String lastPort = path.get(path.size() - 1)[1];

        for (String[] ticket : tickets) {
            String startPort = ticket[0];

            if (lastPort.equals(startPort)) {
                availableTicketList.add(ticket);
            }
        }

        int count = 0;
        for (String[] ticket : availableTicketList) {
            if (path.contains(ticket)) continue;

            if (count == 0) {
                path.add(ticket);
                addAirPlanePath(tickets, availablePathList, pathIdx);
            } else {
                ArrayList<String[]> newPathList = new ArrayList<>(path);
                availablePathList.add(newPathList);
                newPathList.add(ticket);

                addAirPlanePath(tickets, availablePathList, pathIdx + count);
            }

            count++;
        }
    }

    static class PathComparator implements Comparator<List<String[]>> {

        @Override
        public int compare(List<String[]> o1, List<String[]> o2) {
            for (int i = 0; i < o1.size(); i++) {
                if (!o1.get(i)[1].equals(o2.get(i)[1])) return o1.get(i)[1].compareTo(o2.get(i)[1]);
            }
            return 0;
        }
    }

}
