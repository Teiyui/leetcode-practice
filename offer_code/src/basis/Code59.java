package basis;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 题目：剑指 Offer 59 - II. 队列的最大值
 * 题目要求：请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *         若队列为空，pop_front 和 max_value 需要返回 -1
 * 题目分析：1. 使用双端队列作为辅助队列去存储最大值变量
 *         2. 每次存储变量时，推出当前辅助队列中比当前值小的所有元素，最后放入该变量
 */
public class Code59 {

    private Deque<Integer> deque_help;

    private Queue<Integer> queue;

    public Code59() {
        deque_help = new LinkedList<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        if (deque_help.isEmpty()) {
            return -1;
        }
        return deque_help.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque_help.isEmpty() && deque_help.peekLast() < value) {
            deque_help.pollLast();
        }
        deque_help.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        if (queue.peek().equals(deque_help.peekFirst())) {
            deque_help.pollFirst();
        }
        return queue.poll();
    }
}
