
var rootChildren;
var rootId;

$(function ($) {
	//后台查询返回体征模型树结构
	$.ajax( {  
	    url:contextPath+'/cstz/queryCstzModelData',    // 跳转到 action  
	    data:{},
	    type:'post',  
	    dataType:'json',  
	    success:function(result) {
	    	var leftData = new Array();
	        leftData[0] = new Object();
	        leftData[0].id = result[0].id;
	        //leftData[0].name = result.data.name;
	        leftData[0].modified = result[0].modified;
	        leftData[0].value = result[0].value;
	        //leftData[0].itemStyle = result[0].itemStyle;
	        leftData[0].children = new Array();
	        //leftData[0].children[0] = result[0].children[0];
	        //leftData[0].children[1] = result[0].children[3];
	        var arrLeft = getChildrenIndex(1, result[0].children.length);
	        for(var i = 0; i < arrLeft.length; i++){
	        	leftData[0].children[i] = result[0].children[arrLeft[i]];
	        	setItemStyle(leftData[0].children[i], 'left');
	        }
	        //setItemStyle(leftData[0].children[0], 'left');
	        //setItemStyle(leftData[0].children[1], 'left');

	        var rightData = new Array();
	        rightData[0] = new Object();
	        rightData[0].id = result[0].id;
	        rightData[0].name = "[" + result[0].value + "]" + result[0].name;
	        rightData[0].modified = result[0].modified;
	        rightData[0].value = result[0].value;
	        //rightData[0].itemStyle = result[0].itemStyle;
	        rightData[0].children = new Array();
	        //rightData[0].children[0] = result[0].children[2];
	        //rightData[0].children[1] = result[0].children[1];
	        var arrRight = getChildrenIndex(0, result[0].children.length);
	        for(var i = 0; i < arrLeft.length; i++){
	        	rightData[0].children[i] = result[0].children[arrRight[i]];
	        	setItemStyle(rightData[0].children[i], 'right');
	        }
	        //setItemStyle(rightData[0].children[0], 'right');
	        //setItemStyle(rightData[0].children[1], 'right');

	        showIndexDataTree(leftData, rightData);
	        rootChildren = result[0].children;
	        rootId = result[0].id;
	     },  
	     error : function() {    
	          alert("查询返回数据异常！");  
	     }  
	});
	
});

function getChildrenIndex(pos, len){
	var arr = new Array();
	var j = 0;
	if(pos == 0){
		for(var i = 0; i < len; i++){
			if(i%2 == 0){  //偶数
				arr[j++] = i;
			}
		}
	}else if(pos == 1){
		for(var i = 0; i < len; i++){
			if(i%2 == 1){  //奇数
				arr[j++] = i;
			}
		}
	}
	
	return arr;
}

function setItemStyle(data, postion) {
    data.realName = data.name;
    data.name = "[" + data.value + "]" + data.name;

    var lableColor = "#333";
    var dotColor = "#005EBB";
    var titlePosition = "top";
    var symbol = 'circle';
    if (data.children && data.children != null && data.children.length > 0) {
        titlePosition = "top";
        $.each(data.children, function (key, value) {
            setItemStyle(value, postion);
        });
    } else {
    	if(data.signLevel != 4){
    		titlePosition = "top";
    	}else{
    		titlePosition = postion;
    	}
        
        if (data.hasStatic) {
            symbol = 'emptyTriangle';
            dotColor = "#EE9A00";
        }
    }

    if (data.modified && data.modified == true) {
        // lableColor = "#FF0000";
        dotColor = "#FF0000";
    }

    var labelPos = {
        normal: {
            label: {
                show: true,
                textStyle: {
                    color: lableColor
                },
                position: titlePosition
            },
            color: dotColor,
            lineStyle: {
                color: '#bbb',
                type: 'broken' // 'curve'|'broken'|'solid'|'dotted'|'dashed'
            }
        },
        emphasis: {
            label: {
                show: true
            }
        }
    };
    data.itemStyle = labelPos;
    data.symbol = symbol;
}

