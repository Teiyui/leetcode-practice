package basis;

import entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 题目要求：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 * 题目分析：1. 二叉搜索树的性质为：1). 根节点值大于左子节点值，小于右子节点值； 2). 该树中所有根节点都满足二叉搜索树的1)性质
 *         2. 可以通过递归+分治的方法来解决
 *         3. 后序遍历数组中的末尾元素为根节点，设根节点索引为变量j。在遍历数组中找到第一个值大于根节点值的元素索引，记为m；此时为二叉树左区间(i, m-1)
 *         4. 继续遍历右区间，直至当前元素值小于等于根节点元素值，每次遍历p加1；此时右区间为1(m, j-1)
 *         5. 返回p是否等于j；并递归左右区间
 */
public class Code33 {

    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0 ,postorder.length-1);
    }

    public boolean recur(int[] pos, int i, int j) {
        if (i <= j) {
            return true;
        }
        int p = 0;
        while (pos[i] < pos[j]) {
            p++;
        }
        int m = p;
        while (pos[p] > pos[j]) {
            p++;
        }
        return p == j && recur(pos, i, m-1) && recur(pos, m, j-1);
    }

}
