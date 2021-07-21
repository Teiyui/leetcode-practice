package basis;

import entity.ListNode;

/**
 * 题目：剑指 Offer 22. 链表中倒数第k个节点
 * 题目要求：输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 题目分析：1. 想到可以使用双指针解决问题
 */
public class Code22 {

    /**
     * 解题思路：1. 先通过整数k获取移动k步后的节点node
     *         2. 再遍历node直至其为空，同时迭代head节点，最终返回head节点
     */

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode node = head;
        for (int i = 0; i < k; i++) {
            node = node.next;
        }

        while (node != null) {
            head = head.next;
            node = node.next;
        }

        return head;
    }
}
