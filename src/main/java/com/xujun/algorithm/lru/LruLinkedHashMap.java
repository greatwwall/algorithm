package com.xujun.algorithm.lru;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月16日 下午8:28:16 
  */

public class LruLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private static final long serialVersionUID = -3064679881022012686L;

    private int capacity;

    /**
     * @param initialCapacity
     */
    public LruLinkedHashMap(int initialCapacity) {
        super(16, 0.75f, true);
        this.capacity = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        System.out.println("the eldest entry is : " + eldest.getKey() + " - " + eldest.getValue());
        return size() > capacity;
    }


    public static void main(String[] args) {
        LruLinkedHashMap<Integer, Integer> lru = new LruLinkedHashMap<Integer, Integer>(4);
        lru.put(1, 1);
        lru.put(4, 4);
        lru.put(5, 5);
        lru.put(7, 7);
        lru.put(9, 9);
        lru.put(4, 8);

        Iterator<Map.Entry<Integer, Integer>> iterator = lru.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getValue());
        }

    }

}
