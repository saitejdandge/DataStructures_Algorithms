package recursion.print_balanced_paranthesis;

import recursion.differnt_styles_of_braces.Styles;

public class Solution {
    public static void main(String[] args) {
        solve(3, 3, "");
    }

    public static void solve(int open, int close, String output) {
        if (open == 0 && close == 0) {
            Styles.solve(output, "");
            return;
        }
        if (open == 0) {
            solve(open, close - 1, output + ")");
            return;
        }
        if (open < close) {
            solve(open, close - 1, output + ")");
            solve(open - 1, close, output + "(");

        } else
            solve(open - 1, close, output + "(");

    }
}
