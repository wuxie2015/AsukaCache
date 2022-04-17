package com.asuka.cache.test;

import com.asuka.cache.cache.api.AsukaCache;
import junit.framework.TestCase;

import java.util.Objects;

public class CacheTest extends TestCase {
    public void test(){
        AsukaCache<String, String> asukaCache = AsukaCache.getCache(4);
        asukaCache.set("1", "2");
        String value = asukaCache.get("1");
        assert Objects.equals(value, "2");
    }
}
