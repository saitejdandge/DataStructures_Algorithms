package strings.all_palindrome_partitions;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        HashMap<String, Boolean> map = new HashMap<>();
        solve("mississippi", "", map);
        map.forEach((x, y) -> System.out.println(x + ":" + y));
    }

    public static void solve(String input, String builder, HashMap<String, Boolean> map) {
        if (input.isEmpty()) {
            System.out.println(builder);
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            if (isPalindrome(input, 0, i, map)) {
                solve(input.substring(i + 1), builder + input.substring(0, i + 1) + " | ", map);
            }
        }
    }

    private static boolean isPalindrome(String input, int s, int e, HashMap<String, Boolean> map) {
        int os = s;
        int oe = e;
        if (input.charAt(os) == input.charAt(oe)) {
            if (os != oe && map.getOrDefault(input.substring(os + 1, oe), false)) {
                map.put(input.substring(os, oe + 1), true);
                return true;
            }
        }

        while (s <= e) {
            if (input.charAt(s) != input.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        map.put(input.substring(os, oe + 1), true);
        return true;
    }
}
