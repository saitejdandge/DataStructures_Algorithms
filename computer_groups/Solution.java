package computer_groups;

/*
Given set of computers, 
    I need to choose atleast 3 computers to form a group. Each computer has its own capacity, every group total capacity formed should cross the given threshold capacity.
    How many such max groups are possible ?
*/
public class Solution {

    static int[] data = { 1, 3, 2, 1, 3, 2, 1, 3, 2, 4, 3, 1, 1, 1, 2, 3 };
    static int th = 4;
    static int minGrpSize = 2;

    public static void main(String[] args) {
        //
        System.out.println(solve(0, data.length - 1));
    }

    public static int getSum(int i, int j) {
        int sum = 0;
        for (int x = i; x <= j; x++) {
            sum += data[x];
        }
        return sum;
    }

    public static int solve(int i, int j) {
        int sum = getSum(i, j);
        if (j - i < (minGrpSize - 1))
            return 0;

        else if (j - i == (minGrpSize - 1) && sum >= th) {
            return 1;
        }

        if (sum <= th)
            return 0;

        int ans = Integer.MIN_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = solve(i, k) + solve(k + 1, j);
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}