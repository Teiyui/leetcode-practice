package basis;

import entity.TreeNode;

/**
 * 题目：剑指 Offer 26. 树的子结构
 * 题目要求：输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)。B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * 题目分析：1. 看到子结构，想到树A中是否存在一节点的值等于树B根节点的值，若存在，同时进行递归先序遍历直至树B节点为空
 *         2. 若先序遍历过程中，树A节点为空的话，返回false；若树A当前节点值不等与树B当前节点值的话，返回false
 *         3. 在先序遍历树A的过程中，若遇到节点值和树B根节点值相同的情况，开始进行进行递归判断
 */
public class Code26 {

    /**
     * 解题思路：1. 新建先序遍历递归方法，递归树A，边界条件为树A的当前节点值为空
     *         2. 若树A当前节点值等于树B根节点值，调用先序遍历递归方法（新建，参数为树A当前节点值和树B跟节点值），进行参数判断，返回true或false;
     *         3. 若返回true，则return ture，否则继续
     */

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        return preOrderRecur(A, B);
    }

    public boolean preOrderRecur(TreeNode A, TreeNode B) {
        if (A == null) {
            return false;
        }
        if (A.val == B.val) {
            if (preOrderRecurComparison(A, B)) {
                return true;
            }
        }
        return preOrderRecur(A.left, B) || preOrderRecur(A.right, B);
    }

    public boolean preOrderRecurComparison(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return preOrderRecurComparison(A.left, B.left) && preOrderRecurComparison(A.right, B.right); // 这里与号的意义是必须保证左右两数的结构与数据相同
    }
}
