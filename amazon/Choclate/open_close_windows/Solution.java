package amazon.Choclate.open_close_windows;

import kotlin.Pair;

public class Solution {

    public static void main(String[] args) {

        String input = "xx|xx|xx";
        Obj[][] dp = solve(input.toCharArray());
//        for (int l = 0; l < input.length(); l++)
//            for (int r = l; r < input.length(); r++) {
//                System.out.println(input.substring(l, r + 1) + " " + dp[l][r].ans);
//            }

        Pair<Integer, Integer>[][] ans = new Pair[input.length()][input.length()];

        Pair<Integer, Integer> res = solve(0, input.length() - 1, input.toCharArray(), ans);
        System.out.println(res.getFirst() + ":" + res.getSecond());
    }

    public static Pair<Integer, Integer> solve(int s, int e, char[] input, Pair<Integer, Integer>[][] dp) {
        if (s >= 0 && e <= input.length && dp[s][e] != null) {
            System.out.println("Cache hit");
            return dp[s][e];
        }
        if (e - s + 1 <= 2) {
            int xValues = 0;
            while (s <= e) {
                if (input[s] == 'x')
                    xValues++;
                s++;
            }
            return new Pair<>(xValues, 0);
        }

        Pair<Integer, Integer> result;
        if (input[s] == '|' && input[e] == '|') {
            Pair<Integer, Integer> prev = solve(s + 1, e - 1, input, dp);
            result = new Pair<>(prev.getFirst(), prev.getFirst());
        } else {

            Pair<Integer, Integer> result1 = solve(s + 1, e - 1, input, dp);
            Pair<Integer, Integer> result2 = solve(s + 1, e, input, dp);
            Pair<Integer, Integer> result3 = solve(s, e - 1, input, dp);
            Pair<Integer, Integer> finalResult;
            if (result1.getSecond() > result2.getSecond())
                finalResult = result1;
            else if (result3.getSecond() > result2.getSecond())
                finalResult = result3;
            else
                finalResult = result2;

            result = new Pair<>((input[s] == 'x' ? 1 : 0) + (result2.getFirst()), finalResult.getSecond());
        }
        dp[s][e] = result;
        return result;
    }

    public static Obj[][] solve(char[] input) {

        int n = input.length;
        Obj[][] dp = new Obj[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = new Obj(input[i] == 'x' ? 1 : 0, 0);
        }
        for (int i = 0; i < n - 1; i++) {
            int count = 0;
            if (input[i] == 'x')
                count++;
            if (input[i + 1] == 'x')
                count++;
            dp[i][i + 1] = new Obj(count, 0);
        }

        for (int w = 3; w <= n; w++) {
            for (int start = 0; start < n - w + 1; start++) {
                int end = start + w - 1;
                //[start,end] is current substring

                if (input[start] == '|' && input[end] == '|') {
                    dp[start][end] = new Obj(dp[start + 1][end - 1].xCount, dp[start + 1][end - 1].xCount);
                } else {
                    int ansval = Math.max(Math.max(dp[start][end - 1].ans, dp[start + 1][end - 1].ans), dp[start + 1][end].ans);
                    int xCount = dp[start + 1][end].xCount;
                    if (input[start] == 'x')
                        xCount += 1;
                    dp[start][end] = new Obj(xCount, ansval);

                }
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != null)
                    System.out.print(dp[i][j].ans + "\t");
                else
                    System.out.print("_\t");
            }
            System.out.println();
        }


        return dp;
    }


    static class Obj {
        int xCount;
        int ans;

        public Obj(int xCount, int ans) {
            this.xCount = xCount;
            this.ans = ans;
        }
    }
}
