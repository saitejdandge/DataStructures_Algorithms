package recursion.towers_of_hanoi;

public class Solution {
    public static void main(String[] args) {

        solve(2, 1, 3, 2);
    }

    public static void solve(int n, int s, int d, int h) {
        if (n == 1) {
            System.out.println("Move disk from " + s + " -> " + d);
            return;
        }
        solve(n - 1, s, h, d);
        System.out.println("Move disk from " + s + " -> " + d);
        solve(n - 1, h, d, s);
    }
}
