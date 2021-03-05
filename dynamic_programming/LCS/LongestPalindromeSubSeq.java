package dynamic_programming.LCS;

public class LongestPalindromeSubSeq {

    static String a = "banana";

    public static void main(String[] args) {
        int lps = (solve(a));
        System.out.println(lps);
        System.out.println("Insertions/Deletions needed to convert to palin = " + (a.length() - lps));
    }

    public static int solve(String a) {
        if (a == null)
            return 0;
        return LCS.solveBottomUp(a, reverse(a));
    }

    private static String reverse(String input) {

        if (input == null || input.length() == 0)
            return null;

        StringBuilder input1 = new StringBuilder();
        // append a string into StringBuilder input1
        input1.append(input);
        // reverse StringBuilder input1
        input1 = input1.reverse();
        // print reversed String
        return input1.toString();
    }

}