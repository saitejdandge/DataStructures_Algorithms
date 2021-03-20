package sliding_window.first_negative_in_window;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

        int[] a = {12, 1, 2, 8, -15, -1, 16, 28};
        solve(a, 3);

    }

    public static void solve(int[] a, int windowSize) {
        int i = 0, j = 0;
        Queue<Integer> queue = new LinkedList<>();

        while (j < a.length) {
            if (a[j] < 0)
                queue.add(a[j]);

            if (j - i + 1 >= windowSize) {
                System.out.print(queue.peek() + " ");
                if (!queue.isEmpty() && a[i] < 0)
                    queue.poll();
                i++;
            }
            j++;
        }

    }
}
