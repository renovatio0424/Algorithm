package programmers.exercise;

public class NextBigNumber {

    public static void main(String[] args) {
        int n = 15;
        int result = solution(n);
        System.out.println(result);
    }

    private static int solution(int n) {
        return new NextBigNumberFinder().findNextBigNumber(n);
    }
}

class NextBigNumberFinder {

    public int findNextBigNumber(int number) {
        int oneCount = countBinaryOne(number);
        int nextBigNumber = number + 1;

        while (true) {
            int nextOneCount = countBinaryOne(nextBigNumber);
            if (nextOneCount == oneCount) break;
            nextBigNumber++;
        }

        return nextBigNumber;
    }

    private int countBinaryOne(int number) {
        String binaryString = convertBinary(number);
        return countOne(binaryString);
    }

    private int countOne(String binaryString) {
        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') count++;
        }
        return count;
    }

    private String convertBinary(int number) {
        return Integer.toBinaryString(number);
    }
}

