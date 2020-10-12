public class LCM {

    public static void main(String[] args) {
        System.out.println(solve(72, 120));
    }

    public static int solve(int a, int b) {
        int max = Math.max(a, b);
        while (true) {
            if (max % a == 0 && max % b == 0) {
                break;
            }
            max++;
        }
        return max;

    }

}
    