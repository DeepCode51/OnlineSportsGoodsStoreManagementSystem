<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
String applicationPath = basePath + "/" + "application";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>项目管理系统</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="css/css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="59" background="images/top.gif"><table width="99%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="1%"><img src="images/logo.gif" width="557" height="59" border="0" /></td>
        <td width="64%" align="right" style="font-size:12px;vertical-align:bottom;">  当前用户：${admin.userName}(${admin.userType})&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>

<script>

 
//退出
function logonOut(){
	 parent.location = '<%=path%>/loginuser!logonOut.action';
	 self.close();
}

</script>
