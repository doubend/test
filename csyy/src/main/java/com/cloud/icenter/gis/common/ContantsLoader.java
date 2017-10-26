package com.cloud.icenter.gis.common;

import java.io.IOException;
import java.util.Properties;

public class ContantsLoader {
	
	private static String filename="mapServerUrlConfig.properties";
	private static Properties p=new Properties();	
	
	static{		
		try{
			p.load(ContantsLoader.class.getResourceAsStream(filename));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key){
		if(p.size()==0){
			return null;
		}
		return p.getProperty(key)==null?null:p.get(key).toString();
	}
	
}
