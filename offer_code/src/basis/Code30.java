package basis;

import java.util.Stack;

/**
 * 题目：剑指 Offer 30. 包含min函数的栈
 * 题目要求：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * 题目分析：1. 要获取最小元素，可以设置一个辅助栈用来存放最小元素
 */
public class Code30 {

    private Stack<Integer> stack;

    private Stack<Integer> minStack;

    public Code30() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            if (minStack.peek() > x) {
                minStack.push(x);
            } else {
                minStack.push(minStack.peek());
            }
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.isEmpty() && minStack.isEmpty()) {
            return;
        }
        minStack.pop();
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty() && minStack.isEmpty()) {
            throw new RuntimeException();
        }
        return stack.peek();
    }

    public int min() {
        if (stack.isEmpty() && minStack.isEmpty()) {
            throw new RuntimeException();
        }
        return minStack.peek();
    }
}
