package leetcode_problems.rotten_oranges;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        int grid[][] = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(new Solution().orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int c = grid[0].length;
        Queue<Node> q = new LinkedList();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Node(i, j, 0));
                }
            }
        }
        int total = 0;
        while (!q.isEmpty()) {
            Node n = q.poll();

            System.out.println(n.i + ":" + n.j);
            total = n.time + 1;
            if (n.i + 1 < m && grid[n.i + 1][n.j] == 1) {
                grid[n.i + 1][n.j] = 2;
                q.add(new Node(n.i + 1, n.j, n.time + 1));
            }

            if (n.i - 1 >= 0 && grid[n.i - 1][n.j] == 1) {
                grid[n.i - 1][n.j] = 2;
                q.add(new Node(n.i - 1, n.j, n.time + 1));
            }
            if (n.j + 1 < c && grid[n.i][n.j + 1] == 1) {
                grid[n.i][n.j + 1] = 2;
                q.add(new Node(n.i, n.j + 1, n.time + 1));
            }

            if (n.j - 1 >= 0 && grid[n.i][n.j - 1] == 1) {
                grid[n.i][n.j - 1] = 2;
                q.add(new Node(n.i, n.j - 1, n.time + 1));
            }

        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        return check(grid) ? total : -1;
        // return total;
    }

    public boolean check(int grid[][]) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1)
                    return false;
            }
        }
        return true;
    }

    class Node {
        int i;
        int j;
        int time;

        Node(int r, int c, int time) {
            this.i = r;
            this.j = c;
            this.time = time;
        }
    }
}