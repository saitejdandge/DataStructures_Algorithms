package recursion.print_sub_sets;

public class Solution {

    public static void main(String[] args) {
        solve("saitej", "");
    }

    public static void solve(String input, String output) {
        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }
        solve(input.substring(1), output + input.charAt(0));
        solve(input.substring(1), output);
    }
}
