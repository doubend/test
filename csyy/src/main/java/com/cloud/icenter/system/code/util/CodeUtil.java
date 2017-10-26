package com.cloud.icenter.system.code.util;

import org.apache.commons.lang3.StringUtils;

import com.cloud.icenter.common.utils.SpringUtil;
import com.cloud.icenter.system.code.pojo.ResourceCode;
import com.cloud.icenter.system.code.service.ResourceCodeService;
import com.cloud.icenter.system.data.utils.DictConstans;
import com.cloud.icenter.system.organ.pojo.Organ;
import com.cloud.icenter.system.organ.service.OrganService;

/**
 * 编码规则解析
 * @author ynxiea
 *
 */
public class CodeUtil {

	private static OrganService organService;
	
	private static ResourceCodeService codeService;
	
	static {
		organService = SpringUtil.getBean(OrganService.class);
		codeService = SpringUtil.getBean(ResourceCodeService.class);
	}
	
	/**
	 * 判断当前的系统是否已经设置资源编码生成规则
	 * @return
	 */
	public static boolean checkCode() {
		ResourceCode code = codeService.getUsed();
		if (code == null) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 获取分隔标识符
	 * @param value
	 * @return
	 */
	private static String getSpliptSign(String value) {
		if (DictConstans.SPLIPT_SIGN_1.equals(value)) {
			return DictConstans.SPLIPT_SIGN_01;
		} else if (DictConstans.SPLIPT_SIGN_2.equals(value)) {
			return DictConstans.SPLIPT_SIGN_02;
		} else if (DictConstans.SPLIPT_SIGN_03.equals(value)) {
			return DictConstans.SPLIPT_SIGN_03;
		} else {
			return DictConstans.SPLIPT_SIGN_01;
		}
	}
	
	/**
	 * 获取数据项的标识符
	 * @return
	 */
	private static String getNextDataNum(int i, String growValue) {
		if (DictConstans.CODE_IDENTIFIER_01.equals(growValue)) { //三位自增
			if (i>0 & i<10) {
				return "00" +i;
			} else if (i>9 && i<100) {
				return "0" + i;
			} else {
				return String.valueOf(i);
			}
		} else if (DictConstans.CODE_IDENTIFIER_02.equals(growValue)) { //四位自增
			if (i>0 & i<10) {
				return "000" +i;
			} else if (i>9 && i<100) {
				return "00" + i;
			} else if (i>99 && i<1000) {
				return "0" + i;
			} else {
				return String.valueOf(i);
			}
		} else if (DictConstans.CODE_IDENTIFIER_03.equals(growValue)) { //五位自增
			if (i>0 & i<10) {
				return "0000" +i;
			} else if (i>9 && i<100) {
				return "000" + i;
			} else if (i>99 && i<1000) {
				return "00" + i;
			} else if (i>999 && i<10000) {
				return "0" + i;
			} else {
				return String.valueOf(i);
			}
		} else if (DictConstans.CODE_IDENTIFIER_04.equals(growValue)) { //六位自增
			if (i>0 & i<10) {
				return "00000" +i;
			} else if (i>9 && i<100) {
				return "0000" + i;
			} else if (i>99 && i<1000) {
				return "000" + i;
			} else if (i>999 && i<10000) {
				return "00" + i;
			} else if (i>9999 && i<100000) {
				return "0" + i;
			} else {
				return String.valueOf(i);
			}
		} else if (DictConstans.CODE_IDENTIFIER_05.equals(growValue)) { //七位自增
			if (i>0 & i<10) {
				return "000000" +i;
			} else if (i>9 && i<100) {
				return "00000" + i;
			} else if (i>99 && i<1000) {
				return "0000" + i;
			} else if (i>999 && i<10000) {
				return "000" + i;
			} else if (i>9999 && i<100000) {
				return "00" + i;
			} else if (i>99999 && i<1000000) {
				return "0" + i;
			} else {
				return String.valueOf(i);
			}
		} else {
			if (i>0 & i<10) {
				return "0000000" +i;
			} else if (i>9 && i<100) {
				return "000000" + i;
			} else if (i>99 && i<1000) {
				return "00000" + i;
			} else if (i>999 && i<10000) {
				return "0000" + i;
			} else if (i>9999 && i<100000) {
				return "000" + i;
			} else if (i>99999 && i<1000000) {
				return "00" + i;
			} else if (i>999999 && i<10000000) {
				return "0" + i;
			} else {
				return String.valueOf(i);
			}
		}
	}
	
	//获取开始编码
	private static int getStartNum(String last) {
		int currentNum = 0 ;
		if (!StringUtils.isEmpty(last)) {
			if (last.startsWith("0000000")) {
				currentNum = Integer.parseInt(last.substring(7));
			} else if (last.startsWith("000000")) {
				currentNum = Integer.parseInt(last.substring(6));
			} else if (last.startsWith("00000")) {
				currentNum = Integer.parseInt(last.substring(5));
			} else if (last.startsWith("0000")) {
				currentNum = Integer.parseInt(last.substring(4));
			} else if (last.startsWith("000")) {
				currentNum = Integer.parseInt(last.substring(3));
			} else if (last.startsWith("00")) {
				currentNum = Integer.parseInt(last.substring(2));
			} else if (last.startsWith("0")) {
				currentNum = Integer.parseInt(last.substring(1));
			} else {
				try {
					currentNum = Integer.parseInt(last);
				} catch (NumberFormatException e) {
					currentNum++;
					return currentNum;
				}
			}
			currentNum++;
			return currentNum;
		}
		return ++currentNum;
	}
	
	/**
	 * 获取自增编号
	 * @return
	 */
	private static String getIdentifierValue(String organId, String growValue) {
		String resourceNum = codeService.getCurrentCode(organId);
		if (resourceNum == null) {
			if (DictConstans.CODE_IDENTIFIER_01.equals(growValue)) {
				return "001"; //三位自增
			} else if (DictConstans.CODE_IDENTIFIER_02.equals(growValue)) {
				return "0001"; //四位自增
			} else if (DictConstans.CODE_IDENTIFIER_03.equals(growValue)) {
				return "00001"; //五位自增
			} else if (DictConstans.CODE_IDENTIFIER_04.equals(growValue)) {
				return "000001"; //六位自增
			} else if (DictConstans.CODE_IDENTIFIER_05.equals(growValue)) {
				return "0000001"; //七位自增
			} else {
				return "00000001"; //八位自增
			}
		} else {
			if (DictConstans.CODE_IDENTIFIER_01.equals(growValue)) {
				String last = resourceNum.substring(resourceNum.length()-3);
				int currentNum = getStartNum(last);
				return getNextDataNum(currentNum, growValue);
			} else if (DictConstans.CODE_IDENTIFIER_02.equals(growValue)) {
				String last = resourceNum.substring(resourceNum.length()-4);
				int currentNum = getStartNum(last);
				return getNextDataNum(currentNum, growValue);
			} else if (DictConstans.CODE_IDENTIFIER_03.equals(growValue)) {
				String last = resourceNum.substring(resourceNum.length()-5);
				int currentNum = getStartNum(last);
				return getNextDataNum(currentNum, growValue);
			} else if (DictConstans.CODE_IDENTIFIER_04.equals(growValue)) {
				String last = resourceNum.substring(resourceNum.length()-6);
				int currentNum = getStartNum(last);
				return getNextDataNum(currentNum, growValue);
			} else if (DictConstans.CODE_IDENTIFIER_05.equals(growValue)) {
				String last = resourceNum.substring(resourceNum.length()-7);
				int currentNum = getStartNum(last);
				return getNextDataNum(currentNum, growValue);
			} else {
				String last = resourceNum.substring(resourceNum.length()-8);
				int currentNum = getStartNum(last);
				return getNextDataNum(currentNum, growValue);
			}
		}
	}
	
	/**
	 * 获取下一个编码
	 * @return
	 */
	public static String getNextCode(String organId) {
		StringBuilder sb = new StringBuilder();
		ResourceCode code = codeService.getUsed();
		if (code != null) {
			//设置前段码
			sb.append(code.getPreCode());
			
			//设置分隔符
			sb.append(getSpliptSign(code.getSpliptSign())); 
			
			//设置组织机构编码为：生成规则一部分
			if (DictConstans.DATA_STATUS_VALID.equals(code.getIsUseOrgan())) {
				Organ organ = organService.get(organId);
				if (organ != null && !StringUtils.isEmpty(organ.getCode())) {
					sb.append(organ.getCode());
				} else {
					sb.append(DictConstans.CODE_DEFAULT);
				}
			}
			
			//设置自增方式
			sb.append(getIdentifierValue(organId, code.getGrowType()));
		}
		return sb.toString();
	}
	
}
