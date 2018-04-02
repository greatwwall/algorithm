package com.xujun.algorithm.sort.exchange;

import java.util.Arrays;

/**
 * @todo 快速排序
 *      时间复杂度 O(nlogn)
 *      空间复杂度 O(n)
 * @author xujun
 * @version 1.0
 * @date 2018年4月1日 下午6:20:26
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] data = {68, 40, 20, 51, 30, 8, 27, 42};
        sort(data, 2, data.length - 1);
        System.out.println("after sort:" + Arrays.toString(data));
    }

    /**
     * @todo
     * @param data
     * @param right
     * @param left
     * @return void
     */
    private static void sort(int[] data, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int key = data[i];
        // 一趟排序
        while (i < j) {
            // 从右往左找到第一个小于key的值
            while (i < j && key < data[j]) {
                j--;
            }
            // 从左往右找到第一个大于key的值
            while (i < j && key >= data[i]) {
                i++;
            }
            // 交换
            if (i < j) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        // 调整key的位置
        int tmp = data[i];
        data[i] = data[left];
        data[left] = tmp;
        // 对key左边的快排
        sort(data, left, i - 1);
        // 对key右边的快排
        sort(data, i + 1, right);
    }
}
