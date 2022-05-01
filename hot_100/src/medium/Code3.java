package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：Hot 100 03. 无重复字符的最长子串
 * 题目要求：给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 题目分析：1. 方法一：滑动窗口 1). 设置集合存储字符串中每个字符的索引位置；
 *                          2). 滑动窗口有两个属性，最左边元素的索引位置和整体长度。
 *                          3). 遍历整个字符串，若出现相同字符，则更改滑动窗口最左边元素的索引位置
 *                          4). 更新滑动窗口长度
 */
public class Code3 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }

}
