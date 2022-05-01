package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：Hot 100 15. 三数之和
 * 题目要求：给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c，
 *         使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 题目分析：1. 方法一：排序+双指针
 */
public class Code15 {

    public List<List<Integer>> threeSum(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        // 再双指针
        List<List<Integer>> list = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k-1]) {
                continue;
            }
            int i = k + 1;
            int j = nums.length - 1;

            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];

                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]);
                } else {
                    list.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }
        return list;
    }
}
