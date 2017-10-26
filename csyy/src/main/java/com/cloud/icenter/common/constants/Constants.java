package com.cloud.icenter.common.constants;


import com.cloud.icenter.common.utils.SystemConfig;
import com.cloud.icenter.common.utils.TreeNode;


/**
 * 全局常量类
 * @ClassName: Constants
 * @Description:
 * @author zhangle
 * @email  lezhang@isoftstone.com
 * @date 2013年9月21日 下午9:30:37     
 */ 
public final class Constants {
	
	//登录验证码存放在session中的key
	public static final String VERIFY_CODE_SESSION_KEY="VERIFY_CODE_SESSION_KEY";
	//登录的用户对象存放在session中的key
	public static final String LOGIN_USER_SESSION_KEY="LOGIN_USER_SESSION_KEY";
	//是否启用登录验证码
	public static final boolean ENABLE_VERIFY_CODE=Boolean.parseBoolean(SystemConfig.getProperty("isShowValidateCode"));
	
	//登录页面地址
	public static final String LOGIN_PAGE="/login";
	//权限不够,拒绝访问页面
	public static final String ACCESS_DENIED_PAGE="/jsp/system/access_denied.jsp";
	//系统错误页面
	public static final String SYSTEM_ERROR_PAGE="/jsp/system/error.jsp";
	//超时
	public static long REQUEST_TIMEOUT=300;
	//sql条件操作符
    public static enum CompareType {
        GT, GTE, LT, LTE, EQ, NE,EQUAL, LIKE, COMPARE, NOT_LIKE
    }
         
    //主题库
    public static final String SUBJECT = "0";
    //专题库
    public static final String SUBJECT_SPECIAL = "1";
    
    //提供方
    public static final String RELATION_TYPE_1 = "provide";
    //维护方
    public static final String RELATION_TYPE_2 = "maintain";
    
    //数据库类型
   	public static final String DB_MYSQL = "MySQL";    
   	public static final String DB_ORACLE = "Oracle";  
    
    //全局定义，数据状态  0 代表未删除 有效状态    1代表删除 无效状态
    
    //任务运行失败
    public static final int DATA_STATUS_FAILD = 2;
    /** 有效  正常显示 */
    public static final int DATA_STATUS_VALID = 1;
    /** 无效 删除状态 */
    public static final int DATA_STATUS_INVALID = 0;
    /** * 申请类型：获取 */
    public static final String APPLY_TYPE_01 = "0";
    /** * 申请类型：比对 */
    public static final String APPLY_TYPE_02 = "1";
    /** * 申请类型：订阅 */
    public static final String APPLY_TYPE_03 = "2";
    
    //系统编码
    public static final String BASE_SYS_CODE = "100000";
    //基础库系统编码
    public static final String JCK_SYS_CODE = "200000";
    //主题库系统编码
    public static final String ZTK_SYS_CODE = "300000";
    /**
     * 管理员角色
     */
    public static final String ROLE_ADMIN = "admin";
    /**
     * 开发人员角色
     */
    public static final String ROLE_ADMIN_DEVELOPER = "developer";
    /**
     * 中心管理员角色
     */
    public static final String ROLE_CENTER = "center";
    /**
     * 部门角色
     */
    public static final String ROLE_DEPT = "department";
    
    /** 目录层级：一层 */
    public static final int CATALOG_FIRST = 1;
    /** 目录层级：一层 */
    public static final int CATALOG_SECOND = 2;
    /** 目录层级：一层 */
    public static final int CATALOG_THIRD = 3;
    /** 目录层级：一层 */
    public static final int CATALOG_FOURTH = 4;
    /** 目录层级：一层 */
    public static final int CATALOG_FIVETH = 5;
    
    /** 资源形态分类的code */    
    //public static final String CITY_NAME = SystemConfig.getProperty("city_name");
    
    public static final String TOTAL_OTHERS_NAME = "其他";
    
    /**数据库类型*/
    // mysql
    public static final int MYSQL = 1;
    // oracle
    public static final int ORACLE = 2;
    // PostgreSQL
    public static final int POSTGRESQL = 3;
    // SQLite
    public static final int SQLITE = 4;
    // SQLServer
    public static final int SQLSERVER = 5;
    // Maria DB
    public static final int MARIADB = 6;
    
    //是、否
    public static final String YES="1";
    public static final String NO="0";

    public enum DataType{
    	NUM , FLO , STR , YEAR , OTHER , TIME , TEXT
    }
    
