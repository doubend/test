/**
 * 专题体征页面左侧树结构
 */

 $("#TipsTree").tree({
        url : contextPath+'/cstz/queryTzmxTree?tzID='+tzID,
        onLoadSuccess:function(data){
        	var node = $('#TipsTree').tree('find', tzID);
        	$('#TipsTree').tree('select', node.target);
        },
        onClick:function(data){
        	var level = data.attributes.level;
        	var id = data.attributes.id;
        	if(level == 1){
        		var tzmc = data.attributes.name;
        		window.location.href = contextPath+'/cstz/toGeneralSigns2?tzmc=' + encodeURI(tzmc);
        	}else if(level == 2){
        		//window.location.href = contextPath+'/cstz/zttz/' + id;
        		var url = contextPath + '/cstz/zttz/' + id;
        		$('#theRight').attr("src", url);
        	}else if(level == 3){
        		//window.location.href = contextPath+'/cstz/zttzTwo/' + id;
        		var url = contextPath + '/cstz/zttzTwo/' + id;
        		$('#theRight').attr("src", url);
        	}
        }
    });