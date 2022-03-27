package com.asuka.cache.cache.manager;

import com.asuka.cache.cache.store.BasicDataStore;
import com.asuka.cache.cache.store.DataStore;

import java.util.concurrent.ConcurrentHashMap;

public class TimeManager<K,V> extends DataManagerAbstract<K, V> {

    /**
     * 过期时间表，用来存储每个key的过期时间
     */
    private ConcurrentHashMap<K, V> expireMap = new ConcurrentHashMap<>();
    private Integer maxSize;
    private DataStore<K, V> dataStore;

    public TimeManager(){
        dataStore = new BasicDataStore();
    }

    public void evict(){

    }

    @Override
    public void add(K key, V value) {
        dataStore.put(key, value);
    }

    @Override
    public V get(K key) {
        return dataStore.get(key);
    }

}