    public enum MySqlColumnsDataType{
    	//数值类型
    	TINYINT("TINYINT" , 255L , null , true , true , true , DataType.NUM , true),
    	SMALLINT("SMALLINT" , 255L , null , true , true , true , DataType.NUM , false),
    	MEDIUMINT("MEDIUMINT" , 255L , null , true , true , true , DataType.NUM , false),
    	INT("INT" , 255L , null , true , true , true , DataType.NUM , true),
    	BIGINT("BIGINT" , 255L , null , true , true , true , DataType.NUM , false),
    	//浮点型
    	FLOAT("FLOAT" , 255L , 30L , true , true , true , DataType.FLO , true),
    	DOUBLE("DOUBLE" , null , null , true , true , true , DataType.FLO, true),//
    	REAL("REAL" , null , null , true , true , true , DataType.FLO , false),//
    	DECIMAL("DECIMAL" , 255L , 30L , true , true , false , DataType.FLO , true),//
    	NUMERIC("NUMERIC" , 255L , 30L , true , true , false , DataType.FLO , true),//

    	//字符型
    	CHAR("CHAR" , 255L , null , true , false , true , DataType.STR , true),
    	VARCHAR("VARCHAR" , 20000L , null , false , false , true , DataType.STR , true),
    	TINYBLOB("TINYBLOB" , null , null , true , false , false , DataType.STR , false),
    	TINYTEXT("TINYTEXT" , null , null , true , false , false , DataType.STR , false),
    	BLOB("BLOB" , null , null , true , false , false , DataType.STR, false),
    	TEXT("TEXT" , null , null , true , false , false , DataType.STR, false),
    	MEDIUMBLOB("MEDIUMBLOB" , null , null , true , false , false , DataType.STR, false),
    	MEDIUMTEXT("MEDIUMTEXT" , null , null , true , false , false , DataType.STR, false),
    	LONGBLOB("LONGBLOB" , null , null , true , false , false , DataType.STR, false),
    	LONGTEXT("LONGTEXT" , null , null , true , false , false , DataType.STR, false),
    	ENUM("ENUM" , null , null , true , false , true , DataType.STR, false),//
    	SET("SET" , null , null , true , false , true , DataType.STR, false),//
    	//日期类型
    	YEAR("YEAR" , null , null , true , true , true , DataType.YEAR, false),
    	DATE("DATE" , null , null , true , false , false , DataType.YEAR, false),
    	TIME("TIME" , null , null , true , false , false , DataType.YEAR, false),
    	DATETIME("DATETIME" , null , null , true , false , false , DataType.YEAR, false),
    	TIMESTAMP("TIMESTAMP" , null , null , true , false , false , DataType.YEAR, false),
    	//other
    	BINARY("BINARY" , null , null , true , false , false , DataType.OTHER, false),//
    	BIT("BIT" , null , null , true , false , false , DataType.OTHER, false),//
    	BOOL("BOOL" , null , null , true , false , false , DataType.OTHER, false),//
    	BOOLEAN("BOOLEAN" , null , null , true , false , false , DataType.OTHER, false),//
    	VARBINARY("VARBINARY" , 50000L , null , true , false , false , DataType.OTHER, false);//
    	MySqlColumnsDataType(String name , Long maxLength , Long decimalLength , boolean canNull , boolean onlyNum , boolean canDefVal , DataType type , boolean canKey){
    		this.name = name;
    		this.maxLength = maxLength;//最大长度
    		this.canNull = canNull;//是否允许不填长度
    		this.onlyNum = onlyNum;//是否只允许数字类型
    		this.decimalLength = decimalLength;//小数位长度
    		this.canDefVal = canDefVal;//是否允许默认值
    		this.type = type;
    		this.canKey = canKey;
    	}
    	
    	private String name;
    	
    	private Long maxLength;
    	
    	private Long decimalLength;
    	
    	private boolean canNull;
    	
    	private boolean onlyNum;
    	
    	private boolean canDefVal;
    	
    	private DataType type;
    	
    	private boolean canKey;

		public String getName() {
			return name;
		}

		public Long getMaxLength() {
			return maxLength;
		}

		public boolean isCanNull() {
			return canNull;
		}

		public boolean isOnlyNum() {
			return onlyNum;
		}

		public Long getDecimalLength() {
			return decimalLength;
		}

		public boolean isCanDefVal() {
			return canDefVal;
		}
		
		public boolean isCanKey() {
			return canKey;
		}

