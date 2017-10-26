package com.cloud.icenter.yyzx.cszc.zygl.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.common.util.excel.ExcelConstants;
import com.cloud.icenter.yyzx.common.util.excel.reader.ExcelReader;
import com.cloud.icenter.yyzx.common.util.excel.writer.ExcelWriter;
import com.cloud.icenter.yyzx.cszc.zygl.dao.BjmbDao;
import com.cloud.icenter.yyzx.cszc.zygl.dao.JbxxDao;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.BjmbPojo;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.JbxxPojo;
import com.cloud.icenter.yyzx.cszc.zygl.service.JbxxService;

/** 
* @author zhucy 
* @version 2017年3月21日 下午2:47:49 
* 城市资源基本信息
*/
@Logging
@Service
public class JbxxServiceImpl extends BaseServiceImpl<JbxxPojo> implements JbxxService{
	
	@Autowired
	private JbxxDao jbxxDao;
	
	@Autowired
	private BjmbDao bjmbDao;
	
	@Override
	public Map<String, Object> readExcelData(MultipartFile file,String userId,String bjmbId) throws Exception {
		Map<String , Object> map = new HashMap<String, Object>();
		List<JbxxPojo> importDatas = new ArrayList<JbxxPojo>();//存放导入的数据
		//开始读取数据
		InputStream in = null;
        try {
            in = file.getInputStream();
            ExcelReader<JbxxPojo> excelReader = new ExcelReader<JbxxPojo>(
                    0, 13, 1, null, JbxxPojo.class);
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
        List<JbxxPojo> dataList = new ArrayList<JbxxPojo>();
        List<JbxxPojo> errorList = new ArrayList<JbxxPojo>();
        if(null != importDatas && importDatas.size() > 0 ){
        	for (JbxxPojo jbxxPojo : importDatas) {
        		//数据合法性校验
        		if (StringUtil.isEmpty(jbxxPojo.getZymc())) {
					jbxxPojo.setErrInfo("资产名称不能为空");
					errorList.add(jbxxPojo);
					throw new Exception("MSG_导入失败,资产名称不能为空");
//					continue;
				}
        		if (StringUtil.isEmpty(jbxxPojo.getSsqy())) {
					jbxxPojo.setErrInfo("所属区域不能为空");
					errorList.add(jbxxPojo);
					throw new Exception("MSG_导入失败,所属区域不能为空");
//					continue;
				}
        		if (null == jbxxPojo.getStartTime()) {
					jbxxPojo.setErrInfo("启用时间不能为空");
					errorList.add(jbxxPojo);
					throw new Exception("MSG_导入失败,启用时间不能为空");
//					continue;
				}
        		if (null == jbxxPojo.getDisabledTime()) {
					jbxxPojo.setErrInfo("废弃时间不能为空");
					errorList.add(jbxxPojo);
					throw new Exception("MSG_导入失败,废弃时间不能为空");
//					continue;
				}
        		if (!jbxxPojo.getDisabledTime().after(jbxxPojo.getStartTime())) {
        			jbxxPojo.setErrInfo("废弃时间需在启用时间之后");
        			errorList.add(jbxxPojo);
        			throw new Exception("MSG_导入失败,废弃时间需在启用时间之后");
//					continue;
				}
        		if (StringUtil.isEmpty(jbxxPojo.getZgbm())) {
					jbxxPojo.setErrInfo("主管部门不能为空");
					errorList.add(jbxxPojo);
					throw new Exception("MSG_导入失败,主管部门不能为空");
//					continue;
				}
        		if (StringUtil.isEmpty(jbxxPojo.getZgbmbh())) {
					jbxxPojo.setErrInfo("主管部门编号不能为空");
					errorList.add(jbxxPojo);
					throw new Exception("MSG_导入失败,主管部门编号不能为空");
//					continue;
				}
        		if (!jbxxPojo.getZgbmbh().matches("[0-9]{11}")) {
					jbxxPojo.setErrInfo("主管部门编号必须为11位为纯数字");
					errorList.add(jbxxPojo);
					throw new Exception("MSG_导入失败,主管部门编号必须为11位为纯数字");
//					continue;
				}
        		if (StringUtil.isEmpty(jbxxPojo.getQsdw())) {
					jbxxPojo.setErrInfo("权属单位不能为空");
					errorList.add(jbxxPojo);
					throw new Exception("MSG_导入失败,权属单位不能为空");
//					continue;
				}
        		if (StringUtil.isEmpty(jbxxPojo.getYhdw())) {
					jbxxPojo.setErrInfo("养护单位不能为空");
					errorList.add(jbxxPojo);
					throw new Exception("MSG_导入失败,养护单位不能为空");
//					continue;
				}
        		if (StringUtil.isEmpty(jbxxPojo.getSsld())) {
					jbxxPojo.setErrInfo("所属路段不能为空");
					errorList.add(jbxxPojo);
					throw new Exception("MSG_导入失败,所属路段不能为空");
//					continue;
				}
        		if (StringUtil.isEmpty(jbxxPojo.getDz())) {
					jbxxPojo.setErrInfo("地址不能为空");
					errorList.add(jbxxPojo);
					throw new Exception("MSG_导入失败,地址不能为空");
//					continue;
				}
        		if (StringUtil.isEmpty(jbxxPojo.getZblx())) {
        			jbxxPojo.setErrInfo("坐标类型 能为空");
					errorList.add(jbxxPojo);
					throw new Exception("MSG_导入失败,坐标类型不能为空");
//					continue;
				}
        		if (StringUtil.isEmpty(jbxxPojo.getZbz())) {
        			jbxxPojo.setErrInfo("坐标组不能为空");
					errorList.add(jbxxPojo);
					throw new Exception("MSG_导入失败,坐标组不能为空");
//					continue;
				}
//        		if (null == jbxxPojo.getX()) {
//					jbxxPojo.setErrInfo("X坐标不能为空");
//					errorList.add(jbxxPojo);
//					throw new Exception("MSG_导入失败,X坐标不能为空");
////					continue;
//				}
//        		String xStr = String.valueOf(jbxxPojo.getX());
//        		if (!xStr.matches("[1-9]{1}[0-9]{2}[.]{1}[0-9]{1,6}")) {
//        			jbxxPojo.setErrInfo("X坐标:请输入首位不能为0的三位整数,小数位不大于六位的数值！");
//        			errorList.add(jbxxPojo);
//        			throw new Exception("MSG_导入失败,X坐标:请输入首位不能为0的三位整数,小数位不大于六位的数值");
////					continue;
//				}
//        		if (null == jbxxPojo.getY()) {
//					jbxxPojo.setErrInfo("Y坐标不能为空");
//					errorList.add(jbxxPojo);
//					throw new Exception("MSG_导入失败,Y坐标不能为空");
////					continue;
//				}
//        		String yStr = String.valueOf(jbxxPojo.getY());
//        		if (!yStr.matches("[1-9]{1}[0-9]{1}[.]{1}[0-9]{1,6}")) {
//        			jbxxPojo.setErrInfo("Y坐标:请输入首位不能为0的两位整数,小数位不大于六位的数值！");
//        			errorList.add(jbxxPojo);
//        			throw new Exception("MSG_导入失败,Y坐标:请输入首位不能为0的两位整数,小数位不大于六位的数值");
////					continue;
//				}
        		if (null == jbxxPojo.getZtmc()) {
					jbxxPojo.setErrInfo("状态名称不能为空");
					errorList.add(jbxxPojo);
					throw new Exception("MSG_导入失败,状态名称不能为空");
//					continue;
				}
        		//通过资源分类id,找到相关分类信息
        		BjmbPojo bjmbPojo = this.bjmbDao.get(bjmbId);
        		if (null != bjmbPojo) {
        			jbxxPojo.setCreateTime(new Date());
            		jbxxPojo.setCreatorId(userId);
            		jbxxPojo.setDeleteStatus("0");
            		jbxxPojo.setSsyjflid(bjmbPojo.getSjbh());
        			jbxxPojo.setSsejflid(bjmbPojo.getId());
        			//编码处理,获取后两位
        			String ejbh = bjmbPojo.getDm();//二级分类代码
        			if (!StringUtil.isEmpty(ejbh)) {
        				String newStr = ejbh.substring(ejbh.length()-2,ejbh.length());//二级分类代码
        				jbxxPojo.setSsejflbh(newStr);
        				String newStr1 = ejbh.substring(ejbh.length()-4,ejbh.length()-2);//一级分类代码
        				jbxxPojo.setSsyjflbh(newStr1);
        			}
        			if (!StringUtil.isEmpty(jbxxPojo.getSsqy())) {//所属区域
						if (jbxxPojo.getSsqy().equals("武山县")) {
							jbxxPojo.setQydm("620524");
						}
						else if (jbxxPojo.getSsqy().equals("甘谷县")) {
							jbxxPojo.setQydm("620523");
						}
						else if (jbxxPojo.getSsqy().equals("秦州区")) {
							jbxxPojo.setQydm("620502");
						}
						else if (jbxxPojo.getSsqy().equals("麦积区")) {
							jbxxPojo.setQydm("620503");
						}
						else if (jbxxPojo.getSsqy().equals("秦安县")) {
							jbxxPojo.setQydm("620522");
						}
						else if (jbxxPojo.getSsqy().equals("清水县")) {
							jbxxPojo.setQydm("620521");
						}
						else if (jbxxPojo.getSsqy().equals("张家川")) {
							jbxxPojo.setQydm("620525");
						} else {
							jbxxPojo.setErrInfo("请正确选择所属区域");
							errorList.add(jbxxPojo);
							throw new Exception("MSG_导入失败,请正确选择所属区域");
//							continue;
						}
					}
        			if (!StringUtil.isEmpty(jbxxPojo.getZblx())) {//坐标类型
						if (jbxxPojo.getZblx().equals("点")) {
							jbxxPojo.setZblx("1");
							if (!jbxxPojo.getZbz().matches("([1-9]{1}[0-9]{2}[.]{1}[0-9]{1,6}[,]{1}[1-9]{1}[0-9]{1}[.]{1}[0-9]{1,6}[;]{1}){1}")) {
								jbxxPojo.setErrInfo("当前坐标类型为点,请输入一组坐标点,分隔符为英文标点,格式为: X,Y;");
								errorList.add(jbxxPojo);
								throw new Exception("MSG_导入失败,当前坐标类型为点,请输入一组坐标点,分隔符为英文标点,格式为: X,Y;");
							}
						}else if (jbxxPojo.getZblx().equals("线")) {
							jbxxPojo.setZblx("2");
							if (!jbxxPojo.getZbz().matches("([1-9]{1}[0-9]{2}[.]{1}[0-9]{1,6}[,]{1}[1-9]{1}[0-9]{1}[.]{1}[0-9]{1,6}[;]{1}){2,}")) {
								jbxxPojo.setErrInfo("当前坐标类型为线,请输入至少两组坐标点,分隔符为英文标点,格式为: X,Y;X,Y;");
								errorList.add(jbxxPojo);
								throw new Exception("MSG_导入失败,当前坐标类型为线,请输入至少两组坐标点,分隔符为英文标点,格式为: X,Y;X,Y;");
							}
						}else if (jbxxPojo.getZblx().equals("面")) {
							jbxxPojo.setZblx("3");
							if (!jbxxPojo.getZbz().matches("([1-9]{1}[0-9]{2}[.]{1}[0-9]{1,6}[,]{1}[1-9]{1}[0-9]{1}[.]{1}[0-9]{1,6}[;]{1}){3,}")) {
								jbxxPojo.setErrInfo("当前坐标类型为面,请输入至少三组坐标点,分隔符为英文标点,格式为: X,Y;X,Y;X,Y;");
								errorList.add(jbxxPojo);
								throw new Exception("MSG_导入失败,当前坐标类型为面,请输入至少三组坐标点,分隔符为英文标点,格式为: X,Y;X,Y;X,Y;");
							}
						}else {
							jbxxPojo.setErrInfo("请正确选择所属坐标类型");
							errorList.add(jbxxPojo);
							throw new Exception("MSG_导入失败,请选择所属坐标类型");
//							continue;
						}
					}
        			if (!StringUtil.isEmpty(jbxxPojo.getZtmc())) {//状态名称
						if (jbxxPojo.getZtmc().equals("完好")) {
							jbxxPojo.setZtdm(1);
						}
						else if (jbxxPojo.getZtmc().equals("破损")) {
							jbxxPojo.setZtdm(2);
						}
						else if (jbxxPojo.getZtmc().equals("丢失")) {
							jbxxPojo.setZtdm(3);
						}
						else if (jbxxPojo.getZtmc().equals("占用")) {
							jbxxPojo.setZtdm(4);
						} else {
							jbxxPojo.setErrInfo("请正确选择状态名称");
							errorList.add(jbxxPojo);
							throw new Exception("MSG_导入失败,请正确选择状态名称");
//							continue;
						}
					}
        			//验证通过,可用数据
        			dataList.add(jbxxPojo);
				}
			}
        	if (null != dataList && dataList.size() > 0 ) {
				jbxxDao.bachSaveObject(dataList);
				map.put("msg", "ok");
			}
        	if (null != errorList && errorList.size() > 0) {
				map.put("error", errorList);
			}
        }else{
        	 map.put("msg", "dataIsNull");
        }
        return map;
        
	}

	@Override
	public List<JbxxPojo> getListByFenlei(String fenlei) {
		return this.jbxxDao.getListByFenlei(fenlei);
	}

	/**
	 * 获取导出模板路径
	 * @param templateName
	 * @return
	 */
    public String completeExcelTemplate(String templateName) {
        String path = this.getClass().getClassLoader().getResource("")
                .getPath();
        StringBuilder tempString = new StringBuilder();
        tempString.append(path).append(File.separator).append("template")
                .append(File.separator).append("excel").append(File.separator)
                .append(File.separator).append(templateName);
        return tempString.toString();
    }
	
	@Override
	public String createErrorFile(List<JbxxPojo> list) {
		String tempPath = System.getProperty("java.io.tmpdir");
        InputStream in = null;
        try {
            String tempFile = this
                    .completeExcelTemplate("城市资产错误数据.xlsx");
            in = new FileInputStream(tempFile);
            ExcelWriter<JbxxPojo> excelWriter = new ExcelWriter<JbxxPojo>(
                    in, "城市资产错误数据", tempPath, ExcelConstants.OFFICE_2007,
                    "sheetName", JbxxPojo.class);
            excelWriter.setStartColumn(0);
            excelWriter.setStartRow(1);
            excelWriter.push(list);
            excelWriter.flush();
            String finalFile = excelWriter.getFinalFile();
            if (null != finalFile) {
                finalFile = finalFile.substring(tempPath.length());
                return finalFile;
            }
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
        return null;
	}

}
