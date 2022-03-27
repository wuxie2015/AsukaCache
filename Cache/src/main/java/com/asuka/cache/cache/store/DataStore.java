package com.asuka.cache.cache.store;

public interface DataStore<K,V> {
    void put(K key, V value);
    V get(K key);
    void invalid(K key);
    Long size();
}
