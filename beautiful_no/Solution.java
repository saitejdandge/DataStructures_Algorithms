package beautiful_no;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        int l = 20, r = 100;
        HashMap<Integer, Boolean> map = new HashMap<>();
        int res = 0;
        for (int s = l; s <= r; s++) {
            if (solve(s, map))
                res += s;
        }
    }

    public static boolean solve(int number, HashMap<Integer, Boolean> booleanHashMap) {

        if (booleanHashMap.containsKey(number)) {
            return booleanHashMap.get(number);
        }

        if (number == 1)
            return true;
        List<Integer> digits = getDigits(number);
        boolean ans;
        if (digits.size() == 1) {
            ans = digits.get(0) == 1;
        } else {
            int sum = getSum(digits);
            if (sum == 1) {
                ans = true;
            } else {
                ans = solve(sum, booleanHashMap);
            }
        }
        booleanHashMap.put(number, ans);
        return ans;
    }

    private static int getSum(List<Integer> digits) {
        int sum = 0;
        for (Integer i : digits)
            sum += (i * i);
        return sum;
    }

    private static List<Integer> getDigits(int number) {
        List<Integer> list = new ArrayList<>();
        while (number > 0) {
            list.add(number % 10);
            number /= 10;
        }
        return list;
    }


}
