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
var peopleData=[[{'dataIndex':1,'name':'户籍人口','data':'186418','iUnit':'万'},{'dataIndex':2,'name':'流动人口','data':'82840','iUnit':'万'},{'dataIndex':3,'name':'家庭户','data':'41354','iUnit':'万'},{'dataIndex':4,'name':'男性人口','data':'137864','iUnit':'万'},{'dataIndex':5,'name':'女性人口','data':'131394','iUnit':'万'},{'dataIndex':6,'name':'男女性别比','data':'104.92','iUnit':'%'},{'dataIndex':7,'name':'0-14岁','data':'7.37','iUnit':'%'},{'dataIndex':8,'name':'15-64岁','data':'78.39','iUnit':'%'},{'dataIndex':9,'name':'65岁','data':'14.23','iUnit':'%'},{'dataIndex':10,'name':'人口出生率','data':'5.59','iUnit':'‰'},{'dataIndex':11,'name':'人口死亡率','data':'6','iUnit':'‰'},{'dataIndex':12,'name':'自然增长率','data':'-0.41','iUnit':'‰'},{'dataIndex':13,'name':'文盲人口','data':'3663','iUnit':'万'},{'dataIndex':14,'name':'文盲率','data':'1.78','iUnit':'%'},{'dataIndex':15,'name':'晚婚率','data':'93.69','iUnit':'%'},{'dataIndex':16,'name':'计划生育率','data':'99.33','iUnit':'%'},{'dataIndex':17,'name':'结婚对数','data':'1651','iUnit':'对'},{'dataIndex':18,'name':'离婚对数','data':'653','iUnit':'对'}],[{'dataIndex':1,'name':'户籍人口','data':'324188','iUnit':'万'},{'dataIndex':2,'name':'流动人口','data':'98960','iUnit':'万'},{'dataIndex':3,'name':'家庭户','data':'81457','iUnit':'万'},{'dataIndex':4,'name':'男性人口','data':'214968','iUnit':'万'},{'dataIndex':5,'name':'女性人口','data':'208180','iUnit':'万'},{'dataIndex':6,'name':'男女性别比','data':'103.26','iUnit':'%'},{'dataIndex':7,'name':'0-14岁','data':'7.72','iUnit':'%'},{'dataIndex':8,'name':'15-64岁','data':'76.37','iUnit':'%'},{'dataIndex':9,'name':'65岁','data':'15.9','iUnit':'%'},{'dataIndex':10,'name':'人口出生率','data':'5.15','iUnit':'‰'},{'dataIndex':11,'name':'人口死亡率','data':'5.58','iUnit':'‰'},{'dataIndex':12,'name':'自然增长率','data':'-0.43','iUnit':'‰'},{'dataIndex':13,'name':'文盲人口','data':'6474','iUnit':'万'},{'dataIndex':14,'name':'文盲率','data':'1.9','iUnit':'%'},{'dataIndex':15,'name':'晚婚率','data':'96.9','iUnit':'%'},{'dataIndex':16,'name':'计划生育率','data':'99.93','iUnit':'%'},{'dataIndex':17,'name':'结婚对数','data':'3107','iUnit':'对'},{'dataIndex':18,'name':'离婚对数','data':'1082','iUnit':'对'}],[{'dataIndex':1,'name':'户籍人口','data':'255836','iUnit':'万'},{'dataIndex':2,'name':'流动人口','data':'122080','iUnit':'万'},{'dataIndex':3,'name':'家庭户','data':'64934','iUnit':'万'},{'dataIndex':4,'name':'男性人口','data':'193264','iUnit':'万'},{'dataIndex':5,'name':'女性人口','data':'184652','iUnit':'万'},{'dataIndex':6,'name':'男女性别比','data':'106.80','iUnit':'%'},{'dataIndex':7,'name':'0-14岁','data':'6.32','iUnit':'%'},{'dataIndex':8,'name':'15-64岁','data':'79.1','iUnit':'%'},{'dataIndex':9,'name':'65岁','data':'14.57','iUnit':'%'},{'dataIndex':10,'name':'人口出生率','data':'5.51','iUnit':'‰'},{'dataIndex':11,'name':'人口死亡率','data':'5.14','iUnit':'‰'},{'dataIndex':12,'name':'自然增长率','data':'0.37','iUnit':'‰'},{'dataIndex':13,'name':'文盲人口','data':'7919','iUnit':'万'},{'dataIndex':14,'name':'文盲率','data':'2.62','iUnit':'%'},{'dataIndex':15,'name':'晚婚率','data':'86.08','iUnit':'%'},{'dataIndex':16,'name':'计划生育率','data':'99.1','iUnit':'%'},{'dataIndex':17,'name':'结婚对数','data':'2014','iUnit':'对'},{'dataIndex':18,'name':'离婚对数','data':'969','iUnit':'对'}],[{'dataIndex':1,'name':'户籍人口','data':'435342','iUnit':'万'},{'dataIndex':2,'name':'流动人口','data':'366884','iUnit':'万'},{'dataIndex':3,'name':'家庭户','data':'95036','iUnit':'万'},{'dataIndex':4,'name':'男性人口','data':'425355','iUnit':'万'},{'dataIndex':5,'name':'女性人口','data':'376871','iUnit':'万'},{'dataIndex':6,'name':'男女性别比','data':'112.86','iUnit':'%'},{'dataIndex':7,'name':'0-14岁','data':'5.95','iUnit':'%'},{'dataIndex':8,'name':'15-64岁','data':'83.45','iUnit':'%'},{'dataIndex':9,'name':'65岁','data':'10.58','iUnit':'%'},{'dataIndex':10,'name':'人口出生率','data':'5.02','iUnit':'‰'},{'dataIndex':11,'name':'人口死亡率','data':'4.48','iUnit':'‰'},{'dataIndex':12,'name':'自然增长率','data':'0.54','iUnit':'‰'},{'dataIndex':13,'name':'文盲人口','data':'15816','iUnit':'万'},{'dataIndex':14,'name':'文盲率','data':'2.58','iUnit':'%'},{'dataIndex':15,'name':'晚婚率','data':'82.56','iUnit':'%'},{'dataIndex':16,'name':'计划生育率','data':'99.58','iUnit':'%'},{'dataIndex':17,'name':'结婚对数','data':'3404','iUnit':'对'},{'dataIndex':18,'name':'离婚对数','data':'1252','iUnit':'对'}],[{'dataIndex':1,'name':'户籍人口','data':'457506','iUnit':'万'},{'dataIndex':2,'name':'流动人口','data':'357673','iUnit':'万'},{'dataIndex':3,'name':'家庭户','data':'102744','iUnit':'万'},{'dataIndex':4,'name':'男性人口','data':'438820','iUnit':'万'},{'dataIndex':5,'name':'女性人口','data':'376359','iUnit':'万'},{'dataIndex':6,'name':'男女性别比','data':'116.60','iUnit':'%'},{'dataIndex':7,'name':'0-14岁','data':'6.53','iUnit':'%'},{'dataIndex':8,'name':'15-64岁','data':'82.88','iUnit':'%'},{'dataIndex':9,'name':'65岁','data':'10.58','iUnit':'%'},{'dataIndex':10,'name':'人口出生率','data':'5.3','iUnit':'‰'},{'dataIndex':11,'name':'人口死亡率','data':'4.14','iUnit':'‰'},{'dataIndex':12,'name':'自然增长率','data':'1.16','iUnit':'‰'},{'dataIndex':13,'name':'文盲人口','data':'13084','iUnit':'万'},{'dataIndex':14,'name':'文盲率','data':'2.12','iUnit':'%'},{'dataIndex':15,'name':'晚婚率','data':'80.97','iUnit':'%'},{'dataIndex':16,'name':'计划生育率','data':'99.84','iUnit':'%'},{'dataIndex':17,'name':'结婚对数','data':'3351','iUnit':'对'},{'dataIndex':18,'name':'离婚对数','data':'1287','iUnit':'对'}],[{'dataIndex':1,'name':'户籍人口','data':'480238','iUnit':'万'},{'dataIndex':2,'name':'流动人口','data':'292355','iUnit':'万'},{'dataIndex':3,'name':'家庭户','data':'105031','iUnit':'万'},{'dataIndex':4,'name':'男性人口','data':'407295','iUnit':'万'},{'dataIndex':5,'name':'女性人口','data':'365298','iUnit':'万'},{'dataIndex':6,'name':'男女性别比','data':'111.50','iUnit':'%'},{'dataIndex':7,'name':'0-14岁','data':'6.62','iUnit':'%'},{'dataIndex':8,'name':'15-64岁','data':'80.42','iUnit':'%'},{'dataIndex':9,'name':'65岁','data':'12.95','iUnit':'%'},{'dataIndex':10,'name':'人口出生率','data':'4.98','iUnit':'‰'},{'dataIndex':11,'name':'人口死亡率','data':'4.11','iUnit':'‰'},{'dataIndex':12,'name':'自然增长率','data':'0.87','iUnit':'‰'},{'dataIndex':13,'name':'文盲人口','data':'18246','iUnit':'万'},{'dataIndex':14,'name':'文盲率','data':'1.64','iUnit':'%'},{'dataIndex':15,'name':'晚婚率','data':'54.94','iUnit':'%'},{'dataIndex':16,'name':'计划生育率','data':'99.97','iUnit':'%'},{'dataIndex':17,'name':'结婚对数','data':'4378','iUnit':'对'},{'dataIndex':18,'name':'离婚对数','data':'1523','iUnit':'对'}],[{'dataIndex':1,'name':'户籍人口','data':'1241260','iUnit':'万'},{'dataIndex':2,'name':'流动人口','data':'868011','iUnit':'万'},{'dataIndex':3,'name':'家庭户','data':'323','iUnit':'万'},{'dataIndex':4,'name':'男性人口','data':'1111291','iUnit':'万'},{'dataIndex':5,'name':'女性人口','data':'997980','iUnit':'万'},{'dataIndex':6,'name':'男女性别比','data':'111.35','iUnit':'%'},{'dataIndex':7,'name':'0-14岁','data':'6.46','iUnit':'%'},{'dataIndex':8,'name':'15-64岁','data':'82.77','iUnit':'%'},{'dataIndex':9,'name':'65岁','data':'10.78','iUnit':'%'},{'dataIndex':10,'name':'人口出生率','data':'4.97','iUnit':'‰'},{'dataIndex':11,'name':'人口死亡率','data':'5.22','iUnit':'‰'},{'dataIndex':12,'name':'自然增长率','data':'-0.25','iUnit':'‰'},{'dataIndex':13,'name':'文盲人口','data':'34031','iUnit':'万'},{'dataIndex':14,'name':'文盲率','data':'2.39','iUnit':'%'},{'dataIndex':15,'name':'晚婚率','data':'70.66','iUnit':'%'},{'dataIndex':16,'name':'计划生育率','data':'99.74','iUnit':'%'},{'dataIndex':17,'name':'结婚对数','data':'11540','iUnit':'对'},{'dataIndex':18,'name':'离婚对数','data':'3283','iUnit':'对'}],[{'dataIndex':1,'name':'户籍人口','data':'1081321','iUnit':'万'},{'dataIndex':2,'name':'流动人口','data':'219631','iUnit':'万'},{'dataIndex':3,'name':'家庭户','data':'202063','iUnit':'万'},{'dataIndex':4,'name':'男性人口','data':'660511','iUnit':'万'},{'dataIndex':5,'name':'女性人口','data':'640441','iUnit':'万'},{'dataIndex':6,'name':'男女性别比','data':'103.13','iUnit':'%'},{'dataIndex':7,'name':'0-14岁','data':'6.99','iUnit':'%'},{'dataIndex':8,'name':'15-64岁','data':'76.84','iUnit':'%'},{'dataIndex':9,'name':'65岁','data':'16.17','iUnit':'%'},{'dataIndex':10,'name':'人口出生率','data':'5.1','iUnit':'‰'},{'dataIndex':11,'name':'人口死亡率','data':'6.48','iUnit':'‰'},{'dataIndex':12,'name':'自然增长率','data':'-1.38','iUnit':'‰'},{'dataIndex':13,'name':'文盲人口','data':'26665','iUnit':'万'},{'dataIndex':14,'name':'文盲率','data':'2.41','iUnit':'%'},{'dataIndex':15,'name':'晚婚率','data':'74.84','iUnit':'%'},{'dataIndex':16,'name':'计划生育率','data':'99.67','iUnit':'%'},{'dataIndex':17,'name':'结婚对数','data':'11089','iUnit':'对'},{'dataIndex':18,'name':'离婚对数','data':'3114','iUnit':'对'}],[{'dataIndex':1,'name':'户籍人口','data':'347096','iUnit':'万'},{'dataIndex':2,'name':'流动人口','data':'471403','iUnit':'万'},{'dataIndex':3,'name':'家庭户','data':'77114','iUnit':'万'},{'dataIndex':4,'name':'男性人口','data':'447647','iUnit':'万'},{'dataIndex':5,'name':'女性人口','data':'370852','iUnit':'万'},{'dataIndex':6,'name':'男女性别比','data':'120.71','iUnit':'%'},{'dataIndex':7,'name':'0-14岁','data':'5.36%','iUnit':'%'},{'dataIndex':8,'name':'15-64岁','data':'86.70','iUnit':'%'},{'dataIndex':9,'name':'65岁','data':'7.94','iUnit':'%'},{'dataIndex':10,'name':'人口出生率','data':'5.1','iUnit':'‰'},{'dataIndex':11,'name':'人口死亡率','data':'6.48','iUnit':'‰'},{'dataIndex':12,'name':'自然增长率','data':'-1.38','iUnit':'‰'},{'dataIndex':13,'name':'文盲人口','data':'26665','iUnit':'万'},{'dataIndex':14,'name':'文盲率','data':'2.41','iUnit':'%'},{'dataIndex':15,'name':'晚婚率','data':'74.84','iUnit':'%'},{'dataIndex':16,'name':'计划生育率','data':'99.67','iUnit':'%'},{'dataIndex':17,'name':'结婚对数','data':'11089','iUnit':'对'},{'dataIndex':18,'name':'离婚对数','data':'3114','iUnit':'对'}],[{'dataIndex':1,'name':'户籍人口','data':'4809205','iUnit':'万'},{'dataIndex':2,'name':'流动人口','data':'2879837','iUnit':'万'},{'dataIndex':3,'name':'家庭户','data':'772834','iUnit':'万'},{'dataIndex':4,'name':'男性人口','data':'4037015','iUnit':'万'},{'dataIndex':5,'name':'女性人口','data':'3652027','iUnit':'万'},{'dataIndex':6,'name':'男女性别比','data':'110.54','iUnit':'%'},{'dataIndex':7,'name':'0-14岁','data':'6.50','iUnit':'%'},{'dataIndex':8,'name':'15-64岁','data':'81.34','iUnit':'%'},{'dataIndex':9,'name':'65岁','data':'12.16','iUnit':'%'},{'dataIndex':10,'name':'人口出生率','data':'5.1','iUnit':'‰'},{'dataIndex':11,'name':'人口死亡率','data':'5.1','iUnit':'‰'},{'dataIndex':12,'name':'自然增长率','data':'0','iUnit':'‰'},{'dataIndex':13,'name':'文盲人口','data':'125898','iUnit':'万'},{'dataIndex':14,'name':'文盲率','data':'2.2','iUnit':'%'},{'dataIndex':15,'name':'晚婚率','data':'74.02','iUnit':'‰'},{'dataIndex':16,'name':'计划生育率','data':'99.73','iUnit':'%'},{'dataIndex':17,'name':'结婚对数','data':'43728','iUnit':'对'},{'dataIndex':18,'name':'离婚对数','data':'14125','iUnit':'对'}]];
//console.log(peopleData);

