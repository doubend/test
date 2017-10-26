package com.cloud.icenter.yyzx.cszc.zygl.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.common.util.excel.reader.ExcelReader;
import com.cloud.icenter.yyzx.cszc.zygl.dao.HospitalDao;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.HospitalPojo;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.SchoolPojo;
import com.cloud.icenter.yyzx.cszc.zygl.service.HospitalService;

/** 
* @author zhucy 
* @version 2017年3月21日 下午2:54:39 
* 城市资源医院历史信息
*/
@Logging
@Service
public class HospitalServiceImpl extends BaseServiceImpl<HospitalPojo> implements HospitalService{

	@Autowired
	private HospitalDao hospitalDao;
	
	@Override
	public String readExcelData(MultipartFile file,String userId) throws Exception {
		List<HospitalPojo> importDatas = new ArrayList<HospitalPojo>();//存放导入的数据
		//开始读取数据
		InputStream in = null;
        try {
            in = file.getInputStream();
            ExcelReader<HospitalPojo> excelReader = new ExcelReader<HospitalPojo>(
                    0, 6, 1, null, HospitalPojo.class);
            importDatas = excelReader.read(in);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        List<HospitalPojo> useList = new ArrayList<HospitalPojo>();//存放可用的数据
        if(null != importDatas && importDatas.size() > 0 ){
        	for (HospitalPojo hospitalPojo : importDatas) {
        		hospitalPojo.setCreateTime(new Date());
        		hospitalPojo.setCreatorId(userId);
        		hospitalPojo.setDeleteStatus("0");
        		if (StringUtil.isEmpty(hospitalPojo.getYymc())) {
					throw new Exception("MSG_导入失败,医院名称不能为空");
				}
				if (StringUtil.isEmpty(hospitalPojo.getYydj())) {
					throw new Exception("MSG_导入失败,医院等级不能为空");
				}
				if (StringUtil.isEmpty(hospitalPojo.getYylb())) {
					throw new Exception("MSG_导入失败,医院类别不能为空");
				}
				useList.add(hospitalPojo);
			}
        	this.hospitalDao.bachSaveObject(importDatas);
        	// 通过部件标识码去重
//			this.removeDuplicate(importDatas);
//			for (HospitalPojo hospitalPojo : importDatas) {
//				if (!StringUtil.isEmpty(hospitalPojo.getBjbsm())) {// 标识码不为空
//					DetachedCriteria criteria = DetachedCriteria.forClass(HospitalPojo.class);
//					criteria.add(Restrictions.eq("bjbsm", hospitalPojo.getBjbsm()));
//					List<HospitalPojo> pojos = this.find(criteria);
//					if (pojos.size() == 0) {// 查看数据库中是否存在,不存在可以添加
//						useList.add(hospitalPojo);
//					}
//				}else{
//					throw new Exception("MSG_导入失败,部件标识码不能为空");
//				}
//				
//			}
//			if (null != useList && useList.size() > 0) {
//				for (HospitalPojo hospitalPojo : useList) {
//					if (StringUtil.isEmpty(hospitalPojo.getBjbsm())) {
//						throw new Exception("MSG_导入失败,部件标识码不能为空");
//					}
//					
//				}
//				this.hospitalDao.bachSaveObject(useList);
//			}else{
//				throw new Exception("MSG_数据已存在,请更改部件标识码!");
//			}
        	return "ok";
        }else{
        	return "dataIsNull";
        }
	}
	
	
	public static void removeDuplicate(List<HospitalPojo> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = list.size() - 1; j > i; j--) {
				if (list.get(j).getBjbsm().equals(list.get(i).getBjbsm())) {
					list.remove(j);
				}
			}
		}
	}

}
