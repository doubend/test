package com.cloud.icenter.system.data.utils;

public class DictConstans {
	//判定是否点了上报
	public static final String REPORT_CHECK = "report";
	
	/**
	 * 信息资源类型： 1=结构化数据， 2=非结构化数据，3=标准服务接口，4=第三方接口
	 */
	public static final String RESOURCE_TYPE_01 = "1";
	public static final String RESOURCE_TYPE_02 = "2";
	public static final String RESOURCE_TYPE_03 = "3";
	public static final String RESOURCE_TYPE_04 = "4";
	
	/**
	 * 唯一标识：区分 第三方接口和标准服务接口 1==第三方接口  2==标准服务接口
	 */
	public static final String DIVERSITY_1 = "1";
	public static final String DIVERSITY_2 = "2";
	/**
	 * 流程状态：0==未发起，1==审核中,2==已办结，3==退回
	 */
	public static final String FLOW_STATUS_0 = "0";
	public static final String FLOW_STATUS_1 = "1";
	public static final String FLOW_STATUS_2 = "2";
	public static final String FLOW_STATUS_3 = "3";
	/**
	 * 视图分类 1=主题分类，2=政府机构分类，3=行业分类，4=资源形态分类
	 */
	public static final String VIEW_STATUS_1 = "1";
	public static final String VIEW_STATUS_2 = "2";
	public static final String VIEW_STATUS_3 = "3";
	public static final String VIEW_STATUS_4 = "4";
	/**
	 * 信息资源状态： 0==未发布 , 1==已发布, 2==已取消, 3 =已删除
	 */
	public static final String RESOURCE_STATUS_0 = "0";
	public static final String RESOURCE_STATUS_1 = "1";
	public static final String RESOURCE_STATUS_2 = "2";
	public static final String RESOURCE_STATUS_3 = "3";
	
	//待办业务类型 : 1==需求申请,2==资源发布,3==资源变更 ,4==服务申请,5==资源删除,6==非结构化服务申请
	public static final String BUSINESS_TYPE = "businessType";
	public static final String BUSINESS_TYPE_1 = "1";
	public static final String BUSINESS_TYPE_2 = "2";
	public static final String BUSINESS_TYPE_3 = "3";
	public static final String BUSINESS_TYPE_4 = "4";
	public static final String BUSINESS_TYPE_5 = "5";
	public static final String BUSINESS_TYPE_6 = "6";
	/**
	 * 申请类型： 0==获取服务，1==对比申请，2==订阅申请
	 */
	public static final String ApplyType_0 = "0";
	public static final String ApplyType_1 = "1";
	public static final String ApplyType_2 = "2";
	/**
	 * 共享设置： 0==不可共享，1==共享，2==条件共享
	 */
	public static final String ShareType_0 = "0";
	public static final String ShareType_1 = "1";
	public static final String ShareType_2 = "2";
	/**
	 * 对比设置 ： 0==不可对比   1==可对比
	 */
	public static final String IS_COMPARE_0 = "0";
	public static final String IS_COMPARE_1 = "1";
	
	/**
	 * 资源变更类型：自动检测 = 1， 变更资源版本 =2
	 */
	public static final String RESOURCE_CHANGE_1 = "1";
	public static final String RESOURCE_CHANGE_2 = "2";
	
	/**
	 * 信息资源数据项变更时，操作状态： 1=新增， 2=修改， 3=删除
	 */
	public static final String DATA_ITEM_1 = "1";
	public static final String DATA_ITEM_2 = "2";
	public static final String DATA_ITEM_3 = "3";
	
	/**
	 * 应用系统应用模式，操作状态： 1=单机， 2=C/S， 3=B/S,4=多层模式，5=其他
	 */
	public static final String APPLICATION_MODEL_1 = "1";
	public static final String APPLICATION_MODEL_2 = "2";
	public static final String APPLICATION_MODEL_3 = "3";
	public static final String APPLICATION_MODEL_4 = "4";
	public static final String APPLICATION_MODEL_5 = "5";
	
	/**
	 * 应用系统应用阶段，操作状态： 1=再用， 2=在研， 3=规划,4=停用，5=建造，6=即将退役，7=退役，8=废弃
	 */
	public static final String APPLICATION_PHASE_1 = "1";
	public static final String APPLICATION_PHASE_2 = "2";
	public static final String APPLICATION_PHASE_3 = "3";
	public static final String APPLICATION_PHASE_4 = "4";
	public static final String APPLICATION_PHASE_5 = "5";
	public static final String APPLICATION_PHASE_6 = "6";
	public static final String APPLICATION_PHASE_7 = "7";
	public static final String APPLICATION_PHASE_8 = "8";
	
