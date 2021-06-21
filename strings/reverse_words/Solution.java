package strings.reverse_words;

public class Solution {

    public static void main(String[] args) {
        char[] o = (solve("this is book   gf ".toCharArray()));
        for (char x : o)
            System.out.print(x);
    }

    public static char[] solve(char[] input) {
        reverse(0, input.length - 1, input);
        int s = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == ' ') {
                reverse(s, i - 1, input);
                s = i + 1;
            }
        }
        reverse(s, input.length - 1, input);
        return input;
    }

    private static void swap(int s, int e, char[] c) {
        char temp = c[s];
        c[s] = c[e];
        c[e] = temp;
    }

    private static void reverse(int s, int e, char[] c) {
        while (s < e) {
            swap(s, e, c);
            s++;
            e--;
        }
    }
}
