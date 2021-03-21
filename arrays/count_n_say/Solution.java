package arrays.count_n_say;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> res = Arrays.asList(new Integer[]{1});
        for (int i = 0; i < 7; i++) {
            res = solve(res);
        }
        System.out.println(res);
    }

    private static List<Integer> solve(List<Integer> ints) {
        int i = 0;
        int n = ints.size();
        List<Integer> output = new ArrayList<>();
        while (i < n) {
            int count = 1;
            while (i <= n - 2 && ints.get(i).equals(ints.get(i + 1))) {
                i++;
                count++;
            }
            output.add(count);
            output.add(ints.get(i));
            i = i + 1;
        }
        return output;
    }
}
