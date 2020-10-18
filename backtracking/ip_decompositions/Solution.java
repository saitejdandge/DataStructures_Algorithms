package backtracking.ip_decompositions;

public class Solution {

    public static void main(String[] args) {

        int output[] = { -1, -1, -1, -1 };
        solve("25525511135", output, 0);
    }

    public static void solve(String s, int output[], int k) {
        if (k == 3 && isSafe(s)) {
            output[3] = Integer.parseInt(s);

            for (int i : output)
                System.out.print(i + ".");
            System.out.println();
            return;
        } else if (k == 4 || s.isEmpty())
            return;

        for (int i = 1; i <= 3 && s.length() >= i; i++) {

            String temp = s.substring(0, i);
            if (isSafe(temp)) {

                output[k] = Integer.parseInt(temp);
                solve(s.substring(i), output, k + 1);
                output[k] = -1;

            }

        }
    }

    private static boolean isSafe(String temp) {
        try {
            if (temp.isEmpty())
                return false;
            if (temp.startsWith("0") && temp.length() > 1)
                return false;
            int value = Integer.parseInt(temp);
            return value <= 255;
        } catch (Exception e) {
            return false;
        }
    }
}
