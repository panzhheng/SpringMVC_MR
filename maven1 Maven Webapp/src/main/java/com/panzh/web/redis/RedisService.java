package com.panzh.web.redis;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
/** 
 * redis缓存接口。 
 * 
 * 缓存时间单位默认分钟， 
 * 默认timeout值为5， 
 * 没有timeout和timeunit的方法默认不设置有效时间，永久有效。 
 */  
public interface RedisService {
	int EXPIRE_TIME_1 = 1;  
	  
    int EXPIRE_TIME_2 = 2;  
  
    int EXPIRE_TIME_5 = 5;  
  
    int EXPIRE_TIME_7 = 7;  
  
    int EXPIRE_TIME_15 = 15;  
      
    int EXPIRE_TIME_30 = 30;  
  
  
    <T> void put(String key, T obj);  
    <T> void put(String key, T obj, int timeout);  
    <T> void put(String key, T obj, int timeout, TimeUnit unit);  
  
    <T> T get(String key, Class<T> cls);  
  
    <E, T extends Collection<E>> T get(String key, Class<E> cls, Class<T> collectionClass);  
  
    <T> T putIfAbsent(String key, Class<T> cls, Supplier<T> supplier);  
    <T> T putIfAbsent(String key, Class<T> cls, Supplier<T> supplier, int timeout);  
    <T> T putIfAbsent(String key, Class<T> cls, Supplier<T> supplier, int timeout, TimeUnit unit);  
    <T> T putIfAbsent(String key, Class<T> cls, Supplier<T> supplier, int timeout, TimeUnit unit, boolean refresh);  
  
    <E, T extends Collection<E>> T putIfAbsent(String key, Class<E> cls, Class<T> collectionCls, Supplier<T> supplier);  
    <E, T extends Collection<E>> T putIfAbsent(String key, Class<E> cls, Class<T> collectionCls, Supplier<T> supplier, int timeout);  
    <E, T extends Collection<E>> T putIfAbsent(String key, Class<E> cls, Class<T> collectionCls, Supplier<T> supplier, int timeout, TimeUnit unit);  
    <E, T extends Collection<E>> T putIfAbsent(String key, Class<E> cls, Class<T> collectionCls, Supplier<T> supplier, int timeout, TimeUnit unit, boolean refresh);  
  
    boolean exists(String key);  
  
    void delete(String key);  
  
    boolean expire(String key, long timeout, TimeUnit timeUnit);  
    boolean expire(String key, long timeout);  
      
    void put(String key, String value);  
    void put(String key, String value, int timeout);  
    void put(String key, String value, int timeout, TimeUnit unit);  
  
    String get(String key);  
}
