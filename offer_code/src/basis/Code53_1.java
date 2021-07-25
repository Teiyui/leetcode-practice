package basis;

/**
 * 题目：剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 题目要求：统计一个数字在排序数组中出现的次数。
 * 题目分析：1. 直接遍历法
 *         2. 二分法，因为是排序数组，只要确认到target所处的索引即可
 */
public class Code53_1 {

    /**
     * 方法一：直接遍历法
     */

    public int search(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                sum++;
            }
        }
        return sum;
    }

    /**
     * 方法二：二分法
     * 解题思路：1. 通过辅助方法helper()获取右边界索引或者通过helper_left()获取左边界索引（重要：可作为公式模板背下）
     */
    public int search_TwoBinary(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target-1);
    }

    public int helper(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i+j) / 2;
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return j;
    }

    public int helper_left(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i+j) / 2;
            if (nums[m] >= target) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }
}
