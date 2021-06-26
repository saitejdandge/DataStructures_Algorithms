package sliding_window.variable.k_unique_chars.shortest_substr_k_unique_chars;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solve("aaaaaaaaaaaaaaaaaaaaa".toCharArray(), 1));
    }

    public static int solve(char[] a, int k) {
        int i = 0, j = 0;
        int ans = Integer.MAX_VALUE;
        int n = a.length;

        HashMap<Character, Integer> map = new HashMap<>();
        while (j < n) {
            map.put(a[j], map.getOrDefault(a[j], 0) + 1);
            if (map.size() < k) {
                j++;
            } else if (map.size() == k) {
                //candidate
                ans = Math.min(ans, j - i + 1);
                while (i <= j && map.size() == k) {

                    ans = Math.min(ans, j - i + 1);
                    map.put(a[i], map.get(a[i]) - 1);
                    if (map.get(a[i]) == 0)
                        map.remove(a[i]);
                    i++;
                }
                j++;

            }
            //map.size>k;
            else {

                while (map.size() > k) {
                    map.put(a[i], map.get(a[i]) - 1);
                    if (map.get(a[i]) == 0)
                        map.remove(a[i]);
                    i++;
                }

                if (map.size() == k) {
                    ans = Math.min(ans, j - i + 1);
                }
                j++;
            }
        }
        return ans;
    }
}
