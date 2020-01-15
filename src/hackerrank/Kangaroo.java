package hackerrank;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/kangaroo/problem?isFullScreen=false
 * */
public class Kangaroo {

    // Complete the solveProblem function below.
    static String solveProblem(int x1, int v1, int x2, int v2) {
        int prevDiff = 10001;

        for(int time = 0 ; time < 10001 ; time++){
            int diff = Math.abs(x1 + v1 * time - (x2 + v2 * time));

            if (diff == 0)
                return "YES";

            if (prevDiff < diff)
                return "NO";

            prevDiff = diff;
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = solveProblem(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
