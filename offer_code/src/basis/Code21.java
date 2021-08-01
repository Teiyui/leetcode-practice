package basis;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 题目要求：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 题目分析：1. 直接法
 *         2. 首尾双指针
 */
public class Code21 {

    /**
     * 方法一：直接法
     */
    public int[] exchange(int[] nums) {
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evenList.add(nums[i]);
            } else {
                oddList.add(nums[i]);
            }
        }
        oddList.addAll(evenList);
        int[] res = new int[oddList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = oddList.get(i);
        }
        return res;
    }

    /**
     * 方法二：首尾双指针
     * 解题思路：1. 设置左右边界指针left和right
     *         2. 遍历数组，每次若left指向偶数的话，与right指向的数对调，并使right--；同理若right指向奇数的话，与left指向的数对调，并使left++;
     *         3. 边界条件为left == right
     */
    public int[] exchange_TwoPointer(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 1) {
                left++;
                continue;
            } else if (nums[right] % 2 == 0) {
                right--;
                continue;
            }
            int tmp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = tmp;
        }
        return nums;
    }
}
