package hackerrank.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TheCoinChangeProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = getWays2(n, c);

        System.out.println(ways);
    }

    public static long getWays2(int n, List<Long> c) {
        // Write your code here
        int[] dp = new int[n+1];

        dp[0] = 1;

        for (long coin : c) {
            for (int i = (int) coin; i <= n; i++) {
                dp[i] += dp[i - (int) coin];
            }
        }

        return dp[n];
    }

    public static long getWays(int n, List<Long> c) {
        // Write your code here
        findWay(n, 0, c, new ArrayList<>());
        return waySet.size();
    }

    public static Set<WayData> waySet = new HashSet<>();

    private static void findWay(int n, long sum, List<Long> c, ArrayList<Long> wayList) {
        if (sum > n) return;

        if (n == sum) {
            Collections.sort(wayList);
            waySet.add(new WayData(wayList));
            return;
        }

        for (long change : c) {
            ArrayList<Long> copyList = new ArrayList<>(wayList);
            copyList.add(change);
            findWay(n, sum + change, c, copyList);
        }
    }

    private static class WayData {
        private final List<Long> wayList;

        WayData(List<Long> wayList) {
            this.wayList = wayList;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof WayData)) return false;
            WayData other = (WayData) o;
            return wayList.containsAll(other.wayList);
        }

        @Override
        public int hashCode() {
            return Objects.hash(wayList);
        }
    }
}
