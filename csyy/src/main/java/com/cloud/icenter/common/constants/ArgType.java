package com.cloud.icenter.common.constants;

import java.util.HashSet;
import java.util.Set;

/**
 * 参数类型
 */
public enum ArgType {
	
	STRING("String","字符串"){
        @Override
        public String getBaseFlag(){
            return "1";
        }
        @Override
        public String getTypeName(){
            return STRING.typeName;
        }

	},
	
	BYTE("Byte","数字"){
        @Override
        public String getBaseFlag(){
            return "1";
        }
        @Override
        public String getTypeName(){
            return BYTE.typeName;
        }

	},
	SHORT("Short","数字"){
        @Override
        public String getBaseFlag(){
            return "1";
        }
        @Override
        public String getTypeName(){
            return SHORT.typeName;
        }

	},
	INTEGER("Integer","数字"){
        @Override
        public String getBaseFlag(){
            return "1";
        }
        @Override
        public String getTypeName(){
            return INTEGER.typeName;
        }
	},
	FLOAT("Float","数字"){
        @Override
        public String getBaseFlag(){
            return "1";
        }
        @Override
        public String getTypeName(){
            return FLOAT.typeName;
        }
	},
	DOUBLE("Double","数字"){
        @Override
        public String getBaseFlag(){
            return "1";
        }
        @Override
        public String getTypeName(){
            return DOUBLE.typeName;
        }
	},
	LONG("Long","数字"){
        @Override
        public String getBaseFlag(){
            return "1";
        }
        @Override
        public String getTypeName(){
            return LONG.typeName;
        }
	},
	
	DATE("Date","日期"){
        @Override
        public String getBaseFlag(){
            return "1";
        }
        @Override
        public String getTypeName(){
            return DATE.typeName;
        }
	},
	TIMESTAMP("Timestamp","日期"){
        @Override
        public String getBaseFlag(){
            return "1";
        }
        @Override
        public String getTypeName(){
            return TIMESTAMP.typeName;
        }
	},
	
	LIST("List","集合"){
        @Override
        public String getBaseFlag(){
            return "0";
        }
        @Override
        public String getTypeName(){
            return LIST.typeName;
        }

	},
	SET("Set","集合"){
        @Override
        public String getBaseFlag(){
            return "0";
        }
        @Override
        public String getTypeName(){
            return SET.typeName;
        }

	},
	MAP("Map","集合"){
        @Override
        public String getBaseFlag(){
            return "0";
        }
        @Override
        public String getTypeName(){
            return MAP.typeName;
        }

	},
	VECTOR("Vector","集合"){
        @Override
        public String getBaseFlag(){
            return "0";
        }
        @Override
        public String getTypeName(){
            return VECTOR.typeName;
        }

	},
	
	ARRAY("ARRAY","数组"){
        @Override
        public String getBaseFlag(){
            return "0";
        }
        @Override
        public String getTypeName(){
            return ARRAY.typeName;
        }

	},
	
	OTHER("OTHER","自定义"){
        @Override
        public String getBaseFlag(){
            return "0";
        }
        @Override
        public String getTypeName(){
            return OTHER.typeName;
        }

	};
	
	private String typeName;
	private String type;
	private ArgType(String typeName,String type){
		this.typeName=typeName;
		this.type=type;
	}

    public String getTypeName() {
		return null;
	}

	public abstract String getBaseFlag();

	/**
     * 获取所有参数类型
     * @return
     */
	public static Set<String> typeSet=new HashSet<String>();
	static{
		for(ArgType e:ArgType.values()){
			typeSet.add(e.type);
		}
	}
	
    /**
     * 获取相同type的name集合
     * @return
     */
	public static Set<String> getSameType(String type){
		Set<String> set=new HashSet<String>();
		for(ArgType e:ArgType.values()){
			if(e.type.equals(type)){
				set.add(e.typeName);
			}
		}
		return set;
	}

	
}
