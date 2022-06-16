package programmers.kakao18_blind;

import java.util.ArrayList;

public class Friends4Block {
    public static void main(String[] args) {
        int m =
                6;
//                4;
        int n =
                6;
//                5;
        String[] board = new String[]{
                "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"
//                "CCBDE", "AAADE", "AAABF", "CCBBF"
        };
        int result = solution(m, n, board);
        System.out.println(result);
    }

    private static int solution(int m, int n, String[] board) {
        FriendsBlockGame game = new FriendsBlockGame(m, n, board);
        return game.countRemovedBlock();
    }

    private static char EMPTY = '*';

    static class FriendsBlockGame {
        private int m, n;
        private String[] board;

        FriendsBlockGame(int m, int n, String[] board) {
            this.m = m;
            this.n = n;
            this.board = board;
        }

        public int countRemovedBlock() {
            int removed = 0;

            while (true) {
                ArrayList<Point> removePointList = findRemovePointList();
                if (removePointList.isEmpty()) break;
                removed += removeCharacter(removePointList);
                moveBlocks();
            }

            return removed;
        }

        private void moveBlocks() {
            for (int j = 0; j < board[0].length(); j++) {
                StringBuilder sb = new StringBuilder();
                for (int i = board.length - 1; i >= 0; i--) {
                    char current = getCharacter(i, j);
                    if (!isEmptyCharacter(current)) {
                        sb.append(current);
                    }
                }
                while (sb.length() < m) {
                    sb.append(EMPTY);
                }

                for (int i = 0; i < board.length; i++) {
                    setCharacter(i, j, sb.charAt(i));
                }
            }
        }

        private int removeCharacter(ArrayList<Point> removePointList) {
            int removed = 0;

            for (Point remove : removePointList) {
                char a11 = getCharacter(remove.i, remove.j);
                char a12 = getCharacter(remove.i, remove.j + 1);
                char a21 = getCharacter(remove.i + 1, remove.j);
                char a22 = getCharacter(remove.i + 1, remove.j + 1);

                if (!isEmptyCharacter(a11)) {
                    setEmptyCharacter(remove.i, remove.j);
                    removed++;
                }

                if (!isEmptyCharacter(a12)) {
                    setEmptyCharacter(remove.i, remove.j + 1);
                    removed++;
                }

                if (!isEmptyCharacter(a21)) {
                    setEmptyCharacter(remove.i + 1, remove.j);
                    removed++;
                }

                if (!isEmptyCharacter(a22)) {
                    setEmptyCharacter(remove.i + 1, remove.j + 1);
                    removed++;
                }
            }

            return removed;
        }

        private ArrayList<Point> findRemovePointList() {
            ArrayList<Point> removePointList = new ArrayList<>();

            for (int i = 0; i < board.length - 1; i++) {
                for (int j = 0; j < board[i].length() - 1; j++) {
                    Block current = new Block(board, i, j);
                    if (current.enableToRemove()) {
                        removePointList.add(new Point(i, j));
                    }
                }
            }
            return removePointList;
        }

        private boolean isEmptyCharacter(char character) {
            return character == EMPTY;
        }

        private char getCharacter(int i, int j) {
            return board[i].toCharArray()[j];
        }

        private void setEmptyCharacter(int i, int j) {
            setCharacter(i, j, EMPTY);
        }

        private void setCharacter(int i, int j, char insert) {
            StringBuilder sb = new StringBuilder();
            sb.append(board[i]);
            sb.replace(j, j + 1, "" + insert);
            board[i] = sb.toString();
        }
    }

    static class Block {
        char a11, a12, a21, a22;

        Block(String[] board, int i, int j) {
            this.a11 = board[i].charAt(j);
            this.a12 = board[i].charAt(j + 1);
            this.a21 = board[i + 1].charAt(j);
            this.a22 = board[i + 1].charAt(j + 1);
        }

        Block(char a11, char a12, char a21, char a22) {
            this.a11 = a11;
            this.a12 = a12;
            this.a21 = a21;
            this.a22 = a22;
        }

        public boolean enableToRemove() {
            return a11 == a12 && a11 == a21 && a21 == a22 && a11 != EMPTY;
        }
    }

    static class Point {
        int i, j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
