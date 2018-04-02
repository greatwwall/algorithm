package com.xujun.algorithm.sort.select;

import java.util.Arrays;

/**
 * @todo 堆排序 时间复杂度 O(n*logn) 空间复杂度 O(1)
 * @author xujun
 * @version 1.0
 * @date 2018年4月1日 下午3:18:40
 */

public class HeapSort {

    public static int[] sort(int[] datas) {
        int len = datas.length;
        for (int i = len - 1; i > 0; i--) {
            // 构建堆
            buildHeap(datas, i);
            // 首尾交换
            System.out.println((len - i) + "*: " + Arrays.toString(datas));
            swap(datas, 0, i);
            System.out.println((len - i) + " : " + Arrays.toString(datas));
        }
        return datas;
    }

    /**
     * @todo
     * @param datas
     * @param i2
     * @return void
     */
    private static void buildHeap(int[] datas, int len) {
        // i表示最后一个不是叶子节点的子节点
        if (len % 2 == 0) {
            for (int i = len / 2 - 1; i >= 0; i--) {
                adjustHeap(datas, i, len);
            }
        } else {
            for (int i = len / 2; i >= 0; i--) {
                adjustHeap(datas, i, len);
            }
        }
    }

    /**
     * @todo 根据最后一个不是叶子节点的子节点调整堆
     * @param datas
     * @param parent
     * @param len
     * @return void
     */
    private static void adjustHeap(int[] datas, int parent, int len) {
        int left = 2 * parent + 1; // i的左孩子下标
        int right = 2 * parent + 2; // i的右孩子下标
        int largest = 0; // i及其孩子最大值的下标

        // 如果左孩子比父节点大,替换下标
        if (left <= len && datas[left] > datas[parent]) {
            largest = left;
        } else {
            largest = parent;
        }
        // 如果右孩子比其他两个节点大,替换下标
        if (right <= len && datas[right] > datas[largest]) {
            largest = right;
        }
        if (largest != parent) {
            // 交换
            swap(datas, largest, parent);
        }
    }

    /**
     * @todo 交换
     * @param datas
     * @param largest
     * @param i
     * @return void
     */
    private static void swap(int[] datas, int largest, int i) {
        int temp = datas[i];
        datas[i] = datas[largest];
        datas[largest] = temp;
    }

    public static void main(String[] args) {
        int[] datas = {60, 70, 12, 30, 40, 9, 10};
        System.out.println("before sort: " + Arrays.toString(datas));
        int[] result = sort(datas);
        System.out.println("after sort : " + Arrays.toString(result));
    }
}
