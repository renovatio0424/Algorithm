package hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class HackerlandRadioTransmitters {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> x = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = hackerlandRadioTransmitters(x, k);

        System.out.println(result);

        bufferedReader.close();
    }

    private static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        if (x.size() == 1) return 1;

        Collections.sort(x);

        int count = 0;
        int range = 0;

        for (int i = 0; i < x.size(); i++) {
            if (x.get(i) >= range) {
                count++;

                int currentRange = x.get(i) + k;
                int currentIdx = i;

                while (currentIdx < x.size() && x.get(currentIdx) <= currentRange) {
                    currentIdx++;
                }

                range = x.get(--currentIdx) + k + 1;
                i = currentIdx;
            }
        }

        return count;
    }
}
