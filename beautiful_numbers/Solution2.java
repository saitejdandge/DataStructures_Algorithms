package beautiful_numbers;

import java.util.HashSet;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(isHappy(31));
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> myset = new HashSet<>();
        int val;
        int index;
        while (true) {
            val = 0;
            while (n > 0) {
                index = n % 10;
                val += index * index;
                n /= 10;
            }
            if (val == 1)
                return true;
            else if (myset.contains(val))
                return false;

            myset.add(val);
            n = val;
        }
    }
}
