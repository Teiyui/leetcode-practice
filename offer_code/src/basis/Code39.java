package basis;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：剑指 Offer 39. 数组中出现次数超过一半的数字
 * 题目要求：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 题目分析：1. 方法一，通过HashMap记录每个数字出现的次数，在第一次循环中返回超过该数组长度一半的数字
 *         2. 方法二，摩尔投票法，遇到相同的数字就加一，否则就减一。最终返回次数超过一半的数字
 */
public class Code39 {

    /**
     * 方法一：哈希法
     * 解题思路：1. 设置变量保存数组长度
     *         2. 新建HashMap，遍历数组记录每个数字出现的次数，若当前数字出现次数大于该数组长度一半的话，返回该数字
     *         3. 返回数组中只有一个元素的情况
     */

    public int majorityElement(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int val = map.get(nums[i]) + 1;
                if (val > length/2) {
                    return nums[i];
                }
                map.put(nums[i], val);
            }
        }
        return nums[0];
    }

    /**
     * 方法二：摩尔投票法
     */
    public int majorityElement_mole(int[] nums) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
            }
            count += res == nums[i] ? 1 : -1;
        }
        return res;
    }
}
