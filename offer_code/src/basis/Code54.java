package basis;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：剑指 Offer 54. 二叉搜索树的第k大节点
 * 题目要求：给定一棵二叉搜索树和整数k，请找出其中第k大的节点。
 * 题目分析：1. 因为是二叉搜索树，所以中序遍历后获取的是有序数组
 *         2. 返回有序数组中倒数第k个元素
 */
public class Code54 {

    /**
     * 方法一：中序遍历+数组
     * 解题思路：1. 中序遍历二叉树获取有序数组
     *         2. 返回有序数组的倒数第k个元素
     */

    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        preOrderRecursion(root, list);
        return list.get(list.size() - k);
    }

    public void preOrderRecursion(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        preOrderRecursion(root.left, list);
        list.add(root.val);
        preOrderRecursion(root.right, list);
    }

    /**
     * 方法二：中序遍历
     * 解题思路：1. 反向中序遍历获取的数组是降序数组
     *         2. 建立全局变量res（用来记录当前节点值）和time（计时器）
     */

    private int res;

    private int time;

    public int kthLargest_BestSpace(TreeNode root, int k) {
        time = 0;
        preOrderRecursion_BestSpace(root, k);
        return res;
    }

    public void preOrderRecursion_BestSpace(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        preOrderRecursion_BestSpace(root.right, k);
        res = root.val;
        if (++time == k) {
            return;
        }
        preOrderRecursion_BestSpace(root.left, k);
    }
}
