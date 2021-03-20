package sliding_window.max_sub_arrays_k;

import java.util.Deque;
import java.util.LinkedList;

public class SolutionWithDeque {
    public static void main(String[] args) {
        int a[] = {1, 3, -1, 3, 5, 6, 7};
        solve(a, 3);
    }

    private static void solve(int[] a, int windowSize) {

        Deque<Integer> deque = new LinkedList<>();
        int i = 0, j = 0;
        while (j < a.length) {
            if (!deque.isEmpty()) {
                if (a[j] > deque.peekFirst())
                    while (!deque.isEmpty() && deque.peekFirst() < a[j])
                        deque.removeFirst();
            }
            deque.addLast(a[j]);
            if (j - i + 1 >= windowSize) {
                System.out.print(deque.peekFirst() + " ");
                if (!deque.isEmpty() && deque.peekFirst() == a[i])
                    deque.removeFirst();
                i++;
            }
            j++;
        }
    }
}
