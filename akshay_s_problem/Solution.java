package akshay_s_problem;

import java.util.HashMap;

public class Solution {

    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        int n = 823;

        // int a[] = new int[n];

        // for (int i = 0; i < n; i++)
        //     a[i] = i + 1;

        int a[]={1,2,3,5,6};
        // exponential 2~a.length
        System.out.println(solve(a.length, a, n));
    }

    // f(8)- f(7)+f(6)
    // 2+[1,2]

    // n -> number of elements
    // Top Down

    // {1,2,3,5}

    public static int f(int n) {

        if (n <= 1)
            return n;
        else
            return f(n - 1) + f(n - 2);
    }

    public static int fi(int n) {

        int a = 0;
        int b = 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {

            sum += (a + b);
            a = sum;
            b = a;
        }

        return sum;
    }


    public static int solve(int n, int a[], int sum) {

        if (map.get(n + "_" + sum) != null)
            return map.get(n + "_" + sum);

        if (sum == 0)
            return 1;
        if (n == 0)
            return 0;

        if (a[n - 1] <= sum)
            map.put(n + "_" + sum, solve(n, a, sum - a[n - 1]) + solve(n - 1, a, sum));
        else
            map.put(n + "_" + sum, solve(n - 1, a, sum));

        return map.get(n + "_" + sum) % 1000000007;
    }
}
// not tail recursion
