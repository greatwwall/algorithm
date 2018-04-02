package com.xujun.algorithm.sort.cardinal;

import java.util.Arrays;

/**
 * @todo 基数排序
 * @author xujun
 * @version 1.0
 * @date 2018年4月1日 下午10:34:52
 */

public class CardinalSort {

    public static void main(String[] args) {
        int[] data = {123, 232, 355, 443, 41, 175, 226};
        System.out.println("before sort: " + Arrays.toString(data));
        sort(data);
        System.out.println("after  sort: " + Arrays.toString(data));
    }

    /**
     * @todo
     * @param data
     * @return
     * @return String
     */
    private static void sort(int[] data) {
        // 最大位数
        int number = 0;
        for (int i : data) {
            number = Math.max(number, String.valueOf(i).length());
        }
        // 余数的除数
        int n = 1;
        // 当前的位数, 1个位,2十位
        int m = 1;
        int k = 0;
        // 临时数组,第一位余数,第二位值
        int[][] tempArray = new int[10][data.length];
        // 二维索引
        int[] order = new int[10];
        while (m <= number) {
            // 按当前位数的余数进行归类
            for (int i = 0; i < data.length; i++) {
                int r = (data[i] / n) % 10;
                tempArray[r][order[r]] = data[i];
                order[r]++;
            }
            for (int i = 0; i < 10; i++) {
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) {
                        data[k] = tempArray[i][j];
                        k++;
                    }
                }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            m++;
            System.out.println(Arrays.toString(data));
        }

    }
}
