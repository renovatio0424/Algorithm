import java.util.Scanner;

public class test1 {

    public static int[] result;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int k = scanner.nextInt();

            if (k == 0)
                break;

            int[] arr = new int[k];
            result = new int[6];

            for (int i = 0; i < k; i++) {
                arr[i] = scanner.nextInt();
            }

            printLotto(arr, 0, 0);
            System.out.println();
        }

    }

    private static void printLotto(int[] arr, int arrIndex, int count) {
        if (result.length == count) {
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
                if (i != result.length - 1)
                    System.out.print(" ");
            }
            System.out.println();
            return;
        }

        for (int j = arrIndex; j < arr.length; j++) {
            result[count] = arr[j];
            printLotto(arr, j + 1, count + 1);
        }


    }
}
