package hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class GridlandMetro {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> track = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                track.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        BigInteger result = gridlandMetro(n, m, k, track);

        System.out.println(result);

        bufferedReader.close();
    }

    public static BigInteger gridlandMetro(int n, int m, int k, List<List<Integer>> track) {
        // Write your code here
        BigInteger bigN = new BigInteger("" + n);
        BigInteger bigM = new BigInteger("" + m);
        if (k == 0) return bigN.multiply(bigM);

        BigInteger count = BigInteger.ZERO;

        track.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });

        int prevRow = 0;
        int prevStart = 0;
        int prevEnd = 0;

        boolean[] rowVisited = new boolean[n];

        for (List<Integer> trackList : track) {
            int row = trackList.get(0);
            int start = trackList.get(1);
            int end = trackList.get(2);
            rowVisited[row - 1] = true;

            if (row == prevRow) {
                prevStart = Math.min(prevStart, start);
                prevEnd = Math.max(prevEnd, end);
                continue;
            }

            if (prevRow == 0) {
                prevRow = row;
                prevStart = start;
                prevEnd = end;
                continue;
            }

            BigInteger lampCount = bigN.subtract(new BigInteger("" + (prevEnd - prevStart + 1)));
            count = count.add(lampCount);
            prevRow = row;
            prevStart = start;
            prevEnd = end;
        }

        //last
        rowVisited[prevRow - 1] = true;
        BigInteger lampCount = bigN.subtract(new BigInteger("" + (prevEnd - prevStart + 1)));
        count = count.add(lampCount);
        // track 없는 열
        for (boolean visited : rowVisited) {
            if (!visited) count = count.add(bigN);
        }

        return count;
    }
}
