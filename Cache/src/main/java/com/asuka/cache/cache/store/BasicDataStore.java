package com.asuka.cache.cache.store;

import java.util.concurrent.ConcurrentHashMap;

public class BasicDataStore<K,V> implements DataStore<K, V> {
    private ConcurrentHashMap<K,V> concurrentHashMap = new ConcurrentHashMap<K,V>();

    @Override
    public void put(K key, V value) {
        concurrentHashMap.put(key, value);
    }

    @Override
    public V get(K key) {
        return concurrentHashMap.get(key);
    }

    @Override
    public void invalid(K key) {
        concurrentHashMap.remove(key);
    }

    @Override
    public Long size() {
        return (long) concurrentHashMap.size();
    }
}
