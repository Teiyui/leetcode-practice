package basis;

import entity.ListNode;

/**
 * 题目：剑指 Offer 25. 合并两个排序的链表
 * 题目要求：输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 题目分析：1. 方法一：建立辅助栈，同时遍历两个链表将元素放入栈中；然后遍历栈建立链表、
 *         2. 方法二：建立哑点，从头结点开始往后连。
 */
public class Code25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummyNode.next;
    }
}
