<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>政务大数据展示系统</title>  
  <link href="${pageContext.request.contextPath}/js/css/index/iconfont.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/js/css/index/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/js/css/index/bigdata_style.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath}/js/assets/app/index/iconfont.js"></script>
</head>
<body>
<div class="col-xs-12 content-wrapper pdt-10">
  <div class="col-xs-7 col-bd-left">
    <div class="col-xs-3 bd-right">
      <div class="tiles h100">
        <div class="h50">
          <div class="sprite_box sprite_box_01">
            <svg class="icon" aria-hidden="true">
              <use xlink:href="#icon-population"></use>
            </svg>
          </div>
          <div class="numberBox">
            <div class="numTit">户籍人口（万）</div>
              <div class="numBody">${result.CZRK }</div>
          </div>
        </div>
        <div class="h50">
          <div class="numberBox h50">
            <div class="numTit">流动人口（万）</div>
              <div class="numBody">${result.LDRK }</div>
          </div>
          <div class="numberBox h50">
            <div class="numTit">家庭户（万）</div>
              <div class="numBody">${result.JTH }</div>
          </div>
        </div>
      </div>
    </div><!--.col-xs-3 End-->
    <div class="col-xs-3 bd-right">
      <div class="tiles h50 bd-bottom">
        <div class="sprite_box">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-male"></use>
          </svg>
        </div>
        <div class="numberBox">
          <div class="numTit">男性人口（万）</div>
            <div class="numBody">${result.MAN }</div>
        </div>
      </div>
      <div class="tiles h50">
        <div class="sprite_box">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-female"></use>
          </svg>
        </div>
        <div class="numberBox">
          <div class="numTit">女性人口（万）</div>
            <div class="numBody font-powder">${result.WOMAN }</div>
        </div>
      </div>
    </div><!--.col-xs-3 End-->
    <div class="col-xs-3 bd-right">
      <div class="tiles h50 bd-bottom">
        <div class="sprite_box">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-Yr-"></use>
          </svg>
        </div>
        <div class="numberBox">
          <div class="numTit">0-14岁（万）</div>
            <div class="numBody font-green">${result.YEAR_0_14 }</div>
        </div>
      </div>
      <div class="tiles h50">
        <div class="sprite_box">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-Yr-1"></use>
          </svg>
        </div>
        <div class="numberBox">
          <div class="numTit">15-64岁（万）</div>
            <div class="numBody">${result.YEAR_15_64 }</div>
        </div>
      </div>
    </div><!--.col-xs-3 End-->
    <div class="col-xs-3">
      <div class="tiles h100 bg-blue enterprise">
        <div class="h50">
          <div class="numTit font-white text-center titles-md h10">近一年数据</div>
          <div class="sprite_box sprite_box_02">
            <div class="sprite_item sprite_02 ifont icon-enterprise"></div>
          </div>
          <div class="numberBox h50">
            <div class="numTit font-white">新注册企业（家）</div>
              <div class="numBody font-white">${result.XZCQY }</div>
          </div>
        </div>
        <div class="h50 pdt-10">
          <div class="numberBox h50">
            <div class="numTit font-white">销售收入（亿）</div>
              <div class="numBody font-white">${result.XSSR }</div>
          </div>
          <div class="numberBox h50">
            <div class="numTit font-white">实际税额（亿）</div>
              <div class="numBody font-white">${result.SJSE }</div>
          </div>
        </div>
      </div>
    </div><!--.col-xs-3 End-->
  </div><!--.col-xs-7 End-->
  <div class="col-xs-5 col-bd-right">
    <div class="col-xs-4 bd-right">
      <div class="tiles h50 bd-bottom">
        <div class="sprite_box">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-SSpopulation"></use>
          </svg>
        </div>
        <div class="numberBox">
          <div class="numTit">上月参保人数(万)</div>
            <div class="numBody">${result.CBRS }</div>
        </div>
      </div>
      <div class="tiles h50">
        <div class="sprite_box">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-housefund"></use>
          </svg>
        </div>
        <div class="numberBox">
          <div class="numTit">本年公积金实缴(亿)</div>
            <div class="numBody">${result.GJJ }</div>
        </div>
      </div>
    </div><!--.col-xs-3 End-->
    <div class="col-xs-4 bd-right">
      <div class="tiles h50 bd-bottom">
        <div class="sprite_box">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-SocialSecurity"></use>
          </svg>
        </div>
        <div class="numberBox">
          <div class="numTit">本年社保缴纳(亿)</div>
            <div class="numBody">${result.SB }</div>
        </div>
      </div>
      <div class="tiles h50">
        <div class="sprite_box">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-IT"></use>
          </svg>
        </div>
        <div class="numberBox">
          <div class="numTit">软件企业(家)</div>
            <div class="numBody">${result.RJQY }</div>
        </div>
      </div>
    </div><!--.col-xs-3 End-->
    <div class="col-xs-4 bd-right">
      <div class="tiles h50 bd-bottom">
        <div class="sprite_box">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-hotel"></use>
          </svg>
        </div>
        <div class="numberBox">
          <div class="numTit">住宿和餐饮业(家)</div>
            <div class="numBody">${result.ZSHCYY }</div>
        </div>
      </div>
      <div class="tiles h50">
        <div class="sprite_box">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-building"></use>
          </svg>
        </div>
        <div class="numberBox">
          <div class="numTit">房地产企业(家)</div>
            <div class="numBody">${result.FDCQY }</div>
        </div>
      </div>
    </div><!--.col-xs-3 End-->
  </div><!--.col-xs-5 End-->
