package linked_list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseInGroup {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 4, 6, 3, 7, 8, 5, -4, 19);
        reverseKGroup(3, list);
        System.out.println(list);
    }

    static void reverseKGroup(int k, List<Integer> original) {
        if (original.size() < k || k <= 0)
            return;
        for (int i = 1; i * k <= original.size(); i++)
            Collections.reverse(original.subList((i - 1) * k, i * k));
    }
}