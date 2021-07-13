package basis;

import entity.TreeNode;

/**
 * 题目：剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * 题目要求：1. 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *         2. 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 *            满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 题目分析：1. 若p、q两个节点分别处在二叉搜索树的左右边界，则最近公共祖先为根节点
 *         2. 从1可以发现，若p、q两个节点分别处在同一边界的话，继续比较那一边界的根节点情况值
 */
public class Code68 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
}
