package programmers.kakao20_internship;

public class ClickKeypad {
    public static void main(String[] args) {
        int[] numbers = new int[]{
                //1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5
                7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2
        };
        String hand = "left";//"right";
        String result = solution(numbers, hand);
        System.out.println(result);
    }

    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        String currentLeft = "10";
        String currentRight = "12";

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            String current = findClickedHand(number, hand, currentLeft, currentRight);
            if (current.equals("L")) {
                currentLeft = "" + number;
            } else {
                currentRight = "" + number;
            }
            answer.append(current);
        }

        return answer.toString();
    }

    public static String findClickedHand(int number, String hand, String currentLeft, String currentRight) {
        if (number == 1 || number == 4 || number == 7) {
            return "L";
        } else if (number == 3 || number == 6 || number == 9) {
            return "R";
        } else {
            int leftDistance = getLeftDistance(number, currentLeft);
            int rightDistance = getRightDistance(number, currentRight);
            if (leftDistance == rightDistance) {
                if (hand.equals("right"))
                    return "R";
                else
                    return "L";
            } else if (leftDistance > rightDistance) return "R";
            else return "L";
        }
    }

    public static int getLeftDistance(int number, String currentLeft) {
        int target = number;
        int current = Integer.parseInt(currentLeft);
        if (target == 0) {
            target = 11;
        }

        if (current == 0) {
            current = 11;
        }

        int diff = Math.abs(target - current);
        int distance = diff / 3;
        if (diff % 3 != 0) distance += diff % 3;
        return distance;
    }

    public static int getRightDistance(int number, String currentRight) {
        int current = Integer.parseInt(currentRight);
        if (current == 3 || current == 6 || current == 9) {
            current -= 2;
        }
        return getLeftDistance(number, "" + current);
    }

}
