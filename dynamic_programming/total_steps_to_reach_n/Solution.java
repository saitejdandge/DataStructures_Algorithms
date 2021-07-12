package dynamic_programming.total_steps_to_reach_n;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solve(10, 0));
    }

    public static int solve(int n, int steps) {
        if (steps <= 0)
            return 0;
        if (n <= 1)
            return 1;
        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (deque.size() < steps) {
                if (!deque.isEmpty())
                    sum += deque.peekLast();
                deque.add(sum);
            } else if (deque.size() == steps) {
                if (!deque.isEmpty())
                    sum += deque.peekLast();
                deque.addLast(sum);
                sum -= deque.removeFirst();
            }
        }
        return !deque.isEmpty() ? deque.peekLast() : -1;
    }
}
