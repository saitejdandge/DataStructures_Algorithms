package sliding_window.variable.k_unique_chars.longest_substr_k_unique_chars;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        System.out.println(longestSubstr("aabacbebebe".toCharArray(), 3));
    }

    public static int longestSubstr(char[] inputString, int k) {

        int ans = 0;
        int i = 0;
        int j = 0;

        int x = 0;
        int y = 0;

        HashMap<Character, Integer> freqMap = new HashMap<>();

        while (j < inputString.length) {
            freqMap.put(inputString[j], freqMap.getOrDefault(inputString[j], 0) + 1);
            if (freqMap.size() < k)
                j++;
            else if (freqMap.size() == k) {
                if (j - i + 1 > ans) {
                    x = i;
                    y = j;
                }
                ans = Math.max(ans, j - i + 1);
                j++;
            } else if (freqMap.size() > k) {

                while (freqMap.size() > k) {
                    freqMap.put(inputString[i], freqMap.get(inputString[i]) - 1);
                    if (freqMap.get(inputString[i]) == 0)
                        freqMap.remove(inputString[i]);
                    i++;
                }

                if (freqMap.size() == k) {
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
            System.out.print(inputString[p]);
        return ans;
    }
}
