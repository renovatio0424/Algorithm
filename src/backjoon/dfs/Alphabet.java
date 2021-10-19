package backjoon.dfs;

import java.util.*;

public class Alphabet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int R = scanner.nextInt();
        int C = scanner.nextInt();

        char[][] alphabetMap = new char[R][C];
        scanner.nextLine();

        for (int i = 0; i < alphabetMap.length; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < alphabetMap[0].length; j++) {
                alphabetMap[i][j] = input.charAt(j);
            }
        }

        int result = getMaximumMove(0, 0, alphabetMap, new HashSet<>());

        System.out.println(result);
    }

    private static int getMaximumMove(int i, int j, char[][] alphabetMap, Set<Character> visited) {
        if (i < 0 || i >= alphabetMap.length || j < 0 || j >= alphabetMap[0].length) {
            return 0;
        }

        if (visited.contains(alphabetMap[i][j])) {
            return 0;
        }

        Set<Character> newVisited = new HashSet<>();
        newVisited.addAll(visited);
        newVisited.add(alphabetMap[i][j]);

        int move1 = getMaximumMove(i + 1, j, alphabetMap, newVisited);
        int move2 = getMaximumMove(i, j + 1, alphabetMap, newVisited);
        int move3 = getMaximumMove(i - 1, j, alphabetMap, newVisited);
        int move4 = getMaximumMove(i, j - 1, alphabetMap, newVisited);

        int max1 = Math.max(move1, move2);
        int max2 = Math.max(move3, move4);

        return Math.max(max1, max2) + 1;
    }
}