/*
 * 各区教育数据
 * schoolOption 1:崇安区 2:南长区 3:北塘区 4:锡山区 5:惠山区 6:滨湖区 7:江阴市 8:宜兴市
 */
schoolOption = [
	{
		backgroundColor: 'rgba(255,255,255,.05)',
		title : {
			text: '教育状况',
			subtext: '6岁及以上各种受教育程度人口（人）',
			x:'center',
			y:'10',			
			textStyle : {
				color: '#2ab6ff',
				fontSize: '30',
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
					{value: 155117,  name:'未上过学'},
					{value: 1344320,  name:'小学'},
					{value: 2657168,  name:'初中'},
					{value: 1135155,  name:'高中'},
					{value: 501320,  name:'大学专科'},
					{value: 319650,  name:'大学本科及以上'}
				]
			}
		]
	},
	{
		title : {
			text: '教育状况',
			subtext: '6岁及以上各种受教育程度人口（人） -  崇安区',
			x:'center',
			y:'10',
			textStyle : {
				color: '#348fca',
				fontSize: '30',
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
					{value: 1287+3678,  name:'未上过学'},
					{value: 12982+15887,  name:'小学'},
					{value: 44335+39428,  name:'初中'},
					{value: 27840+26596,  name:'高中'},
					{value: 14953+13708,  name:'大学专科'},
					{value: 10604+8016,  name:'大学本科及以上'}
				]
			}
		]
	},
	{
		title : {
			text: '教育状况',
			subtext: '6岁及以上各种受教育程度人口（人） -  南长区',
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
					{value: 1586+6318,  name:'未上过学'},
					{value: 20752+26474,  name:'小学'},
					{value: 64321+61106,  name:'初中'},
					{value: 48320+44930,  name:'高中'},
					{value: 27666+24960,  name:'大学专科'},
					{value: 20970+16240,  name:'大学本科及以上'}
				]
			}
		]
	},
	{
		title : {
			text: '教育状况',
			subtext: '6岁及以上各种受教育程度人口（人） -  北塘区',
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
					{value: 2293+6987,  name:'未上过学'},
					{value: 20752+26474,  name:'小学'},
					{value: 64321+61106,  name:'初中'},
					{value: 48320+44930,  name:'高中'},
					{value: 27666+24960,  name:'大学专科'},
					{value: 20970+16240,  name:'大学本科及以上'}
				]
			}
		]
	},
	{
		title : {
			text: '教育状况',
			subtext: '6岁及以上各种受教育程度人口（人） -  锡山区',
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
					{value: 3737+14279,  name:'未上过学'},
					{value: 72171+82067,  name:'小学'},
					{value: 170309+142257,  name:'初中'},
					{value: 61293+45981,  name:'高中'},
					{value: 20441+17932,  name:'大学专科'},
					{value: 12311+9350,  name:'大学本科及以上'}
				]
			}
		]
	},
	{
		title : {
			text: '教育状况',
			subtext: '6岁及以上各种受教育程度人口（人） -  惠山区',
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
					{value: 3532+11846,  name:'未上过学'},
					{value: 70287+78314,  name:'小学'},
					{value: 180006+144435,  name:'初中'},
					{value: 60073+41098,  name:'高中'},
					{value: 26610+24512,  name:'大学专科'},
					{value: 11499+8669,  name:'大学本科及以上'}
				]
			}
		]
	},
	{
		title : {
			text: '教育状况',
			subtext: '6岁及以上各种受教育程度人口（人） -  滨湖区',
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
					{value: 5274+17730,  name:'未上过学'},
					{value: 88900+104839,  name:'小学'},
					{value: 251685+214963,  name:'初中'},
					{value: 133450+112680,  name:'高中'},
					{value: 76220+61275,  name:'大学专科'},
					{value: 60729+50590,  name:'大学本科及以上'}
				]
			}
		]
	},
	{
		title : {
			text: '教育状况',
			subtext: '6岁及以上各种受教育程度人口（人） -  江阴市',
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
					{value: 8402+33285,  name:'未上过学'},
					{value: 177724+212570,  name:'小学'},
					{value: 373417+322708,  name:'初中'},
					{value: 149058+110512,  name:'高中'},
					{value: 48455+40513,  name:'大学专科'},
					{value: 29448+21780,  name:'大学本科及以上'}
				]
			}
		]
	},
	{
		title : {
			text: '教育状况',
			subtext: '6岁及以上各种受教育程度人口（人） -  宜兴市',
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
					{value: 8619+26264,  name:'未上过学'},
					{value: 150656+180834,  name:'小学'},
					{value: 280838+240016,  name:'初中'},
					{value: 111739+85191,  name:'高中'},
					{value: 37647+30895,  name:'大学专科'},
					{value: 20747+14807,  name:'大学本科及以上'}
				]
			}
		]
	},
	{
		// 目前没有统计数据，拷贝的宜兴市数据
		title : {
			text: '教育状况',
			subtext: '6岁及以上各种受教育程度人口（人） -  新区',
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
					{value: 8619+26264,  name:'未上过学'},
					{value: 150656+180834,  name:'小学'},
					{value: 280838+240016,  name:'初中'},
					{value: 111739+85191,  name:'高中'},
					{value: 37647+30895,  name:'大学专科'},
					{value: 20747+14807,  name:'大学本科及以上'}
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
		'one':4.97,
		'two':60.37,
		'three':34.66
	},
	{
		'area':'崇安区',
		'one':0.06,
		'two':32.64,
		'three':67.3
	},
	{
		'area':'南长区',
		'one':0.13,
		'two':41.45,
		'three':58.42
	},
	{
		'area':'北塘区',
		'one':0.05,
		'two':40.06,
		'three':59.89
	},
	{
		'area':'锡山区',
		'one':2.78,
		'two':70.02,
		'three':27.2
	},
	{
		'area':'惠山区',
		'one':4.06,
		'two':69.56,
		'three':26.38
	},
	{
		'area':'滨湖区',
		'one':1.26,
		'two':61.71,
		'three':37.03
	},
	{
		'area':'江阴市',
		'one':3.59,
		'two':65.81,
		'three':30.6
	},
	{
		'area':'宜兴市',
		'one':15.39,
		'two':54.69,
		'three':29.92
	},
	{	// 目前没有统计数据，拷贝的宜兴市数据
		'area':'新区',
		'one':15.39,
		'two':54.69,
		'three':29.92
	}
];
/***
大屏修改
1、规模以上工业增加值增速
2、行业销售
***/
var legendWidth = document.getElementById('ThreeBox').offsetWidth;
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
threeOption = [];
threeTypeOption.forEach(function(arr){
	var oneName = '一产'+ arr.one +'%';
	var twoName = '二产'+ arr.two +'%';
	var threeName = '三产'+ arr.three +'%';
	var option_type = {
		color:['#ff8659', '#87cefa', '#da70d6'],
		backgroundColor: 'rgba(255,255,255,.05)',
		title: {
			text: '三产人口占比',
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
				name:'一产',
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
						name:'第一产业',
						itemStyle : placeHolderStyle
					}
				]
			},
			{
				name:'二产',
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
						name:'第二产业',
						itemStyle : placeHolderStyle
					}
				]
			},
			{
				name:'三产',
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
						name:'第三产业',
						itemStyle : placeHolderStyle
					}
				]
			}
		]
	};
	threeOption.push(option_type);
});