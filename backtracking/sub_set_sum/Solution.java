package backtracking.sub_set_sum;

/*checking if there's an atleast one subset sum =k*/
public class Solution {

    public static void main(String[] args) {
        int a[] = { 4, 3, 1, 2, -3, 2, 1 };
        print(driver(a, 8), a);
    }

    public static void print(boolean used[], int a[]) {
        if (a == null)
            System.out.println("Null");
        else
            for (int i = 0; i < a.length; i++)
                if (used[i])
                    System.out.print(a[i] + " ");
    }

    public static boolean[] driver(int a[], int sum) {

        boolean used[] = new boolean[a.length];

        if (sum == 0)
            return used;
        if (solve(0, 0, sum, a, used))
            return used;
        else
            return null;
    }

    public static boolean solve(int l, int progress, int total, int a[], boolean used[]) {
        if (total == progress)
            return true;

        for (int i = l; i <= a.length; i++) {
            if (a[i] <= total - progress && !used[i]) {
                used[i] = true;
                if (solve(l + 1, progress + a[i], total, a, used))
                    return true;
                used[i] = false;
            }
        }
        return false;

    }
}
