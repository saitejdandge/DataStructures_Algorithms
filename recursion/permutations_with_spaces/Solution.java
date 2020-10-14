package recursion.permutations_with_spaces;

public class Solution {

    public static void main(String[] args) {

        String input = "bc";
        String output = "a";
        solve(input, output);
    }

    public static void solve(String input, String output) {
        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }
        solve(input.substring(1), output + "_" + input.charAt(0));
        solve(input.substring(1), output + input.charAt(0));
    }

}