function showIndexDataTree(leftData, rightData) {
	 require.config({
	        paths: {
	            echarts: '../js/assets/plugins/Echarts/build'
	        }
	    });

	    require(
	        [
	            'echarts',
	            'echarts/chart/tree'
	        ],
	        function (ec) {
	            echart = ec;
	            var tree = ec.init(document.getElementById('tree'));
	            tree.setOption(getOption(leftData, rightData));

	            //var ecConfig = require('echarts/config');
	            //tree.on(ecConfig.EVENT.CLICK, eConsole);
	        }
	    );
}

function getOption(leftData, rightData) {
    var option = {
        title: {
            text: '',
            subtext: ''
        },
        calculable: false,
        tooltip : {
            trigger: 'item',
            formatter: "{b}: {c}"
        },
        series: [
            {
                name: '',
                type: 'tree',
                layerPadding: 110,
                direction: 'inverse',
                orient: 'horizontal',  // vertical horizontal
                rootLocation: {x: 'center', y: 425}, // 根节点位置  {x: 100, y: 'center'}
                nodePadding: 25,
                symbolSize: 12,
                itemStyle: {
                    normal: {
                        label: {
                            show: true,
                            position: 'top',
                            textStyle: {
                                color: '#333'
                            }
                        },
                        color: "#005EBB",
                        lineStyle: {
                            color: '#bbb',
                            type: 'broken' // 'curve'|'broken'|'solid'|'dotted'|'dashed'
                        }
                    },
                    emphasis: {
                        label: {
                            show: true
                        }
                    }
                },
                data: leftData
            },
            {
                name: '',
                type: 'tree',
                layerPadding: 110,
                orient: 'horizontal',  // vertical horizontal
                rootLocation: {x: 'center', y: 425}, // 根节点位置  {x: 100, y: 'center'}
                nodePadding: 18,
                symbolSize: 12,
                itemStyle: {
                    normal: {
                        label: {
                            show: true,
                            position: "top",
                            textStyle: {
                                color: '#333'
                            }
                        },
                        color: "#005EBB",
                        lineStyle: {
                            color: '#bbb',
                            type: 'broken' // 'curve'|'broken'|'solid'|'dotted'|'dashed'
                        }
                    },
                    emphasis: {
                        label: {
                            show: true
                        }
                    }
                },
                data: rightData
            }
        ]
    };
    return option;
}

function eConsole(param) {
    var children = param.data.children;
    var windowTitle;
    if (!children || children.length < 1) {
        if (!param.data.hasStatic) {
            return;
        } else {
            openWeightWindow = false;
            var inputContent = '<tr><td style="text-align: right; nowrap">' + param.data.staticName + ':</td><td>'
                + '<input  nodeid="' + param.data.id
                + '"class="easyui-textbox" type="text" data-options="required:true" validType="isNumeric" value="'
                + param.data.staticValue + '" oldValue="'
                + param.data.staticValue + '" style="width:80px"></input></td></tr>';
            $("#weight_modify_form").html(inputContent);
            windowTitle = geti18nPropVal("com_zte_wuxi_static_data_window_title");
            setRules(2, geti18nPropVal("com_zte_wuxi_static_accurate_tooltip"));
        }
    } else {
        openWeightWindow = true;
        var inputContent;
        if (param.data.id == rootId) {
            inputContent = getInputText(rootChildren);
            inputCanbeZero = false;
        } else {
            inputContent = getInputText(children);
            inputCanbeZero = true;
        }
        $("#weight_modify_form").html(inputContent);
        windowTitle = geti18nPropVal("com_zte_wuxi_sysconf_window_title");
        setRules(1, geti18nPropVal("com_zte_wuxi_accurate_tooltip"));
    }

    $("#modify_window").window({
        collapsible: false,
        minimizable: false,
        maximizable: false,
        resizable: false,
        shadow: false,
        modal: true,
        inline: false,
        width: 200,
        title: windowTitle
    }).window('center').window('open');
}