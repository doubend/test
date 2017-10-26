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
        text: '三大产业增长趋势',
		x:'center',
		textStyle : {
			color: '#348fca',
			fontWeight: 'bold',
			fontFamily: '微软雅黑'
		}
    },
    tooltip : {
        trigger: 'axis',
		formatter: "{b}年 <br/>{a} : {c}亿<br/>{a1} : {c1}亿<br/>{a2} : {c2}亿"
    },
    legend: {
		x: 'center',
		y: 'bottom',
        data:['第一产业','第二产业','第三产业'],
		textStyle : {
			color:'#FFF'
		}
    },
    xAxis : [
        {
			show : true,
            type : 'category',
			name : '年',
            data : ['2005','2006','2007','2008','2009','2010','2011','2012','2013','2014'],
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
			name : '亿',
			splitLine : {
				lineStyle:{
					color: ['#575f6a'],
					width: 1,
					type: 'dashed'
				}
			},
			axisLabel : {
				textStyle : {
					color:'#FFF',
					formatter: '{value} 亿'
				}
			}
        }
    ],
    series : [
        {
            name:'第一产业',
            type:'bar',
            data:[80.25, 86.04, 103.38, 129.12, 134.54, 145.1, 166.53, 178.69, 190.3, 198.11]
        },
        {
            name:'第二产业',
            type:'bar',
            data:[112.47, 127.59, 159.96, 206.89, 265.24, 353.13, 494.4, 587.55, 651.93, 706.52]
            
        },
		{
            name:'第三产业',
            type:'bar',
            data:[116.28, 132.91, 153.08, 177.95, 200.32, 231.84, 281.66, 319.02, 360.38, 405.96]
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
//var subLineBox_01 = ec.init(document.getElementById('subLineBox_01'));
//subLineBox_01.setOption(subOption_01);
// 人口死亡率
//var subLineBox_02 = ec.init(document.getElementById('subLineBox_02'));
//subLineBox_02.setOption(subOption_02);


var mainIndustry = ec.init(document.getElementById('meterBigBox'));






