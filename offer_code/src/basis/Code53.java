package basis;

/**
 * 题目：剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 题目要求：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 *         在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 题目分析：1. 方法一：直接遍历法，搜索数组元素值与对应下标索引值不相同的情况，返回当前索引值
 *         2. 方法二：二分法，通过中位数处索引是否等于中位数判断缺失元素实在左区间还是右区间
 */
public class Code53 {

    /**
     * 方法一：直接遍历法
     * 解题思路：1. 注意点为最终返回长度为数组长度的值
     */
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 方法二：二分法
     * 解题思路：1. 设置左区间首位元素索引为i，右区间末尾元素索引为j
     *         2. 遍历至i>=j
     */
    public int missingNumber_dichotomy(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
}
