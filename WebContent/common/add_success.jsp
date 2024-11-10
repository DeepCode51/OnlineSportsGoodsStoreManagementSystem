<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title></title>
</head>
<body>
<center>
	<p>
	 <s:if test="message!=null">
               <s:property value='message'/>
     </s:if>
     <s:if test="message==null">
        操作成功！
     </s:if>
	<div id="info">本窗口将在3秒后自动关闭</div>
	<input type="button" value="关闭窗口" onclick="closewindow()">
</center>

<script type="text/javascript">
function closewindow()
{
	window.returnValue=false;
	window.close();
	
}
function clock()
{
	i = i -1;
	
	if(i > 0)
	{
	    document.getElementById("info").innerHTML = "本窗口将在"+i+"秒后自动关闭";
		setTimeout("clock();",1000);
	}
	else
	{
		closewindow();
	}
}

var i = 4;
clock();
</script>
</body>
</html>