package programmers.summer_winter_before_2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class EnglishEndTalk {

    public static void main(String[] args) {
        int n = 3;
        //5;
        //2;
        String[] words = new String[]{
                "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"
//                "hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"
//                "hello", "one", "even", "never", "now", "world", "draw"
        };

        int[] result = solution(n, words);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int n, String[] words) {
        EndTalkGamePlayer[] players = initPlayers(n, words);
        EndTalkGameImpl game = new EndTalkGameImpl(players, words.length);

        EndTalkGamePlayer failurePlayer = game.findFailurePlayer();

        if (failurePlayer == null) return new int[]{0, 0};

        return new int[]{failurePlayer.getNumber(), failurePlayer.getTurn()};
    }

    private static EndTalkGamePlayer[] initPlayers(int n, String[] words) {
        EndTalkGamePlayer[] players = new EndTalkGamePlayerImpl[n];

        for (int i = 0; i < words.length; i++) {
            if (players[i % n] == null) {
                players[i % n] = new EndTalkGamePlayerImpl(i % n);
            }
            players[i % n].setWord(words[i]);
        }
        return players;
    }

    public static class EndTalkGameImpl implements EndTalkGame {
        private final ArrayList<String> wordList;
        private final EndTalkGamePlayer[] players;
        private final int maxTurn;

        EndTalkGameImpl(EndTalkGamePlayer[] players, int maxTurn) {
            this.wordList = new ArrayList<>();
            this.players = players;
            this.maxTurn = maxTurn;
            //init first word
            wordList.add(players[0].speakWord());
        }

        private boolean isFailureWord(String word) {
            if (wordList.contains(word)) return true;

            String before = wordList.get(wordList.size() - 1);
            wordList.add(word);

            return before.toCharArray()[before.length() - 1] != word.toCharArray()[0];
        }

        @Override
        public EndTalkGamePlayer findFailurePlayer() {
            for (int i = 1; i < maxTurn; i++) {
                EndTalkGamePlayer current = players[i % players.length];
                if (isFailureWord(current.speakWord())) {
                    return current;
                }
            }
            return null;
        }
    }

    public static class EndTalkGamePlayerImpl implements EndTalkGamePlayer {
        private final Queue<String> wordQueue;
        private int turn = 0;
        private final int number;

        EndTalkGamePlayerImpl(int zeroBaseNumber) {
            // number is 1 base index
            this.number = zeroBaseNumber + 1;
            wordQueue = new LinkedList<>();
        }


        @Override
        public void setWord(String word) {
            wordQueue.add(word);
        }

        @Override
        public String speakWord() {
            countTurn();
            return wordQueue.poll();
        }

        @Override
        public int getNumber() {
            return number;
        }

        @Override
        public int getTurn() {
            return turn;
        }

        private void countTurn() {
            turn++;
        }
    }

    interface EndTalkGame {
        EndTalkGamePlayer findFailurePlayer();
    }

    interface EndTalkGamePlayer {
        void setWord(String word);

        String speakWord();

        int getNumber();

        int getTurn();
    }
}
