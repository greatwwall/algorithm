package com.xujun.algorithm.sort.merge;

import java.util.Arrays;

/**
 * @todo 归并排序
 * @author xujun
 * @version 1.0
 * @date 2018年4月1日 下午9:28:13
 */

public class MergeSort {

    public static void main(String[] args) {
        int[] data = {23, 32, 55, 43, 75, 26, 46, 27, 16};
        System.out.println("before sort: " + Arrays.toString(data));
        sort(data, 0, data.length - 1);
        System.out.println("after  sort: " + Arrays.toString(data));
    }

    /**
     * @todo
     * @param data
     * @param j
     * @param i
     * @return void
     */
    private static void sort(int[] data, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            // 左边递归
            sort(data, left, center);
            // 右边递归
            sort(data, center + 1, right);
            // 左右合并
            merge(data, left, center, right);
        }
    }

    /**
     * @todo
     * @param data
     * @param left
     * @param center
     * @param right
     * @return void
     */
    private static void merge(int[] data, int left, int center, int right) {
        int[] tempArray = new int[data.length];
        int mid = center + 1;
        // 记录中间数组的索引
        int third = left;
        int tmp = left;
        while (left <= center && mid <= right) {
            // 从两个数组中取出小的放入中间数组
            if (data[left] <= data[mid]) {
                tempArray[third++] = data[left++];
            } else {
                tempArray[third++] = data[mid++];
            }
        }
        // 剩余部分依次放入中间数组
        while (mid <= right) {
            tempArray[third++] = data[mid++];
        }
        while (left <= center) {
            tempArray[third++] = data[left++];
        }
        // 将中间数组的内容复制拷贝回原数组
        while (tmp <= right) {
            data[tmp] = tempArray[tmp++];
        }
    }
}