	/**
	 * 应用系统应用层次，操作状态： 01=业务应用，02=决策支持与管理， 03=渠道接入,04=交互控制，05=基础设施应用，06=管理/控制应用，07=安全应用，08=批处理应用,09=SaaS应用
	 */
	public static final String APPLICATION_LEVEL_01 = "01";
	public static final String APPLICATION_LEVEL_02 = "02";
	public static final String APPLICATION_LEVEL_03 = "03";
	public static final String APPLICATION_LEVEL_04 = "04";
	public static final String APPLICATION_LEVEL_05 = "05";
	public static final String APPLICATION_LEVEL_06 = "06";
	public static final String APPLICATION_LEVEL_07 = "07";
	public static final String APPLICATION_LEVEL_08 = "08";
	public static final String APPLICATION_LEVEL_09 = "09";

	/**
	 * 应用系统开发模式，操作状态： 001=自主开发，002=外包定制开发， 003=商用套件
	 */
	public static final String DEVELOPMENT_MODEL_001 = "001";
	public static final String DEVELOPMENT_MODEL_002 = "002";
	public static final String DEVELOPMENT_MODEL_003 = "003";
	
	/**
	 * 应用系统使用网络，操作状态： 1=政务内网， 2=政务外网， 3=专网，4=互联网
	 */
	public static final String USE_NETWORK_1 = "1";
	public static final String USE_NETWORK_2 = "2";
	public static final String USE_NETWORK_3 = "3";
	public static final String USE_NETWORK_4 = "4";
	
	/**
	 * 非结构化数据的类型，操作状态： 1=办公文档， 2=文本， 3=图片，4=报表，5=图像
	 * 					   6=音频/视频，7=HTML，8=XML,9=其他
	 */
	public static final String FILE_TYPE_1 = "1";
	public static final String FILE_TYPE_2 = "2";
	public static final String FILE_TYPE_3 = "3";
	public static final String FILE_TYPE_4 = "4";
	public static final String FILE_TYPE_5 = "5";
	public static final String FILE_TYPE_6 = "6";
	public static final String FILE_TYPE_7 = "7";
	public static final String FILE_TYPE_8 = "8";
	public static final String FILE_TYPE_9 = "9";
	/**
	 * 是否有效状态：1=有效， 2=无效
	 */
	public static final String DATA_VALID_1 = "1";
	public static final String DATA_VALID_2 = "2";
	
	/**逻辑删除: 有效  正常显示 */
    public static final String DATA_STATUS_VALID = "1";
    /**逻辑删除: 无效 删除状态 */
    public static final String DATA_STATUS_INVALID = "0";
    
    /** 申请类型：数据字典code  */
    public static final String DICT_APPLY_TYPE = "applyType";
    /** 非结构服务类型： */
    public static final String DICT_UNSTRUCT_TYPE = "unStructCode";
    /** 组织机构 */
    public static final String ORGAN_STATUS = "true";
    
    /** 分隔符"/"斜杠 */
	public static final String SPLIPT_SIGN_1 = "1";
	/** 分隔符"\"反斜杠 */
	public static final String SPLIPT_SIGN_2 = "2";
	/** 分隔符"|"竖杠 */
	public static final String SPLIPT_SIGN_3 = "3";
    
	/** 分隔符"/"斜杠 */
	public static final String SPLIPT_SIGN_01 = "/";
	/** 分隔符"\"反斜杠 */
	public static final String SPLIPT_SIGN_02 = "\\";
	/** 分隔符"|"竖杠 */
	public static final String SPLIPT_SIGN_03 = "|";
	/** 当委办局的code为空时，设置该more编码 */
	public static final String CODE_DEFAULT = "ZHCS";
	
	/** 自增方式：三位自增 */
	public static final String CODE_IDENTIFIER_01 = "1";
	/** 自增方式：四位自增 */
	public static final String CODE_IDENTIFIER_02 = "2";
	/** 自增方式：五位自增 */
	public static final String CODE_IDENTIFIER_03 = "3";
	/** 自增方式：六位自增 */
	public static final String CODE_IDENTIFIER_04 = "4";
	/** 自增方式：七位自增 */
	public static final String CODE_IDENTIFIER_05 = "5";
}
