package dynamic_programming.wordbreak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> map = new HashMap<>();
        return solve(0, s.length() - 1, s, wordDict, map);

    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("dog");

        System.out.print(wordBreak(s, wordDict));
    }

    public static boolean solve(int i, int j, String s, List<String> dict, HashMap<String, Boolean> map) {

        if (map.get(i + "_" + j) != null)
            map.get(i + "_" + j);
        if (i > j)
            return false;

        if (dict.contains(s.substring(i, j + 1)))
            return true;

        for (int k = i; k <= j - 1; k++) {

            boolean left;
            if (map.get(i + "_" + k) != null) {
                left = map.get(i + "_" + k);
            } else {
                left = solve(i, k, s, dict, map);
                map.put(i + "_" + k, left);
            }

            boolean right;
            if (map.get(k + 1 + "_" + j) != null) {
                right = map.get(k + 1 + "_" + j);
            } else {
                right = solve(k + 1, j, s, dict, map);
                map.put(k + 1 + "_" + j, right);
            }
            if (left && right) {
                map.put(i + "_" + j, true);
                return true;
            }
        }
        map.put(i + "_" + j, false);
        return false;
    }
}