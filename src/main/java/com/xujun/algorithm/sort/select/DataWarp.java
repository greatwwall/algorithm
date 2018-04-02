package com.xujun.algorithm.sort.select;

/**
 * @author xujun
 *
 */
public class DataWarp implements Comparable<DataWarp> {

    int data;
    String flag;

    public DataWarp(int data, String flag) {
        super();
        this.data = data;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return data + flag;
    }

    public int compareTo(DataWarp o) {
        return this.data > o.data ? 1 : (this.data == o.data ? 0 : -1);
    }

}
