package dynamic_programming.LCS;

public class ShortestCommonSuperSeq {
    static String a = "geek";
    static String b = "eke";

    public static void main(String[] args) {
        System.out.println(solve(a, b));
    }

    static int solve(String a, String b) {
        if (a == null || b == null)
            return 0;
        int lcs = LCS.solveBottomUp(a, b);

        return a.length() + b.length() - lcs;

    }
}