package hackerrank.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Equal {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                int result = equal(arr);
                System.out.println(result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }

    public static int count = 0;

    public static int equal(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        calculate(0, arr);
        return count;
    }

    private static void calculate(int start, List<Integer> newList) {
        if (start + 1 >= newList.size()) return;

        int a1 = newList.get(start);
        int a2 = newList.get(start + 1);

        if (a1 == a2) {
            calculate(start + 1, newList);
            return;
        }

        int diff = a2 - a1;
        int fiveCount = diff / 5;
        int twoCount = (diff - 5 * fiveCount) / 2;
        int oneCount = (diff - 5 * fiveCount - 2 * twoCount);
        count += fiveCount + twoCount + oneCount;

        if (start + 2 < newList.size()) {
            int a3 = newList.get(start + 2);
            newList.set(start + 2, a3 + a2 - a1);
        }
        calculate(start + 1, newList);
    }
}
