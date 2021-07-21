package basis;

import entity.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：剑指 Offer 35. 复杂链表的复制
 * 题目要求：请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 *         还有一个 random 指针指向链表中的任意节点或者 null。
 * 题目分析：1. 可以使用哈希表或拼接与拆分方法
 *         2. 哈希表的解题思路为建立一个HashMap，键存原链表节点，值存新链表节点。需遍历两次原链表
 */
public class Code35 {

    /**
     * 方法一：哈希法
     * 解题思路：1. 新建HashMap，遍历原链表，依次放入键当前链表节点，值新链表节点
     *         2. 遍历原链表，将新链表节点组合在一起
     */

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node tmp1 = head;
        while (tmp1 != null) {
            map.put(tmp1, new Node(tmp1.val));
            tmp1 = tmp1.next;
        }
        Node tmp2 = head;
        while (tmp2 != null) {
            map.get(tmp2).next = map.get(tmp2.next);
            map.get(tmp2).random = map.get(tmp2.random);
            tmp2 = tmp2.next;
        }
        return map.get(head);
    }

    /**
     * 方法二：拼接与拆分
     * 解题思路：1. 先按照原节点1->新节点1->原节点2->新节点2...的顺序组建新链表
     *         2. 遍历新链表，将新节点的random节点设为老节点的random节点的next
     *         3. 再次遍历链表，拆分新旧链表，注意也需要对旧链表进行拼接
     */

    public Node copyRandomList_splitFirst(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        while (cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }

        cur = head;
        while (cur != null && cur.next != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        cur = head.next;
        Node prev = head;
        Node res = head.next;
        while (cur.next != null) {
            prev.next = prev.next.next;
            cur.next = cur.next.next;
            prev = prev.next;
            cur = cur.next;
        }
        prev.next = null;
        return res;
    }
}
