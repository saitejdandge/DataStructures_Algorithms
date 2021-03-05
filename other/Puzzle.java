package other;

import java.util.ArrayList;
import java.util.List;

public class Puzzle {

    public static void main(String[] args) {
        int[] v = {2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 2, 2};
        int[] o = result(v, 3);
        for (int x : o)
            System.out.print(x);
    }

    public static int[] result(int a[], int n) {

        int o[] = null;
        for (int i = 0; i < n; i++) {
            o = solve(a);
            a = o;
        }
        return o;
    }

    public static int[] solve(int a[]) {

        int f = 0;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < a.length - 1) {
            int j = i;
            f = 1;
            while ((j != a.length - 1) && (a[j] == a[j + 1])) {
                f++;
                j++;
            }
            list.add(a[i]);
            list.add(f);
            i = j + 1;
        }

        int[] o = new int[list.size()];
        for (int k = 0; k < list.size(); k++)
            o[k] = list.get(k);

        return o;
    }
}
