package strings.all_subsequences;

public class Solution {

    public static void main(String[] args) {
        solve(0, "abcdefghijlkmlqo", "");
    }

    public static void solve(int i, String input, String output) {
        if (i == input.length()) {
            System.out.println(output);
            return;
        }
        solve(i + 1, input, output + input.charAt(i) + "");
        solve(i + 1, input, output);

    }
}
