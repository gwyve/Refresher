package OJ.LeetCode.Num151_200;

import java.util.Stack;

public class Num155MinStack {
    // 这个题的题目没有看太明白
    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;
    public Num155MinStack() {
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        if (x<=min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        // 实际上最小的push 了两次，pop也要两次的
        if (min == stack.pop())
            min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

}