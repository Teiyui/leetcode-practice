package basis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：剑指 Offer 57 - II. 和为s的连续正数序列
 * 题目要求：输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 题目分析：使用滑动窗口的解法
 */
public class Code57_1 {

    /**
     * 解题思路：1. 滑动窗口先要设置三个默认变量i=1，j=2，它们两的和s=3；
     *         2. 当和等于target时，新建int[]并放入list数组中
     *         3. 当和大于等于target时，将和减去i，并将i加1
     *         4. 否则当和小于target时，将j加1，并将和加上i
     */

    public int[][] findContinuousSequence(int target) {
        int i = 1;
        int j = 2;
        int s = 3;
        List<int[]> res = new ArrayList<>();
        while (i < j) {
            if (s == target) {
                int[] tmp = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    tmp[k-i] = k;
                }
                res.add(tmp);
            }
            if (s >= target) {
                s -= i;
                i++;
            } else {
                j++;
                s += j;
            }
        }
        return res.toArray(new int[0][]);
    }
}
