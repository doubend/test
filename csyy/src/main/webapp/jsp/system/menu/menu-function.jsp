<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  	<%@include file="/jsp/include/base-tag.jsp"%>
   
  </head>
  <body>
  <div class="easyui">
   	<ul id="function-tree"  class="easyui-tree tree pdb-10"   style="margin:5px;"
  		data-options="
			url: contextPath+'/system/menu/func_tree?menuId=${param.menuId}',
			method:'get',
  			checkbox: true,
			animate:true,
			onlyLeafCheck:true,
			onClick:function(node){
				if(node.attributes.type==1) {
					$(this).tree('toggle', node.target);
				} else {
					if($(node.target).find('.tree-checkbox0').size()>0) {
						$(this).tree('check', node.target);
					} else {
						$(this).tree('uncheck', node.target);
					}
				}
			}"></ul> 
   </div>
  </body>
</html>
