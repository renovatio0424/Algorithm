package hackerrank.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class FibonacciModified {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int t1 = Integer.parseInt(firstMultipleInput[0]);

        int t2 = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        BigInteger result = fibonacciModified(t1, t2, n);

        System.out.println(result.toString());

        bufferedReader.close();
    }

    /*
     * Complete the 'fibonacciModified' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER t1
     *  2. INTEGER t2
     *  3. INTEGER n
     */

    public static BigInteger fibonacciModified(int t1, int t2, int n) {
        // Write your code here
        String[] visited = new String[n+1];

        Arrays.fill(visited, "0");
        visited[1] = "" + t1;
        visited[2] = "" + t2;

        fibonazzi(1, n, visited);

        return new BigInteger(visited[n]);
    }

    private static void fibonazzi(int start, int n, String[] visited) {
        if (!new BigInteger(visited[n]).equals(new BigInteger("0"))) {
            return;
        }

        BigInteger t1 = new BigInteger(visited[start]);
        BigInteger t2 = new BigInteger(visited[start + 1]);

        BigInteger pow = t2.pow(2);
        visited[start + 2] = t1.add(pow).toString();

        fibonazzi(start + 1, n, visited);
    }
}
