package com.asuka.cache.cache.manager;

public interface DataManager<K,V> {
    /**
     * 驱逐过期的缓存
     */
    void evict();
    void add(K key, V value);
    V get(K key);
}
