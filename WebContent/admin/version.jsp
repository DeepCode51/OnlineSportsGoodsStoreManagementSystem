<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link rel="stylesheet" href="<%=path %>/css/common.css" type="text/css" />
<title>管理区域</title>
</head>
<body>
<div id="man_zone">

  <table width="95%" border="0" align="center"  cellpadding="3" cellspacing="1" class="table_style">
     <tr>
      <td colspan="2"  >&nbsp;欢迎光临网上体育商城</td>
    </tr> 
    <tr>
      <td width="18%" class="left_title_1"><span class="left-title">系统名称</span></td>
      <td width="82%">&nbsp;网上体育商城系统</td>
    </tr>
    <tr>
      <td class="left_title_2">当前版本</td>
      <td>&nbsp;1.0版</td>
    </tr>
   
    <tr>
      <td class="left_title_2">作者</td>
      <td>&nbsp;wangkelin</td>
    </tr>
    <tr>
      <td class="left_title_1">电子邮件 </td>
      <td>&nbsp; 947342283@qq.com</td>
    </tr>
   
  
         
  </table>

</div>
</body>
</html>
