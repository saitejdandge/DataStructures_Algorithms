package leetcode_problems.max_area_rectangle;

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] a) {

        int nsl[] = getArray(a, -1);
        int nsr[] = getArray(a, 1);
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, Math.abs(Math.abs(nsl[i] - nsr[i]) - 1) * a[i]);
        }
        return max;
    }

    public int[] getArray(int[] a, int d) {

        int o[] = new int[a.length];
        int n = a.length;
        Stack<Integer> s = new Stack<>();

        int i;
        if (d == -1)
            i = 0;
        else
            i = a.length - 1;
        while (true) {
            if (d == -1 && i == a.length) {
                break;
            } else if (i < 0) {
                break;
            }

            if (s.isEmpty()) {
                o[i] = d == -1 ? -1 : a.length;
            } else {
                if (a[s.peek()] < a[i])
                    o[i] = s.peek();
                else {
                    while (!s.isEmpty() && a[s.peek()] >= a[i])
                        s.pop();
                    if (s.isEmpty())
                        o[i] = d == -1 ? -1 : a.length;
                    else
                        o[i] = s.peek();
                }
            }
            s.push(i);

            if (d == -1)
                i++;
            else
                i--;

        }
        return o;

    }
}