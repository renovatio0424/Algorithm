package programmers.study;

public class StringCompression {
    public static void main(String[] args) {
        String[] sArr = new String[]{
                "aabbaccc",
                "ababcdcdababcdcd",
                "abcabcdede",
                "abcabcabcabcdededededede",
                "xababcdcdababcdcd"
        };
        for (String s : sArr) {
            int result = solution(s);
            System.out.println(result);
        }
    }

    private static int solution(String s) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < s.length() + 1; i++) {
            min = Math.min(min, compressString(s, i));
        }
        return min;
    }

    private static int compressString(String s, int express) {
        String prev = null;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        int loopCount = s.length() / express + 1;

        String splitString = "";
        //1. 문자열을 원하는 만큼 자른다.
        for (int i = 0; i < loopCount; i++) {
            int lastIndex = (i + 1) * express;

            if (s.length() > lastIndex) {
                splitString = s.substring(i * express, lastIndex);
            } else {
                splitString = s.substring(i * express);
            }

            //1-a 이전 문자열이 없다면?
            if (prev == null) {
                prev = splitString;
                count++;
                continue;
            }
            //1-b 이전 문자열과 같다면?
            if (prev.equals(splitString)) {
                count++;
                continue;
            }
            //1-c 이전 문자열과 다르다면?
            if (count > 1)
                sb.append(count);
            sb.append(prev);
            prev = splitString;
            count = 1;
        }
        //2. 만약 자른 문자열이 결과 문자열에 추가되지 않았다면?
        if (!splitString.isEmpty()) {
            sb.append(splitString);
        }
        //3. 결과 문자열의 길이를 리턴한다.
        return sb.toString().length();
    }
}
