/**
 * 指标体系数据
 */
/*
var result = {
	status:"0",
	data:{
			"children": [
				{
					"children": [
						{
							"children":[
								{
									"children":null,
									"id": "l3_product_wastewater_discharge",
									"hasStatic": false,
									"modified":false,
									"name":"工业废水排放达标率(%)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.6"
								},
								{
									"children":null,
									"id": "l3_product_flueGas_discharge",
									"hasStatic": false,
									"modified":false,
									"name":"工业废气排放达标率(%)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.4"
								}
							],
							"id": "l2_source_emission",
							"hasStatic": false,
							"modified":false,
							"name":"污染源排放指数",
							"staticKey":null,
							"staticName":null,
							"staticValue":0,
							"value":"0.2"	
						},
						{
							"children":[
								{
									"children":null,
									"id": "l3_air_quality",
									"hasStatic": false,
									"modified":false,
									"name":"空气质量指标(AQI)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.22"
								},
								{
									"children":null,
									"id": "l3_water_quality",
									"hasStatic": false,
									"modified":false,
									"name":"自来水水质指标(WQI)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.14"
								},
								{
									"children":null,
									"id": "l3_riverway_quality",
									"hasStatic": false,
									"modified":false,
									"name":"河道湖泊水质指标(WQI)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.16"
								},
								{
									"children":null,
									"id": "l3_household_garbage_processing_harmless",
									"hasStatic": false,
									"modified":false,
									"name":"生活垃圾无害化处理率(%)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.48"
								}
							],
							"id": "l2_livable_index",
							"hasStatic": false,
							"modified":false,
							"name":"城市宜居指数",
							"staticKey":null,
							"staticName":null,
							"staticValue":0,
							"value":"0.3"	
						},
						{
							"children":[
								{
									"children":null,
									"id": "l3_abnormal_meteorological",
									"hasStatic": false,
									"modified":false,
									"name":"异常气象条件预警数量(条)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"1.0"
								}
							],
							"id": "l2_weather_index",
							"hasStatic": false,
							"modified":false,
							"name":"气象指数",
							"staticKey":null,
							"staticName":null,
							"staticValue":0,
							"value":"0.25"
						}
					],
					"id": "l1_entironment",
					"hasStatic": false,
					"modified":false,
					"name":"生态环境指数",
					"staticKey":null,
					"staticName":null,
					"staticValue":0,
					"value":"0.1"	
				},
				{
					"children": [
						{
							"children":[
								{
									"children":null,
									"id": "l3_product_water_lack",
									"hasStatic": false,
									"modified":false,
									"name":"生产用水供求缺口(万吨)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.63"
								},
								{
									"children":null,
									"id": "l3_life_water_lack",
									"hasStatic": false,
									"modified":false,
									"name":"居民生活用水缺口(万吨)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.37"
								}
							],
							"id": "l2_water_supply",
							"hasStatic": false,
							"modified":false,
							"name":"城市供水指数",
							"staticKey":null,
							"staticName":null,
							"staticValue":0,
							"value":"0.15"
						},
						{
							"children":[
								{
									"children":null,
									"id": "l3_domestic_sewage_rate",
									"hasStatic": false,
									"modified":false,
									"name":"污水处理水平(%)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"1.0"
								}
							],
							"id": "l2_water_drain",
							"hasStatic": false,
							"modified":false,
							"name":"城市排水指数",
							"staticKey":null,
							"staticName":null,
							"staticValue":0,
							"value":"0.2"
						},
						{
							"children":[
								{
									"children":null,
									"id": "l3_publicToilet_number",
									"hasStatic": false,
									"modified":false,
									"name":"万人公厕数(座)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.4"
								},
								{
									"children":null,
									"id": "l3_Park_greenLand_area",
									"hasStatic": false,
									"modified":false,
									"name":"人均公共绿地面积(m3)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.5"
								},
								{
									"children":null,
									"id": "l3_area_greening_coverage",
									"hasStatic": false,
									"modified":false,
									"name":"建成区绿化覆盖率(%)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.1"
								}
							],
							"id": "l2_city_environment",
							"hasStatic": false,
							"modified":false,
							"name":"城市环境指数",
							"staticKey":null,
							"staticName":null,
							"staticValue":0,
							"value":"0.05"
						},
						{
							"children":[
								{
									"children":null,
									"id": "l3_product_power_lack",
									"hasStatic": false,
									"modified":false,
									"name":"工业生产用电供求缺口(万kw/h)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.1"
								},
								{
									"children":null,
									"id": "l3_life_power_lack",
									"hasStatic": false,
									"modified":false,
									"name":"居民用电供求缺口(万kw/h)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.2"
								},
								{
									"children":null,
									"id": "l3_power_supply_level",
									"hasStatic": false,
									"modified":false,
									"name":"供电设施水平(等级)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.1"
								},
								{
									"children":null,
									"id": "l3_life_LPG_lack",
									"hasStatic": false,
									"modified":false,
									"name":"民用液化石油气缺口(万m3)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.05"
								},
								{
									"children":null,
									"id": "l3_life_natgas_lack",
									"hasStatic": false,
									"modified":false,
									"name":"民用天然气供求缺口(万m3)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.3"
								},
								{
									"children":null,
									"id": "l3_product_LPG_lack",
									"hasStatic": false,
									"modified":false,
									"name":"工业用液化石油气缺口(万m3)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.12"
								},
								{
									"children":null,
									"id": "l3_product_natgas_lack",
									"hasStatic": false,
									"modified":false,
									"name":"工业用天然气供求缺口(万m3)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.13"
								}
							],
							"id": "l2_city_energy",
							"hasStatic": false,
							"modified":false,
							"name":"城市能源指数",
							"staticKey":null,
							"staticName":null,
							"staticValue":0,
							"value":"0.3"
						}
					],
					"id": "l1_infrastructure",
					"hasStatic": false,
					"modified":false,
					"name":"基础设施指数",
					"staticKey":null,
					"staticName":null,
					"staticValue":0,
					"value":"0.2"
				},
				{
					"children": [
						{
							"children":[
								{
									"children":null,
									"id": "l3_average_speeds",
									"hasStatic": false,
									"modified":false,
									"name":"道路平均行驶速度(km/h)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.2"
								},
								{
									"children":null,
									"id": "l3_traffic_congestion_time",
									"hasStatic": false,
									"modified":false,
									"name":"交通严重拥堵持续时间(min)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.5"
								},
								{
									"children":null,
									"id": "l3_traffic_congestion_section",
									"hasStatic": false,
									"modified":false,
									"name":"常发拥堵路段数(段)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.3"
								}
							],
							"id": "l2_traffic_congestion",
							"hasStatic": false,
							"modified":false,
							"name":"交通拥堵指数",
							"staticKey":null,
							"staticName":null,
							"staticValue":0,
							"value":"0.5"
						},
						{
							"children":[
								{
									"children":null,
									"id": "l3_passenger_volume_bus",
									"hasStatic": false,
									"modified":false,
									"name":"公交客运量(万人次)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.42"
								},
								{
									"children":null,
									"id": "l3_passenger_volume_taxi",
									"hasStatic": false,
									"modified":false,
									"name":"出租车客运量(人次)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.15"
								},
								{
									"children":null,
									"id": "l3_passenger_volume_long",
									"hasStatic": false,
									"modified":false,
									"name":"长途客运量(万人次)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.12"
								},
								{
									"children":null,
									"id": "l3_passenger_volume_airport",
									"hasStatic": false,
									"modified":false,
									"name":"机场客运量(人次)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.1"
								}
							],
							"id": "l2_passenger_traffic",
							"hasStatic": false,
							"modified":false,
							"name":"城市客运指数",
							"staticKey":null,
							"staticName":null,
							"staticValue":0,
							"value":"0.5"
						}
					],
					"id": "l1_transportation",
					"hasStatic": false,
					"modified":false,
					"name":"交通出行指数",
					"staticKey":null,
					"staticName":null,
					"staticValue":0,
					"value":"0.3"
				},
				{
					"children": [
						{
							"children":[
								{
									"children":null,
									"id": "l3_production_accident_monthly_number",
									"hasStatic": false,
									"modified":false,
									"name":"年度生产事故数量(件)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.47"
								},
								{
									"children":null,
									"id": "l3_production_accident_monthly_casualties",
									"hasStatic": false,
									"modified":false,
									"name":"年度生产事故人身伤亡数量(件)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.53"
								}
							],
							"id": "l2_production_safety",
							"hasStatic": false,
							"modified":false,
							"name":"生产安全指数",
							"staticKey":null,
							"staticName":null,
							"staticValue":0,
							"value":"0.1"
						},
						{
							"children":[
								{
									"children":null,
									"id": "l3_crown_case",
									"hasStatic": false,
									"modified":false,
									"name":"刑事案件日接报警数量(件)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.35"
								},
								{
									"children":null,
									"id": "l3_public_security_cases",
									"hasStatic": false,
									"modified":false,
									"name":"治安案件日接报警数量(件)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.65"
								}
							],
							"id": "l2_public_security",
							"hasStatic": false,
							"modified":false,
							"name":"城市治安指数",
							"staticKey":null,
							"staticName":null,
							"staticValue":0,
							"value":"0.1"
						},
						{
							"children":[
								{
									"children":null,
									"id": "l3_traffic_accident_number",
									"hasStatic": false,
									"modified":false,
									"name":"交通事故日接报警数量(件)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.3"
								},
								{
									"children":null,
									"id": "l3_traffic_accident_AHT",
									"hasStatic": false,
									"modified":false,
									"name":"交通事故平均处理时长(min)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"0.7"
								}
							],
							"id": "l2_traffic_safety",
							"hasStatic": false,
							"modified":false,
							"name":"交通安全指数",
							"staticKey":null,
							"staticName":null,
							"staticValue":0,
							"value":"0.2"
						},
						{
							"children":[
								{
									"children":null,
									"id": "l3_public_health_event",
									"hasStatic": false,
									"modified":false,
									"name":"公共卫生事件日接报警数量(件)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"1.0"
								}
							],
							"id": "l2_public_health",
							"hasStatic": false,
							"modified":false,
							"name":"公共卫生指数",
							"staticKey":null,
							"staticName":null,
							"staticValue":0,
							"value":"0.2"
						},
						{
							"children":[
								{
									"children":null,
									"id": "l3_city_inspectors_case",
									"hasStatic": false,
									"modified":false,
									"name":"城管案件日接报警数量(件)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"1.0"
								}
							],
							"id": "l2_city_inspectors",
							"hasStatic": false,
							"modified":false,
							"name":"城管综合指数",
							"staticKey":null,
							"staticName":null,
							"staticValue":0,
							"value":"0.2"
						},
						{
							"children":[
								{
									"children":null,
									"id": "l3_fire_safety_case",
									"hasStatic": false,
									"modified":false,
									"name":"消防事故日接报警数量(件)",
									"staticKey":null,
									"staticName":null,
									"staticValue":0,
									"value":"1.0"
								}
							],
							"id": "l2_fire_safety",
							"hasStatic": false,
							"modified":false,
							"name":"消防安全指数",
							"staticKey":null,
							"staticName":null,
							"staticValue":0,
							"value":"0.2"
						}
					],
					"id": "l1_public_safety",
					"hasStatic": false,
					"modified":false,
					"name":"公共安全指数",
					"staticKey":null,
					"staticName":null,
					"staticValue":0,
					"value":"0.4"
				}
		],
		"id": "root",
		"hasStatic": false,
		"modified":false,
		"name":"城市体征指数",
		"staticKey":null,
		"staticName":null,
		"staticValue":0,
		"value":"1.0"
	}
};
*/