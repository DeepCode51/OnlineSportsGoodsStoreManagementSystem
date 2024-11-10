<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>



<div id="F">
	<div class="bq">
	<br/>
		版权所有： &nbsp;
		

		<a target="_blank" href="<%=path%>/admin/login.jsp">管理登录</a>
	</div>
	 
</div>

