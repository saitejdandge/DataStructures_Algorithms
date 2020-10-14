package stocks;

// buy and sell the stock II
public class BNS1 {

    static int a[] = { 7, 1};

    public static void main(String[] args) {
        System.out.println(solve(0, false));
    }

    public static int solve(int n, boolean isBought) {

        if (n >= a.length || (isBought && n == a.length - 1))
            return 0;

        int skip = solve(n + 1, isBought);
        int output;
        if (isBought) {
            output = (-a[n] + solve(n + 1, false));
        } else
            output = (a[n] + solve(n + 1, true));

        return Math.max(output, skip);
    }
}
