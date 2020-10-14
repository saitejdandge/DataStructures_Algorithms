package recursion.permutations_with_letter_cases;

public class Solution {

    public static void main(String[] args) {

        String input = "a1bc";
        String output = "";
        solve(input, output);
    }

    public static void solve(String input, String output) {
        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }

        if (Character.isAlphabetic(input.charAt(0))) {
            solve(input.substring(1), output + Character.toLowerCase(input.charAt(0)));
            solve(input.substring(1), output + Character.toUpperCase(input.charAt(0)));
        } else
            solve(input.substring(1), output + input.charAt(0));
    }

}
