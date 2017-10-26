$('.lineItem').on({
	'mouseenter': function(){
		//console.log($(this).find('.subLineBox'));
		if($(this).hasClass('hover')){
			$(this).removeClass('hover');
		}
	}
});
$('.MapAreaItem').on({
	'mouseenter': function(){
		if($(this).hasClass('hover')){
			$(this).removeClass('hover');
		}
	}
});

setInterval(function(){
	var iRandom = getRandom(0,3);
	$('.lineItem').eq(iRandom).addClass('hover');
	setTimeout(function(){
		$('.lineItem').eq(iRandom).removeClass('hover');
	}, 2500);
	
}, 5000);

function getRandom(min, max){
	var _max = max || min;
	var _min = max ? min : 0;
	return parseInt(Math.random() * (_max - _min+1) + _min);
}

var ec = echarts;
/*
 * 主要行业增加值
 */
var projectUrl=document.getElementById('projectUrl').innerHTML.trim();
var nian=new Array();
var first_industry=new Array();
var secondary_industry=new Array();
var tertiary_industry=new Array();
$.ajax({
	url : projectUrl+'/main/getSdcy',
	type : 'post',
	async: false,
	dataType : 'json',
	success : function(data){
		$.each(data,function(i,value){
			nian.push(value.NIAN);
			first_industry.push(value.FIRST_INDUSTRY);
			secondary_industry.push(value.SECONDARY_INDUSTRY);
			tertiary_industry.push(value.TERTIARY_INDUSTRY);
		});
	}
});
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
            data : nian,
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
			min:0,
			max:350,
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
            type:'line',
            data:first_industry
        },
        {
            name:'第二产业',
            type:'line',
            data:secondary_industry
            
        },
		{
            name:'第三产业',
            type:'line',
            data:tertiary_industry
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






