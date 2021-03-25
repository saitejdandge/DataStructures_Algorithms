package grid_problems.all_paths;

public class Solution {

    public static void main(String[] args) {

        int[][] grid = new int[][]{
                {0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0, 0, 0}
        };
        solve(2, 0, grid, new boolean[grid.length][grid[0].length], "");
    }

    public static void solve(int r, int c, int[][] grid, boolean[][] visited, String path) {

        if (r < 0 || r == grid.length || c < 0 || c == grid[0].length || grid[r][c] == 1 || visited[r][c])
            return;

        if (r == grid.length - 1 && c == grid[0].length - 1) {
            visited[r][c] = true;
            print(visited, path + "&");
            visited[r][c] = false;
            System.out.println(path);
//            return;
        }
        visited[r][c] = true;
        solve(r - 1, c, grid, visited, path + "t");
        solve(r, c - 1, grid, visited, path + "l");
        solve(r + 1, c, grid, visited, path + "d");
        solve(r, c + 1, grid, visited, path + "r");
        visited[r][c] = false;

    }

    private static void print(boolean[][] visited, String path) {

        System.out.println("-------------------------------");
        int c = 0;
        for (boolean[] r : visited) {
            for (boolean v : r) {
                if (v)
                    System.out.print("@" + " ");
                else
                    System.out.print("_ ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------");

    }
}
