package stack;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluatingExpression {
    public int evalRPN(ArrayList<String> A) {

        Stack<Integer> stack = new Stack<>();
        for (String c : A) {

            if (isNumeric(c)) {
                stack.push(Integer.parseInt(c));
            } else {
                if (stack.size() < 2)
                    return -1;

                int c1 = stack.pop();
                int c2 = stack.pop();
                int result = 0;
                switch (c) {

                    case "+":
                        result = c2 + c1;
                        break;
                    case "-":
                        result = c2 - c1;
                        break;
                    case "*":
                        result = c2 * c1;
                        break;
                    case "/":
                        if (c1 == 0)
                            return -1;
                        result = c2 / c1;
                        break;
                    default:
                        break;
                }
                stack.push(result);

            }
        }
        return stack.peek();
    }

    public boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}