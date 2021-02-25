package dbs;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class ArraySum {

    public static void main(String[] args) {
        System.out.println(solve());

    }

    public static List<Integer> solve() {
        Scanner s=new Scanner(System.in);

        int n=s.nextInt();
        int m=s.nextInt();
        int t[][]=new int[n][m];
        int i,j;
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                t[i][j]=s.nextInt();
            }
        }
        int q = s.nextInt();
        int input[][]=new int[q][2];
        for(i=0;i<q;i++)
        {
            for(j=0;j<2;j++)
            {
                input[i][j]=s.nextInt();
            }
        }
        for(int x[]:input)
            for(int y:x)
                System.out.println(y);
        List<Integer> sums=getSums(t);
        System.out.println(t);
        System.out.println(sums);
        List<Integer> result = new ArrayList<>();
        for (i = 0; i < q; i++) {
            result.add(getCount(input[i][0], input[i][1], sums));
        }
        return result;
    }

    public static int getCount(int l, int r, List<Integer> sums) {
        return sums.stream().filter(integer -> integer >= l && integer <= r).reduce(0, (count, value) -> count + 1);
    }

    public static List<Integer> getSums(int[][] t) {

        int m = t.length;
        int n = t[0].length;
        List<Integer> sums = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += t[i][j];
            }
            sums.add(sum);
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += t[j][i];
            }
            sums.add(sum);
        }
        return sums;
    }
}