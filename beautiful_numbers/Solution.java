package beautiful_numbers;

public class Solution {

    public static void main(String[] args) {
        int l = 0, r = 20;
        int sum = 0;
        for (int i = l; i <= r; i++) {
            if (isBeautifulNumber(i))
                sum += i;
        }
        System.out.println(sum);
    }

    static int numSquareSum(int n) {
        int squareSum = 0;
        while (n != 0) {
            squareSum += (n % 10) * (n % 10);
            n /= 10;
        }
        return squareSum;
    }


    //  method return true if n is Happy number
    static boolean isBeautifulNumber(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = numSquareSum(slow);
            fast = numSquareSum(numSquareSum(fast));
        }
        while (slow != fast);
        return (slow == 1);
    }

}
