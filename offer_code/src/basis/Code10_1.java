package basis;

/**
 * 题目：剑指 Offer 10- I. 斐波那契数列
 * 题目要求：写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即F(N)）。斐波那契数列的定义如下：
 *         F(0) = 0, F(1) = 1；F(N) = F(N - 1) + F(N - 2), 其中 N > 1。
 *         答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 题目分析：1. 典型的动态规划问题
 *         2. 已经给定了明确需求的函数F(N)；也得知F(N)的关系表达式；最后知道初始值的大小。
 */
public class Code10_1 {

    public int fib(int n) {
        if (n == 1) {
            return 1;
        }
        int sum = 0;
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            sum = (a+b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }
}
