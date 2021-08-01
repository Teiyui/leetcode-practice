package basis;

/**
 * 题目：剑指 Offer 64. 求1+2+…+n
 * 题目要求：求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 题目分析：1. 使用递归的方法
 *         2. 递归的终止条件可以使用&&运算的短路
 */
public class Code64 {

    public int sumNums(int n) {
        boolean flag = (n >= 1) && (n += sumNums(n-1)) > 0;
        return n;
    }
}
