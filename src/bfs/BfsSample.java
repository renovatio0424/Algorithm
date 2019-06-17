package bfs;


import java.util.LinkedList;
import java.util.Queue;

public class BfsSample {
    public static void main(String[] args) {

    }

//    출처: https://mygumi.tistory.com/102 [마이구미의 HelloWorld]
    public static void bfs(int[][] a, boolean[] c, int v) {
        Queue<Integer> q = new LinkedList<>();
        int n = a.length - 1;
        q.add(v);
        c[v] = true;
        while (!q.isEmpty()) {
            v = q.poll();
            System.out.print(v + " ");
            for (int i = 1; i <= n; i++) {
                if (a[v][i] == 1 && !c[i]) {
                    q.add(i);
                    c[i] = true;
                }
            }
        }
    }

}
