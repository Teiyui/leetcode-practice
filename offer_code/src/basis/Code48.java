package basis;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：剑指 Offer 48. 最长不含重复字符的子字符串
 * 题目要求：请从字符串中找出一个最长的不包含重复字符的子字符串s，计算该最长子字符串的长度。
 * 题目分析：1. 该题可以使用动态规划进行求解。 1). 定义状态：设动态规划列表dp，dp[j]代表以字符s[j]为结尾的"最长不重复子字符串"的长度
 *                                     2). 定义关系表达式：dp[j] = j-i (dp[j-1] >= j-i) 或者 dp[j] = dp[j-1]+1 (dp[j-1] < j-i)
 *                                     3). 初始化参数：dp[0] = 1
 *         2. 建立变量存储当前最大值
 */
public class Code48 {

    /**
     * 解题思路：1. 建立HashMap存储字符串中每个字符的出现索引
     *         2. 建立两个变量tmp（代表dp[j-1]）和res（代表最大值）
     *         3. 遍历字符串，每次从map中获取当前字符的出现索引i
     *         4. 更新tmp：tmp = tmp < j - i ? tmp + 1 : j - i
     *         5. 更新res：res = Math.max(res, tmp)
     */

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int tmp = 0;
        int res = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = map.getOrDefault(s.charAt(j), -1);
            map.put(s.charAt(j), j);
            tmp = tmp < j - i ? tmp + 1 : j - i;
            res = Math.max(res, tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        Code48 obj = new Code48();
        String s = "pwwkew";
        obj.lengthOfLongestSubstring(s);
    }
}
