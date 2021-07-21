package basis;

import entity.ListNode;

/**
 * 题目：剑指 Offer 18. 删除链表的节点
 * 题目要求：给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
 * 题目分析：1. 新建哑节点用来处理删除头指针的情况
 *         2. 删除该节点就意味着将该节点的前续节点连向该节点的后继节点
 */
public class Code18 {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode node = dummyNode;
        while (node != null && node.next != null) {
            if(node.next.val == val) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        return dummyNode.next;
    }
}
