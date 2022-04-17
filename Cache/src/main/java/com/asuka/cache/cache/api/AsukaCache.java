package com.asuka.cache.cache.api;

import com.asuka.cache.cache.manager.DataManager;
import com.asuka.cache.cache.manager.LRUManager;

public class AsukaCache<K,V> {
    private DataManager<K,V> dataManager;

    private AsukaCache(DataManager<K,V> dataManager){
        this.dataManager = dataManager;
    }

    public V get(K key){
        return dataManager.get(key);
    }
    public void set(K key, V value){
        dataManager.add(key, value);
    }

    public static <K, V> AsukaCache<K,V> getCache(Integer size){
        DataManager<K,V> dataManager = new LRUManager<>(size);
        return new AsukaCache<>(dataManager);
    }
}
