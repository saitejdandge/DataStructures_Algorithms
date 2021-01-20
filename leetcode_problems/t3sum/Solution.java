package leetcode_problems.t3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> x = threeSum(new int[] { -1, -1, 0, 1, 1, 2, 4 });
        for (List<Integer> l : x) {
            for (Integer i : l)
                System.out.print(i + " ");
            System.out.println();
        }

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int a[] = nums;
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        for (int i = 0; i < n - 2; i++) {

            if (i == 0 || (a[i] != a[i - 1])) {
                int t = 0 - a[i];
                int low = i + 1;
                int high = n - 1;
                while (low < high) {

                    int c = a[low] + a[high];
                    if (t == c) {
                        res.add(Arrays.asList(a[low], a[high], a[i]));
                        while (low < high && a[low] == a[low + 1])
                            low++;
                        while (low < high && a[high] == a[high - 1])
                            high--;
                    }
                    if (c > t) {
                        high--;
                    } else if(c<t){
                        low++;
                    }

                }
            }

        }
        return res;
    }
}