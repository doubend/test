package com.cloud.icenter.common.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/***
 * 
 * @ClassName: CacheUtil
 * @Description: TODO(这里用一句话描述这个类的作用) 缓存工具类库
 * @author Chen_JIAN
 * @date 2015年9月11日 上午11:24:47
 *
 */
public class CacheUtil {

    /**
     * 公钥缓存缓存
     */
    private static Cache<String, Object> publickeyIdCache = null;
    private static Cache<String, String> stringCache2min = null;

    /**
     * 系统配置缓存
     */
    private static Cache<String, Object> systemConfigCache = null;

    private static Logger log = Logger.getLogger(CacheUtil.class);

    static {
        try {
            publickeyIdCache = initCache(5, TimeUnit.MINUTES, Long.MAX_VALUE);// 设置缓存过期时间为5分钟
            stringCache2min = initCache(2, TimeUnit.MINUTES, Long.MAX_VALUE);// 设置缓存过期时间为5分钟
            systemConfigCache = initCache(365 * 10, TimeUnit.DAYS, Long.MAX_VALUE);// 初始化系统配置缓存
        } catch (Exception e) {
            log.error("缓存初始化出现异常[" + e.getMessage() + "]");
        }
    }

    /**
     * 
     * initCache(这里用一句话描述这个方法的作用) 缓存初始化配置
     * 
     * @param duration
     *            缓存过期时间设置
     * @param unit
     *            缓存过期单位
     * @param size
     *            设置缓存个数
     * @return
     * @throws Exception
     *             Cache<K,V>
     * @exception
     * @version 1.0.0
     * @date 2015年9月11日
     *
     */
    public static <K, V> Cache<K, V> initCache(long duration, TimeUnit unit, long size) throws Exception {
        Cache<K, V> cache = CacheBuilder.newBuilder()
        // .refreshAfterWrite(1, TimeUnit.MINUTES)// 给定时间内没有被读/写访问，则回收。
        // .expireAfterWrite(5, TimeUnit.SECONDS)//给定时间内没有写访问，则回收。
                .expireAfterAccess(duration, unit)// 缓存过期时间为3秒
                .maximumSize(size)// 设置缓存个数
                .build();
        return cache;
    }

    /***
     * 
     * getPublickey(这里用一句话描述这个方法的作用) 从缓存里获取公钥
     * 
     * @param keyName
     * @return Object
     * @exception
     * @version 1.0.0
     * @date 2015年9月10日
     *
     */

    public static Object getPublickey(final String keyName) {
        try {

            // Callable只有在缓存值不存在时，才会调用
            return publickeyIdCache.get(keyName.toLowerCase(), new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    log.info("公钥缓存中不存在key=[" + keyName + "]的值！");
                    return "";
                }
            });
        } catch (ExecutionException e) {
            log.error("从公钥缓存中获取key=[" + keyName + "]值时出现异常！[" + e.getMessage() + "]");
            return null;
        }
    }

    /**
     * 
     * putPublickey(这里用一句话描述这个方法的作用) 向缓存里增加公钥
     * 
     * @param Publickey
     * @return String
     * @exception
     * @version 1.0.0
     * @date 2015年9月11日
     *
     */
    public static String putPublickey(Object publicKey) {
        String key = String.valueOf(System.currentTimeMillis()) + RandomStringUtils.randomNumeric(6);// 生产key
        publickeyIdCache.put(key.toLowerCase(), publicKey);
        return key;
    }

    /**
     * 
     * putSystemConfig(这里用一句话描述这个方法的作用) 将配置信息放入缓存
     * 
     * @param key
     * @param value
     *            void
     * @exception
     * @version 1.0.0
     * @date 2015年9月14日
     *
     */
    public static void putSystemConfig(String key, Object value) {

        systemConfigCache.put(key.toLowerCase(), value);
    }

    /**
     * 
     * getSystemConfig(这里用一句话描述这个方法的作用) 根据key值从系统配置缓存里获取配置信息
     * 
     * @param key
     * @return Object
     * @exception
     * @version 1.0.0
     * @date 2015年9月14日
     *
     */

    public static Object getSystemConfig(final String key) {

        try {
            return systemConfigCache.get(key, new Callable<Object>() {

                @Override
                public Object call() throws Exception {
                    log.info("系统配置缓存中不存在key=[" + key + "]的配置信息！");
                    return "";
                }
            });
        } catch (ExecutionException e) {
            log.error("从系统配置缓存获取key=[" + key + "]配置信息时出现异常！[" + e.getMessage() + "]");
        }
        return null;
    }

    /**
     * 获取缓存中的内容
     * 
     * @param key
     * @return
     */
    public static String get(String key) {
        try {
            return stringCache2min.get(key, new Callable<String>() {

                @Override
                public String call() throws Exception {
                    return null;
                }
            });
        } catch (Exception e) {}
        return null;
    }

    /**
     * 设置缓存信息
     * 
     * @param key
     * @param value
     */
    public static void put(String key, String value) {
        stringCache2min.put(key, value);
    }

    public static void main(String[] args) throws Exception {
        String timestamp = String.valueOf(System.currentTimeMillis());// 时间戳
        String nonce = RandomStringUtils.randomNumeric(6);// 随机数
        System.out.println(timestamp + ">>>" + nonce);

    }
}
