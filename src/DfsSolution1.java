import java.util.Scanner;
import java.util.Stack;

public class DfsSolution1 {

    public static Stack<Integer> stack = new Stack<>();
    public static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }

        printStackArr(0);
    }

    private static void printStackArr(int idx) {
        if (idx == 0) {
            stack.push(arr[0]);
        }

        if(idx > arr.length - 1){
            System.out.println("NO");
            return;
        }

        //반복해야될 부분
        if (stack.peek() == idx) {
            stack.pop();
            System.out.println("-");
        } else {
            stack.push(arr[idx]);
            System.out.println("+");
            printStackArr(idx + 1);
        }
    }
}
