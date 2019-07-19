package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BirthdayCakeCandlesSolution {
    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar) {
        int count = 0;
        int lastTallest = 0;
        Arrays.sort(ar);

        for(int idx = ar.length - 1 ; idx >= 0 ; idx--){
            if(lastTallest < ar[idx]){
                lastTallest = ar[idx];
                count = 1;
            } else if(lastTallest == ar[idx]){
                count++;
            }

        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = birthdayCakeCandles(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
