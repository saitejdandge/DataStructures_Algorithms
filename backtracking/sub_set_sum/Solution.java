package backtracking.sub_set_sum;

import java.util.ArrayList;

/*checking if there's an atleast one subset sum =k*/
public class Solution {

    public static void main(String[] args) {
        int a[] = { 4, 3, 1, 2, -3, 2, 1 };
        driver(a, 4);
        // print(driver(a, 4), a);
    }

    public static void print(boolean used[], int a[]) {
        if (used == null || a == null)
            System.out.println("Null");
        else
            for (int i = 0; i < a.length; i++)
                if (used[i])
                    System.out.print(a[i] + " ");
    }

    public static void driver(int a[], int sum) {

        boolean used[] = new boolean[a.length];

        if (sum == 0)
            return;
        // if (solve(0, 0, sum, a, used, a.length))
        // return used;
        // else
        // return null;
        // //
        solve(0, 0, sum, a, used, a.length, new ArrayList<>());
        for (ArrayList<Integer> q : state) {
            for (int y : q) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    static ArrayList<ArrayList<Integer>> state = new ArrayList<>();

    public static boolean solve(int l, int progress, int total, int a[], boolean used[], int n,
            ArrayList<Integer> currentSubSet) {

        if (l >= n)
            return false;

        if (total == progress) {

            for(int i:currentSubSet)
                System.out.print(i+" ");
            System.out.println();
            state.add(currentSubSet);

            return solve(0, progress, total, a, used, n - 1, currentSubSet);
        }

        for (int i = l; i < n; i++) {
            if (a[i] <= total - progress && !used[i]) {
                used[i] = true;
                currentSubSet.add(a[i]);
                if (solve(i + 1, progress + a[i], total, a, used, n, currentSubSet))
                    return true;
                used[i] = false;
                currentSubSet.remove(new Integer(a[i]));
            }
        }
        return false;

    }
}
