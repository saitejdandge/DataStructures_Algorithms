package binary_search.k_sorted_array;

public class Solution {

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 2, 3, 5, 2, 4, 34,};
        System.out.println(solve(a, a.length, 5));
    }

    public static int solve(int[] a, int k, int key) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int checkAns = check(a, k, key, l, r);
            if (checkAns != -1)
                return checkAns;
            if (key < a[m])
                r = m - 1 - k;
            else
                l = m + 1 + k;
        }
        return -1;
    }

    private static int check(int[] a, int k, int key, int l, int r) {
        int m = l + (r - l) / 2;
        for (int i = 0; i <= k; i++) {
            if (m - i >= l && a[m - i] == key)
                return m - i;
            if (m + i <= r && a[m + i] == key)
                return m + i;
        }
        return -1;
    }
}
