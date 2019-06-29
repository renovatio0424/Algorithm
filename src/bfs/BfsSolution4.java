package bfs;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * [문제]
 * <p>
 * 우리 나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화를 가지고 있다.
 * 이러한 촌수는 다음과 같은 방식으로 계산된다.
 * 기본적으로 부모와 자식 사이를 1촌으로 정의하고 이로부터 사람들 간의 촌수를 계산한다.
 * 예를 들면 나와 아버지, 아버지와 할아버지는 각각 1촌으로 나와 할아버지는 2촌이 되고, 아버지 형제들과 할아버지는 1촌, 나와 아버지 형제들과는 3촌이 된다.
 * <p>
 * 여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때, 주어진 두 사람의 촌수를 계산하는 프로그램을 작성하시오.
 * <p>
 * bfs
 */
public class BfsSolution4 {
    private static boolean[][] personRelation;
    private static int[] visited;
    private static int totalPeopleCount;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        totalPeopleCount = scanner.nextInt();
        int person1 = scanner.nextInt();
        int person2 = scanner.nextInt();

        int relationCount = scanner.nextInt();
        personRelation = new boolean[totalPeopleCount + 1][totalPeopleCount + 1];
        visited = new int[totalPeopleCount + 1];

        for (int i = 0; i < relationCount; i++) {
            int parent = scanner.nextInt();
            int child = scanner.nextInt();
            personRelation[parent][child] = personRelation[child][parent] = true;
        }

        countPersonNumber(person1, person2);
    }

    private static void countPersonNumber(int start, int end) {
        Arrays.fill(visited, -1);

        Queue<Integer> visitedQueue = new LinkedList<>();

        visitedQueue.add(start);
        visited[start] = 0;

        while (!visitedQueue.isEmpty()) {
            int current = visitedQueue.poll();

            if (current == end) {
                System.out.print(visited[current]);
                return;
            }

            for (int i = 1; i <= totalPeopleCount; i++) {
                if (personRelation[current][i] && visited[i] == -1) {
                    visitedQueue.add(i);
                    visited[i] = visited[current] + 1;
                }
            }
        }

        System.out.print(-1);
    }
}
