package basis;

import entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：剑指 Offer 52. 两个链表的第一个公共节点
 * 题目需求：输入两个链表，找出它们的第一个公共节点。
 * 题目分析：1. 使用双指针进行处理或使用哈希方法处理
 */
public class Code52 {

    /**
     * 方法一：哈希法
     * 解题思路：1. 建立HashSet集合，遍历其中一个链表，将节点元素存入HashSet中
     *         2. 遍历第二个链表，查看是否包含相同节点，若包含则返回，否则返回null
     */

    public ListNode getIntersectionNode_HashSet(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 方法二：双指针法
     * 解题思路：1. 核心就是将两个链表的节点放在同一起跑线上
     */

    public ListNode getIntersectionNode_TwoHead(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}
