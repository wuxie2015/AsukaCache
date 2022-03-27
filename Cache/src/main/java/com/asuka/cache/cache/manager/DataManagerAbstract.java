package com.asuka.cache.cache.manager;

import com.asuka.cache.common.tuple.Tuple2;

import java.util.LinkedList;

public abstract class DataManagerAbstract<K,V> implements DataManager<K,V> {
    private LinkedList<Tuple2<K, Long>> linkedList = new LinkedList<>();

    private void lruPush(K key){
        long currentMillSeconds = System.currentTimeMillis();
        linkedList.add(Tuple2.of(key, currentMillSeconds));
    }

    private void lruGet(K key, V value){
        for (int i = linkedList.size() - 1; i >=0; i--){
            Tuple2<K, Long> elem = linkedList.get(i);
            if (elem.f1 == key){
                linkedList.remove(i);
                linkedList.addFirst(elem);
                break;
            }
        }
    }

    private void lruEvict(int size){
        for (int i = linkedList.size() -1 ; i >=0; i --){
            if (i >= size){
                linkedList.remove(i);
            } else {
                break;
            }
        }
    }
}
