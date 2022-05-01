package medium;

/**
 * 题目：Hot 100 11. 盛最多水的容器
 * 题目要求：给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *         找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *         返回容器可以储存的最大水量
 * 题目分析：1. 方法一：双指针法 1). 初始化左右两端指针以及容器面积
 *                          2). 循环直至两指针相遇，短板向内收缩
 *                          3). 返回最大容器面积
 */
public class Code11 {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;

        while (left < right) {
            res = height[left] > height[right] ?
                    Math.max(res, (right - left) * height[right--]) :
                    Math.max(res, (right - left) * height[left++]);
        }

        return res;
    }
}
