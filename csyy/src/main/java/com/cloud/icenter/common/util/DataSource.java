package com.cloud.icenter.common.util;

import java.lang.annotation.*;
 
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default DataSource.master;
 
    public static String master = "dataSource1";
 
    public static String slave1 = "dataSource2";
 
    public static String slave2 = "dataSource3";
 
}