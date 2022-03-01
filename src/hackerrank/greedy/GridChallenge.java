package hackerrank.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class GridChallenge {
    public static void main(String[] args) throws IOException {
        List<String> grid = Arrays.asList(
                "eabcd",
                "fghij",
                "olkmn",
                "trpqs",
                "xywuv"

        );
        String result = gridChallenge(grid);
        System.out.println(result);
    }

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        for (int i = 0; i < grid.get(0).length(); i++) {
            char prev = 'a';

            for (int j = 0; j < grid.size(); j++) {
                String origin = grid.get(j);
                char[] sortedArr = origin.toCharArray();
                Arrays.sort(sortedArr);
                String sortString = new String(sortedArr);
                if (!origin.equals(sortString)) return "NO";

                char current = grid.get(j).charAt(i);
                if (current - prev < 0) return "NO";
                prev = current;
            }
        }

        return "YES";
    }

}
