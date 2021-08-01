package basis;

/**
 * 题目：剑指 Offer 58 - I. 翻转单词顺序
 * 题目要求：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student."，
 *         则输出"student. a am I"。
 * 题目分析：1. 方法一：双指针法。 1). 倒序遍历字符串s，记录单词左右索引边界i和j
 *                           2). 每确定一个单词的边界，则将其添加至单词列表res
 *                           3). 最终将单词列表拼接为字符串，返回即可
 */
public class Code58 {

    /**
     * 方法一：双指针法
     * 解题思路：1. 将字符串首尾空字符消除
     *         2. 设置双指针变量i和j（初始时都指向字符串末尾）
     *         3. 遍历至i小于0
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        int j = i;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s.substring(i, j)).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return sb.toString().trim();
    }
}
