package sliding_window.variable.min_window_substring;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
//

    }

    public static String solve(String input, char[] pattern) {

        char[] a = input.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> patternMap = new HashMap<>();
        int i = 0, j = 0;

        int start = 0, end = 0;
        while (j < a.length) {
            map.put(a[j], map.getOrDefault(a[j], 0) + 1);

        }


        return input.substring(start, end + 1);
    }
}
