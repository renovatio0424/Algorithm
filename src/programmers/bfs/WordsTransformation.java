package programmers.bfs;

import java.util.*;

/*
        문제 설명
        두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.

        1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
        2. words에 있는 단어로만 변환할 수 있습니다.
        예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면 "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.

        두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.

        제한사항
        각 단어는 알파벳 소문자로만 이루어져 있습니다.
        각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
        words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
        begin과 target은 같지 않습니다.
        변환할 수 없는 경우에는 0를 return 합니다.
*/

public class WordsTransformation {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog" };

        int result = solution(begin, target, words);
        System.out.println("result: " + result);
    }

    private static int solution(String begin, String target, String[] words) {
        if (hasNotTarget(target, words))
            return 0;

        boolean[] visited = new boolean[words.length + 1];
        Queue<WordTransformation> queue = new LinkedList<>();
        queue.offer(new WordTransformation(begin, 0));
        visited[0] = true;

        // target 이 있어도 변경이 불가한 경우가 있는가?

        while (!queue.isEmpty()) {
            WordTransformation current = queue.poll();

            for (int i = 0; i < words.length; i++) {
                if (isOneCharDifferent(current.word, words[i])) {
                    if (!visited[i + 1]) {
                        int count = current.transformationCount + 1;
                        queue.offer(new WordTransformation(words[i], count));
                        visited[i + 1] = true;

                        if (words[i].equals(target)) {
                            return count;
                        }
                    }
                }
            }
        }

        return 0;
    }

    public static class WordTransformation {
        private String word;
        private int transformationCount;

        public WordTransformation(String word, int transformationCount) {
            this.word = word;
            this.transformationCount = transformationCount;
        }

        public String getWord() {
            return word;
        }

        public int getTransformationCount() {
            return transformationCount;
        }
    }

    private static boolean hasNotTarget(String target, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target))
                return false;
        }
        return true;
    }

    private static boolean isOneCharDifferent(String first, String second) {
        int count = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }


}
