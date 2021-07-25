package basis;

/**
 * 题目：剑指 Offer 44. 数字序列中某一位的数字
 * 题目要求：数字以0123456789101112131415…的格式序列化到一个字符序列中，在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *         请写一个函数，求任意第n位对应的数字。
 * 题目分析：1. 首先找出如下规律：1). start为1：digit为1，数字数量为9，则总位数为9
 *                          2). start为10：digit为2，数字数量为9*10，则总位数为180
 *                          3). start为100：digit为3，数字数量为9*10*10，则总位数为2700
 *                          4). start为10*n：digit为n，数字数量为9*10^(n-1)
 *         2. 可以进行递归处理，边界条件为当前n的数目小于总位数
 *         3. 拿到start和digit后，可以通过遍历获取对应值
 */
public class Code44 {

    public int findNthDigit(int n) {
        long start = 1;
        int digit = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            start *= 10;
            digit += 1;
            count = 9 * start * digit;
        }
        long num = start + (n - 1) / digit; // 获取字符串中对应索引的字符，这里n-1的目的是减去start那个数
        return Long.toString(num).charAt((n-1) % digit) - '0';
    }

}
