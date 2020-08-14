package LCS;

public class ConvertAToB {

    static String a = "saitej";
    static String b = "heeraj";

    public static void main(String[] args) {
        System.out.println(solve(a, b));
    }

    public static int solve(String a, String b) {
        if (a == null || b == null)
            return 0;
        int lcs = LCS.solveBottomUp(a, b);
        int deletions = a.length() - lcs;
        int insertions = b.length() - lcs;
        System.out.println("Deletions : " + deletions);
        System.out.println("Insertions : " + insertions);
        return insertions + deletions;

    }
}