package strings.LongestCommonSubSeq;

public class BottomUp {

    public static void main(String[] args) {
        System.out.println(solve("acd", "abc"));
    }

    public static int solve(String a, String b) {

        int[][] t = new int[2][b.length() + 1];
        int bi = 0;
        for (int i = 1; i <= a.length(); i++) {
            bi = i % 2;
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    t[bi][j] = 1 + t[1 - bi][j - 1];
                else
                    t[bi][j] = Math.max(t[1 - bi][j], t[bi][j - 1]);
            }
        }
        return t[bi][b.length()];
    }
}
