package com.cloud.icenter.common.util;

import java.util.Comparator;
import java.util.Map;

/**
 * Map 按值排序(降序)
 * @author whcai
 *
 */
public class ValueCompareDesc implements Comparator<String> {  
	  
    Map<String, Float> base;  
    public ValueCompareDesc(Map<String, Float> base) {  
        this.base = base;  
    }  
  
    // Note: this comparator imposes orderings that are inconsistent with equals.      
    public int compare(String a, String b) {  
        if (base.get(a) < base.get(b)) {  
            return 1;  
        } else {  
            return -1;  
        } // returning 0 would merge keys  
    }  
}
