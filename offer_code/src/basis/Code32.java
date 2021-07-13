package basis;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：剑指 Offer 32 - I. 从上到下打印二叉树
 * 题目要求：从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 题目分析：1. 考虑使用广度优先搜索
 *         2. 广度优先搜索的关键是通过队列先进先出的原则，依次放入每层节点的下一层节点
 */
public class Code32 {

    /**
     * 解题思路：1. 新建变量queue和list
     *         2. 遍历至queue为空，先记录queue的size，遍历queue取出节点元素，如果左右节点不为空放入queue中，将该节点元素值至放入list中
     *         3. 将list转换为数组int[]返回
     */

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                list.add(cur.val);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
