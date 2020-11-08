package stack;

public class RainWaterTapping {
    public static void main(String[] args) {
        int a[] = { 0, 0, 8, 0, 0 };
        System.out.print(solve(a));
    }

    public static int solve(int[] a) {
        int n = a.length;
        int[] mxl = new int[n];
        int[] mxr = new int[n];

        mxl[0] = a[0];
        for (int i = 1; i < n; i++)
            mxl[i] = Math.max(mxl[i - 1], a[i]);
        mxr[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--)
            mxr[i] = Math.max(mxr[i + 1], a[i]);

    
        for (int i : mxl)
            System.out.print(i + " ");
        System.out.println();
        for (int i : mxr)
            System.out.print(i + " ");
        System.out.println();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int v = Math.min(mxl[i], mxr[i]) - a[i];
            System.out.println("v = " + v);
            sum += v;
        }
        return sum;
    }
}
