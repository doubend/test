/*
 * 人口出生率
 */	
subOption_01 = {
    color: ['#FFF'],
    backgroundColor: 'rgba(0,122,204,.9)',
    tooltip: {
        trigger: "item",
        formatter: "{a} <br/>{b} : {c}%"
    },
    grid: {
        x: 0,
        x2: 0,
        y: 10,
        y2: 0,
        borderWidth: 0
    },
    lineStyle: {
        color: '#FFF',
        width: 10
    },
    xAxis: [{
        type: "category",
        name: "x",
        axisTick: false,
        splitLine: {
            show: false
        },
        data: ["2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010"]
    }],
    yAxis: [{
        type: "log",
        name: "y",
        axisLine: false,
        axisTick: false,
        axisLabel: false,
        splitLine: {
            show: false
        },
        splitArea: false
    }],
    series: [{
        name: "人口出生率",
        type: "line",
        itemStyle: {
            normal: {
                lineStyle: {
                    color: '#FFF'
                }
            }
        },
        data: [8, 9.5, 8.6, 9, 7, 6, 3, 6, 8]

    }]
};

/*
 * 人口死亡率
 */	
subOption_02 = {
    color: ['#FFF'],
    backgroundColor: 'rgba(161,53,34,.9)',
    tooltip: {
        trigger: "item",
        formatter: "{a} <br/>{b} : {c}%"
    },
    grid: {
        x: 0,
        x2: 0,
        y: 10,
        y2: 0,
        borderWidth: 0
    },
    lineStyle: {
        color: '#FFF',
        width: 10
    },
    xAxis: [{
        type: "category",
        name: "x",
        axisTick: false,
        splitLine: {
            show: false
        },
        data: ["2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010"]
    }],
    yAxis: [{
        type: "log",
        name: "y",
        axisLine: false,
        axisTick: false,
        axisLabel: false,
        splitLine: {
            show: false
        },
        splitArea: false
    }],
    series: [{
        name: "人口死亡率",
        type: "line",
        itemStyle: {
            normal: {
                lineStyle: {
                    color: '#FFF'
                }
            }
        },
        data: [8, 9.5, 8.6, 9, 7, 6, 3, 6, 8]
    }]
};
/*
 * 自然增长率
 */	
subOption_03 = {
    color: ['#FFF'],
    backgroundColor: 'rgba(62,142,2,.9)',
    tooltip: {
        trigger: "item",
        formatter: "{a} <br/>{b} : {c}%"
    },
    grid: {
        x: 0,
        x2: 0,
        y: 10,
        y2: 0,
        borderWidth: 0
    },
    lineStyle: {
        color: '#FFF',
        width: 10
    },
    xAxis: [{
        type: "category",
        name: "x",
        axisTick: false,
        splitLine: {
            show: false
        },
        data: ["2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010"]
    }],
    yAxis: [{
        type: "log",
        name: "y",
        axisLine: false,
        axisTick: false,
        axisLabel: false,
        splitLine: {
            show: false
        },
        splitArea: false
    }],
    series: [{
        name: "自然增长率",
        type: "line",
        itemStyle: {
            normal: {
                lineStyle: {
                    color: '#FFF'
                }
            }
        },
        data: [8, 9.5, 8.6, 9, 7, 6, 3, 6, 8]

    }]
};

/*
 * 各区人口综合数据
 * dataIndex 1:崇安区 2:南长区 3:北塘区 4:锡山区 5:惠山区 6:滨湖区 7:江阴市 8:宜兴市 9:新区
 * 未压缩的参考：peopleData_bak.js
 */

//var peopleData = [];
var projectUrl=document.getElementById('projectUrl').innerHTML.trim();
var array = [];
$.ajax({
	url : projectUrl+'/main/getAreaInfo',
	type : 'post',
	async: false,
	dataType : 'json',
	success : function(data){
		array=data;
	}
});

var allInfo=[];
$.ajax({
	url : projectUrl+'/main/getAllInfo',
	type : 'post',
	async: false,
	dataType : 'json',
	success : function(data){
		allInfo=data;
	}
});
	

	//console.log(array);
