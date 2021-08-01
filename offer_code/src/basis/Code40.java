package basis;

import java.util.Arrays;

/**
 * 题目：剑指 Offer 40. 最小的k个数
 * 题目要求：输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 题目分析：1. 排序算法：快速排序（哨兵划分 + 递归），时间复杂度为O(nlogn)，空间复杂度为O(n)
 */
public class Code40 {

    /**
     * 方法一：快速排序
     * 解题思路：1. 哨兵划分：先取首元素为基准点，设置两个指针遍历数组（从头到尾与从尾到头），若前指针小于等于当前首元素值，前指针加1；
     *            后指针大于等于当前首元素值，后指针减1.
     *         2. 交换前后指针值，并将left指针值与前指针值对调
     *         3. 递归处理，处理前指针左右两边界
     */

    public int[] getLeastNumbers(int[] arr, int k) {
        recursion(arr, 0 ,arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    public void recursion(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && arr[j] >= arr[left]) {
                j--;
            }
            while (i < j && arr[i] <= arr[left]) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, left, i);
        recursion(arr, left, i-1);
        recursion(arr, i+1, right);
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
