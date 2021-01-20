package dynamic_programming.painters_partition;

public class Recursive {

    public static void main(String[] args) {

    }

    public static int solve(int a[], int n, int k) {

        if (k == 0 || n == 0)
            return 0;

        int ans = Integer.MAX_VALUE;
        for (int i = n; i >= 0; i--) {
            ans=Math.min(ans,solve(a, i, k-1));
        }
    }
}
