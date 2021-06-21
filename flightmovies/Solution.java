package flightmovies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] ans = findSum(new int[]{50, 20, 10, 40, 25, 30}, 90);
        System.out.println(ans[0] + " " + ans[1]);
        System.out.println(numberOfItems("|**|*|*", List.of(1, 1), List.of(5, 6)));

        System.out.println(numberOfItems2("|**|*|*", List.of(1, 1), List.of(5, 6)));
    }

    public static int[] findSum(int[] movies, int flightDuration) {
        int target = flightDuration - 30;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maximum = -1;
        int[] ans = new int[]{-1, -1};

        for (int i = 0; i < movies.length; i++) {
            if (!map.containsKey(movies[i])) {
                map.put(target - movies[i], i);
            } else {
                if (movies[i] > maximum || target - movies[i] > maximum) {
                    ans[0] = map.get(movies[i]);
                    ans[1] = i;
                    maximum = Math.max(movies[i], target - movies[i]);
                }
            }
        }
        if (ans[0] != -1 && ans[1] != -1)
            return ans;
        else
            return new int[]{};
    }

    public static List<Integer> numberOfItems(String string, List<Integer> startIndices, List<Integer> endIndices) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < startIndices.size(); i++) {
            int startIndex = startIndices.get(i);
            int endIndex = endIndices.get(i);
            boolean isWindowOpen = false;
            int count = 0;
            int ans = 0;
            for (int j = startIndex - 1; j <= endIndex - 1; j++) {
                if (!isWindowOpen && string.charAt(j) == '|') {
                    isWindowOpen = true;
                } else if (isWindowOpen && string.charAt(j) == '*') {
                    count++;
                } else if (isWindowOpen && string.charAt(j) == '|') {
                    ans += count;
                    count = 0;
                }
            }
            list.add(ans);

        }
        return list;

    }

    public static List<Integer> numberOfItems2(String string, List<Integer> startIndices, List<Integer> endIndices) {
        List<Integer> list = new ArrayList<>();
        int[] dp = new int[string.length()];
        int[] lefts = new int[string.length()];
        boolean isWindowOpen = false;
        int count = 0;
        int leftValue = -1;
        for (int i = 0; i < string.length(); i++) {

            if (string.charAt(i) == '|') {
                leftValue = i;
            }
            lefts[i] = leftValue;

            if (!isWindowOpen && string.charAt(i) == '|') {
                isWindowOpen = true;
            } else if (isWindowOpen && string.charAt(i) == '*') {
                count++;
            } else if (isWindowOpen && string.charAt(i) == '|') {
                dp[i] = count;
            }
        }

        for (int k = 0; k < startIndices.size(); k++) {
            int leftIndex = lefts[startIndices.get(k) - 1];
            int rightIndex = lefts[endIndices.get(k) - 1];
            if (leftIndex != -1 && rightIndex != -1)
                list.add(dp[rightIndex] - dp[leftIndex]);
            else
                list.add(0);
        }

        return list;

    }

}
