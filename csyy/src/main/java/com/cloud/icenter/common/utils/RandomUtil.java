package com.cloud.icenter.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class RandomUtil {
	
	/**
	 * @param target 传入的随机数,类型为String
	 * @return 返回一个数值不超过原来数值10%的随机数
	 */
	public static double getRandom(String target){
		return getRandom(Double.parseDouble(target));
	}
	/**
	 * @param target 传入的随机数,类型为double
	 * @return 返回一个数值不超过原来数值10%的随机数
	 */
	public static double getRandom(double target){
		DecimalFormat df = new DecimalFormat("0.0000");
		double temp = 0;
		temp = Math.round(Math.random()*10);
		temp = temp>10?10d:temp;
		if(target<=0){
			/*target = 0;*/
			target+=(temp/100)*target;
		}else if(temp%2 == 0){
			target+=(temp/100)*target;
		}else{
			target-=(temp/100)*target;
		}
		double res;
		try {
			res = Double.parseDouble(df.format(target));
		} catch (NumberFormatException e) {
			res = target;
			e.printStackTrace();
		}
		return res;
	}
	
	public static double getReduce(String db){
		double res = 0.00;
		try {
			 res = getReduce(Double.parseDouble(db));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * @param target
	 * @return 向前预测随机数
	 */
	public static double getReduce(double target){
		DecimalFormat df = new DecimalFormat("0.0000");
		double temp = 0;
		temp = Math.round(Math.random()*10);
		temp = temp>10?10d:temp;
		target-=(temp/100)*target;
		double res;
		try {
			res = Double.parseDouble(df.format(target));
		} catch (NumberFormatException e) {
			res = target;
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * TODO  计算一个组数据的平均数值
	 * @param strs 传入的一组数据,类型为String[]
	 * @return 返回这组数据的平均值
	 */
	public static double getAvgBydoubles(String[] strs){
		double [] target = new double[strs.length];
		try {
			for(int i = 0 ;i<strs.length;i++){
				String str = strs[i]== null? "0" :strs[i];
				target[i] = Double.parseDouble(str);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0d;
		}
		return getAvgBydoubles(target);
	}
		/**
			  * double 类型的保留几位小数
			  * @param resultFormat
			  * @return
			  */
			public static String numFormat(String resultFormat){
				String d = resultFormat;
				if (d.contains(".")) {
				String dot=d.substring(d.indexOf("."), d.length());
				 DecimalFormat df  = new DecimalFormat("#.####");
				//不用指定整数位多少位，这样比较好，以免数很大造成科学计数法
				double db=Double.valueOf(dot);
				String str=df.format(db);
				str=d.substring(0, d.indexOf("."))+str.substring(1, str.length());
				    return str;
				}
				   return d;
				} 
		/**
			 * 把科学计数法转成double
			 * @param b
			 * @return
			 */
			public static  String  getBigDecimal(Double b){
				BigDecimal bg=new BigDecimal(String.valueOf(b));  
				return numFormat(bg.toPlainString());
			}
	/**
	 * 新
	 * 计算过去5年的增速,增率
	 * (今年-去年)/去年
	 * @param arrZ
	 * @return
	 * @throws ParseException 
	 */
	public static double setZrenAvgLong(String[] objs) {
		double [] obj = new double[objs.length];
		try {
			for(int i = 0 ;i<objs.length;i++){
				String str = objs[i]== null? "0.00" :objs[i];
				obj[i] = Double.parseDouble(str);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0d;
		}
		double rOld = 0.00;
		for (int i = 0;i< obj.length-1;++i) {
		    	if(obj[i+1] != 0){
		    		rOld+=(double)(obj[i]-obj[i+1])/obj[i+1];
		    	}else{
		    		rOld+=0.00;
		    	}
		   }
		Double num = Double.valueOf(numFormat(String.valueOf(rOld)));
	   return Double.valueOf(getBigDecimal(num/obj.length));
	}

	/**
	 * TODO  计算一个组数据的平均数值
	 * @param strs 传入的一组数据,类型为double[]
	 * @return 返回这组数据的平均值
	 */
	public static double getAvgBydoubles(double[] ds){
		DecimalFormat df = new DecimalFormat("0.0000");
		int cs = 0;
		double bcs = 0;
		if(ds.length == 0){
			return 0;
		}else{
			for(double d : ds){
				cs+= d==0?0:1;
				bcs+=d;
			}
		}
		String str = cs == 0 ?"0":df.format(bcs/cs);
		double res = 0d;
		try {
			res = Double.parseDouble(str);
		} catch (NumberFormatException e) {
			res = 0d;
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * 
	 * TODO 将一个数字按照不同的类型取整
	 * @param target 需要取整的数值
	 * @param type 取整的类型
	 * @return 返回取整后的数值
	 */
	public static int tranc(double target,String type){
		double temp = 0d;
		int res = 0;
		try {
			if(type.equals("up")){
				temp = Math.ceil(target);
			}else if(type.equals("down")){
				temp = Math.floor(target);
			}else if(type.equals("round")){
				temp = Math.round(target);
			}else{
				return Integer.parseInt(String.valueOf(target).substring(0, String.valueOf(target).indexOf(".")+1));
			}
			String str = String.valueOf(temp);
			res = Integer.valueOf(str.substring(0, str.indexOf(".")));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	
	/**
	 * TODO 直接返回百分比结果(不带百分号)
	 * @param a 被除数
	 * @param b 除数 
	 * @return 返回百分比
	 * 下午1:00:40
	 */
	public static String getPercentage(double a,double b){
		if(b==0) return "0.00";
		DecimalFormat df = new DecimalFormat("0.0000");
		try {
			String format = df.format(a/b);
			return getround2(Double.parseDouble(format)*100)+"";
		} catch (Exception e) {
			return "0.00";
		}
	}
	
	public static String getPercentage(String a,String b){
		String res ="0.00";
		try {
			if(StringUtils.isBlank(a) || StringUtils.isBlank(b)) return "0.00";
			res = getPercentage(Double.parseDouble(a),Double.parseDouble(b));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * @param a 被除数 double类型参数
	 * @param b 除数 double类型参数
	 * @param num 保留小数的位数
	 * @return 返回保留后的结果
	 */
	public static String getRoundnum(double a , double b, int num){
		if(b == 0) return "0.00";
		String str = "0.";
		for(int i =0;i<num;i++){
			str+="0";
		}
		try {
			DecimalFormat df = new DecimalFormat(str);
			return df.format(a/b);
		} catch (Exception e) {
			return "0.00";
		}
	}
	/**
	 * @param a 被除数 String类型参数
	 * @param b 除数 String类型参数
	 * @param num 保留小数的位数
	 * @return 返回保留后的结果
	 */
	public static String getRoundnum(String a , String b, int num){
		String res ="0";
		try {
			res = getRoundnum(Double.parseDouble(a), Double.parseDouble(b), num);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * 
	 * TODO 算出数字连续两个数值的商保留两位小数
	 * @param dbs 传入的数组对象 类型为double[]
	 * @return 返回的结果
	 */
	public static String[] getquotients(double[] dbs){
		int length = dbs.length-1;
		DecimalFormat df = new DecimalFormat("0.0000");
		String[] res = new String[length];
		for (int i = 0; i < length; i++) {
			String str = dbs[i+1] == 0d?"0.0000":df.format(dbs[i]/dbs[i+1]);
			res[i] = str;
		}
		return res;
	}
	/**
	 * 
	 * TODO 算出数字连续两个数值的商保留两位小数
	 * @param dbs 传入的数组对象 类型为String[]
	 * @return 返回的结果
	 */
	public static String[] getquotients(String[] dbs){
		double[] res = new double[dbs.length];
		for (int i = 0; i < dbs.length; i++) {
			res[i] = dbs[i] == null ? 0d :Double.parseDouble(dbs[i]); 
		}
		return getquotients(res);
	}
	/**
	 * TODO 如果一个数组里面某一项的数据没有为null,则设置为0
	 * @param array 传入一个数组
	 * @return 返回的结果
	 */
	public static String[] getarray(String [] array){
		try {
			if(array != null && array.length > 0){
				for (int i = 0; i < array.length; i++) {
					array[i] = array[i]==null?"0":array[i];
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}
	
	/**
	 * @param number
	 * @return 将一个结果小数四舍五入并且保留两位小数
	 */
	public static double getround2(double number){
		DecimalFormat df = new DecimalFormat("0.00");
		double res;
		try {
			res =  Double.parseDouble(df.format(number));
		} catch (NumberFormatException e) {
			res = number;
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * @param dbs 传入的是一个double类型的数组参数
	 * @return 返回的结果数据
	 */
	public static double[] getspeeds(double[] dbs){
		double[] speeds = new double[dbs.length-1];
		for(int i=0;i<dbs.length-1;i++){
			double temp = dbs[i]-dbs[i+1];
			String speed;
			try {
				speed = dbs[i+1] == 0d?"0.0000":getRoundnum(temp,dbs[i+1],4);
			} catch (Exception e) {
				speed = "0.0000";
				e.printStackTrace();
			}
			speeds[i] = Double.parseDouble(speed);
		}
		return speeds;
	}
	public static double[] getspeeds(String[] dbs){
		double [] t = new double[dbs.length];
		for(int i=0;i<dbs.length-1;i++){
			try {
				t[i] = StringUtils.isEmpty(dbs[i])?0.0000:Double.parseDouble(dbs[i]);
			} catch (NumberFormatException e) {
				t[i] = 0.0000;
				e.printStackTrace();
			}
		}
		return getspeeds(t);
	}
	
	/**
	 * @param dbs 传入目标参数,类型为double[]
	 * @param isasc 出入的目标是否是按照年份升序排列,如果不是升序,则倒序
	 * @return 返回连续两个数据的商
	 */
	public static String[] getAddAbsByArray(double[] dbs,boolean isasc){
		String[] res =new String[dbs.length-1];
		try {
			if(!isasc){
				 for (int start = 0, end = dbs.length - 1; start < end; start++, end--) {
			        double temp = dbs[end];
			        dbs[end] = dbs[start];
			        dbs[start] = temp;
			     }
			}//如果数据为降序则倒叙防置
			for(int i = 0;i<res.length;i++){
				double dif = Math.abs(dbs[i+1]-dbs[i]);
				res[i] = dbs[i] == 0?"0.0000":getRoundnum(dif, dbs[i],4);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * @param dbs 传入目标参数
	 * @param isasc 出入的目标是否是按照年份升序排列,如果不是升序,则倒序
	 * @return 返回连续两个数据的商
	 */
	public static String[] getAddAbsByArray(String[] dbs,boolean isasc){
		String[] addAbsByArray = new String[dbs.length-1];
		try {
			double[] target =new double[dbs.length];
			for(int i = 0;i<dbs.length;i++){
				target[i] = dbs[i] == null?0:Double.valueOf(dbs[i]);
			}
			addAbsByArray = getAddAbsByArray(target,isasc);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return addAbsByArray;
	}
	
	/**
	 * @param dbs 传入double[]类型参数
	 * @param num 需要截取后面的参数的个数
	 * @return
	 */
	public static  String[] getLengthArray(double[] dbs,int num){
		String[] res = new String[num];
		for(int i =0;i<num;i++){
			res[i] = String.valueOf(getround2(dbs[dbs.length+i-num]*100));
		}
		return res;
	}
	/**
	 * @param dbs 传入String[]类型参数
	 * @param num 需要截取后面的参数的个数
	 * @return
	 */
	public static  String[] getLengthArray(String[] dbs,int num){
		String[] res = new String[num];
		for(int i =0;i<num;i++){
			res[i] = dbs[dbs.length+i-num];
		}
		return res;
	}
	
	/**
	 * 截取某个数组的部分数据
	 * @param array 传入目标数组
	 * @param num 需要阶段的个数
	 * @param isbefore 截取之前还是之后的数据
	 * @return 返回截断之后的数据
	 */
	public static Integer[] getTrancArray(Integer[] array,int num,boolean isbefore){
		if(num>array.length){
			return array;
		}
		Integer[] res = new Integer[num];
		for(int i=0;i<array.length;i++){
			if(isbefore){
				res[i] = array[i];
			}else{
				res[i] = array[array.length+i-num];
			}
		}
		return res;
	}
	
	/**
	 * 实现数组倒置
	 * @param array传入数组
	 * @return 返回倒置之后的数组
	 */
	public static <T> T[] getReverseArray(T[] array) {
		ArrayUtils.reverse(array);
		 return array;
/*		Object[] new_array = new Object[array.length];  
	    for (int i = 0; i < array.length; i++) {  
	        // 反转后数组的第一个元素等于源数组的最后一个元素：  
	        new_array[i] = array[array.length - i - 1];  
	    }  
	    return new_array;*/  
	}
} 
