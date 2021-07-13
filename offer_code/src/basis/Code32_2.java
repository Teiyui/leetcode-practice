package basis;

import entity.TreeNode;

import java.util.*;

/**
 * 题目：剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 题目要求：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * 题目分析：1. 因为是打印每层，优先想到使用广度优先搜索，使用队列存储每行元素
 *         2. 使用双端队列，存储队列弹出的元素，奇数层时addLast，偶数层时addFirst
 *         3. 使用队列哪个方法的判断条件为当前list集合的size是否为奇偶数
 */
public class Code32_2 {

    /**
     * 解题思路：1. 新建变量集合A，队列queue；
     *         2. 遍历队列queue直至其为空，新建双端队列deque用来存储打印元素；弹出queue中节点元素，若当前层为奇数层(集合A的size此时为偶数)，
     *            从左到右输出(使用addLast方法)；若当前层为偶数层(集合A的size此时为奇数)，从右到左输出(使用addFirst方法)；
     *         3. 往队列内存入当前元素的左右节点；并将deque转为List集合存入集合A中；
     *         4. 返回集合A。
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> sumList = new ArrayList<>();
        if (root == null) {
            return sumList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Deque<Integer> deque = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (queue.size() % 2 == 0) {
                    deque.addLast(node.val);
                } else {
                    deque.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            sumList.add(new ArrayList<>(deque));
        }
        return sumList;
    }
}
