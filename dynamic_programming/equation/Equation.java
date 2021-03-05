package dynamic_programming.equation;

public class Equation {

    static int[] coeff = {1, 2, 3};

    public static void main(String[] args) {

        int rhs = 4;
        System.out.println(solve(coeff.length, rhs));
    }

    public static int solve(int n, int rhs) {

        if (rhs == 0)
            return 1;

        if (n <= 0 || rhs < 0)
            return 0;

        int include = solve(n, rhs - (coeff[n - 1]));

        int exclude = solve(n - 1, rhs);

        return include + exclude;
    }
}