</div><!--.col-xs-12 End-->
<div class="col-xs-12 content-wrapper pdb-10">
  <div class="col-xs-7 col-bd-left">
    <div class="col-xs-3 bd-right">
      <div class="tiles h50 bd-bottom">
        <div class="sprite_box">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-pregnantagewoman"></use>
          </svg>
        </div>
        <div class="numberBox">
          <div class="numTit">育龄妇女（万）</div>
            <div class="numBody">${result.YLFN }</div>
        </div>
      </div>
      <div class="tiles h50">
        <div class="sprite_box">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-housefundloan"></use>
          </svg>
        </div>
        <div class="numberBox">
          <div class="numTit">个人公积金贷款（亿）</div>
            <div class="numBody">${result.DKJE }</div>
        </div>
      </div>
    </div><!--.col-xs-3 End-->
    <div class="col-xs-3 bd-right">
      <div class="tiles h50 bd-bottom">
        <div class="sprite_box">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-MF"></use>
          </svg>
        </div>
        <div class="numberBox">
          <div class="numTit">男女性别比（%）</div>
            <div class="numBody">${result.NVXBB }</div>
        </div>
      </div>
      <div class="tiles h50">
        <div class="sprite_box">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-disabled"></use>
          </svg>
        </div>
        <div class="numberBox">
          <div class="numTit">残疾人（万）</div>
            <div class="numBody">${result.CJR }</div>
        </div>
      </div>
    </div><!--.col-xs-3 End-->
    <div class="col-xs-3 bd-right">
      <div class="tiles h50 bd-bottom">
        <div class="sprite_box">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-Yr"></use>
          </svg>
        </div>
        <div class="numberBox">
          <div class="numTit">65岁以上（万）</div>
            <div class="numBody">${result.YEAR_65 }</div>
        </div>
      </div>
      <div class="tiles h50">
        <div class="sprite_box">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-helpfund"></use>
          </svg>
        </div>
        <div class="numberBox">
          <div class="numTit">救助金额（${result.DW }）</div>
            <div class="numBody">${result.JZJE }</div>
        </div>
      </div>
    </div><!--.col-xs-3 End-->
    <div class="col-xs-3">
      <div class="col-line-box h50">
        <div class="col-xs-6 h50 col-line-item">
          <a href="javascript:;" class="active" onclick="selectBusi('zzy');">
            <i class="ifont icon-industry"></i>
            <span>制造业</span>
          </a>
        </div>
        <div class="col-xs-6 h50 col-line-item">
          <a class="bdr-none" href="javascript:;" onclick="selectBusi('jzy');">
            <i class="ifont icon-constructure"></i>
            <span>建筑业</span>
          </a>
        </div>
        <div class="col-xs-6 h50 col-line-item">
          <a href="javascript:;" onclick="selectBusi('ggjt');">
            <i class="ifont icon-transportation"></i>
            <span>公共交通</span>
          </a>
        </div>
        <div class="col-xs-6 h50 col-line-item">
          <a class="bdr-none" href="javascript:;" onclick="selectBusi('zsy');">
            <i class="ifont icon-accomodation"></i>
            <span>住宿业</span>
          </a>
        </div>
      </div>
      <div class="col-line-box h50">
        <div class="col-xs-6 h50 col-line-item">
          <a href="javascript:;" onclick="selectBusi('cyy');">
            <i class="ifont icon-foodbeverage"></i>
            <span>餐饮业</span>
          </a>
        </div>
        <div class="col-xs-6 h50 col-line-item">
          <a class="bdr-none" href="javascript:;" onclick="selectBusi('hlw');">
            <i class="ifont icon-software"></i>
            <span>IT</span>
          </a>
        </div>
        <div class="col-xs-6 h50 col-line-item">
          <a href="javascript:;" onclick="selectBusi('fdc');">
            <i class="ifont icon-estate"></i>
            <span>房地产</span>
          </a>
        </div>
        <div class="col-xs-6 h50 col-line-item">
          <a class="bdr-none" href="javascript:;" onclick="selectBusi('ny');">
            <i class="ifont icon-piggy"></i>
            <span>农林牧业</span>
          </a>
        </div>
      </div>
    </div><!--.col-xs-3 End-->
  </div><!--.col-xs-7 End-->
  <div class="col-xs-5 col-bd-right">
    <div class="charts-box h100">
      <!-- 行业标题 -->
      <div id="fenlei" class="charts-title"></div>
      <div class="charts-content">
        <!-- 码表容器 -->
      <div id="chart1" class="charts-pie" style="width:30%;"></div>
      <div id="chart2" class="charts-pie" style="width:40%;"></div>
      <div id="chart3" class="charts-pie" style="width:30%;"></div>
      </div>
    </div>
  </div><!--.col-xs-5 End-->
