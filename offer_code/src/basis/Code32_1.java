package basis;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 题目要求：从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。即呈现[[3],[9,20],[15,7]]
 * 题目分析：1. 看到从上到下按层想到广度优先搜索
 *         2. 需建立变量queue和list集合存放每层的list
 */
public class Code32_1 {

    /**
     * 解题思路：1. 建立变量queue和A数组
     *         2. 遍历至queue为空，每次记录queue的size；新建B数组；遍历queue取出当前节点，若该节点左右不为空的化放入queue中；将节点值
     *            放入B数组中，再将B数组放入A数组中
     *         3. 最终返回A数组
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> sumList = new ArrayList<>();
        if (root == null) {
            return sumList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                list.add(node.val);
            }
            sumList.add(list);
        }
        return sumList;
    }
}
