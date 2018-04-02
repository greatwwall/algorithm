package com.xujun.algorithm.sort.insert;

import java.util.Arrays;

/**
 * @todo shell排序 时间复杂度 O(nlogn) 空间复杂度 O(1)
 * @author xujun
 * @version 1.0
 * @date 2018年4月1日 下午8:49:44
 */

public class ShellInsertSort {

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
        int len = data.length;
        int h = 1;
        while (h < len / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (int i = h; i < len; i++) {
                int temp = data[i];
                if (temp < data[i - h]) {
                    int j = i - h;
                    for (; j >= 0 && data[j] > temp; j -= h) {
                        data[j + h] = data[j];
                    }
                    data[j + h] = temp;
                }
                System.out.println(Arrays.toString(data));
            }
            h = (h - 1) / 3;
        }
    }
}
