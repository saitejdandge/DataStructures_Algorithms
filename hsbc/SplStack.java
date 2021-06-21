package hsbc;

import java.util.Stack;

public class SplStack {

    private final Stack<Integer> stack;
    private int sum;
    private int sumOfSquares;
    private int value;

    public SplStack() {
        this.sum = 0;
        this.sumOfSquares = 0;
        this.value = 0;
        stack = new Stack<>();
    }

    public void push(int ele) {
        sum += ele;
        sumOfSquares += (ele * ele);
        value += getExtraValue(ele);
        stack.push(ele);
    }

    private int getExtraValue(int ele) {
        return (sum * (ele * ele)) + (sumOfSquares * ele) - (ele * ele * ele);
    }

    public int pop() {
        if (stack.isEmpty()) {
            return 0;
        } else {
            int ele = stack.pop();
            value -= getExtraValue(ele);
            sum -= ele;
            sumOfSquares -= (ele * ele);
            return ele;
        }
    }

    public int getSplValue() {
        if (stack.isEmpty()) {
            return 0;
        } else {
            return value;
        }
    }


}
