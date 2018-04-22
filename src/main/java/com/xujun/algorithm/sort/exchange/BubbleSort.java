package com.xujun.algorithm.sort.exchange;

import java.util.Arrays;

/**
 * @todo 冒泡排序 从一组数据的第一个开始,如果两个不等,大的置后,直到数组最后一个数最大,
 *      再排除最后一个数,前面的n-1个数递归执行
 *      时间复杂度 O(n2) 空间复杂度 O(1)
 * @author xujun
 * @version 1.0
 * @date 2018年4月1日 下午5:46:08
 */

public class BubbleSort {

    public static void main(String[] args) {
        int[] datas = {68, 40, 20, 51, 30, 8, 27, 42};
        System.out.println("before sort:" + Arrays.toString(datas));
        sort(datas);
        System.out.println("after sort :" + Arrays.toString(datas));
    }

    /**
     * @todo
     * @param datas
     * @return void
     */
    private static void sort(int[] datas) {
        int len = datas.length - 1;
        for (int i = 0; i < len; i++) {
            boolean flag = true;
            for (int j = 0; j < len - i; j++) {
                if (datas[j] > datas[j + 1]) {
                    int temp = datas[j];
                    datas[j] = datas[j + 1];
                    datas[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }

        }
    }
}
