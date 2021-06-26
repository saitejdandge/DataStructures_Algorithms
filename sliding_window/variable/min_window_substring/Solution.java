package sliding_window.variable.min_window_substring;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solve("ab", "b"));
    }

    public static String solve(String a, String pattern) {

        HashMap<Character, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        String substring = null;
        int i = 0, j = 0;
        for (int k = 0; k < pattern.length(); k++)
            map.put(pattern.charAt(k), map.getOrDefault(pattern.charAt(k), 0) + 1);

        int count = map.size();
        while (j < a.length()) {
            if (map.containsKey(a.charAt(j)))
                map.put(a.charAt(j), map.get(a.charAt(j)) - 1);

            if (map.containsKey(a.charAt(j)) && map.get(a.charAt(j)) == 0) {
                count--;
            }
            if (count == 0) {
                if (j - i + 1 < ans) {
                    ans = Math.min(ans, j - i + 1);
                    substring = a.substring(i, j + 1);
                }
                while (i <= j && count == 0) {
                    if (j - i + 1 < ans) {
                        ans = Math.min(ans, j - i + 1);
                        substring = a.substring(i, j + 1);
                    }
                    if (map.containsKey(a.charAt(i))) {
                        map.put(a.charAt(i), map.get(a.charAt(i)) + 1);
                        if (map.get(a.charAt(i)) > 0)
                            count++;
                    }
                    i++;
                }
            }
            j++;
        }
//        System.out.println(ans);
        return substring;
    }
}
