package basis;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 题目：剑指 Offer 50. 第一个只出现一次的字符
 * 题目要求：在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 题目分析：1. 方法一：哈希法（新建HashMap，key为字符，value为字符出现次数）；再次遍历集合，获取value为1的字符
 */
public class Code50 {

    /**
     * 方法一：哈希法
     * 解题思路：1. 新建HashMap，分割字符串为数组，遍历数组存放进HashMap中进行记录
     *         2. 再次遍历数组，返回第一个value为true的字符，否则返回空格
     */

    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Boolean> map = new HashMap();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.containsKey(chars[i]));
        }

        for (int i = 0; i < chars.length; i++) {
            if (!map.get(chars[i])) {
                return chars[i];
            }
        }
        return ' ';
    }

    /**
     * 方法二：有序哈希表
     * 解题思路：1. 新建LinkedHashMap，分割字符串为数组，遍历数组存放进LinkedHashMap中进行记录
     *         2. 遍历LinkedHashMap中的entrySet，获取第一个value为false的字符
     */
    public char firstUniqChar_Sorted(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.containsKey(chars[i]));
        }

        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (!entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
