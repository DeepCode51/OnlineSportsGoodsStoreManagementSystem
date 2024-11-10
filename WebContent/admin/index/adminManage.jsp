<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path%>/css/base.css" />
		<script type="text/javascript"
			src="<%=path%>/js/jquery/jquery-1.4.2.min.js">
		</script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery/plugin/jquery-easyui/jquery.easyui.min.js">
		</script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery/plugin/jquery-easyui/locale/easyui-lang-zh_CN.js">
		</script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery/plugin/jquery-easyui/plugins/jquery.window.js">
		</script>

		<script language="javascript">
function adminDel(userId) {
	if (confirm('您确定删除吗？')) {
		window.location.href = "<%=path%>/adminDel.action?userId=" + userId;
	}
}

function adminAdd() {
	var url = "<%=path%>/admin/index/adminAdd.jsp";
	//var n="";
	//var w="480px";
	//var h="500px";
	//var s="resizable:no;help:no;status:no;scroll:yes";
	//openWin(url,n,w,h,s);
	window.location.href = url;
}
</script>
	</head>

	<body leftmargin="2" topmargin="2"
		background='<%=path%>/images/allbg.gif'>
		<input type="hidden" name="messageInfo" id="messageInfo"
			value="${messageInfo}" />
		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
			<tr bgcolor="#E7E7E7">
				<td height="14" colspan="14" background="<%=path%>/images/wbg.gif">
					&nbsp;管理员维护&nbsp;
					
				</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<td width="15%">
					ID
				</td>
				<td width="15%">
					用户名
				</td>
				<td width="15%">
					密码
				</td>
				<td width="15%">
					类型
				</td>
				<td width="15%">
					操作
				</td>
			</tr>
			<s:iterator value="#request.adminList" id="admin">
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='red';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#admin.userId" />
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#admin.userName" />
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#admin.userPw" />
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#admin.userType" />
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a
							href="toadminEdit.action?userId=<s:property value="#admin.userId"/>"
							class="pn-loperator">编辑</a>|
						<a href="#"
							onclick="adminDel(<s:property value="#admin.userId"/>)"
							class="pn-loperator">删除</a>

					</td>
				</tr>
			</s:iterator>
		</table>

		<table width='98%' border='0'
			style="margin-top: 8px; margin-left: 5px;">
			<tr>
				<td>
					<input type="button" value="添加" style="width: 80px;"
						onclick="adminAdd()" />
				</td>
			</tr>
		</table>
	</body>
</html>
<script>

$(document).ready(function() {
	var $messageInfo = $("#messageInfo").val();
	
	if ($messageInfo != null && $messageInfo != "") {
		alert("操作成功");
	}
});
</script>