</div>
<!--正文结束-->
</body>
<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<script src="${contextPath}/js/assets/plugins/bootstrap.min.js"></script>
<script src="${contextPath}/js/assets/gis/echarts-all.js"></script>
<script>
function selectBusi(value){
	$.ajax({
		type: "get",
		url: "getHy?hy="+value,
		dataType:"json",
		success: function(data){
			var data1=new Array();
			var data2=new Array();
			var data3=new Array();
			//动态设置仪表盘的最大值
			var sjse=data.SJSE.toString().split(".")[0];
			var xssr=data.XSSR.toString().split(".")[0];
			var hysb=data.HYSB.toString().split(".")[0];
			option1.series[0].max=Math.pow(10,sjse.toString().length);
			option2.series[0].max=Math.pow(10,xssr.toString().length);
			option3.series[0].max=Math.pow(10,hysb.toString().length);
			data1.push({value:data.SJSE,name:'亿元'});
			data2.push({value:data.XSSR,name:'亿元'});
			data3.push({value:data.HYSB,name:'亿元'});
			option1.series[0].data=data1;
			option2.series[0].data=data2;
			option3.series[0].data=data3;
			//myChart.refresh();
			myChart1.setOption(option1,true);
			myChart2.setOption(option2,true);
			myChart3.setOption(option3,true);
			document.getElementById("fenlei").innerHTML='';
			document.getElementById("fenlei").innerHTML=data.HY;
		}	
	})
}
</script>
<script>

