package basis;

import entity.TreeNode;

import java.util.*;

/**
 * 题目：剑指 Offer 34. 二叉树中和为某一值的路径
 * 题目要求：输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 题目分析：1. 求路径时优先想到深度优先搜索（DFS）
 *         2. 从根节点开始所以可以采用先序遍历，新建一个队列保存当前经过叶节点的值；
 *         3. 每次经过节点时，用整数减去当前节点值，因为是叶节点所以此节点不能为其他节点的根节点；满足条件时插入集合元素为队列的List；
 *         4. 递归当前根节点的左右节点，最后删去path中的元素
 */
public class Code34 {

    /**
     * 解题思路：1. 新建变量List集合存放队列，变量队列存放每个节点值
     *         2. 建立先序递归方法，每次经过一个节点就将其值插入队列中，target减去当前值
     *         3. 若target值等于0且该节点为叶节点（不为其他节点的根节点），则将该队列插入List集合中
     *         4. 深度搜索当前根节点的左右节点，最终弹出队列首元素
     *         5. 注意插入List集合中的队列需要新建，拷贝当前队列中的所有元素
     */

    private List<List<Integer>> list = new ArrayList<>();

    /**
     * 注意点：Deque和Queue的区别
     * 区别：1. Deque继承Queue
     *      2. Deque为双端队列（既可以作为栈也可以作为队列），而Queue为队列（FIFO的典型代表）
     *      3. 两者都可以通过LinkedList实现，Queue只能通过每次将元素插入尾部（offer方法），每次删除头部元素(poll方法)实现FIFO
     */
    private Deque<Integer> queue = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        maxLength_DFS(root, target);
        return list;
    }

    public void maxLength_DFS(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        int val = root.val;
        target -= val;
        queue.offer(val);
        if (target == 0 && root.left == null && root.right == null) {
            list.add(new ArrayList<>(queue));
        }
        maxLength_DFS(root.left, target);
        maxLength_DFS(root.right, target);
        queue.removeLast(); // 这里remove尾部元素将队列转为栈的原因是，每次递归都为按照顺序插入先序的节点值，到最后的叶子节点时，
                            // 该叶子节点的值恰好处于该队列的末尾元素（谨记队列插入元素时的原则）
    }
}