var peopleData=[[{'dataIndex':1,'name':'户籍人口','data':array[0].HJRK,'iUnit':'万'},{'dataIndex':2,'name':'流动人口','data':array[0].LDRK,'iUnit':'万'},{'dataIndex':3,'name':'家庭户','data':allInfo[0].JTH.toString(),'iUnit':'万'},{'dataIndex':4,'name':'男性人口','data':array[0].MAN,'iUnit':'万'},{'dataIndex':5,'name':'女性人口','data':array[0].WOMAN,'iUnit':'万'},{'dataIndex':6,'name':'男女性别比','data':array[0].NNXBB,'iUnit':'%'},{'dataIndex':7,'name':'0-14岁','data':array[0].YEAR_0_14_P,'iUnit':'%'},{'dataIndex':8,'name':'15-64岁','data':array[0].YEAR_15_64_P,'iUnit':'%'},{'dataIndex':9,'name':'65岁','data':array[0].YEAR_65_P,'iUnit':'%'},{'dataIndex':10,'name':'人口出生率','data':allInfo[0].BIRTH_RATE.toString(),'iUnit':'‰'},{'dataIndex':11,'name':'人口死亡率','data':allInfo[0].DIE_RATE.toString(),'iUnit':'‰'},{'dataIndex':12,'name':'自然增长率','data':allInfo[0].GROWTH_RATE.toString(),'iUnit':'‰'},{'dataIndex':13,'name':'文盲人口','data':allInfo[0].ILLITERATE.toString(),'iUnit':''},{'dataIndex':14,'name':'文盲率','data':allInfo[0].ILL_PROP.toString(),'iUnit':''},{'dataIndex':15,'name':'晚婚率','data':allInfo[0].MARRIAGE_RATE.toString(),'iUnit':'%'},{'dataIndex':16,'name':'计划生育率','data':allInfo[0].BIRTH_CONTROL_RATE.toString(),'iUnit':'‰'},{'dataIndex':17,'name':'结婚对数','data':allInfo[0].MARRIAGES.toString(),'iUnit':'对'},{'dataIndex':18,'name':'离婚对数','data':allInfo[0].DIVORCES.toString(),'iUnit':'对'}],
                [{'dataIndex':1,'name':'户籍人口','data':array[1].HJRK,'iUnit':'万'},{'dataIndex':2,'name':'流动人口','data':array[1].LDRK,'iUnit':'万'},{'dataIndex':3,'name':'家庭户','data':allInfo[1].JTH.toString(),'iUnit':'万'},{'dataIndex':4,'name':'男性人口','data':array[1].MAN,'iUnit':'万'},{'dataIndex':5,'name':'女性人口','data':array[1].WOMAN,'iUnit':'万'},{'dataIndex':6,'name':'男女性别比','data':array[1].NNXBB,'iUnit':'%'},{'dataIndex':7,'name':'0-14岁','data':array[1].YEAR_0_14_P,'iUnit':'%'},{'dataIndex':8,'name':'15-64岁','data':array[1].YEAR_15_64_P,'iUnit':'%'},{'dataIndex':9,'name':'65岁','data':array[1].YEAR_65_P,'iUnit':'%'},{'dataIndex':10,'name':'人口出生率','data':allInfo[1].BIRTH_RATE.toString(),'iUnit':'‰'},{'dataIndex':11,'name':'人口死亡率','data':allInfo[1].DIE_RATE.toString(),'iUnit':'‰'},{'dataIndex':12,'name':'自然增长率','data':allInfo[1].GROWTH_RATE.toString(),'iUnit':'‰'},{'dataIndex':13,'name':'文盲人口','data':allInfo[1].ILLITERATE.toString(),'iUnit':''},{'dataIndex':14,'name':'文盲率','data':allInfo[1].ILL_PROP.toString(),'iUnit':''},{'dataIndex':15,'name':'晚婚率','data':allInfo[1].MARRIAGE_RATE.toString(),'iUnit':'%'},{'dataIndex':16,'name':'计划生育率','data':allInfo[1].BIRTH_CONTROL_RATE.toString(),'iUnit':'‰'},{'dataIndex':17,'name':'结婚对数','data':allInfo[1].MARRIAGES.toString(),'iUnit':'对'},{'dataIndex':18,'name':'离婚对数','data':allInfo[1].DIVORCES.toString(),'iUnit':'对'}],
                [{'dataIndex':1,'name':'户籍人口','data':array[2].HJRK,'iUnit':'万'},{'dataIndex':2,'name':'流动人口','data':array[2].LDRK,'iUnit':'万'},{'dataIndex':3,'name':'家庭户','data':allInfo[2].JTH.toString(),'iUnit':'万'},{'dataIndex':4,'name':'男性人口','data':array[2].MAN,'iUnit':'万'},{'dataIndex':5,'name':'女性人口','data':array[2].WOMAN,'iUnit':'万'},{'dataIndex':6,'name':'男女性别比','data':array[2].NNXBB,'iUnit':'%'},{'dataIndex':7,'name':'0-14岁','data':array[2].YEAR_0_14_P,'iUnit':'%'},{'dataIndex':8,'name':'15-64岁','data':array[2].YEAR_15_64_P,'iUnit':'%'},{'dataIndex':9,'name':'65岁','data':array[2].YEAR_65_P,'iUnit':'%'},{'dataIndex':10,'name':'人口出生率','data':allInfo[2].BIRTH_RATE.toString(),'iUnit':'‰'},{'dataIndex':11,'name':'人口死亡率','data':allInfo[2].DIE_RATE.toString(),'iUnit':'‰'},{'dataIndex':12,'name':'自然增长率','data':allInfo[2].GROWTH_RATE.toString(),'iUnit':'‰'},{'dataIndex':13,'name':'文盲人口','data':allInfo[2].ILLITERATE.toString(),'iUnit':''},{'dataIndex':14,'name':'文盲率','data':allInfo[2].ILL_PROP.toString(),'iUnit':''},{'dataIndex':15,'name':'晚婚率','data':allInfo[2].MARRIAGE_RATE.toString(),'iUnit':'%'},{'dataIndex':16,'name':'计划生育率','data':allInfo[2].BIRTH_CONTROL_RATE.toString(),'iUnit':'‰'},{'dataIndex':17,'name':'结婚对数','data':allInfo[2].MARRIAGES.toString(),'iUnit':'对'},{'dataIndex':18,'name':'离婚对数','data':allInfo[2].DIVORCES.toString(),'iUnit':'对'}],
                [{'dataIndex':1,'name':'户籍人口','data':array[3].HJRK,'iUnit':'万'},{'dataIndex':2,'name':'流动人口','data':array[3].LDRK,'iUnit':'万'},{'dataIndex':3,'name':'家庭户','data':allInfo[3].JTH.toString(),'iUnit':'万'},{'dataIndex':4,'name':'男性人口','data':array[3].MAN,'iUnit':'万'},{'dataIndex':5,'name':'女性人口','data':array[3].WOMAN,'iUnit':'万'},{'dataIndex':6,'name':'男女性别比','data':array[3].NNXBB,'iUnit':'%'},{'dataIndex':7,'name':'0-14岁','data':array[3].YEAR_0_14_P,'iUnit':'%'},{'dataIndex':8,'name':'15-64岁','data':array[3].YEAR_15_64_P,'iUnit':'%'},{'dataIndex':9,'name':'65岁','data':array[3].YEAR_65_P,'iUnit':'%'},{'dataIndex':10,'name':'人口出生率','data':allInfo[3].BIRTH_RATE.toString(),'iUnit':'‰'},{'dataIndex':11,'name':'人口死亡率','data':allInfo[3].DIE_RATE.toString(),'iUnit':'‰'},{'dataIndex':12,'name':'自然增长率','data':allInfo[3].GROWTH_RATE.toString(),'iUnit':'‰'},{'dataIndex':13,'name':'文盲人口','data':allInfo[3].ILLITERATE.toString(),'iUnit':''},{'dataIndex':14,'name':'文盲率','data':allInfo[3].ILL_PROP.toString(),'iUnit':''},{'dataIndex':15,'name':'晚婚率','data':allInfo[3].MARRIAGE_RATE.toString(),'iUnit':'%'},{'dataIndex':16,'name':'计划生育率','data':allInfo[3].BIRTH_CONTROL_RATE.toString(),'iUnit':'‰'},{'dataIndex':17,'name':'结婚对数','data':allInfo[3].MARRIAGES.toString(),'iUnit':'对'},{'dataIndex':18,'name':'离婚对数','data':allInfo[3].DIVORCES.toString(),'iUnit':'对'}],
                [{'dataIndex':1,'name':'户籍人口','data':array[4].HJRK,'iUnit':'万'},{'dataIndex':2,'name':'流动人口','data':array[4].LDRK,'iUnit':'万'},{'dataIndex':3,'name':'家庭户','data':allInfo[4].JTH.toString(),'iUnit':'万'},{'dataIndex':4,'name':'男性人口','data':array[4].MAN,'iUnit':'万'},{'dataIndex':5,'name':'女性人口','data':array[4].WOMAN,'iUnit':'万'},{'dataIndex':6,'name':'男女性别比','data':array[4].NNXBB,'iUnit':'%'},{'dataIndex':7,'name':'0-14岁','data':array[4].YEAR_0_14_P,'iUnit':'%'},{'dataIndex':8,'name':'15-64岁','data':array[4].YEAR_15_64_P,'iUnit':'%'},{'dataIndex':9,'name':'65岁','data':array[4].YEAR_65_P,'iUnit':'%'},{'dataIndex':10,'name':'人口出生率','data':allInfo[4].BIRTH_RATE.toString(),'iUnit':'‰'},{'dataIndex':11,'name':'人口死亡率','data':allInfo[4].DIE_RATE.toString(),'iUnit':'‰'},{'dataIndex':12,'name':'自然增长率','data':allInfo[4].GROWTH_RATE.toString(),'iUnit':'‰'},{'dataIndex':13,'name':'文盲人口','data':allInfo[4].ILLITERATE.toString(),'iUnit':''},{'dataIndex':14,'name':'文盲率','data':allInfo[4].ILL_PROP.toString(),'iUnit':''},{'dataIndex':15,'name':'晚婚率','data':allInfo[4].MARRIAGE_RATE.toString(),'iUnit':'%'},{'dataIndex':16,'name':'计划生育率','data':allInfo[4].BIRTH_CONTROL_RATE.toString(),'iUnit':'‰'},{'dataIndex':17,'name':'结婚对数','data':allInfo[4].MARRIAGES.toString(),'iUnit':'对'},{'dataIndex':18,'name':'离婚对数','data':allInfo[4].DIVORCES.toString(),'iUnit':'对'}],
                [{'dataIndex':1,'name':'户籍人口','data':array[5].HJRK,'iUnit':'万'},{'dataIndex':2,'name':'流动人口','data':array[5].LDRK,'iUnit':'万'},{'dataIndex':3,'name':'家庭户','data':allInfo[5].JTH.toString(),'iUnit':'万'},{'dataIndex':4,'name':'男性人口','data':array[5].MAN,'iUnit':'万'},{'dataIndex':5,'name':'女性人口','data':array[5].WOMAN,'iUnit':'万'},{'dataIndex':6,'name':'男女性别比','data':array[5].NNXBB,'iUnit':'%'},{'dataIndex':7,'name':'0-14岁','data':array[5].YEAR_0_14_P,'iUnit':'%'},{'dataIndex':8,'name':'15-64岁','data':array[5].YEAR_15_64_P,'iUnit':'%'},{'dataIndex':9,'name':'65岁','data':array[5].YEAR_65_P,'iUnit':'%'},{'dataIndex':10,'name':'人口出生率','data':allInfo[5].BIRTH_RATE.toString(),'iUnit':'‰'},{'dataIndex':11,'name':'人口死亡率','data':allInfo[5].DIE_RATE.toString(),'iUnit':'‰'},{'dataIndex':12,'name':'自然增长率','data':allInfo[5].GROWTH_RATE.toString(),'iUnit':'‰'},{'dataIndex':13,'name':'文盲人口','data':allInfo[5].ILLITERATE.toString(),'iUnit':''},{'dataIndex':14,'name':'文盲率','data':allInfo[5].ILL_PROP.toString(),'iUnit':''},{'dataIndex':15,'name':'晚婚率','data':allInfo[5].MARRIAGE_RATE.toString(),'iUnit':'%'},{'dataIndex':16,'name':'计划生育率','data':allInfo[5].BIRTH_CONTROL_RATE.toString(),'iUnit':'‰'},{'dataIndex':17,'name':'结婚对数','data':allInfo[5].MARRIAGES.toString(),'iUnit':'对'},{'dataIndex':18,'name':'离婚对数','data':allInfo[5].DIVORCES.toString(),'iUnit':'对'}],
                [{'dataIndex':1,'name':'户籍人口','data':array[6].HJRK,'iUnit':'万'},{'dataIndex':2,'name':'流动人口','data':array[6].LDRK,'iUnit':'万'},{'dataIndex':3,'name':'家庭户','data':allInfo[6].JTH.toString(),'iUnit':'万'},{'dataIndex':4,'name':'男性人口','data':array[6].MAN,'iUnit':'万'},{'dataIndex':5,'name':'女性人口','data':array[6].WOMAN,'iUnit':'万'},{'dataIndex':6,'name':'男女性别比','data':array[6].NNXBB,'iUnit':'%'},{'dataIndex':7,'name':'0-14岁','data':array[6].YEAR_0_14_P,'iUnit':'%'},{'dataIndex':8,'name':'15-64岁','data':array[6].YEAR_15_64_P,'iUnit':'%'},{'dataIndex':9,'name':'65岁','data':array[6].YEAR_65_P,'iUnit':'%'},{'dataIndex':10,'name':'人口出生率','data':allInfo[6].BIRTH_RATE.toString(),'iUnit':'‰'},{'dataIndex':11,'name':'人口死亡率','data':allInfo[6].DIE_RATE.toString(),'iUnit':'‰'},{'dataIndex':12,'name':'自然增长率','data':allInfo[6].GROWTH_RATE.toString(),'iUnit':'‰'},{'dataIndex':13,'name':'文盲人口','data':allInfo[6].ILLITERATE.toString(),'iUnit':''},{'dataIndex':14,'name':'文盲率','data':allInfo[6].ILL_PROP.toString(),'iUnit':''},{'dataIndex':15,'name':'晚婚率','data':allInfo[6].MARRIAGE_RATE.toString(),'iUnit':'%'},{'dataIndex':16,'name':'计划生育率','data':allInfo[6].BIRTH_CONTROL_RATE.toString(),'iUnit':'‰'},{'dataIndex':17,'name':'结婚对数','data':allInfo[6].MARRIAGES.toString(),'iUnit':'对'},{'dataIndex':18,'name':'离婚对数','data':allInfo[6].DIVORCES.toString(),'iUnit':'对'}],
                [{'dataIndex':1,'name':'户籍人口','data':array[7].HJRK,'iUnit':'万'},{'dataIndex':2,'name':'流动人口','data':array[7].LDRK,'iUnit':'万'},{'dataIndex':3,'name':'家庭户','data':allInfo[7].JTH.toString(),'iUnit':'万'},{'dataIndex':4,'name':'男性人口','data':array[7].MAN,'iUnit':'万'},{'dataIndex':5,'name':'女性人口','data':array[7].WOMAN,'iUnit':'万'},{'dataIndex':6,'name':'男女性别比','data':array[7].NNXBB,'iUnit':'%'},{'dataIndex':7,'name':'0-14岁','data':array[7].YEAR_0_14_P,'iUnit':'%'},{'dataIndex':8,'name':'15-64岁','data':array[7].YEAR_15_64_P,'iUnit':'%'},{'dataIndex':9,'name':'65岁','data':array[7].YEAR_65_P,'iUnit':'%'},{'dataIndex':10,'name':'人口出生率','data':allInfo[7].BIRTH_RATE.toString(),'iUnit':'‰'},{'dataIndex':11,'name':'人口死亡率','data':allInfo[7].DIE_RATE.toString(),'iUnit':'‰'},{'dataIndex':12,'name':'自然增长率','data':allInfo[7].GROWTH_RATE.toString(),'iUnit':'‰'},{'dataIndex':13,'name':'文盲人口','data':allInfo[7].ILLITERATE.toString(),'iUnit':''},{'dataIndex':14,'name':'文盲率','data':allInfo[7].ILL_PROP.toString(),'iUnit':''},{'dataIndex':15,'name':'晚婚率','data':allInfo[7].MARRIAGE_RATE.toString(),'iUnit':'%'},{'dataIndex':16,'name':'计划生育率','data':allInfo[7].BIRTH_CONTROL_RATE.toString(),'iUnit':'‰'},{'dataIndex':17,'name':'结婚对数','data':allInfo[7].MARRIAGES.toString(),'iUnit':'对'},{'dataIndex':18,'name':'离婚对数','data':allInfo[7].DIVORCES.toString(),'iUnit':'对'}],
                [{'dataIndex':1,'name':'户籍人口','data':array[8].HJRK,'iUnit':'万'},{'dataIndex':2,'name':'流动人口','data':array[8].LDRK,'iUnit':'万'},{'dataIndex':3,'name':'家庭户','data':allInfo[8].JTH.toString(),'iUnit':'万'},{'dataIndex':4,'name':'男性人口','data':array[8].MAN,'iUnit':'万'},{'dataIndex':5,'name':'女性人口','data':array[8].WOMAN,'iUnit':'万'},{'dataIndex':6,'name':'男女性别比','data':array[8].NNXBB,'iUnit':'%'},{'dataIndex':7,'name':'0-14岁','data':array[8].YEAR_0_14_P,'iUnit':'%'},{'dataIndex':8,'name':'15-64岁','data':array[8].YEAR_15_64_P,'iUnit':'%'},{'dataIndex':9,'name':'65岁','data':array[8].YEAR_65_P,'iUnit':'%'},{'dataIndex':10,'name':'人口出生率','data':allInfo[8].BIRTH_RATE.toString(),'iUnit':'‰'},{'dataIndex':11,'name':'人口死亡率','data':allInfo[8].DIE_RATE.toString(),'iUnit':'‰'},{'dataIndex':12,'name':'自然增长率','data':allInfo[8].GROWTH_RATE.toString(),'iUnit':'‰'},{'dataIndex':13,'name':'文盲人口','data':allInfo[8].ILLITERATE.toString(),'iUnit':''},{'dataIndex':14,'name':'文盲率','data':allInfo[8].ILL_PROP.toString(),'iUnit':''},{'dataIndex':15,'name':'晚婚率','data':allInfo[8].MARRIAGE_RATE.toString(),'iUnit':'‰'},{'dataIndex':16,'name':'计划生育率','data':allInfo[8].BIRTH_CONTROL_RATE.toString(),'iUnit':'‰'},{'dataIndex':17,'name':'结婚对数','data':allInfo[8].MARRIAGES.toString(),'iUnit':'对'},{'dataIndex':18,'name':'离婚对数','data':allInfo[8].DIVORCES.toString(),'iUnit':'对'}],
                [{'dataIndex':1,'name':'户籍人口','data':array[9].HJRK,'iUnit':'万'},{'dataIndex':2,'name':'流动人口','data':array[9].LDRK,'iUnit':'万'},{'dataIndex':3,'name':'家庭户','data':allInfo[9].JTH.toString(),'iUnit':'万'},{'dataIndex':4,'name':'男性人口','data':array[9].MAN,'iUnit':'万'},{'dataIndex':5,'name':'女性人口','data':array[9].WOMAN,'iUnit':'万'},{'dataIndex':6,'name':'男女性别比','data':array[9].NNXBB,'iUnit':'%'},{'dataIndex':7,'name':'0-14岁','data':array[9].YEAR_0_14_P,'iUnit':'%'},{'dataIndex':8,'name':'15-64岁','data':array[9].YEAR_15_64_P,'iUnit':'%'},{'dataIndex':9,'name':'65岁','data':array[9].YEAR_65_P,'iUnit':'%'},{'dataIndex':10,'name':'人口出生率','data':allInfo[9].BIRTH_RATE.toString(),'iUnit':'‰'},{'dataIndex':11,'name':'人口死亡率','data':allInfo[9].DIE_RATE.toString(),'iUnit':'‰'},{'dataIndex':12,'name':'自然增长率','data':allInfo[9].GROWTH_RATE.toString(),'iUnit':'‰'},{'dataIndex':13,'name':'文盲人口','data':allInfo[9].ILLITERATE.toString(),'iUnit':''},{'dataIndex':14,'name':'文盲率','data':allInfo[9].ILL_PROP.toString(),'iUnit':''},{'dataIndex':15,'name':'晚婚率','data':allInfo[9].MARRIAGE_RATE.toString(),'iUnit':'‰'},{'dataIndex':16,'name':'计划生育率','data':allInfo[9].BIRTH_CONTROL_RATE.toString(),'iUnit':'‰'},{'dataIndex':17,'name':'结婚对数','data':allInfo[9].MARRIAGES.toString(),'iUnit':'对'},{'dataIndex':18,'name':'离婚对数','data':allInfo[9].DIVORCES.toString(),'iUnit':'对'}]];