var myChart1 = null;
var myChart2 = null;
var myChart3 = null;
var option1 = null;
var option2 = null;
var option3 = null;
function getCharts(){
	myChart1 = echarts.init(document.getElementById("chart1"));
	myChart2 = echarts.init(document.getElementById("chart2"));
	myChart3 = echarts.init(document.getElementById("chart3"));
	option1 = {
			title : {
				text : '实缴税额',
				x : 'center',
				y : 'bottom',
				textStyle :{
				    fontSize: 18,
				    fontWeight: 'bold',
				    color: '#a0a0a0'
				}   
			},
			tooltip : {
		        formatter: "{a} <br/>{c} {b}"
		    },
		    series : [
		        {
		            name:'实缴税额',
		            type:'gauge',
		            center : ['55%', '55%'],
		            radius : '100%',
		            endAngle:45,
		            splitNumber:5,
		            axisLine: {            // 坐标轴线
		            	lineStyle: {
		                    color: [
		                        [0.2, '#6fa0bb'],
		                        [0.8, '#5992b1'],
		                        [1, '#206b95']
		                    ],
		                    width: 5
		                }
		            },
		            axisTick: {            // 坐标轴小标记
		                length :10,        // 属性length控制线长
		                lineStyle: {       // 属性lineStyle控制线条样式
		                    color: 'auto'
		                }
		            },
		            splitLine: {           // 分隔线
		                length :12,         // 属性length控制线长
		                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
		                    color: 'auto'
		                }
		            },
		            pointer :{
	                    length : '80%',
	                    width : 3
	                },
		            title : {
		                offsetCenter: [0, '-30%'],       // x, y，单位px
		            },
		            detail : {
		                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
		                	fontSize : 20
		                }
		            }
		            //data:data2
		        }
		    ]
		};
	option2={
			title : {
				text : '销售收入',
				x : 'center',
				y : 'bottom',
				textStyle :{
				    fontSize: 18,
				    fontWeight: 'bold',
				    color: '#a0a0a0'
				}   
			},
			tooltip : {
		        formatter: "{a} <br/>{c} {b}"
		    },
		    series : [
		        {
		            name:'销售收入',
		            type:'gauge',
		            z: 3,
		            splitNumber:5,
		            radius: '100%',
		            axisLine: {            // 坐标轴线
		            	lineStyle: {
		                    color: [
		                        [0.2, '#6fa0bb'],
		                        [0.8, '#5992b1'],
		                        [1, '#206b95']
		                    ],
		                    width: 5
		                }
		            },
		            axisTick: {            // 坐标轴小标记
		                length :10,        // 属性length控制线长
		                lineStyle: {       // 属性lineStyle控制线条样式
		                    color: 'auto'
		                }
		            },
		            splitLine: {           // 分隔线
		                length :12,         // 属性length控制线长
		                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
		                    color: 'auto'
		                }
		            },
		            pointer :{
	                    length : '80%',
	                    width : 3
	                },
		            title : {
		            	offsetCenter: [0, '-30%'],  
		            },
		            detail : {
		                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
		                	fontSize : 20
		                }
		            }
		           // data:data1
		        },
		        
		    ]
	};
	option3={
			title : {
				text : '社保缴纳',
				x : 'center',
				y : 'bottom',
				textStyle :{
				    fontSize: 18,
				    fontWeight: 'bold',
				    color: '#a0a0a0'
				}   
			},
			tooltip : {
		        formatter: "{a} <br/>{c} {b}"
		    },
		    series : [
		        {
		            name:'社保缴纳',
		            type:'gauge',
		            center : ['40%', '55%'], 
		            radius : '100%',
		            splitNumber:5,
		            startAngle:125,
		            axisLine: {            // 坐标轴线
		            	lineStyle: {
		                    color: [
		                        [0.2, '#6fa0bb'],
		                        [0.8, '#5992b1'],
		                        [1, '#206b95']
		                    ],
		                    width: 5
		                }
		            },
		            axisTick: {            // 坐标轴小标记
		                length :10,        // 属性length控制线长
		                lineStyle: {       // 属性lineStyle控制线条样式
		                    color: 'auto'
		                }
		            },
		            splitLine: {           // 分隔线
		                length :12,         // 属性length控制线长
		                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
		                    color: 'auto'
		                }
		            },
		            pointer :{
	                    length : '80%',
	                    width : 3
	                },
		            title : {
		                offsetCenter: [0, '-30%'],       // x, y，单位px
		            },
		            detail : {
		                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
		                	fontSize : 20
		                }
		            }
		           // data:data3
		        }
		    ]
	}
	
}

		$(function(){
			setTimeout(function(){
				getCharts();
				selectBusi('zzy');
			}, 200);
			
			
		});
		
	
	
</script>
</html>