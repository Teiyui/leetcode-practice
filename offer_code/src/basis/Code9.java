package basis;

import java.util.Stack;

/**
 * 题目：剑指 Offer 09. 用两个栈实现队列
 * 题目要求：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead，
 *         分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1）
 * 题目分析：1. 栈的属性为后进先出，队列的属性为先进先出；所以设置两个栈将其中一个栈作为辅助栈即可
 */
public class Code9 {

    /**
     * 解题思路：1. 插入元素时全部放入栈help中
     *         2. 删除元素时，有两步注意事项: 1). 若stack为空，才将help中元素全部压入stack中
     *                                   2). 否则返回stack栈顶元素
     */

    private Stack<Integer> stack;

    private Stack<Integer> help;

    public Code9() {
        stack = new Stack<>();
        help = new Stack<>();
    }

    public void appendTail(int value) {
        help.push(value);
    }

    public void helpToStack() {
        if (stack.isEmpty()) {
            while (!help.isEmpty()) {
                stack.push(help.pop());
            }
        }
    }

    public int deleteHead() {
        if (stack.isEmpty() && help.isEmpty()) {
            return -1;
        }
        helpToStack();
        return stack.pop();
    }

    public int selectHead() {
        if (stack.isEmpty() && help.isEmpty()) {
            return -1;
        }
        helpToStack();
        return stack.pop();
    }
}
