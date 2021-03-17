package dynamic_programming.painters_partition;

import java.util.Arrays;

public class Partition {
    static int[] a = {10, 20, 30, 40, 50};

    public static void main(String[] args) {
        System.out.println(solve(a.length, 3));
    }

    public static int solve(int paintings, int painters) {

        if (paintings == 1)
            return a[0];
        if (painters == 1) {
            return Arrays.stream(a).limit(paintings).reduce(0, Integer::sum);
        }
        int best = Integer.MAX_VALUE;
        for (int i = paintings - 1; i >= 1; i--) {

//            int subArraySum = 0;
//            for (int k = i; k < paintings; k++)
//                subArraySum += a[k];

            int subArraySum = Arrays.stream(a).skip(i + 1).limit(paintings).reduce(0, Integer::sum);

            int subProblemSum = solve(i, painters - 1);

            best = Math.min(best, Math.max(subProblemSum, subArraySum));
        }
        return best;
    }
}
