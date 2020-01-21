package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class BetweenTwoSets {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        // array a 가장 작은수
        // array b 가장 작은수
        List<Integer> result = new ArrayList();
        a.sort(null);
        b.sort(null);
        // loop aArr
        // get lcm

        int lcm = lcm(a);
        if(lcm < 0)
            return 0;

        int count = 2;
        int multiply = lcm;
        while (multiply <= b.get(0)) {
            result.add(multiply);
            multiply = lcm * count;
            count ++;
        }

        // loop bArr
        List<Integer> removeList = new ArrayList<>();

        for (int valueB : b) {
            for (int valueR : result) {
                // b % resultArr[i] != 0 remove
                if(valueB % valueR != 0){
                   removeList.add(valueR);
                }
            }
        }

        for(int removeValue : removeList) {
            result.remove((Integer) removeValue);
        }
        // return resultArr
        return result.size();
    }

    private static int gcd(int a, int b) {
        int temp;
        while(b != 0) {
            temp = a;
            a = b;
            b = temp % b;
        }

        return a;
    }

    // 정수 배열을 받아들여 최대 공약수을 반환하는 메소드
    public static int gcd(List<Integer> array) {
        int result;

        if(array.size() <= 1)
            return array.get(0);

        result = gcd(array.get(0), array.get(1));
        for(int i = 2; i < array.size(); ++i)
            result = gcd(result, array.get(i));

        return result;
    }

    // 정수 배열을 받아들여 최소 공배수을 반환하는 메소드
    public static int lcm(List<Integer> array) {
        int gcd = gcd(array);
        int lcm = gcd;
        for(int i = 0; i < array.size(); ++i) {
            int result = array.get(i) / gcd;
            array.set(i, result);
            if(lcm != array.get(i))
                lcm *= array.get(i);
        }

        return lcm;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int n = Integer.parseInt(firstMultipleInput[0]);
//
//        int m = Integer.parseInt(firstMultipleInput[1]);

//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());

        List<Integer> arr = new ArrayList<>();
        List<Integer> brr = new ArrayList<>();
        int[] a = {2, 4};
        int[] b = {16, 32, 96};
        for(int valueA : a) {
            arr.add(valueA);
        }

        for(int valueB : b) {
            brr.add(valueB);
        }

        int total = BetweenTwoSets.getTotalX(arr, brr);

        System.out.println(total);
//        bufferedWriter.write(String.valueOf(total));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}

