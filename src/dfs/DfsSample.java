package dfs;

import java.util.Stack;

public class DfsSample {
    public static void main(String[] args) {

    }

    //출처: https://mygumi.tistory.com/102 [마이구미의 HelloWorld]
    //recursive
    private static void dfs(int[][] a, boolean[] c, int v) {
        int n = a.length - 1;
        c[v] = true;
        System.out.print(v + " ");
        for (int i = 1; i <= n; i++) {
            if (a[v][i] == 1 && !c[i]) {
                dfs(a, c, i);
            }
        }
    }

    //stack
    public static void dfs(int[][] a, boolean[] c, int v, boolean flag) {
        Stack<Integer> stack = new Stack<>();
        int n = a.length - 1;
        stack.push(v);
        c[v] = true;
        System.out.print(v + " ");
        while (!stack.isEmpty()) {
            int vv = stack.peek();
            flag = false;
            for (int i = 1; i <= n; i++) {
                if (a[vv][i] == 1 && !c[i]) {
                    stack.push(i);
                    System.out.print(i + " ");
                    c[i] = true;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                stack.pop();
            }
        }
    }
}
