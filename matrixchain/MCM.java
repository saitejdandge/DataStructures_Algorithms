package matrixchain;

public class MCM {

    static int a[] = { 1, 2, 3,4};

    public static void main(String[] args) {
        System.out.println(solve(1, a.length - 1));
    }

    public static int solve(int i, int j) {

        if (i >= j)
            return 0;
        int ans = 0;
        for (int k = i; k <= j - 1; k++) {
            int temp = solve(i, k) + solve(k + 1, j) + 1;
            if (i == 1 && j == a.length - 1)
                System.out.println(temp + "");
            ans += temp;
        }
        return ans;
    }
}