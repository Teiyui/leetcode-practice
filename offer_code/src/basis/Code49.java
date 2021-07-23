package basis;

/**
 * 题目：剑指 Offer 49. 丑数
 * 题目要求：我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 题目分析：1. 看到从一个升序列表中取出第n个数，想到使用动态规划
 *         2. 动态规划的三步骤: 1). 定义状态：设动态规划列表为dp[]，其中dp[i]代表第i+1个丑数
 *                           2). 定义关系表达式：dp[i] = min (dp[a]*2, dp[b]*3, dp[c]*5)；若dp[i]等于其中任意一值，则对应的索引+1
 *                           3). 初始化参数：dp[0] = 1
 */
public class Code49 {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 1; i < dp.length; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (n2 == dp[i]) {
                a++;
            }
            if (n3 == dp[i]) {
                b++;
            }
            if (n5 == dp[i]) {
                c++;
            }
        }
        return dp[n-1];
    }
}
