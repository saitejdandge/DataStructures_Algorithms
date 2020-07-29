package prime_partition;

public class PP {
    static String str = "banana";

    public static void main(String[] args) {

        System.out.println("Number of min partitions are : "+solve(0,str.length()-1));
    }

    static boolean isPalindrome(String str, int i, int j) {
        if (i >= j)
            return true;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    static int solve(int i, int j) {

        if (i >= j) {
            return 0;
        }
        if (isPalindrome(str, i, j)) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = 1 + solve(i, k) + solve(k + 1, j);
            ans = Math.min(ans, temp);
        }
        return ans;
    }
}