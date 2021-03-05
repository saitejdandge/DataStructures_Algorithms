package recursion.josephus_problem;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        int n = 40;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            list.add(i);
        System.out.println("Survived at " + solve(list, 0, 7 - 1));

    }

    public static int solve(List<Integer> list, int index, int k) {
        if (list.size() == 1) {
            return list.get(0);
        }
        index = (index + k) % list.size();
        list.remove(index);
        return solve(list, index, k);

    }

}
