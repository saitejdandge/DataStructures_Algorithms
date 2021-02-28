package strings.LongestCommonSubString;

public class BottomUp {

    public static void main(String[] args) {
        System.out.println(solve("OldSite:GeeksforGeeks.org", "NewSite:GeeksQuiz.com"));
    }

    public static int solve(String a, String b) {
        int[][] t = new int[2][b.length() + 1];
        int res = 0;
        int bi;
        for (int i = 1; i <= a.length(); i++) {
            bi = 1 & i;
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    t[bi][j] = 1 + t[1 - bi][j - 1];
                } else
                    t[bi][j] = 0;
                res = Math.max(res, t[bi][j]);
            }
        }
        return res;
    }
}
