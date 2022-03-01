package hackerrank.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ClimbingTheLeaderboard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = climbingLeaderboard(ranked, player);

        System.out.println(Collections.unmodifiableList(result));

        bufferedReader.close();
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        HashSet<Integer> rankSet = new HashSet<>(ranked);
        List<Integer> rankList = new ArrayList<>(rankSet);
        rankList.sort(Collections.reverseOrder());

        List<Integer> resultList = new ArrayList<>();
        for (int score : player) {
            int rank = getRank2(rankList, score);
            resultList.add(rank);
        }
        return resultList;
    }

    private static int getRank(List<Integer> rankList, int score) {
        for (int i = 0; i < rankList.size(); i++) {
            int rankScore = rankList.get(i);
            if (rankScore <= score) return i + 1;
        }
        return rankList.size() + 1;
    }

    private static int getRank2(List<Integer> rankList, int score) {
        int start = 0;
        int end = rankList.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int rankScore = rankList.get(mid);

            if (rankScore < score) {
                end = mid - 1;
            } else if (rankScore > score) {
                start = mid + 1;
            } else {
                return mid + 1;
            }
        }

        return start + 1;
    }
}
