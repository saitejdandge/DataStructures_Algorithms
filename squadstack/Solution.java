package squadstack;

public class Solution {
    static int n;

    static long solve(int n) {
        // Write your code here
        Solution.n = n;
        long[][] t = new long[n + 1][5];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j < 5; j++)
                t[i][j] = -1;
        return solve(0, '_', t);
    }

    public static void main(String[] args) {
        System.out.println(solve(8000));
    }

    static long solve(int c, char last, long t[][]) {
        if (c == n)
            return 1;

        if (last != '_') {
            int v = switch (last) {
                case 'a' -> 0;
                case 'e' -> 1;
                case 'i' -> 2;
                case 'o' -> 3;
                case 'u' -> 4;
                default -> -1;
            };
            if (v != -1 && t[c][v] != -1)
                return t[c][v] % ((int) (Math.pow(10, 9) + 7));

        }

        switch (last) {
            case '_' -> {
                if (t[c + 1][0] == -1)
                    t[c + 1][0] = solve(c + 1, 'a', t) % ((int) (Math.pow(10, 9) + 7));
                if (t[c + 1][1] == -1)
                    t[c + 1][1] = solve(c + 1, 'e', t) % ((int) (Math.pow(10, 9) + 7));
                if (t[c + 1][2] == -1)
                    t[c + 1][2] = solve(c + 1, 'i', t) % ((int) (Math.pow(10, 9) + 7));
                if (t[c + 1][3] == -1)
                    t[c + 1][3] = solve(c + 1, 'o', t) % ((int) (Math.pow(10, 9) + 7));
                if (t[c + 1][4] == -1)
                    t[c + 1][4] = solve(c + 1, 'u', t) % ((int) (Math.pow(10, 9) + 7));
                return (t[c + 1][0] + t[c + 1][1] + t[c + 1][2] + t[c + 1][3] + t[c + 1][4])
                        % ((int) (Math.pow(10, 9) + 7));
            }
            case 'a' -> {
                if (t[c + 1][1] == -1)
                    t[c + 1][1] = solve(c + 1, 'e', t) % ((int) (Math.pow(10, 9) + 7));
                if (t[c + 1][3] == -1)
                    t[c + 1][3] = solve(c + 1, 'o', t) % ((int) (Math.pow(10, 9) + 7));
                t[c][0] = (t[c + 1][1] + t[c + 1][3]) % ((int) (Math.pow(10, 9) + 7));
                return t[c][0];
            }
            case 'e' -> {
                if (t[c + 1][2] == -1)
                    t[c + 1][2] = solve(c + 1, 'i', t) % ((int) (Math.pow(10, 9) + 7));
                t[c][1] = t[c + 1][2];
                return t[c][1];
            }
            case 'i' -> {
                if (t[c + 1][0] == -1)
                    t[c + 1][0] = solve(c + 1, 'a', t) % ((int) (Math.pow(10, 9) + 7));
                if (t[c + 1][1] == -1)
                    t[c + 1][1] = solve(c + 1, 'e', t) % ((int) (Math.pow(10, 9) + 7));
                if (t[c + 1][3] == -1)
                    t[c + 1][3] = solve(c + 1, 'o', t) % ((int) (Math.pow(10, 9) + 7));
                if (t[c + 1][4] == -1)
                    t[c + 1][4] = solve(c + 1, 'u', t);
                t[c][2] = (t[c + 1][0] + t[c + 1][1] + t[c + 1][3] + t[c + 1][4]) % ((int) (Math.pow(10, 9) + 7));
                return t[c][2];
            }
            case 'o' -> {
                if (t[c + 1][2] == -1)
                    t[c + 1][2] = solve(c + 1, 'i', t) % ((int) (Math.pow(10, 9) + 7));
                t[c][3] = t[c + 1][2];
                return t[c][3];
            }
            case 'u' -> {
                if (t[c + 1][2] == -1)
                    t[c + 1][2] = solve(c + 1, 'i', t) % ((int) (Math.pow(10, 9) + 7));
                t[c][4] = t[c + 1][2];
                return t[c][4];
            }
        }
        return 0;
    }
}
