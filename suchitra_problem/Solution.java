package suchitra_problem;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solve2(new int[]{9, 4, 9}, new int[]{3, 1, 3}));
    }

    public static boolean solve(int[] a, int[] b) {
        int i = 0, j = 0;
        int windowSize = b.length;
        int[] res = getMax(b);
        int m2 = res[0];
        int sum2 = res[1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((f, s) -> s - f);
        int sum1 = 0;
        while (j < a.length) {
            maxHeap.add(a[j]);
            sum1 += a[j];
            if (j - i + 1 >= windowSize) {
                int m1 = maxHeap.peek();
                if (checkSum(sum1, sum2, m1 / m2) && check(a, b, m1, m2, i, j))
                    return true;
                maxHeap.remove(a[i]);
                sum1 -= a[i];
                i++;
            }
            j++;
        }
        return false;
    }


    private static boolean solve2(int[] a, int[] b) {

        int windowSize = b.length;
        int m2 = getMax(b)[0];
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
                if (check(a, b, deque.peekFirst(), m2, i, j))
                    return true;
                if (!deque.isEmpty() && deque.peekFirst() == a[i])
                    deque.removeFirst();
                i++;
            }
            j++;
        }
        return false;
    }

    private static boolean checkSum(int sum1, int sum2, int k) {
        for (int i = 1; i <= k; i++)
            if (sum1 / i == sum2)
                return true;
        return false;
    }


    private static boolean check(int[] a, int[] b, int m1, int m2, int i, int j) {


        for (int k = 1; k <= m1 / m2; k++) {
            //check every element of a,b
            int count = 0;
            for (int r = i; r <= j; r++) {
                if (a[r] / k == b[r - i])
                    count++;
            }
            if (count == j - i + 1)
                return true;
        }
        return false;
    }

    private static int[] getMax(int[] b) {
        int ans = b[0];
        int sum = 0;
        for (int j : b) {
            ans = Math.max(ans, j);
            sum += j;
        }
        return new int[]{ans, sum};
    }
}