//console.log(peopleData);
/*
 * 各区教育数据
 * schoolOption 
 *  1索镇
	2起凤镇
	3田庄镇
	4荆家镇
	5马桥镇
	6新城镇
	7唐山镇
	8果里镇
	9城区
 */
schoolOption = [
	{
		backgroundColor: 'rgba(255,255,255,.05)',
		title : {
			text: '教育状况',
			subtext: '6岁及以上各种受教育程度人口（人）',
			x:'center',
			textStyle : {
				color: '#348fca',
				fontWeight: 'bold',
				fontFamily: '微软雅黑'
			}
		},
		tooltip : {
			trigger: 'item',
			formatter: "{a} <br/>{b} : {c} ({d}%)"
		},
		series : [
			{
				name:'教育状况',
				type:'pie',
				center: ['50%', '58%'],
				radius : ['40%', '60%'],
				data:[
					//{value: allInfo[9].NOSCHOOLING,  name:'幼儿园'},
					{value: allInfo[9].PRIMARY_SCHOOL,  name:'小学'},
					{value: allInfo[9].JUNIOR_SCHOOL,  name:'初中'},
					//{value: allInfo[9].SENIOR_SCHOOL,  name:'高中'},
					//{value: allInfo[9].COLLEGE,  name:'职业学校'},
					//{value: allInfo[9].UNIVERSITY,  name:'大学本科及以上'}
					{value: allInfo[9].ZXXJZGRS,  name:'中小学教职工'}
				]
			}
		]
	},
	{
		title : {
			text: '教育状况',
			subtext: '6岁及以上各种受教育程度人口（人） -  索镇',
			x:'center',
			textStyle : {
				color: '#348fca',
				fontWeight: 'bold',
				fontFamily: '微软雅黑'
			}
		},
		tooltip : {
			trigger: 'item',
			formatter: "{a} <br/>{b} : {c} ({d}%)"
		},
		series : [
			{
				name:'教育状况',
				type:'pie',
				center: ['50%', '58%'],
				radius : ['40%', '60%'],
				data:[
					//{value: allInfo[0].NOSCHOOLING,  name:'未上过学'},
					{value: allInfo[0].PRIMARY_SCHOOL,  name:'小学'},
					{value: allInfo[0].JUNIOR_SCHOOL,  name:'初中'},
			    	//{value: allInfo[0].SENIOR_SCHOOL,  name:'高中'},
					//{value: allInfo[0].COLLEGE,  name:'大学专科'},
					//{value: allInfo[0].UNIVERSITY,  name:'大学本科及以上'} 
					{value: allInfo[0].ZXXJZGRS,  name:'中小学教职工'}
				]
			}
		]
	},
	{
		title : {
			text: '教育状况',
			subtext: '6岁及以上各种受教育程度人口（人） -  起凤镇',
			x:'center',
			textStyle : {
				color: '#348fca',
				fontWeight: 'bold',
				fontFamily: '微软雅黑'
			}
		},
		tooltip : {
			trigger: 'item',
			formatter: "{a} <br/>{b} : {c} ({d}%)"
		},
		series : [
			{
				name:'教育状况',
				type:'pie',
				center: ['50%', '58%'],
				radius : ['40%', '60%'],
				data:[
						//{value: allInfo[1].NOSCHOOLING,  name:'未上过学'},
						{value: allInfo[1].PRIMARY_SCHOOL,  name:'小学'},
						{value: allInfo[1].JUNIOR_SCHOOL,  name:'初中'},
						//{value: allInfo[1].SENIOR_SCHOOL,  name:'高中'},
						//{value: allInfo[1].COLLEGE,  name:'大学专科'},
						//{value: allInfo[1].UNIVERSITY,  name:'大学本科及以上'} 
						{value: allInfo[1].ZXXJZGRS,  name:'中小学教职工'}
				]
			}
		]
	},
	{
		title : {
			text: '教育状况',
			subtext: '6岁及以上各种受教育程度人口（人） -  田庄镇',
			x:'center',
			textStyle : {
				color: '#348fca',
				fontWeight: 'bold',
				fontFamily: '微软雅黑'
			}
		},
		tooltip : {
			trigger: 'item',
			formatter: "{a} <br/>{b} : {c} ({d}%)"
		},
		series : [
			{
				name:'教育状况',
				type:'pie',
				center: ['50%', '58%'],
				radius : ['40%', '60%'],
				data:[
						//{value: allInfo[2].NOSCHOOLING,  name:'未上过学'},
						{value: allInfo[2].PRIMARY_SCHOOL,  name:'小学'},
						{value: allInfo[2].JUNIOR_SCHOOL,  name:'初中'},
						//{value: allInfo[2].SENIOR_SCHOOL,  name:'高中'},
						//{value: allInfo[2].COLLEGE,  name:'大学专科'},
						//{value: allInfo[2].UNIVERSITY,  name:'大学本科及以上'} 
						{value: allInfo[2].ZXXJZGRS,  name:'中小学教职工'}
				]
			}
		]
	},
	{
		title : {
			text: '教育状况',
			subtext: '6岁及以上各种受教育程度人口（人） -  荆家镇',
			x:'center',
			textStyle : {
				color: '#348fca',
				fontWeight: 'bold',
				fontFamily: '微软雅黑'
			}
		},
		tooltip : {
			trigger: 'item',
			formatter: "{a} <br/>{b} : {c} ({d}%)"
		},
		series : [
			{
				name:'教育状况',
				type:'pie',
				center: ['50%', '58%'],
				radius : ['40%', '60%'],
				data:[
						//{value: allInfo[3].NOSCHOOLING,  name:'未上过学'},
						{value: allInfo[3].PRIMARY_SCHOOL,  name:'小学'},
						{value: allInfo[3].JUNIOR_SCHOOL,  name:'初中'},
						//{value: allInfo[3].SENIOR_SCHOOL,  name:'高中'},
						//{value: allInfo[3].COLLEGE,  name:'大学专科'},
						//{value: allInfo[3].UNIVERSITY,  name:'大学本科及以上'} 
						{value: allInfo[3].ZXXJZGRS,  name:'中小学教职工'}
				]
			}
		]
	},
	{
		title : {
			text: '教育状况',
			subtext: '6岁及以上各种受教育程度人口（人） -  马桥镇',
			x:'center',
			textStyle : {
				color: '#348fca',
				fontWeight: 'bold',
				fontFamily: '微软雅黑'
			}
		},
		tooltip : {
			trigger: 'item',
			formatter: "{a} <br/>{b} : {c} ({d}%)"
		},
		series : [
			{
				name:'教育状况',
				type:'pie',
				center: ['50%', '58%'],
				radius : ['40%', '60%'],
				data:[
					//{value: allInfo[4].NOSCHOOLING,  name:'未上过学'},
					{value: allInfo[4].PRIMARY_SCHOOL,  name:'小学'},
					{value: allInfo[4].JUNIOR_SCHOOL,  name:'初中'},
					//{value: allInfo[4].SENIOR_SCHOOL,  name:'高中'},
					//{value: allInfo[4].COLLEGE,  name:'大学专科'},
					//{value: allInfo[4].UNIVERSITY,  name:'大学本科及以上'} 
					{value: allInfo[4].ZXXJZGRS,  name:'中小学教职工'}
				]
			}
		]
	},
	{
		title : {
			text: '教育状况',
			subtext: '6岁及以上各种受教育程度人口（人） -  新城镇',
			x:'center',
			textStyle : {
				color: '#348fca',
				fontWeight: 'bold',
				fontFamily: '微软雅黑'
			}
		},
		tooltip : {
			trigger: 'item',
			formatter: "{a} <br/>{b} : {c} ({d}%)"
		},
		series : [
			{
				name:'教育状况',
				type:'pie',
				center: ['50%', '58%'],
				radius : ['40%', '60%'],
				data:[
					//{value: allInfo[5].NOSCHOOLING,  name:'未上过学'},
					{value: allInfo[5].PRIMARY_SCHOOL,  name:'小学'},
					{value: allInfo[5].JUNIOR_SCHOOL,  name:'初中'},
					//{value: allInfo[5].SENIOR_SCHOOL,  name:'高中'},
					//{value: allInfo[5].COLLEGE,  name:'大学专科'},
					//{value: allInfo[5].UNIVERSITY,  name:'大学本科及以上'} 
					{value: allInfo[5].ZXXJZGRS,  name:'中小学教职工'}
				]
			}
		]
	},
	{
		title : {
			text: '教育状况',
			subtext: '6岁及以上各种受教育程度人口（人） -  唐山镇',
			x:'center',
			textStyle : {
				color: '#348fca',
				fontWeight: 'bold',
				fontFamily: '微软雅黑'
			}
		},
		tooltip : {
			trigger: 'item',
			formatter: "{a} <br/>{b} : {c} ({d}%)"
		},
		series : [
			{
				name:'教育状况',
				type:'pie',
				center: ['50%', '58%'],
				radius : ['40%', '60%'],
				data:[
					//{value: allInfo[6].NOSCHOOLING,  name:'未上过学'},
					{value: allInfo[6].PRIMARY_SCHOOL,  name:'小学'},
					{value: allInfo[6].JUNIOR_SCHOOL,  name:'初中'},
					//{value: allInfo[6].SENIOR_SCHOOL,  name:'高中'},
					//{value: allInfo[6].COLLEGE,  name:'大学专科'},
					//{value: allInfo[6].UNIVERSITY,  name:'大学本科及以上'} 
					{value: allInfo[6].ZXXJZGRS,  name:'中小学教职工'}
				]
			}
		]
	},
	{
		title : {
			text: '教育状况',
			subtext: '6岁及以上各种受教育程度人口（人） -  果里镇',
			x:'center',
			textStyle : {
				color: '#348fca',
				fontWeight: 'bold',
				fontFamily: '微软雅黑'
			}
		},
		tooltip : {
			trigger: 'item',
			formatter: "{a} <br/>{b} : {c} ({d}%)"
		},
		series : [
			{
				name:'教育状况',
				type:'pie',
				center: ['50%', '58%'],
				radius : ['40%', '60%'],
				data:[
					//{value: allInfo[7].NOSCHOOLING,  name:'未上过学'},
					{value: allInfo[7].PRIMARY_SCHOOL,  name:'小学'},
					{value: allInfo[7].JUNIOR_SCHOOL,  name:'初中'},
					//{value: allInfo[7].SENIOR_SCHOOL,  name:'高中'},
					//{value: allInfo[7].COLLEGE,  name:'大学专科'},
					//{value: allInfo[7].UNIVERSITY,  name:'大学本科及以上'} 
					{value: allInfo[7].ZXXJZGRS,  name:'中小学教职工'}
				]
			}
		]
	},
	{
		// 目前没有统计数据，拷贝的宜兴市数据
		title : {
			text: '教育状况',
			subtext: '6岁及以上各种受教育程度人口（人） -  城区',
			x:'center',
			textStyle : {
				color: '#348fca',
				fontWeight: 'bold',
				fontFamily: '微软雅黑'
			}
		},
		tooltip : {
			trigger: 'item',
			formatter: "{a} <br/>{b} : {c} ({d}%)"
		},
		series : [
			{
				name:'教育状况',
				type:'pie',
				center: ['50%', '58%'],
				radius : ['40%', '60%'],
				data:[
					//{value: allInfo[8].NOSCHOOLING,  name:'未上过学'},
					{value: allInfo[8].PRIMARY_SCHOOL,  name:'小学'},
					{value: allInfo[8].JUNIOR_SCHOOL,  name:'初中'},
					//{value: allInfo[8].SENIOR_SCHOOL,  name:'高中'},
					//{value: allInfo[8].COLLEGE,  name:'大学专科'},
					//{value: allInfo[8].UNIVERSITY,  name:'大学本科及以上'} 
					{value: allInfo[8].ZXXJZGRS,  name:'中小学教职工'}
				]
			}
		]
	}
];

