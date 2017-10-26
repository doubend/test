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
import com.cloud.icenter.yyzx.cstz.pojo.CstzYwzbsjPojo;
import com.cloud.icenter.yyzx.cszc.zygl.dao.SchoolDao;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.SchoolPojo;
import com.cloud.icenter.yyzx.cszc.zygl.service.SchoolService;

/**
 * @author zhucy
 * @version 2017年3月21日 下午2:51:55 城市资源学校历史信息
 */
@Logging
@Service
public class SchoolServiceImpl extends BaseServiceImpl<SchoolPojo> implements SchoolService {

	@Autowired
	private SchoolDao schoolDao;

	@Override
	public String readExcelData(MultipartFile file, String userId) throws Exception {
		List<SchoolPojo> importDatas = new ArrayList<SchoolPojo>();// 存放导入的数据
		// 开始读取数据
		InputStream in = null;
		try {
			in = file.getInputStream();
			ExcelReader<SchoolPojo> excelReader = new ExcelReader<SchoolPojo>(0, 9, 1, null, SchoolPojo.class);
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
		
		List<SchoolPojo> useList = new ArrayList<SchoolPojo>();// 存放可用的数据
		if (null != importDatas && importDatas.size() > 0) {
			for (SchoolPojo schoolPojo : importDatas) {
				schoolPojo.setCreateTime(new Date());
				schoolPojo.setCreatorId(userId);
				schoolPojo.setDeleteStatus("0");
				if (StringUtil.isEmpty(schoolPojo.getXxmc())) {
					throw new Exception("MSG_导入失败,学校名称不能为空");
				}
				if (StringUtil.isEmpty(schoolPojo.getXxlx())) {
					throw new Exception("MSG_导入失败,学校类型不能为空");
				}
				useList.add(schoolPojo);
			}
			this.schoolDao.bachSaveObject(useList);
			return "ok";
			// 通过部件标识码去重,不再需要
//			this.removeDuplicate(importDatas);
//			for (SchoolPojo schoolPojo : importDatas) {
//				if (!StringUtil.isEmpty(schoolPojo.getBjbsm())) {// 标识码不为空
//					DetachedCriteria criteria = DetachedCriteria.forClass(SchoolPojo.class);
//					criteria.add(Restrictions.eq("bjbsm", schoolPojo.getBjbsm()));
//					List<SchoolPojo> pojos = this.find(criteria);
//					if (pojos.size() == 0) {// 查看数据库中是否存在,不存在可以添加
//						useList.add(schoolPojo);
//					}
//				}else{
//					throw new Exception("MSG_导入失败,部件标识码不能为空");
//				}
//			}
		} else {
			return "dataIsNull";
		}
	}

	public static void removeDuplicate(List<SchoolPojo> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = list.size() - 1; j > i; j--) {
				if (list.get(j).getBjbsm().equals(list.get(i).getBjbsm())) {
					list.remove(j);
				}
			}
		}
	}

}
