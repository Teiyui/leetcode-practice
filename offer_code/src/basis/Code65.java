package basis;

/**
 * 题目：剑指 Offer 65. 不用加减乘除做加法
 * 题目要求：写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * 题目分析：1. 看到不能使用四则运算符号，优先想到使用位运算
 */
public class Code65 {

    public int add(int a, int b) {
        while(b != 0) {
            int c = (a&b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
