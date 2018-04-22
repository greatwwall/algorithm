package com.xujun.algorithm.sort.insert;

import java.util.Arrays;

/**
 * @todo 折半插入排序 依次将待排序的元素插入前面的有序序列,每次判断前面的有序序列中间值大小,递归
 *      时间复杂度 O(n2) 空间复杂度 O(1)
 * @author xujun
 * @version 1.0
 * @date 2018年4月1日 下午8:23:15
 */

public class BinaryInsertSort {

    public static void main(String[] args) {
        int[] data = {23, 32, 55, 43, 75, 26, 46, 27, 16};
        System.out.println("before sort: " + Arrays.toString(data));
        sort(data);
        System.out.println("after  sort: " + Arrays.toString(data));
    }

    /**
     * @todo
     * @param data
     * @return void
     */
    private static void sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            int left = 0;
            int right = i - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (temp > data[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            for (int j = i; j > left; j--) {
                data[j] = data[j - 1];
            }
            data[left] = temp;
        }
    }
}
