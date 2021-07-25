package basis;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：剑指 Offer 57. 和为s的两个数字
 * 题目要求：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * 题目分析：1. 方法一为哈希法，通过遍历数组记录元素值至HashSet中，看集合中是否有(target - nums[i])该值
 *         2. 方法二为双指针法，设置头尾指针，边界条件为头尾指针索引相同
 */
public class Code57 {

    /**
     * 方法一：哈希法
     */

    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                return new int[]{target- nums[i], nums[i]};
            }
            set.add(nums[i]);
        }
        return null;
    }

    /**
     * 方法二：双指针法
     *
     */
    public int[] twoSum_TwoPointer(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int tmp = nums[i] + nums[j];
            if (tmp > target) {
                j--;
            } else if (tmp < target) {
                i++;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }
        return null;
    }
}
