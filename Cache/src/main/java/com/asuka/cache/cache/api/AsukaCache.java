package com.asuka.cache.cache.api;

import com.asuka.cache.cache.manager.DataManager;
import com.asuka.cache.cache.manager.TimeManager;
import com.asuka.cache.cache.store.BasicDataStore;

public class AsukaCache {
    private DataManager dataManager;

    AsukaCache(DataManager dataManager){
        this.dataManager = dataManager;
    }

    public static <K, V> AsukaCache getCache(Class<K> keyClass, Class<V> valueClass){
        DataManager<K,V> dataManager = new TimeManager<>();
        return new AsukaCache(dataManager);
    }
}
