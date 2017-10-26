/**
 * 城市体征公用方法
 */

/**
 * 根据体征指数值得到指数变化率
 */
function getSignRate(arrSign){
	var arrRate = new Array();
	for(var i = 0; i < arrSign.length; i++){
		if(i == 0 || i == (arrSign.length-1)){
			arrRate[i] = 1.0;
		}else if(arrSign[i] == 0){
			arrRate[i] = 0;
		}else{
			arrRate[i] = (arrSign[i+1]/arrSign[i]).toFixed(2);
		}
	}
	
	return arrRate;
}
