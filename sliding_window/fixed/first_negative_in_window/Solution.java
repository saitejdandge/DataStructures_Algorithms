package sliding_window.fixed.first_negative_in_window;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

        int[] a = {12, 1, 2, 8, -15, -1, 16, 28};
        solve(a, 3);

    }

    public static void solve(int[] a, int k) {
        int i = 0, j = 0;
        Queue<Integer> queue = new LinkedList<>();
        while (j < a.length) {
            if (a[j] < 0)
                queue.add(a[j]);
            if (getWindowSize(i, j) < k) {
                j++;
            } else if (getWindowSize(i, j) == k) {
                System.out.print(queue.peek() + " ");
                if (!queue.isEmpty() && a[i] < 0)
                    queue.poll();
                i++;
                j++;
            }
        }

    }

    private static int getWindowSize(int i, int j) {
        return j - i + 1;
    }
}
