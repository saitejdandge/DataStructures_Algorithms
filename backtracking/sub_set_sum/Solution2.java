package backtracking.sub_set_sum;

public class Solution2 {

    public static void main(String[] args) {

        int a[] = {1, 1, 2, 1, 3, 4};
        solve(a, 0, 4, new boolean[a.length]);
    }

    public static void solve(int a[], int i, int sum, boolean output[]) {
        if (sum == 0) {
            for (int k = 0; k < output.length; k++) {
                if (output[k])
                    System.out.print(a[k]);
            }
            System.out.println();
            return;
        }
        if (i == a.length) {
            return;
        }

        for (int k = i; k < a.length; k++) {
            if (a[k] <= sum && !output[k]) {
                output[k] = true;
                solve(a, i + 1, sum - a[k], output);
                output[k] = false;
            }
        }
    }
}
