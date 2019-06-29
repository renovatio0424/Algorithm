import java.util.Scanner;
import java.util.Vector;

public class SolutionBFS {
    public static Vector<Character> vector = new Vector<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.nextInt() != 0){
            int testCase = scanner.nextInt();
            int[] arr = new int[testCase];
            for (int i = 0; i < testCase; i++) {
                arr[i] = scanner.nextInt();
            }
            printLotto(arr,0);
        }
    }

    private static void printLotto(int[] arr, int count) {
        if(count == arr.length){
            for(int i = 0 ; i < arr.length ; i++){
                System.out.print(i);
                if(i != arr.length - 1)
                    System.out.print(" ");
            }
            System.out.println();
            return;
        }

//        printLotto(arr);
    }
}
