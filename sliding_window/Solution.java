package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solve("sairam", "asir"));
        System.out.println(solve("abc", ""));
    }

    private static int solve(String string, String pattern) {

        if (string == null || string.length() == 0 || pattern == null || pattern.length() == 0)
            return 0;
        int count = 0;
        int i = 0, j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (j < string.length()) {
            //updating the map
            map.put(string.charAt(j), map.getOrDefault(string.charAt(j), 0) + 1);
            if (j - i + 1 >= pattern.length()) {
                if (check(map, pattern)) {
                    System.out.println(string.substring(i, j + 1));
                    count++;
                }
                map.put(string.charAt(i), map.get(string.charAt(i)) - 1);
                i++;
            }
            j++;
        }
        return count;
    }

    private static boolean check(HashMap<Character, Integer> map, String pattern) {
        HashMap<Character, Integer> clone = (HashMap<Character, Integer>) map.clone();
        for (char c : pattern.toCharArray()) {
            if (map.containsKey(c))
                clone.put(c, map.get(c) - 1);
        }
        for (Map.Entry<Character, Integer> entry : clone.entrySet())
            if (entry.getValue() != 0)
                return false;
        return true;
    }
}
