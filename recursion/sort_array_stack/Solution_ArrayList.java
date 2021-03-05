package recursion.sort_array_stack;

import java.util.ArrayList;
import java.util.Random;

public class Solution_ArrayList {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList();

        Random rand = new Random();
        for (int i = 0; i < 100; i++)
            list.add(rand.nextInt(10));
        sort(list);
        for (int i : list)
            System.out.print(i + " ");
    }

    public static ArrayList<Integer> sort(ArrayList<Integer> stack) {
        if (stack.size() == 1)
            return stack;
        int temp = stack.remove(stack.size() - 1);
        insert(sort(stack), temp);
        return stack;
    }

    private static void insert(ArrayList<Integer> stack, int value) {
        if (stack.isEmpty() || stack.get(stack.size() - 1) <= value) {
            stack.add(value);
            return;
        }
        int temp = stack.remove(stack.size() - 1);
        insert(stack, value);
        stack.add(temp);

    }
}
