package sliding_window.variable.longest_substr_without_repeat_chars;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        System.out.println(longestSubstrWithoutRepeat("pwwkedwq".toCharArray()));
    }

    public static int longestSubstrWithoutRepeat(char[] a) {
        int ans = 0;
        int i = 0, j = 0;
        int x = 0, y = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        while (j < a.length) {
            freqMap.put(a[j], freqMap.getOrDefault(a[j], 0) + 1);
            //current window has all the unique characters
            if (freqMap.size() == j - i + 1) {
                if (j - i + 1 > ans) {
                    x = i;
                    y = j;
                }
                ans = Math.max(ans, j - i + 1);
                j++;
            } else if (freqMap.size() < j - i + 1) {
                while (freqMap.size() < j - i + 1) {
                    freqMap.put(a[i], freqMap.get(a[i]) - 1);
                    if (freqMap.get(a[i]) == 0)
                        freqMap.remove(a[i]);
                    i++;
                }
                if (j - i + 1 == freqMap.size()) {
                    if (j - i + 1 > ans) {
                        x = i;
                        y = j;
                    }
                    ans = Math.max(ans, j - i + 1);
                }
                j++;
            }

        }
        for (int p = x; p <= y; p++)
            System.out.print(a[p]);
        return ans;
    }
}
