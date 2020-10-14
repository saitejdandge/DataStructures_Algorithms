package backtracking.permutate_strings;

public class Solution {

    public static void main(String[] args) {
        String str = "abca";
        solve(0, str.length()-1, str.toCharArray());
    }

    public static void solve(int l, int r, char[] a) {

        if (l == r) {
            System.out.println(a);
            return;
        }
        for (int i = l; i <= r; i++) {
            swap(i, l, a);
            solve(l + 1, r, a);
            swap(i, l, a);
        }
    }

    private static void swap(int i, int j, char[] a) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
