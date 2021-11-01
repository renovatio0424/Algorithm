package this_is_coding_test.shortest_path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ImprovedDijkstra {
    public static final int INF = (int) 1e9;
    public static int n, m, start;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] d = new int[100001];

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();

            if (d[now] < dist) continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Node(b, c));
        }

        Arrays.fill(d, INF);

        dijkstra(start);

        for (int i = 1; i <= n; i++) {
            if (d[i] == INF) {
                System.out.println("Infinity");
            } else {
                System.out.println(d[i]);
            }
        }
    }

    static class Node implements Comparable<Node> {
        private final int index;
        private final int distance;

        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if (this.distance < o.distance)
                return -1;
            return 1;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }
    }
}
