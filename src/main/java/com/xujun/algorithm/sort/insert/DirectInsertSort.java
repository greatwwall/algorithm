package com.xujun.algorithm.sort.insert;

import java.util.Arrays;

/**
 * @todo 直接插入排序 时间复杂度 平均 O(n2),最好O(n) 空间复杂度 O(1)
 * @author xujun
 * @version 1.0
 * @date 2018年4月1日 下午8:10:58
 */

public class DirectInsertSort {

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
            for (int j = i; j > 0; j--) {
                if (data[j] < data[j - 1]) {
                    int temp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;
                }
            }
        }
    }
}
