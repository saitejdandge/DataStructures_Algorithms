package beautiful_no;

import java.util.Arrays;

public class TaskSol {

    public static void main(String[] args) {
//        System.out.println(solve(new int[][]{{1, 3}, {2, 2}}, 6));
//        System.out.println(solve(new int[][]{{2, 8}, {6, 3}, {5, 1}}, 16));


        System.out.println(solve(new int[][]{{1, 2}, {4, 2}, {5, 1}, {6, 2}, {3, 1}}, 16));
    }


    //

    public static int solve(int[][] pairs, int time) {

        if (pairs.length == 0)
            return 0;
        Arrays.sort(pairs, (a, b) -> (a[0] + a[1]) - (b[1] + b[0]));
        //sorting is done
        int[] firstPair = pairs[0];

        int count;
        if (firstPair[0] + firstPair[1] + firstPair[0] <= time) {
            count = 1;
            time -= firstPair[0] + firstPair[1];
        } else
            return 0;

        for (int i = 1; i < pairs.length; i++) {
            int[] nextPair = pairs[i];
            if (Math.abs(nextPair[0] - firstPair[0]) + nextPair[1] + nextPair[0] <= time) {
                time -= Math.abs((nextPair[0] - firstPair[0]) + nextPair[1]);
                count++;
                firstPair = nextPair;
            } else
                break;

        }
        return count;
    }
}
