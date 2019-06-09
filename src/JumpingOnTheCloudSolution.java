import java.io.IOException;
import java.util.Scanner;

public class JumpingOnTheCloudSolution {
    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jumpingCount = 0;
        int totalCount = c.length - 1;
        int blockCount = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 1)
                blockCount++;
            if (i < c.length - 2 && c[i] == 0 && c[i+1] == 0 && c[i + 2] == 0){
                jumpingCount++;
                i += 1;
            }
        }

        return totalCount - blockCount - jumpingCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        System.out.println("result: " + result);
        scanner.close();
    }
}

