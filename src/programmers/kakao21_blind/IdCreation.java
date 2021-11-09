package programmers.kakao21_blind;

public class IdCreation {
    public static void main(String[] args) {

        String id = "abcdefghijklmn.p";
        System.out.println(solution(id));
    }

    public static String solution(String new_id) {
        String answer = "";

        //step 1
        answer = new_id.toLowerCase();
        System.out.println("step 1 :" + answer);
        //step 2
        answer = answer.replaceAll("[^a-z\\d\\.\\-\\_]", "");
        System.out.println("step 2 :" + answer);
        //step 3
        answer = answer.replaceAll("([\\.+]{2,})", ".");
        System.out.println("step 3 :" + answer);
        //step 4
        answer = answer.replaceAll("^[\\.]+", "");
        answer = answer.replaceAll("[\\.]$", "");
        System.out.println("step 4 :" + answer);
        //step 5
        if (answer.length() == 0)
            answer = "a";
        System.out.println("step 5 :" + answer);
        //step 6
        if (answer.length() >= 16)
            answer = answer.substring(0, 15);

        answer = answer.replaceAll("[\\.]$", "");
        System.out.println("step 6 :" + answer);
        //step 7
        if (answer.length() <= 2) {
            char lastChar = answer.charAt(answer.length() - 1);
            StringBuilder sb = new StringBuilder();
            sb.append(answer);

            while (sb.length() < 3) {
                sb.append(lastChar);
            }

            answer = sb.toString();
        }
        System.out.println("step 7 :" + answer);
        return answer;
    }
}
