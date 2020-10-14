package dynamic_programming.paranthesization;

public class Paran {
    public static void main(String[] args) {

        System.out.println("Ans" + solve("F|T^T&F"));
    }

    public static int solve(String a) {
        return solve(a, 0, a.length() - 1, true);
    }

    public static int solve(String a, int i, int j, boolean expected) {

        if (i > j)
            return 0;
        if (i == j) {
            if (expected) {
                if (a.charAt(i) == 'T')
                    return 1;
                else
                    return 0;
            } else {
                if (a.charAt(i) == 'F')
                    return 1;
                else
                    return 0;
            }
        }
        int temp = 0;
        for (int k = i + 1; k <= j - 1; k += 2) {

            int lf = solve(a, i, k - 1, false);
            int lt = solve(a, i, k - 1, true);
            int rt = solve(a, k + 1, j, true);
            int rf = solve(a, k + 1, j, false);

            switch (a.charAt(k)) {
                case '&':
                    if (expected)
                        temp += (lt * rt);
                    else
                        temp += (lf * rf) + (lf * rt) + (rf * lt);
                    break;

                case '|':

                    if (expected)
                        temp += (lt * rt) + (lf * rt) + (lt * rf);
                    else
                        temp += (lf * rf);
                    break;
                case '^':
                    if (!expected)
                        temp += (lt * rt) + (lf * rf);
                    else
                        temp += (lf * rt) + (lt * rf);
                    break;
                default:

            }
            if (i == 0 && j == a.length() - 1) {
                System.out.println("temp " + temp + " " + a.charAt(k));
                System.out.println(lf + "_" + lt + "_" + rf + "_" + rt);
            }
            // global = Math.min(temp, global);

        }

        return temp;
    }

}