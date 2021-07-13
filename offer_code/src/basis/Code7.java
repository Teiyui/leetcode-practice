package basis;

import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：剑指 Offer 07. 重建二叉树
 * 题目要求：输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 题目分析：1. 此题的关键是知道前序遍历和中序遍历中根节点元素的所处位置索引
 *         2. 通过线索可知：1). 前序遍历索引为0处是二叉树根节点值
 *                       2). 确定根节点值后，可以在中序遍历数组中获取根节点索引i
 *                       3). 通过i，可以获取左子树右边界(i-1)，右子树左边界(i+1)
 *                       4). 根据中序遍历数组的性质，左子树左边界为中序遍历索引为0处的值；右子树右边界为中序遍历索引为length-1处的值
 *                       5). 同理根据前序遍历的性质，左子树根节点处在前序遍历索引为root+1处，右子树根节点处在前序遍历索引root+(i-left)+1
 *                       6). root+(i-left)+1的意思是根节点索引加上左子树元素长度在加上1
 */
public class Code7 {

    /**
     * 解题思路：1. 建立全局变量Map集合，key为中序数组值，value为中序数组索引
     *         2. 建立全局变量前序遍历集合，用来获取根节点值
     *         3. 建立递归方法，参数为根节点值，左节点值，右节点值
     *         4. 如果left大于right，则返回null
     */

    private Map<Integer, Integer> map;

    private int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.preorder = preorder;
        return recursion(0, 0, inorder.length-1);
    }

    public TreeNode recursion(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootVal = preorder[root];
        int i = map.get(rootVal);
        TreeNode node = new TreeNode(rootVal);
        node.left = recursion(root+1, left, i-1);
        node.right = recursion(root + (i - left) + 1, i+1, right);
        return node;
    }
}
