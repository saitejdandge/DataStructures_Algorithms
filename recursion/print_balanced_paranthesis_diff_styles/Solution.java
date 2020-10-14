package recursion.print_balanced_paranthesis_diff_styles;

public class Solution {
    static int k = 2;

    public static void main(String[] args) {
        solve(0, 0, 0, 0, "");
    }

    public static void solve(int open1, int close1, int open2, int close2, String output) {
        if (open1 + close1 + open2 + close2 == k) {
            System.out.println(output);
            return;
        }
        if (open1 == k) {
            solve(open1, close1 + 1, open2, close2, output + ")");
            return;
        }
        if (open2 == k) {
            solve(open1, close1, open2, close2 + 1, output + "]");
            return;
        }
        // neutral state, but only open
        if (open1 - close1 == 0 && open2 - close2 == 0) {

            solve(open1 + 1, close1, open2, close2, output + "(");
            solve(open1, close1, open2 + 1, close2, output + "[");
        } else {

            if (open1 > open2) {

                solve(open1, close1, open2 + 1, close2, output + "[");
                solve(open1, close1 + 1, open2, close2, output + ")");
                solve(open1 + 1, close1, open2, close2, output + "(");
            } else {

                solve(open1 + 1, close1, open2, close2, output + "(");
                solve(open1, close1, open2, close2 + 1, output + "]");
                solve(open1, close1, open2 + 1, close2, output + "[");
            }
        }
    }
}
