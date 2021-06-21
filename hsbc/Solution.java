package hsbc;

public class Solution {

    public static void main(String[] args) {
        SplStack stack = new SplStack();
        int[] input = {1, 4, -5, 0, 0, 0, 0};
        for (int i : input) {
            if (i == 0) {
                stack.pop();
            } else {
                stack.push(i);
            }
            System.out.println(stack.getSplValue());
        }
    }
}
