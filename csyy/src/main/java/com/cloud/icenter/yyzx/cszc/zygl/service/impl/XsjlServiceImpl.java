package com.cloud.icenter.yyzx.cszc.zygl.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.common.util.excel.reader.ExcelReader;
import com.cloud.icenter.yyzx.cszc.zygl.dao.JbxxDao;
import com.cloud.icenter.yyzx.cszc.zygl.dao.XsjlDao;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.JbxxPojo;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.XsjlPojo;
import com.cloud.icenter.yyzx.cszc.zygl.service.JbxxService;
import com.cloud.icenter.yyzx.cszc.zygl.service.XsjlService;

/** 
* @author zhucy 
* @version 2017年3月23日 上午11:22:29 
* 养护记录
*/
@Logging
@Service
public class XsjlServiceImpl extends BaseServiceImpl<XsjlPojo> implements XsjlService{
	@Autowired
	private XsjlDao xsjlDao;
	@Autowired
	private JbxxDao jbxxDao;
	
	@Override
	public String readExcelData(MultipartFile file,String id,String userId) throws Exception {
		List<XsjlPojo> importDatas = new ArrayList<XsjlPojo>();//存放导入的数据
		//开始读取数据
		InputStream in = null;
        try {
            in = file.getInputStream();
            ExcelReader<XsjlPojo> excelReader = new ExcelReader<XsjlPojo>(
                    0, 6, 1, null, XsjlPojo.class);
            importDatas = excelReader.read(in);
        } catch (Exception e) {
            e.printStackTrace();
            if (e.getMessage().contains("Unparseable date")) {
            	throw new Exception("MSG_导入失败,请检查相关日期格式是否正确,示例:2015/05/08");
			}
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if(null != importDatas && importDatas.size() > 0 ){
        	for (XsjlPojo xsjlPojo : importDatas) {
        		//获取代码
        		JbxxPojo jbxxPojo = jbxxDao.get(id);
        		//天水市城市代码620500
        		String code = "620500"+jbxxPojo.getSsyjflbh()+jbxxPojo.getSsejflbh();
        		xsjlPojo.setDm(code);
        		xsjlPojo.setJbxxId(id);
        		xsjlPojo.setCreateTime(new Date());
        		xsjlPojo.setCreatorId(userId);
        		xsjlPojo.setDeleteStatus("0");
        		if (StringUtil.isEmpty(xsjlPojo.getYhdw())) {
        			throw new Exception("MSG_导入失败,养护单位不能为空");
				}
        		if (StringUtil.isEmpty(xsjlPojo.getZrr())) {
        			throw new Exception("MSG_导入失败,责任人不能为空");
				}
        		if (null == xsjlPojo.getStartTime()) {
        			throw new Exception("MSG_导入失败,开始时间不能为空");
				}
        		if (null == xsjlPojo.getEndTime()) {
        			throw new Exception("MSG_导入失败,结束时间不能为空");
				}
        		if (!xsjlPojo.getEndTime().after(xsjlPojo.getStartTime())) {
        			throw new Exception("MSG_导入失败,结束时间需在开始时间之后");
        		}
        		if (StringUtil.isEmpty(xsjlPojo.getBxyy())) {//报修原因转换
        			throw new Exception("MSG_导入失败,报修原因不能为空");
				}else{
					if (xsjlPojo.getBxyy().equals("破损")) {
						xsjlPojo.setBxyy("1");
					}
					else if (xsjlPojo.getBxyy().equals("丢失")) {
						xsjlPojo.setBxyy("2");
					}
					else if (xsjlPojo.getBxyy().equals("占用")) {
						xsjlPojo.setBxyy("3");
					} else{
						throw new Exception("MSG_导入失败,请正确选择报修原因");
					}
				}
        		if (StringUtil.isEmpty(xsjlPojo.getYhlx())) {//养护类型转换
        			throw new Exception("MSG_导入失败,养护类型不能为空");
				}else{
					if (xsjlPojo.getYhlx().equals("维修")) {
						xsjlPojo.setYhlx("1");
					}
					else if (xsjlPojo.getYhlx().equals("保养")) {
						xsjlPojo.setYhlx("2");
					} else {
						throw new Exception("MSG_导入失败,请正确选择养护类型");
					}
				}
			}
        	xsjlDao.bachSaveObject(importDatas);
        	return "ok";
        }else{
        	return "dataIsNull";
        }
	}
}
