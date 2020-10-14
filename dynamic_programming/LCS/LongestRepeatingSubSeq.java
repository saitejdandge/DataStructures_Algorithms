package dynamic_programming. LCS;

public class LongestRepeatingSubSeq {
    static String a = "AABEBCDD";

    public static void main(String[] args) {

        System.out.println(solve(a));

    }

    public static int solve(String a) {
        if (a == null || a.length() == 0)
            return 0;

        int[][] t = new int[a.length() + 1][a.length() + 1];

        for (int i = 0; i <= a.length(); i++)
            t[i][0] = 0;
        for (int j = 0; j <= a.length(); j++)
            t[0][j] = 0;

        for (int i = 1; i <= a.length(); i++)
            for (int j = 1; j <= a.length(); j++) {
                if (a.charAt(i - 1) == a.charAt(j - 1) && i != j) //i!=j is important
                    t[i][j] = 1 + t[i - 1][j - 1];
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        return t[a.length()][a.length()];
    }
}