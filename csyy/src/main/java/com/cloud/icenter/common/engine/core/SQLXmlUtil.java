package com.cloud.icenter.common.engine.core;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;

import com.cloud.icenter.common.engine.command.IfCommand;
import com.cloud.icenter.common.engine.command.OrderCommand;
import com.cloud.icenter.common.engine.command.TrimCommand;
import com.cloud.icenter.common.engine.tag.DeleteTag;
import com.cloud.icenter.common.engine.tag.InsertTag;
import com.cloud.icenter.common.engine.tag.SelectTag;
import com.cloud.icenter.common.engine.tag.UpdateTag;
import com.cloud.icenter.common.engine.tag.commTag;
import com.cloud.icenter.common.engine.template.sqlConFigXml;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * 
 * <p>Title:SQLXmlUtil</p>
 * <p>Description:  SQLxml模板工具类    </p>
 * <p>Copyright: Copyright (c) </p>
 * <p>Company: XXXX</p>
 * <p>Date:2015年1月12日</p>
 * @author CHEN_JIAN
 * @version 1.0
 */

public class SQLXmlUtil {
	private static XStream xstream = null;
	//生成或者读取xml的文件路径
	private static String xmlPath="resources/querys.xml";

	static{
		xmlPath=	System.getProperty("user.dir")+"/src/main/"+xmlPath;
    if(xstream==null){
			xstream=new XStream(new XppDriver() {
				public HierarchicalStreamWriter createWriter(Writer out) {
					return new PrettyPrintWriter(out) {
						// 对所有xml节点的转换都增加CDATA标记
						boolean cdata = true;
						public void startNode(String name, Class clazz) {
							super.startNode(name, clazz);
						}
						protected void writeText(QuickWriter writer, String text) {
							if (cdata) {
								writer.write("<![CDATA[");
								writer.write(text);
								writer.write("]]>");
							} else {
								writer.write(text);
							}
						}
					};
				}
			});
			
			//注册启用注解的实体
			xstream.processAnnotations(new Class[]{sqlConFigXml.class,DeleteTag.class,UpdateTag.class,SelectTag.class,InsertTag.class});
			xstream.autodetectAnnotations(true); 
			xstream.setMode(XStream.NO_REFERENCES);//取消引用
//			xstream.alias("sqlxml", sqlXml.class);
//			xstream.alias("select", SelectCommand.class);
//			xstream.alias("trim", TrimCommand.class);
//			xstream.alias("if", IfCommand.class);
//		    //不显示集合标签 ifCommand
//		    xstream.addImplicitCollection(TrimCommand.class, "ifCommand");
//			xstream.useAttributeFor(SelectCommand.class, "key");
//			xstream.useAttributeFor(SelectCommand.class, "parameterType");
//			xstream.useAttributeFor(SelectCommand.class, "resultType");
//			xstream.useAttributeFor(SelectCommand.class, "author");
//			xstream.useAttributeFor(TrimCommand.class, "prefix");
//			xstream.useAttributeFor(IfCommand.class, "test");	
			
		}
		
	}

/**
 * 生成sql配置文件xml模板字符串
 * @param xml
 * @return
 */
public static String sqlXMLTemplate(sqlConFigXml xml){

	
	return xstream.toXML(xml);
	
}	


/**
 * 将标签序列化生成
 * 对应格式的xml字符串
 * @param tag
 * @return
 */
public static String tagToXml(commTag tag){

	return xstream.toXML(tag);
}
	
/**
 * 根据标签xml字符串
 * 反序列化生成对应的标签对象
 * @param xml
 * @return
 */
public static commTag fromXmlToTag(String xml){

	return (commTag) xstream.fromXML(xml);
}

/**
 * 生成sql配置文件
 * @param xml
 */
public static void CreateSQLXmlFile(sqlConFigXml xml){
		   
		String xmlstr=xstream.toXML(xml);
	   //生成xml;
       BufferedOutputStream Buff = null;
       FileOutputStream fs = null;
      
	try {
	
		//System.getProperty("user.dir") 得到项目路径+src 就可以得到类路径
//	      paths=System.getProperty("user.dir")+"/src/"+xmlPath;//在类路径下生成的文件会自动编译出到class文件夹下
		System.out.println("生成SQL配置文件为："+xmlPath);
		fs = new FileOutputStream(xmlPath);
		
		Buff = new BufferedOutputStream(fs);
		Buff.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes("utf-8"));
//		Buff.write("<!--导入文件的值对象配置 -->\n".getBytes("utf-8"));
	    Buff.write(xmlstr.getBytes("utf-8"));
		Buff.flush();
		Buff.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		
		Close(Buff, fs);
	}
    
    
	   
}

/**
 * 根据sql配置文件反序列
 * 生成sql配置文件模板实体（sqlConFigXml）
 * @return
 */
public static sqlConFigXml fromXMLToSQLTemplate(String xmlPath){
	return (sqlConFigXml) xstream.fromXML(new File(xmlPath));
}
public static void Close(  BufferedOutputStream Buff,FileOutputStream fs) {
		try {
			if(Buff!=null){
				Buff.close();
			}
			if(fs!=null){
				fs.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

public static void main(String[] args) {


		sqlConFigXml xml=new sqlConFigXml();
		SelectTag select=new SelectTag();
		TrimCommand trim=new TrimCommand();
		IfCommand command=new IfCommand();
		command.setTest("name!=null");
		command.setExp("name=#{name}");
		OrderCommand order=new OrderCommand();
		order.setExp(" 123");
		order.setValue("desc");
		trim.setPrefix("where");
		IfCommand commands=new IfCommand();
		commands.setTest("#name!=22");
		commands.setExp("name=#{name}");
		trim.setPrefix("where");
		trim.addIfCommand(command);
		trim.addIfCommand(commands);
		select.setSql("select * from t_user");
		select.setKey("123");
		select.setParameterType("String");
		select.setResultType("xxxxx");
		select.setTrim(trim);
		select.setAuthor("chen_jian");
		select.setOrder(order);
		xml.addTag(select);
//		UpdateTag up=new UpdateTag();
//		up.setKey("9999");
//		up.setParameterType("xxx");
//		up.setSql("update user ");
//		SetCommand set=new SetCommand();
//		set.addIfCommand(commands);
//		WhereCommand where =new WhereCommand();
//		where.addIfCommand(command);
//		IfCommand command4=new IfCommand();
//		command4.setTest("#name!=null");
//		command4.setExp("name=#{name}");
//		command4.setPrefix("and");
//		where.addIfCommand(command4);
//		up.setWhere(where);
//		up.setSet(set);
//		xml.addTag(up);
		
	  String str=SQLXmlUtil.tagToXml(select);
	  
//	  commTag comm=sqlXmlUtil.fromXmlToTag(str);
	//	str=sqlXmlUtil.sqlXMLTemplate(xml);
		SQLXmlUtil.CreateSQLXmlFile(xml);
//		
//     	xml=(sqlConFigXml) xstream.fromXML(str);
     	System.out.println(str);

//		System.out.println(xml.getSelect());
		 
	}

}

	

