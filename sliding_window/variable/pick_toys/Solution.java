package sliding_window.variable.pick_toys;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        System.out.println(solve("abcd", 2));

        System.out.println(solve2("aaabbxyyyyyyyyyyyy", 3));
    }

    //atmost k unique
    public static String solve(String s, int k) {

        char[] a = s.toCharArray();
        //k will be 2
        int ans = 0;
        int i = 0, j = 0;
        int start = 0, end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (j < a.length) {
            map.put(a[j], map.getOrDefault(a[j], 0) + 1);

            if (map.size() <= k) {
                //checking candidate
                if (getWindowSize(i, j) > ans) {
                    ans = getWindowSize(i, j);
                    start = i;
                    end = j;
                }
                j++;
            } else if (map.size() > k) {

                while (map.size() > k) {
                    map.put(a[i], map.get(a[i]) - 1);
                    if (map.get(a[i]) == 0)
                        map.remove(a[i]);
                    i++;
                }
                //checking candidate
                if (getWindowSize(i, j) > j) {
                    ans = getWindowSize(i, j);
                    start = i;
                    end = j;
                }
                j++;
            }

        }

        return s.substring(start, end + 1);
    }

    //exactly k unique
    public static String solve2(String s, int k) {

        char[] a = s.toCharArray();
        //k will be 2
        int ans = 0;
        int i = 0, j = 0;
        int start = 0, end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (j < a.length) {
            map.put(a[j], map.getOrDefault(a[j], 0) + 1);

            if (map.size() == k) {
                //checking candidate
                if (getWindowSize(i, j) > ans) {
                    ans = getWindowSize(i, j);
                    start = i;
                    end = j;
                }
                j++;
            } else if (map.size() < k)
                j++;

            else if (map.size() > k) {

                while (map.size() > k) {
                    map.put(a[i], map.get(a[i]) - 1);
                    if (map.get(a[i]) == 0)
                        map.remove(a[i]);
                    i++;
                }
                //checking candidate
                if (getWindowSize(i, j) > j) {
                    ans = getWindowSize(i, j);
                    start = i;
                    end = j;
                }
                j++;
            }

        }

        return ans != 0 ? s.substring(start, end + 1) : "";
    }


    private static int getWindowSize(int i, int j) {
        return j - i + 1;
    }
}
