package com.xujun.algorithm.sort.select;

import java.util.Arrays;

/**
 * @todo 直接排序
 *      时间复杂度 O(n2)
 *      空间复杂度 O(1)
 * @author xujun
 * @version 1.0
 * @date 2018年4月1日 下午2:29:21
 */
public class DirectSelectSort {

    /**
     * @todo
     * @param datas
     * @return void
     */
    public static void sort(DataWarp[] datas) {
        System.out.println("start direct select sort.");

        for (int i = 0; i < datas.length; i++) {
            // 最小值的索引
            int tempIndex = i;
            for (int j = i + 1; j < datas.length; j++) {
                // 如果tempIndex的值 > j的值,替换索引,保证tempIndex的值最小
                if (datas[tempIndex].compareTo(datas[j]) > 0) {
                    tempIndex = j;
                }
            }
            // tempIndex的值不是最小时交换
            if (tempIndex != i) {
                DataWarp temp = datas[i];
                datas[i] = datas[tempIndex];
                datas[tempIndex] = temp;
            }
            System.out.println(i + " : " + Arrays.toString(datas));
        }
    }

    public static void main(String[] args) {
        DataWarp[] datas = {new DataWarp(10, ""), new DataWarp(30, ""), new DataWarp(16, ""),
                new DataWarp(30, "*"), new DataWarp(49, ""), new DataWarp(42, ""),};
        System.out.println("before sort: " + Arrays.toString(datas));
        sort(datas);
        System.out.println("after sort : " + Arrays.toString(datas));
    }
}
