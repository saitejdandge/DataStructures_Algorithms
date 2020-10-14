package dynamic_programming. LCS;

public class PatternMatching {

    public static void main(String[] args) {

        System.out.println(isSubSequence("nan", "bananan"));
        System.out.println(isSubSequence("nxn", "bananan"));
    }

    public static boolean isSubSequence(String a, String b) {
        if (a == null || b == null)
            return false;

        int lcs = LCS.solveBottomUp(a, b);

        return a.length()==lcs;
    }

}