package this_is_coding_test.graph_theory;

import java.util.Scanner;

public class ImprovedDisjointSets {
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

        for (int i = 0; i < e; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            unionParent(a, b);
        }

        System.out.println("각 우너소가 속한 집합: ");
        for (int i = 1; i <= v; i++) {
            System.out.println(findParent(i) + " ");
        }
        System.out.println();
        System.out.print("부모 테이블: ");
        for (int i = 1; i <= v; i++) {
            System.out.println(parent[i] + " ");
        }
        System.out.println();
    }
}
