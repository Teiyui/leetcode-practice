package basis;

import entity.TreeNode;

/**
 * 题目：剑指 Offer 68 - II. 二叉树的最近公共祖先
 * 题目要求：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 题目分析：1. 与前一题的二叉搜索树不同，这题寻求二叉树中指定节点的最近公共祖先
 *         2. 最近公共祖先的可能情况：1). p和q在root的子树中，且分列root的异侧（即分别在左、右子树中）；
 *                               2). p=root，且q在root的左或右子树中；
 *                               3). q=root，且p在root的左或右子树中。
 *         3. 考虑通过递归对二叉树进行先序遍历，当遇到节点p或q时返回。从底至顶回溯，当节点p、q在节点root的异侧时，节点root即为最近公共祖先，
 *            则向上返回root。
 */
public class Code68_1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
