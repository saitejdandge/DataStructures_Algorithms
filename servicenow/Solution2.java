package servicenow;

public class Solution2 {

    public static void main(String[] args) {

    }


    //[1,2,2,2,1,3,4]

    //k- count partitions
    public int solve(int[] a, int startIndex, int k, int p, int sum) {

        if (k == p - 1)
            return sum;

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            int sum2 = 0;
            for (int j = 0; j <= i; j++)
                sum2 += a[j];

            res = Math.min(res, sum2 + solve(a, startIndex, k + 1, p, sum));
        }

        return res;

    }
}
