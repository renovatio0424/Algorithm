package dfs;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * 스택 수열
 *
 * <문제/>
 * 스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다.
 * 스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.
 *
 * 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
 * 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
 * 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다.
 * 이를 계산하는 프로그램을 작성하라.
 *
 * <입력/>
 * 첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다.
 * 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다.
 * 물론 같은 정수가 두 번 나오는 일은 없다.
 *
 * <출력/>
 * 입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다.
 * push연산은 +로, pop 연산은 -로 표현하도록 한다.
 * 불가능한 경우 NO를 출력한다.
 *
 * https://www.acmicpc.net/problem/1874
 *
 */
public class DfsSolution1 {

    private static int[] arr;
    private static ArrayList<Integer> arr2;
    private static Stack<Integer> stack = new Stack<>();
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();

        arr = new int[length];
        arr2 = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }

        printStackArr(0,0);
    }

    /**
     * 시간 복잡도
     * arr.length * 2
     *
     * arr = [4,3,6,8,7,5,2,1] => 결과 수열
     * sortArr = [1,2,3,4,5,6,7,8] => push 할 수열
     *
     * @param arrIdx arr 를 검색하는 인덱스
     * @param sortIdx sortArr 를 검색하는 인덱스
     */
    private static void printStackArr(int arrIdx, int sortIdx) {
        for(int i = sortIdx ; i < arr.length ; i++){
            if(stack.size() == 0 || arr[arrIdx] != stack.peek()){
                stack.push(i + 1);
                result.append("+\n");
            } else {
                arr2.add(stack.pop());
                result.append("-\n");
                printStackArr(arrIdx + 1, i);
                return;
            }
        }

        int size = stack.size();
        for(int j = 0 ; j < size; j++){
            result.append("-\n");
            arr2.add(stack.pop());
        }

        if(isEqualArr(arr2)){
            System.out.println(result.toString());
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isEqualArr(ArrayList<Integer> resultArr) {
        for (int i = 0 ; i < resultArr.size() ; i ++) {
            if(resultArr.get(i) != arr[i]){
                return false;
            }
        }

        return true;
    }
}
