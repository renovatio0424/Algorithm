package leet_code.greedy;

import java.util.HashMap;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        int result = longestPalindrome(s);
        System.out.println(result);
    }

    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> characterMap = new HashMap<>();
        for (char element : s.toCharArray()) {
            if (characterMap.containsKey(element)) {
                int count = characterMap.get(element) + 1;
                characterMap.put(element, count);
                continue;
            }

            characterMap.put(element, 1);
        }

        int odd = 0;
        int even = 0;
        for (char key : characterMap.keySet()) {
            int count = characterMap.get(key);
            // even
            if (count % 2 == 0) {
                even += count;
                continue;
            }

            odd = Math.max(odd, count);
        }

        return odd + even;
    }
}
