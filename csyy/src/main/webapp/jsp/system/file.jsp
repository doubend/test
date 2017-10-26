<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/jsp/include/base-tag.jsp"%>
<script type="text/javascript" src="${commonSkin}/js/jquery.form.js"></script>
<title>文件上传</title>
<script type="text/javascript">
	$(function() {
		$("#fileinfo").submit(function() {
			$(this).ajaxSubmit({
				type : "post", //提交方式
				url : contextPath + '/upfile/file',
				dataType : "text", //数据类型 
				success : function(data) { //提交成功的回调函数
					alert(data);
				},
				error : function(err) {
					/* $.post(contextPath+"/upfile/progress",
						function(datas){
							alert(datas);
						}); */
				}
			});
			return false; //不刷新页面
		});

	});
</script>
</head>
<body>
	<form method="post" id="fileinfo" enctype="multipart/form-data">
		<input name="file" type="file"> <input name="submitbutton"
			id="submitbutton" type="submit" value="上传">
	</form>

</body>
</html>