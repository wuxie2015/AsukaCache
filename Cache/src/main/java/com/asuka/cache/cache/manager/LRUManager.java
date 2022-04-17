package com.asuka.cache.cache.manager;

import com.asuka.cache.cache.store.BasicDataStore;
import com.asuka.cache.cache.store.DataStore;
import java.util.LinkedList;

public class LRUManager<K,V> extends DataManagerAbstract<K, V> {

    /**
     * 过期时间表，用来存储每个key的过期时间
     */
    private LinkedList<K> linkedList = new LinkedList<>();
    private Integer maxSize;
    private DataStore<K, V> dataStore;

    public LRUManager(Integer maxSize){
        this.maxSize = maxSize;
        dataStore = new BasicDataStore();
    }

    public void evict(){
        this.lruEvict(maxSize);
    }

    @Override
    public void add(K key, V value) {
        this.lruPush(key);
        int length = this.linkedList.size();
        // 如果超过最大长度就重写
        if (length > maxSize){
            this.evict();
        }
        dataStore.put(key, value);
    }

    @Override
    public V get(K key) {
        this.lruGet(key);
        return dataStore.get(key);
    }

    private void lruPush(K key){
        linkedList.remove(key);
        linkedList.addFirst(key);
    }

    protected void lruGet(K key){
        for (int i = linkedList.size() - 1; i >=0; i--){
            K elem = linkedList.get(i);
            if (elem == key){
                linkedList.remove(i);
                linkedList.addFirst(elem);
                break;
            }
        }
    }

    protected void lruEvict(int size){
        for (int i = linkedList.size() -1 ; i >=0; i --){
            if (i >= size - 1){
                dataStore.invalid(linkedList.get(i));
                linkedList.remove(i);
            } else {
                break;
            }
        }
    }
}