// 三产数据
var dataStyle = {
	normal: {
		label: {show:false},
		labelLine: {show:false}
	}
};
var placeHolderStyle = {
	normal : {
		color: 'rgba(0,0,0,0)',
		label: {show:false},
		labelLine: {show:false}
	},
	emphasis : {
		color: 'rgba(0,0,0,0)'
	}
};
var threeTypeOption = [
	{
		'area':'',
		'one':allInfo[9].FIRST_INDUSTRY,
		'two':allInfo[9].SECONDARY_INDUSTRY,
		'three':allInfo[9].TERTIARY_INDUSTRY
	},
	{
		'area':'索镇',
		'one':allInfo[0].FIRST_INDUSTRY,
		'two':allInfo[0].SECONDARY_INDUSTRY,
		'three':allInfo[0].TERTIARY_INDUSTRY
	},
	{
		'area':'起凤镇',
		'one':allInfo[1].FIRST_INDUSTRY,
		'two':allInfo[1].SECONDARY_INDUSTRY,
		'three':allInfo[1].TERTIARY_INDUSTRY
	},
	{
		'area':'田庄镇',
		'one':allInfo[2].FIRST_INDUSTRY,
		'two':allInfo[2].SECONDARY_INDUSTRY,
		'three':allInfo[2].TERTIARY_INDUSTRY
	},
	{
		'area':'荆家镇',
		'one':allInfo[3].FIRST_INDUSTRY,
		'two':allInfo[3].SECONDARY_INDUSTRY,
		'three':allInfo[3].TERTIARY_INDUSTRY
	},
	{
		'area':'马桥镇',
		'one':allInfo[4].FIRST_INDUSTRY,
		'two':allInfo[4].SECONDARY_INDUSTRY,
		'three':allInfo[4].TERTIARY_INDUSTRY
	},
	{
		'area':'新城镇',
		'one':allInfo[5].FIRST_INDUSTRY,
		'two':allInfo[5].SECONDARY_INDUSTRY,
		'three':allInfo[5].TERTIARY_INDUSTRY
	},
	{
		'area':'唐山镇',
		'one':allInfo[6].FIRST_INDUSTRY,
		'two':allInfo[6].SECONDARY_INDUSTRY,
		'three':allInfo[6].TERTIARY_INDUSTRY
	},
	{
		'area':'果里镇',
		'one':allInfo[7].FIRST_INDUSTRY,
		'two':allInfo[7].SECONDARY_INDUSTRY,
		'three':allInfo[7].TERTIARY_INDUSTRY
	},
	{	 
		'area':'城区',
		'one':allInfo[8].FIRST_INDUSTRY,
		'two':allInfo[8].SECONDARY_INDUSTRY,
		'three':allInfo[8].TERTIARY_INDUSTRY
	}
];
/***
大屏修改
1、规模以上工业增加值增速
2、行业销售
***/
var legendWidth = document.getElementById('ThreeBox').offsetWidth
if(window.screen.width <= 1920){
    var threeType = {
            title:{
                x: '55',
                y: 'center',
                itemGap: 5,
            },
            legend: {
                x : legendWidth / 2 - 15,
                y : 13
            },
            center: ['40%', '50%'],
            radius1 : [60, 50],
            radius2 : [50, 40],
            radius3 : [40, 30]
        };
}else if(window.screen.width >= 1920){
    var threeType = {
            title:{
                x: '80',
                y: 'center',
                itemGap: 10
            },
            legend: {
                x : legendWidth / 2 + 10,
                y : 13
            },
            center: ['50%', '52%'],
            radius1: [105, 90],
            radius2: [90, 75],
            radius3: [75, 60]
        };
}
threeOption = [];
threeTypeOption.forEach(function(arr){
	var oneName = '一孩'+ arr.one +'%';
	var twoName = '二孩'+ arr.two +'%';
	var threeName = '多孩'+ arr.three +'%';
	var option_type = {
		color:['#ff8659', '#87cefa', '#da70d6'],
		backgroundColor: 'rgba(255,255,255,.05)',
		title: {
			text: '孩子人口占比',
			subtext: arr.area,
			x: threeType.title.x,
			y: threeType.title.y,
			itemGap: threeType.title.itemGap,
			textStyle : {
				color : 'rgba(30,144,255,0.8)',
				fontFamily : '微软雅黑',
				fontSize : 16,
				fontWeight : 'bolder'
			}
		},
		tooltip : {
			show: true,
			formatter: "{a} : {c} %"
		},
		legend: {
			orient : 'vertical',
			x :  threeType.legend.x,
			y : threeType.legend.y,
			itemGap: 2,
			textStyle : {
				color: '#FFF'
			},
			data:[oneName, twoName, threeName]
		},
		series : [
			{
				name:'一孩',
				type:'pie',
				clockWise:false,
				center: threeType.center,
				radius : threeType.radius1,
				itemStyle : dataStyle,
				data:[
					{
						value:arr.one,
						name: oneName
					},
					{
						value:100-arr.one,
						name:'一孩',
						itemStyle : placeHolderStyle
					}
				]
			},
			{
				name:'二孩子',
				type:'pie',
				clockWise:false,
                center: threeType.center,
                radius : threeType.radius2,
				itemStyle : dataStyle,
				data:[
					{
						value:arr.two, 
						name:twoName
					},
					{
						value:100-arr.two,
						name:'二孩子',
						itemStyle : placeHolderStyle
					}
				]
			},
			{
				name:'三孩子',
				type:'pie',
				clockWise:false,
                center: threeType.center,
                radius : threeType.radius3,
				itemStyle : dataStyle,
				data:[
					{
						value:arr.three, 
						name:threeName
					},
					{
						value:100-arr.three,
						name:'三孩子',
						itemStyle : placeHolderStyle
					}
				]
			}
		]
	};
	threeOption.push(option_type);
});