		/**
		 * @return the type
		 */
		public DataType getType() {
			return type;
		}
    }
    
    public enum OracleColumnsDataType{
    	BINARY_DOUBLE("BINARY_DOUBLE" , null , null , true , true , true , "NUM" , true),
    	BINARY_FLOAT("BINARY_FLOAT" , null , null , true , true , true , "NUM" , true),
    	BLOB("BLOB" , null , null , true , false , false , "STR" , false),
    	CLOB("CLOB" , null , null , true , false , false , "STR" , false),
    	CHAR("CHAR" , 2000L , null , false , false , true , "STR" , false),
    	DATE("DATE" , null , null , true , false , false , "DATE" , false),
    	INTERVAL_DAY_TO_SECOND("INTERVAL DAY TO SECOND" , null , null , true , false , false , "DATE" , false),
    	INTERVAL_YEAR_TO_MONTH("INTERVAL YEAR TO MONTH" , null , null , true , false , false , "DATE" , false),
    	LONG("LONG" , null , null , true , false , false , "STR" , false),
    	LONG_RAW("LONG RAW" , null , null , true , false , false , "STR" , false),
    	NCLOB("NCLOB" , null , null , true , false , false , "STR" , false),
    	NUMBER("NUMBER" , 38L , null , true , false , true , "NUM" , false),
    	NVARCHAR2("NVARCHAR2" , 2000L , null , false , false , true , "STR" , false),
    	RAW("RAW" , 2000L , null , false , false , true , "STR" , false),
    	TIMESTAMP("TIMESTAMP" , null , null , true , false , false , "DATE" , false),
    	TIMESTAMP_WITH_LOCAL_TIME_ZONE("TIMESTAMP WITH LOCAL TIME ZONE" , null , null , true , false , false , "DATE" , false),
    	TIMESTAMP_WITH_TIME_ZONE("TIMESTAMP WITH TIME ZONE" , null , null , true , false , false , "DATE" , false),
    	VARCHAR2("VARCHAR2" , 2000L , null , false , false , true , "STR" , true);
    	/////////////////////////////////////////////////////////////////////////////////
    	OracleColumnsDataType(String name , Long maxLength , Long decimalLength , boolean canNull , boolean onlyNum , boolean canDefVal , String type , boolean canKey){
    		this.name = name;
    		this.maxLength = maxLength;//最大长度
    		this.canNull = canNull;//是否允许不填长度
    		this.onlyNum = onlyNum;//是否只允许数字类型
    		this.decimalLength = decimalLength;//小数位长度
    		this.canDefVal = canDefVal;//是否允许默认值
    		this.type = type;
    		this.canKey = canKey;
    	}
    	
    	private String name;
    	
    	private Long maxLength;
    	
    	private Long decimalLength;
    	
    	private boolean canNull;
    	
    	private boolean onlyNum;
    	
    	private boolean canDefVal;
    	
    	private String type;//类型
    	
    	private boolean canKey;//是否可以为主键

		public String getName() {
			return name;
		}

		public Long getMaxLength() {
			return maxLength;
		}

		public boolean isCanNull() {
			return canNull;
		}

		public boolean isOnlyNum() {
			return onlyNum;
		}

		public Long getDecimalLength() {
			return decimalLength;
		}

		public boolean isCanDefVal() {
			return canDefVal;
		}

		public String getType() {
			return type;
		}

		public boolean isCanKey() {
			return canKey;
		}
    }
    
    public enum SqlServerColumnsDataType{
    	
