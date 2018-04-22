package com.xujun.algorithm.sort.bucket;

import java.util.Arrays;

/**
 * @todo 桶式排序 一组数据(m)最大的为n,则建立一个新数组(桶)用来装原来的数据,规则是
 *      从m取出的数据k是几就放入桶的第几位并计数为1,如果这个数出现了几次,就加到几,
 *      最后遍历桶的下标即为排序,是几就循环几次
 * @author xujun
 * @version 1.0
 * @date 2018年4月1日 下午10:04:00
 */

public class BucketSort {

    public static void main(String[] args) {
        int[] data = {23, 32, 55, 43, 1, 75, 26, -10, 46, 3, 27, 16, 16};
        System.out.println("before sort: " + Arrays.toString(data));
        String result = sort(data, -10, 75);
        System.out.println("after  sort: " + result);
    }

    /**
     * @todo
     * @param data
     * @param i
     * @param j
     * @return String
     */
    private static String sort(int[] data, int min, int max) {
        int[] buckets = new int[max + 1 - min];
        // 在桶中记录每个元素的个数
        for (int i = 0; i < data.length; i++) {
            buckets[data[i] - min]++;
        }
        System.out.println(Arrays.toString(buckets));
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] > 0) {
                for (int j = 0; j < buckets[i]; j++) {
                    result.append(i + min).append(" ");
                }
            }

        }
        return result.toString();
    }
}
