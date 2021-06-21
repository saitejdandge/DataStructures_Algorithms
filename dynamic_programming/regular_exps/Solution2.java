package dynamic_programming.regular_exps;

public class Solution2 {

    public static void main(String[] args) {

        String s = "pxyzabyrc";
        String pattern = "p*ab*";
        System.out.println(solve(s, pattern, s.length(), pattern.length()));
    }

    public static boolean solve(String str, String pattern, int s, int p) {
        if (p == 0)
            return s == 0;
        if (s == 0) {
            for (int i = p - 1; i >= 0; i--)
                if (pattern.charAt(i) != '*')
                    return false;
            return true;
        }

        if (str.charAt(s - 1) == pattern.charAt(p - 1) || pattern.charAt(p - 1) == '?')
            return solve(str, pattern, s - 1, p - 1);
        else if (pattern.charAt(p - 1) == '*')
            return solve(str, pattern, s, p - 1) || solve(str, pattern, s - 1, p);


        return false;
    }
}
