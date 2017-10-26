$(function(){
//    图表信息
    var topcharts1 = echarts.init(document.getElementById("topChart1"));
    var topcharts2 = echarts.init(document.getElementById("topChart2"));
    var centerChart1 = echarts.init(document.getElementById("centerChart1"));
    var axislabel = {
        textStyle: {
            color: '#6C6C6C',
            fontSize: 10
        }
    };
    var tips = {
        trigger: 'axis',
        textStyle: {fontSize: 12}
    };
    var axisLine = {
        show: true,        // 默认显示，属性show控制显示与否
        lineStyle: {       // 属性lineStyle控制线条样式
            color: '#e5e5e5',//#101F37
            width: 2,
            type: 'solid'
        }
    }
    $.post(contextPath + "/cszcJyfzfxAction/getJcjyfz","",function(da){
    	//基础教育发展
    	var nian = []; //年份
    	var wrYey = []; //万人幼儿园
    	var wrXx = [];//万人小学
    	var wrCz = [];//万人初中
    	if(da.data!=null){
    		var datalist = eval(da.data);
    		for(var i=datalist.length - 1;i>= 0 ;i--){
    			nian.push(datalist[i].nian);
    			wrYey.push(datalist[i].wrYey);
    			wrXx.push(datalist[i].wrXx);
    			wrCz.push(datalist[i].wrCz);
    		}
    		loadTopOption1(nian,wrYey,wrXx,wrCz);
    	}
    	
    });
    function loadTopOption1(nian,wrYey,wrXx,wrCz){
    	var topOption1= {
    	        color:['rgba(18,109,139,.5)','rgba(0,180,255,.5)','rgba(253,176,0,.5)'],
    	        title:{
    	            text:'基础教育发展',
    	            textStyle:{
    	                fontFamily:'Microsoft YaHei',
    	                fontSize: 16,
    	                color: '#353840'
    	            },
    	            x:16,
    	            y:10
    	        },
    	        tooltip : tips,
    	        calculable : true,
    	        legend: {
    	            data:['万人幼儿园数量','万人小学数量','万人初中数量'],
    	            x:'center',
    	            y:30
    	        },
    	        grid:{
    	            x:56,
    	            y:60,
    	            x2:50,
    	            y2:30,
    	            borderWidth:0
    	        },
    	        xAxis : [
    	            {
    	                type : 'category',
    	                boundaryGap : false,
    	                data : nian,
    	                splitLine:{
    	                    show:false
    	                },
    	                axisLine: axisLine,
    	                axisLabel: axislabel
    	            }
    	        ],
    	        yAxis : [
    	            {
    	                type : 'value',
    	                name : '数量（所/万人）',
    	                nameTextStyle:{
    	                    fontSize: 12,
    	                    color: '#6C6C6C',
    	                    fontStyle: 'normal',
    	                    fontWeight: 'normal'
    	                },
    	                splitNumber:5,
    	                axisLine: axisLine,
    	                axisLabel: axislabel

    	            }
    	              
    	        ],
    	        series : [

    	            {
    	                name:'万人初中数量',
    	                type:'line',
    	                smooth:true,
    	                itemStyle: {normal: {areaStyle: {type: 'default'}}},
    	                data:wrCz
    	            },
    	            {
    	                name:'万人小学数量',
    	                type:'line',
    	                smooth:true,
    	                itemStyle: {normal: {areaStyle: {type: 'default'}}},
    	                data:wrXx
    	            },
    	            {
    	                name:'万人幼儿园数量',
    	                type:'line',
    	                smooth:true,
    	                itemStyle: {normal: {areaStyle: {type: 'default'}}},
    	                data:wrYey
    	            },
    	        ]
    	    };
    	topcharts1.setOption(topOption1);
    }
    
    $.post(contextPath + "/cszcJyfzfxAction/getZyjyfz","",function(da){
    	//职业教育发展
    	var nian = []; //年份
    	var wrJx = []; //万人技校数量
    	var jx = [];//技校数量
    	if(da.data!=null){
    		var datalist = eval(da.data);
    		for(var i=datalist.length - 1;i>= 0 ;i--){
    			nian.push(datalist[i].nian);
    			wrJx.push(datalist[i].wrJx);
    			jx.push(datalist[i].jx);
    		}
    		loadTopOption2(nian,wrJx,jx);
    	}
    	
    });
    function loadTopOption2(nian,wrJx,jx){
    	var topOption2 = {
    	        tooltip :tips,
    	        title:{
    	            text:'职业教育发展',
    	            textStyle:{
    	                fontFamily:'Microsoft YaHei',
    	                fontSize: 16,
    	                color: '#353840'
    	            },
    	            x:16,
    	            y:10
    	        },
    	        grid:{
    	            x:56,
    	            y:60,
    	            x2:65,
    	            y2:30,
    	            borderWidth:0
    	        },
    	        calculable : true,
    	        legend: {
    	            data:['万人技校数量','技校数量'],
    	            x:'center',
    	            y:30
    	        },
    	        xAxis : [
    	            {
    	                type : 'category',
    	                data : nian,
    	                splitLine:{
    	                    show:false
    	                },
    	                axisLine: axisLine,
    	                axisLabel: axislabel
    	            }
    	        ],
    	        yAxis : [
    	            {
    	                type : 'value',
    	                name : '技校数量（所）',
    	                nameTextStyle:{
    	                    fontSize: 12,
    	                    color: '#6C6C6C',
    	                    fontStyle: 'normal',
    	                    fontWeight: 'normal'
    	                },
    	                splitNumber:5,
    	                axisLine: axisLine,
    	                axisLabel: axislabel

    	            },
    	            {
    	                type : 'value',
    	                name : '万人技校数量（所/万人）',
    	                nameTextStyle:{
    	                    fontSize: 12,
    	                    color: '#6C6C6C',
    	                    fontStyle: 'normal',
    	                    fontWeight: 'normal'
    	                },
    	                splitNumber:5,
    	                axisLine: axisLine,
    	                axisLabel: axislabel
    	            }
    	        ],
    	        series : [

    	            {
    	                name:'技校数量',
    	                type:'bar',
    	                barWidth:20,
    	                data:jx
    	            },
    	            {
    	                name:'万人技校数量',
    	                type:'line',
    	                smooth:true,
    	                yAxisIndex: 1,
    	                data:wrJx
    	            }
    	        ]
    	    };
    	topcharts2.setOption(topOption2);
    }
    $.post(contextPath + "/cszcJyfzfxAction/getJcjyfb","",function(da){
    	//职业教育发展
    	var dq = []; //地区
    	var yey = []; //幼儿园
    	var xx = [];//小学
    	var cz = [];//初中
    	if(da.data!=null){
    		var datalist = eval(da.data);
    		for(var i=0;i<datalist.length;i++){
    			dq.push(datalist[i].dq);
    			yey.push(datalist[i].yey);
    			xx.push(datalist[i].xx);
    			cz.push(datalist[i].cz);
    		}
    		loadCenterOption(dq,yey,xx,cz);
    	}
    	
    });
    function loadCenterOption(dq,yey,xx,cz){
    	var centerOption={
    	        color:['#12D18B','#FF7F50','#FDB000'],
    	        title:{
    	            text:'基础教育分布',
    	            textStyle:{
    	                fontFamily:'Microsoft YaHei',
    	                fontSize: 16,
    	                color: '#353840'
    	            },
    	            x:16,
    	            y:10
    	        },
    	        tooltip : tips,
    	        legend: {
    	            data:['幼儿园','小学','初中'],
    	            x:'center',
    	            y:30
    	        },
    	        grid:{
    	            x:56,
    	            y:60,
    	            x2:50,
    	            y2:30,
    	            borderWidth:0
    	        },
    	        calculable : true,
    	        xAxis : [
    	            {
    	                type : 'category',
    	                splitLine: {show:true,lineStyle:{color:'#e5e5e5'},},
    	                axisTick:{show:false},
    	                data :  dq,
    	                axisLine: axisLine,
    	                axisLabel: axislabel,
    	            }
    	        ],
    	        yAxis : [
    	            {
    	                type : 'value',
    	                min:0,
    	                max:60,
    	                splitNumber:6,
    	                name : '数量（所）',
    	                nameTextStyle:{
    	                    fontSize: 12,
    	                    color: '#6C6C6C',
    	                    fontStyle: 'normal',
    	                    fontWeight: 'normal'
    	                },
    	                axisLine: axisLine,
    	                axisLabel: axislabel
    	            }
    	        ],
    	        series : [
    	            {
    	                name:'幼儿园',
    	                type:'bar',
    	                barWidth:20,
    	                data:yey,
    	                barCategoryGap:'20%'
    	            },
    	            {
    	                name:'小学',
    	                type:'bar',
    	                barWidth:20,
    	                data:xx,
    	                barCategoryGap:'20%'
    	            },
    	            {
    	                name:'初中',
    	                type:'bar',
    	                barWidth:20,
    	                barGap:'20%',
    	                data:cz,
    	                barCategoryGap:'20%'
    	            }


    	        ]
    	    };
    	    centerChart1.setOption(centerOption);
    }
    

//    新闻滚动播放

    window.onload = function () {
        setTimeout("startmarquee(80, 80, 0, 'scroll')", 4000);
    }
})
