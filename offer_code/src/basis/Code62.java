package basis;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：剑指 Offer 62. 圆圈中最后剩下的数字
 * 题目要求：1. 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 *         2. 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * 题目分析：1.
 */
public class Code62 {

    /**
     * 方法一：数组法
     * 解题思路：1.
     */

    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % n;
            list.remove(index);
        }
        return list.get(0);
    }

    /**
     * 方法二：约瑟夫环
     */
    public int lastRemaining_Circle(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}
