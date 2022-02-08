package hackerrank.greedy;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BeautifulPair {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = beautifulPairs(A, B);

        System.out.println(result);
        bufferedReader.close();
    }

    public static int beautifulPairs(List<Integer> A, List<Integer> B) {
        // Write your code here
        //a 와 겹치는 b 인덱스 저장하는 셋
        HashSet<Integer> bSet = new HashSet<>();

        for (int a : A) {
            for (int i = 0; i < B.size(); i++) {
                int b = B.get(i);
                if (a == b) {
                    if (bSet.contains(i)) continue;

                    bSet.add(i);
                    break;
                }
            }
        }

        int count = bSet.size();
        // A = {1}, B = {1}
        if (count == B.size()) {
            return count - 1;
        }

        return count + 1;
    }
}
