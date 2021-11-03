package this_is_coding_test.graph_theory;

import java.util.Scanner;

public class DisjointSetExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int e = scanner.nextInt();

        int[] parent = new int[v + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        DisjointSet disjointSet = new DisjointSet(parent);
        for (int i = 1; i <= e; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            disjointSet.unionParent(a, b);
        }

        for (int i = 1; i <= v; i++) {
            System.out.print(parent[i] + " ");
        }
    }
}

class DisjointSet {
    private final int[] parent;

    DisjointSet(int[] parent) {
        this.parent = parent;
    }

    public int findParent(int x) {
        if (x == parent[x]) return x;
        return findParent(parent[x]);
    }

    public void unionParent(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);

        if (p1 > p2) parent[p1] = p2;
        else parent[p2] = p1;
    }
}
