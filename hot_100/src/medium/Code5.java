package medium;

/**
 * 题目：Hot 100 05. 最长回文子串
 * 题目要求：给你一个字符串 s，找到 s 中最长的回文子串。例如"babad"中的"bab"或者"aba"
 * 题目分析：1. 方法一：中心扩散方法 1). 回文有两种形式：一种是奇数的情况，从中间扩散左右看是否一致；另一种是偶数的情况，从中间左右扩散看是否一致
 *                             2). 开始扩散的场合：奇数的情况下，left=right；偶数的情况下，left=right-1。
 *                             3). 扩散的时候，记录回文的长度max
 *                             4). 最终通过left与max取出对应最长回文子串
 */
public class Code5 {

    public String longestPalindrome(String s) {
        int strLen = s.length();

        int left = 0;
        int right = 0;
        int len = 1;

        int strStart = 0;
        int maxLen = 0;


        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            // 先左
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }

            // 再右
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }

            // 中心扩散
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }

            // 确定最大值
            if (len > maxLen) {
                maxLen = len;
                strStart = left;
            }

            len = 1;
        }

        return s.substring(strStart + 1, strStart + maxLen + 1);
    }

}
