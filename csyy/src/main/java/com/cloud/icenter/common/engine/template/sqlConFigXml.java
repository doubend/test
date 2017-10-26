package com.cloud.icenter.common.engine.template;

import java.util.ArrayList;
import java.util.List;

import com.cloud.icenter.common.engine.tag.commTag;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;


/**
 * 
 * <p>Title:sqlConFigXml</p>
 * <p>Description:sql配置文件模板   </p>
 * <p>Copyright: Copyright (c) </p>
 * <p>Company: XXXX</p>
 * <p>Date:2015年1月3日</p>
 * @author CHEN_JIAN
 * @version 1.0
 */
@XStreamAlias(value="sqlXml")
public class sqlConFigXml {     
	//去掉集合节点
	@XStreamImplicit 
	private List<commTag> tags;



   public void addTag(commTag tag){
	   if(tags==null){
		   tags=new ArrayList<commTag>(0);
	   }
	   tags.add(tag);
   }



}
