package other;
public class SubArrays {

    static int a[] = { 4, 8, 5, 2, 4 };

    static int value = 4;

    public static void main(String[] args) {
        System.out.println(solve(0, a.length - 1));
    }

    public static int solve(int i, int j) {

        if (i > j)
            return 0;

        int count = 0;
        for (int k = i; k <= j; k++) {
            if (a[k] == value)
                count++;
        }
        if (count <= 1)
            return count;
        int ans = 0;
        for (int k = i; k <= j - 1; k++) {
            int left = solve(i, k);
            int right = solve(k + 1, j);
            int temp = left + right;
            if (i == 0 && j == a.length - 1)
                System.out.println(temp + ":"+left+":"+right);
            ans = Math.max(temp, ans);
        }
        return ans;
    }
}
