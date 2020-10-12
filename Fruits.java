import java.util.ArrayList;
import java.util.List;

public class Fruits {

    static int t[] = { 2, 3, 5 };
    static int count[] = { 2, 2, 1 };
    static int cost[] = { 5, 5, 20 };
    static int s = 10;

    public static void main(String[] args) {
        int cache[][] = new int[t.length + 1][s + 1];

        for (int i = 0; i <= t.length; i++)
            for (int j = 0; j <= s; j++)
                cache[i][j] = -1;

        System.out.println(solve(t.length, s, cache, new ArrayList<>()));

    }

    public static int solve(int n, int s, int cache[][], List<Integer> list) {

        if (cache[n][s] != -1)
            return cache[n][s];
        if (s == 0) {
            System.out.println();
            for (int y : list)
                System.out.print(y + " ");
            System.out.println();
            return 0;
        }
        if (n == 0)
            return Integer.MAX_VALUE - 100;

        if (t[n - 1] <= s) {

            int inclusive;
            list.add(t[n - 1]);
            if (count[n - 1] - 1 > 0) {
                count[n - 1]--;
                inclusive = cost[n - 1] + solve(n, s - t[n - 1], cache, list);
            } else {
                inclusive = cost[n - 1] + solve(n - 1, s - t[n - 1], cache, list);
            }
            list.remove(new Integer(t[n - 1]));
            int exclusive = solve(n - 1, s, cache, list);

            cache[n][s] = Math.min(inclusive, exclusive);
        } else
            cache[n][s] = solve(n - 1, s, cache, list);
        return cache[n][s];

    }
}
