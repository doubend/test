var ec = echarts;
/*
 * 主要行业增加值
 */
var mainIndustry = ec.init(document.getElementById('mainIndustry'));
mainIndustryOption = {
	backgroundColor: 'rgba(255,255,255,.05)',
	color: [ 
		'#dc5c5a', '#409ad3', '#86b72f', '#32cd32', '#6495ed', 
		'#ff69b4', '#ba55d3', '#cd5c5c', '#ffa500', '#40e0d0', 
		'#1e90ff', '#ff6347', '#7b68ee', '#00fa9a', '#ffd700', 
		'#6b8e23', '#ff00ff', '#3cb371', '#b8860b', '#30e0e0' 
	],
    title : {
        text: '主要行业增加值',
		x:'center',
		textStyle : {
			color: '#348fca',
			fontWeight: 'bold',
			fontFamily: '微软雅黑'
		}
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
		x: 'center',
		y: 'bottom',
        data:['食品制造业','医药制造业','汽车制造业'],
		textStyle : {
			color:'#FFF'
		}
    },
    xAxis : [
        {
			show : true,
            type : 'category',
            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
			splitLine : {
				lineStyle:{
					color: ['#575f6a'],
					width: 1,
					type: 'dashed'
				}
			},
			axisLabel : {
				textStyle : {
					color:'#FFF'
				}
			}
			
        }
    ],
    yAxis : [
        {
            type : 'value',
			splitLine : {
				lineStyle:{
					color: ['#575f6a'],
					width: 1,
					type: 'dashed'
				}
			},
			axisLabel : {
				textStyle : {
					color:'#FFF'
				}
			}
        }
    ],
    series : [
        {
            name:'食品制造业',
            type:'bar',
            data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
            
        },
        {
            name:'医药制造业',
            type:'bar',
            data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
            
        },
		{
            name:'汽车制造业',
            type:'bar',
            data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
        }
    ]
};
mainIndustry.setOption(mainIndustryOption); 

// 国有及国国控股企业
var enterpriseType_01 = ec.init(document.getElementById('enterpriseType_01'));
enterpriseType_01.setOption(enterpriseType_01Option); 
//集体企业
var enterpriseType_02 = ec.init(document.getElementById('enterpriseType_02'));
enterpriseType_02.setOption(enterpriseType_02Option); 
//股份制企业
var enterpriseType_03 = ec.init(document.getElementById('enterpriseType_03'));
enterpriseType_03.setOption(enterpriseType_03Option);
//外商及港澳台商投资企业
var enterpriseType_04 = ec.init(document.getElementById('enterpriseType_04'));
enterpriseType_04.setOption(enterpriseType_04Option); 
//规模以上工业增加值
var industrialBox = ec.init(document.getElementById('industrialBox'));
industrialBox.setOption(industrialOption); 

//小微企业产值
var microCompany = ec.init(document.getElementById('microCompany'));
microCompany.setOption(microCompanyOption); 

// 人口出生率
var subLineBox_01 = ec.init(document.getElementById('subLineBox_01'));
subLineBox_01.setOption(subOption_01);
// 人口死亡率
var subLineBox_02 = ec.init(document.getElementById('subLineBox_02'));
subLineBox_02.setOption(subOption_02);


var mainIndustry = ec.init(document.getElementById('meterBigBox'));






