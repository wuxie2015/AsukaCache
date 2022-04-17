package com.asuka.cache.test;

import com.asuka.cache.cache.api.AsukaCache;
import junit.framework.TestCase;

import java.util.Objects;

public class CacheTestEvict extends TestCase {
    public void test(){
        AsukaCache<String, String> asukaCache = AsukaCache.getCache(4);
        asukaCache.set("1", "2");
        asukaCache.set("2", "2");
        asukaCache.set("3", "2");
        asukaCache.set("5", "2");
        asukaCache.set("6", "2");
        String value = asukaCache.get("1");
        assert value == null;
    }
}
