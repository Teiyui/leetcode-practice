package basis;

/**
 * 题目：剑指 Offer 58 - II. 左旋转字符串
 * 题目要求：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 *         比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * 题目分析：1. 方法一：直接法；通过substring方法截取对应字符串进行拼接
 *         2. 方法二：列表遍历拼接；新建StringBuilder类，遍历字符串插入对应字符
 */
public class Code58_1 {

    /**
     * 方法一：直接法
     * 解题思路：1. 注意substring(int start, int end)方法中截取的字符串包括索引start对应的字符，不包括索引end对应的字符
     */

    public String reverseLeftWords(String s, int n) {
        String former = s.substring(0, n);
        String latter = s.substring(n, s.length());
        return latter + former;
    }

    /**
     * 方法二：列表遍历拼接
     */

    public String reverseLeftWords_List(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length() + n; i++) {
            sb.append(s.charAt(i % s.length()));
        }
        return sb.toString();
    }
}
