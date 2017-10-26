package com.cloud.icenter.common.util;

import java.util.*;

/**
 * Map 按值排序(升序)
 * @author whcai
 *
 */
public class ValueCompareAsc implements Comparator<String> {  
	  
    Map<String, Float> base;  
    public ValueCompareAsc(Map<String, Float> base) {  
        this.base = base;  
    }  
      
    public int compare(String a, String b) {  
        if (base.get(a) >= base.get(b)) {  
            return 1;  
        } else {  
            return -1;  
        } // returning 0 would merge keys  
    }  
} 

 
