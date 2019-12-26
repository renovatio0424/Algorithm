import java.util.Queue;
import java.util.Scanner;

public class Virus {
    public static int totalComputerCount = 0;
    public static int infectionComputerCount = 0;

    public static boolean computerAdj[][];
    public static boolean visited[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        totalComputerCount = scanner.nextInt();
        int adjComputerCount = scanner.nextInt();

        computerAdj = new boolean[totalComputerCount][totalComputerCount];
        visited = new boolean[totalComputerCount];

        for (int i = 0; i < adjComputerCount; i++) {
            int c1 = scanner.nextInt();
            int c2 = scanner.nextInt();

            computerAdj[c1 - 1][c2 - 1] = computerAdj[c2 - 1][c1 - 1] = true;
        }
        countInfectedComputerDFS(0);
//        countInfectedComputerBFS(0);
        System.out.println(infectionComputerCount);
    }

    private static void countInfectedComputerDFS(int currentIndex) {
        visited[currentIndex] = true;

        for (int i = 0; i < totalComputerCount; i++) {
            //인접해있고 방문하지 않았다면 감염 횟수를 센다
            if (computerAdj[currentIndex][i] && !visited[i]) {
                //카운트
                infectionComputerCount++;
                //인접한 곳으로 이동한다.
                countInfectedComputerDFS(i);
            }
        }
    }
}
