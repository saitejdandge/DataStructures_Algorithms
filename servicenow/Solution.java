package servicenow;

public class Solution {


    public static void main(String[] args) {

        int[][] a = new int[][]{{2, 1, 2}, {1, 0, 1}, {0, 2, 1}};
        int x = 3;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != 0 && a[i][j] != 2) {
                    canInfect(a, i, j, getN(i, j, a) + 1);
                }
            }
        }
        int timeRequired = 3;
        boolean isHumanFound = false;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1) {
                    isHumanFound = true;
                }
                if (a[i][j] >= 3) {
                    timeRequired = Math.max(timeRequired, a[i][j]);
                }
            }
        }
        System.out.println(!isHumanFound && timeRequired < x);
    }

    public static int getN(int i, int j, int[][] a) {
        //
        //return -1, if safe
        //return min of all zombies

        int p = a[i + 1][j];
        int q = a[i - 1][j];
        int r = a[i][j + 1];
        int s = a[i][j - 1];

        int[] n = new int[]{p, q, r, s};
        int min = -1;
        for (int ele : n) {
            if (ele != 1 && ele != 0)
                min = Math.min(ele, min);
        }
        return min;

    }


    /*
     *
     * 2,1,2
     * 3,0,3
     * 4,5,4
     *
     *
     *
     * [3,..]
     *
     *
     * 2,3,2
     * 3,0,3
     * 0,2,3(2)
     * 3-2->1
     * */

    //a 0(wall), 1(human), 2(zombie), returns can infect bool,currentTime(3)
    public static void canInfect(int[][] a, int i, int j, int currentTime) {

        //checking if its invalid
        if (i < 0 || i >= a.length || j < 0 || j >= a[i].length || a[i][j] == 0 || a[i][j] == 2 || currentTime == 0)
            return;

        if (a[i][j] != 1 && a[i][j] < currentTime)
            return;


        if (a[i][j] == 1)
            a[i][j] = currentTime;
        else {
            a[i][j] = Math.min(a[i][j], currentTime);

        }

        canInfect(a, i + 1, j, currentTime + 1);
        canInfect(a, i - 1, j, currentTime + 1);
        canInfect(a, i, j + 1, currentTime + 1);
        canInfect(a, i, j - 1, currentTime + 1);


    }
}
