package basis;

import entity.TreeNode;
import treeNode.GenerateTreeNode;

import java.util.Stack;

/**
 * 题目：剑指 Offer 36. 二叉搜索树与双向链表
 * 题目要求：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 题目分析：1. 通过中序遍历能够获取到有序数组进行处理
 *         2. 双向链表的构建方式为：设前驱节点pre和当前节点cur，不仅应该构建pre.right = cur还应构建cur.left = pre；最后再设pre = cur
 *         3. 循环链表的构建方式为：设头节点head和尾节点tail，则head.left = tail并且tail.right = head。
 */
public class Code36 {

    /**
     * 解题思路：1. 设置节点变量head和pre，中序遍历该二叉树，pre最终为尾节点;
     *         2. 在遍历过程中，若pre为空，则代表当前节点为链表的头节点，设head为prev；否则，设置pre.right = cur;
     *         3. 设置cur.left = prev；并且prev = cur;
     *         4. 建立循环链表：head.left = tail；tail.right = head;
     */

    private TreeNode head;

    private TreeNode pre;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        inOrderRecursion(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void inOrderRecursion(TreeNode cur) {
        if (cur == null) {
            return;
        }
        inOrderRecursion(cur.left);
        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        inOrderRecursion(cur.right);
    }

    public static void main(String[] args) {
        TreeNode node = GenerateTreeNode.generateTreeNode(new Integer[]{4,2,5,1,3});
        Code36 obj = new Code36();
        obj.treeToDoublyList(node);
    }
}
