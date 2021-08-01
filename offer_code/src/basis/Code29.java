package basis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：剑指 Offer 29. 顺时针打印矩阵
 * 题目要求：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 题目分析：1. 顺时针打印矩阵的顺序为“从左向右、从上到下、从右向左、从下到上”
 *         2. 设置左、右、上、下边界变量为l（left）、r（right）、t（top）、b（bottom）
 *         3. 每次遍历一个过程将值放入数组中时，自动地将其对应的边界减1（例如从左向右后需要将上边界值减去1）
 */
public class Code29 {

    /**
     * 解题思路：1. 新建数组变量nums以及设置左、右、上、下边界变量为l（left）、r（right）、t（top）、b（bottom）
     */

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int[] nums = new int[matrix.length * matrix[0].length];
        int x = 0;
        int l = 0;
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;
        while (true) {
            // 从左到右
            for (int i = l; i <= r; i++) {
                nums[x++] = (matrix[t][i]);
            }
            if (++t > b) {
                break;
            }
            // 从上到下
            for (int i = t; i <= b; i++) {
                nums[x++] = (matrix[i][r]);
            }
            if (--r < l) {
                break;
            }
            // 从右到左
            for (int i = r; i >= l; i--) {
                nums[x++] = (matrix[b][i]);
            }
            if (--b < t) {
                break;
            }
            // 从下到上
            for (int i = b; i >= t; i--) {
                nums[x++] = (matrix[i][l]);
            }
            if (++l > r) {
                break;
            }
        }
        return nums;
    }
}
