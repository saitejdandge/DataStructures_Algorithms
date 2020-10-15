package backtracking.permutate_strings_ibh;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        List<String> result = new ArrayList<>();
        result = solve("saitej");
        System.out.println(result);
    }

    public static List<String> solve(String input) {
        ArrayList<String> output = new ArrayList<>();
        if (input.isEmpty()) {
            output.add("");
            return output;
        }

        char temp = input.charAt(0);
        List<String> words = solve(input.substring(1));
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String newWord = insertChar(temp, word, i);
                output.add(newWord);
            }
        }
        return output;

    }

    private static String insertChar(char temp, String word, int i) {
        return word.substring(0, i) + temp + word.substring(i, word.length());
    }
}