    	IMAGE("IMAGE" , null , null , true , false , false , DataType.TEXT , false),//图片
    	TEXT("TEXT" , null , null , true , false , false , DataType.TEXT , false),
    	UNIQUEIDENTIFIER("UNIQUEIDENTIFIER" , null , null , true , false , false , DataType.TEXT , false),
    	DATE("DATE" , null , null , true , false , false , DataType.TIME , false),
    	TIME("TIME" , null , null , true ,false , false , DataType.TIME , false),
    	DATETIME2("DATETIME2" , null , null , true , false , false , DataType.TIME , false),
    	DATETIMEOFFSET("DATETIMEOFFSET" , null , null , true , false , false , DataType.TIME , false),
    	TINYINT("TINYINT" , null , null , true , true , true , DataType.NUM , true),
    	SMALLINT("SMALLINT" , null , null , true , true , true , DataType.NUM , true),
    	INT("INT" , null , null , true , true , true , DataType.NUM , true),
    	SMALLDATETIME("SMALLDATETIME" , null , null , true , false , false , DataType.TIME , false),
    	REAL("REAL" , null , null , true , true , true , DataType.NUM , true),
    	MONEY("MONEY" , null , null , true , true , true , DataType.NUM , true),
    	DATETIME("DATETIME" , null , null , true , false , false , DataType.TIME , false),
    	FLOAT("FLOAT" , 53L , null , true , true , true , DataType.NUM , true),
    	SQL_VARIANT("SQL_VARIANT" , null , null , true , false , false , DataType.TEXT , false),
    	NTEXT("NTEXT" , null , null , true , false , false , DataType.TEXT , false),
    	BIT("BIT" , null , null , true , true , true , DataType.NUM , true),
    	DECIMAL("DECIMAL" , 38L , 5L , true , true , true , DataType.FLO , true),
    	NUMERIC("NUMERIC" , 38L , 38L , true , true , true , DataType.FLO , true),
    	SMALLMONEY("SMALLMONEY" , null , null , true , true , true , DataType.NUM , true),
    	BIGINT("BIGINT" , null , null , true , true , true , DataType.NUM , true),
    	HIERARCHYID("HIERARCHYID" , null , null , true , false , false , DataType.OTHER , false),
    	GEOMETRY("GEOMETRY" , null , null , true , false , false , DataType.OTHER , false),
    	GEOGRAPHY("GEOGRAPHY" , null , null , true , false , false , DataType.OTHER , false),
    	VARBINARY("VARBINARY" , null , null , true , false , false , DataType.OTHER , false),
    	VARCHAR("VARCHAR" , 8000L , null , true , false , true , DataType.STR , true),
    	BINARY("BINARY" , null , null , true , true , true , DataType.NUM , false),
    	CHAR("CHAR" , 3000L , null , true , false , true , DataType.STR , true),
    	TIMESTAMP("TIMESTAMP", null , null , true , false , false , DataType.TIME , false),
    	NVARCHAR("NVARCHAR" , 4000L , null , true , false , true , DataType.STR , false),
    	NCHAR("NCHAR" , 4000L , null , true , false , true , DataType.STR , false),
    	XML("XML" , null , null , true , false , false , DataType.OTHER , false),
    	SYSNAME("SYSNAME" , null , null , true , false , false , DataType.OTHER , false);
    	
    	private String name;
    	
    	private Long maxLength;
    	
    	private Long decimalLength;
    	
    	private boolean canNull;
    	
    	private boolean onlyNum;
    	
    	private boolean canDefVal;
    	
    	private DataType type;//类型
    	
    	private boolean canKey;//是否可以为主键
    	
    	private SqlServerColumnsDataType(String name , Long maxLength , Long decimalLength , boolean canNull , boolean onlyNum , boolean canDefVal , DataType type , boolean canKey) {
    		this.name = name;
    		this.maxLength = maxLength;//最大长度
    		this.canNull = canNull;//是否允许不填长度
    		this.onlyNum = onlyNum;//是否只允许数字类型
    		this.decimalLength = decimalLength;//小数位长度
    		this.canDefVal = canDefVal;//是否允许默认值
    		this.type = type;
    		this.canKey = canKey;
		}

		public String getName() {
			return name;
		}

		public Long getMaxLength() {
			return maxLength;
		}

		public Long getDecimalLength() {
			return decimalLength;
		}

		public boolean isCanNull() {
			return canNull;
		}

		public boolean isOnlyNum() {
			return onlyNum;
		}

		public boolean isCanDefVal() {
			return canDefVal;
		}

		public DataType getType() {
			return type;
		}

		public boolean isCanKey() {
			return canKey;
		}
    }
    
    /**
     *  插件类型枚举定义
     *  输入、输出、清洗、比对
     *  此枚举定义结构与TreeNode相似，仅缺少少数几个属性
     *  text与iconCls不开放set方法，仅children开放set方法
     *  @see TreeNode
     * @author charo
     *
     */
    public enum PluginsType{
    	READER("输入" , "ifont ifont-folder") , WRITER("输出" , "ifont ifont-folder") , PROCESSOR("数据清洗" , "ifont ifont-folder") , CONTRAST("数据对比" , "ifont ifont-folder");
    	PluginsType(String text , String iconCls){
    		this.text = text;
    		this.iconCls = iconCls;
    	}
    	private String text;
    	private String iconCls;
		public String getText() {
			return text;
		}
		public String getIconCls() {
			return iconCls;
		}
    }
}







