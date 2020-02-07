package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BirthdayChocolate {
    public static void main(String[] args) {
        String input = "2 5 1 3 4 4 3 5 1 1 2 1 4 1 3 3 4 2 1";
        List<Integer> s = Stream.of(input.replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        int d = 18;
        int m = 7;

        System.out.println(birthday(s,d,m));
    }

    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
        int result = 0;

//        if(m == 1 && (s.get(0) == d))
//            return 1;

        for(int idx = 0 ; idx <= s.size() - m; idx++) {
            int sum = 0;

            for(int i = idx; i < idx + m; i ++) {
                sum += s.get(i);
            }

            if(sum == d) {
                result++;
            }
        }
        return result;
    }
}

