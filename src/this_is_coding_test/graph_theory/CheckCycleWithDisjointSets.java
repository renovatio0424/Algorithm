package this_is_coding_test.graph_theory;

import java.util.Scanner;

public class CheckCycleWithDisjointSets {
    public static int v, e;
    public static int[] parent = new int[100001];

    public static int findParent(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        v = scanner.nextInt();
        e = scanner.nextInt();

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        boolean cycle = false;

        for (int i = 0; i < e; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (findParent(a) == findParent(b)) {
                cycle = true;
                break;
            } else {
                unionParent(a, b);
            }
        }

        if (cycle)
            System.out.println("사이클이 발생했습니다.");
        else
            System.out.println("사이클이 발생하지 않았습니다.");
    }
}
