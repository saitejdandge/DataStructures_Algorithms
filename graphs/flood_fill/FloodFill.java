package graphs.flood_fill;

class FloodFill {
    public int[][] floodFill(int[][] b, int i, int j, int newColor) {
        return dfs(b, i, j, newColor, b[i][j]);

    }

    public int[][] dfs(int[][] b, int i, int j, int newColor, int original) {

        int m = b.length;
        int n = b[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || b[i][j] != original || b[i][j] == newColor)
            return b;

        b[i][j] = newColor;

        dfs(b, i + 1, j, newColor, original);
        dfs(b, i - 1, j, newColor, original);
        dfs(b, i, j + 1, newColor, original);
        dfs(b, i, j - 1, newColor, original);

        return b;

    }

}
