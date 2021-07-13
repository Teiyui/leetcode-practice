package basis;

import entity.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目：剑指 Offer 06. 从尾到头打印链表
 * 题目要求：输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 题目分析：1. 建立一个栈，遍历链表将元素放入栈中
 *         2. 建立数组，将栈中元素依次放入数组中
 */
public class Code6 {

    /**
     * 方法一：辅助栈
     * 解题思路：1. 通过栈的后进先出原则，遍历链表将节点元素值依次入栈
     *         2. 建立数组，将栈中元素放入数组中
     */

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] nums = new int[stack.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = stack.pop();
        }
        return nums;
    }

    /**
     * 方法二：递归
     * 解题思路：1. 递归链表的每个节点，将节点值放入数组的代码放在递归方法下面，这样就实现了后进先出的样式
     */

    private List<Integer> list;

    public int[] reversePrint_Recursion(ListNode head) {
        list = new ArrayList<>();
        recur(head);
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    public void recur(ListNode node) {
        if (node == null) {
            return;
        }
        recur(node.next);
        list.add(node.val);
    }
}
