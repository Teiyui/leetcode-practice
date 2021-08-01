package basis;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：剑指 Offer 61. 扑克牌中的顺子
 * 题目要求：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，
 *         而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 题目分析：1. 顺子中大、小王的意思是这两张牌可以看成任意数字；
 *         2. 首先找到最大值和最小值，判断两者的差值是否小于5；若是则返回ture；若不是，则返回false。
 */
public class Code61 {

    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int min = 14;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            if (set.contains(nums[i])) {
                return false;
            }
            set.add(nums[i]);
        }
        return max - min < 5;
    }
}
