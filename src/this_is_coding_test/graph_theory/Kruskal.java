package this_is_coding_test.graph_theory;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    private final int distance;
    private final int nodeA;
    private final int nodeB;

    Edge(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.distance < o.distance)
            return -1;
        return 1;
    }

    public int getDistance() {
        return distance;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }
}

public class Kruskal {

    public static int v, e;
    public static int[] parent = new int[100001];
    public static ArrayList<Edge> edges = new ArrayList<>();
    public static int result = 0;

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // 모든 간선에 대한 정보를 입력 받기
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge(cost, a, b));
        }

        // 간선을 비용순으로 정렬
        Collections.sort(edges);

        for (Edge edge : edges) {
            int cost = edge.getDistance();
            int a = edge.getNodeA();
            int b = edge.getNodeB();

            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
            }
        }

        System.out.println(result);
    }
}
