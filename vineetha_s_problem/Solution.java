package vineetha_s_problem;

public class Solution {

    public static void main(String[] args) {
        int[] a = {2, 1, 3, 4, 6, 5};

        System.out.println(solve(a, 0, a.length - 1));

    }

    public static boolean check(int[] a, int i, int j) {

        int state = 0;// increasingOrder
        if (a[i] > a[i + 1]) {
            state = 1;
        }
        for (int k = i; k <= j - 1; k++) {

            if (a[k] == a[k + 1])
                return false;

            if (state == 0) {
                if (a[k] + 1 != a[k + 1])
                    return false;
            } else if (state == 1) {

                if (a[k] != a[k + 1] + 1)
                    return false;
            }
        }
        return true;
    }


    public static boolean solve(int[] a, int i, int j) {
        if (i == j && i + 1 == a[i])
            return true;
        if (i >= j)
            return false;

        if (check(a, i, j))
            return true;

        for (int k = i; k <= j - 1; k++) {
            if (solve(a, i, k) && solve(a, k + 1, j))
                return true;
        }

        return false;
    }


}
