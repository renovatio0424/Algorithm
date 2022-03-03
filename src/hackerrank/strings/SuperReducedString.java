package hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SuperReducedString {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        System.out.println(result);
        bufferedReader.close();
    }

    private static String superReducedString(String s) {
        int last = 'z' - 'a';
        for (int i = 0; i <= last; i++) {
            char a = (char)(i + 'a');
            StringBuilder sb = new StringBuilder();
            String duplicate = sb.append(a).append(a).toString();
            while (s.contains(duplicate)) {
                s = s.replaceAll(duplicate, "");
                i = -1;
            }
        }
        if (s.length() == 0) return "Empty String";
        return s;
    }

    private static String superReducedStringRecursive(String s) {
        String sequence = getSequenceChar(s);
        if (sequence != null) {
            s = s.replaceAll(sequence, "");
            s = superReducedStringRecursive(s);
        }

        if (s.length() == 0) return "Empty String";
        return s;
    }

    private static String getSequenceChar(String s) {
        int last = 'z' - 'a';
        for (int i = 0; i <= last; i++) {
            char a = (char) (i + 'a');
            String duplicate = "" + a + "" + a;
            if (s.contains(duplicate)) return duplicate;
        }

        return null;
    }
}
