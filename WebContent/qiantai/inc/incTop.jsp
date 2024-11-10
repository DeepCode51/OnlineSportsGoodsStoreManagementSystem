<%@ page language="java" import="java.util.*,cn.itbaizhan.record.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <script type="text/javascript">
	        function myXinxi()
	        {
	            <s:if test="#session.user==null">
	                  alert("请先登录");
	            </s:if>
	            
	            <s:else>
	                var url="<%=path %>/qiantai/userinfo/userXinxi.jsp";
	                var n="";
	                var w="480px";
	                var h="500px";
	                var s="resizable:no;help:no;status:no;scroll:yes";
				    openWin(url,n,w,h,s);
	            </s:else>
	        }
	        function myCart()
	        {
	            <s:if test="#session.user==null">
	                  alert("请先登录");
	            </s:if>
	            
	            <s:else>
	                 var s="<%=path %>/myCart.action";
	                 window.location.href=s;
	            </s:else>
	        }
	        
	        function myOrder()
	        {
	            <s:if test="#session.user==null">
	                  alert("请先登录");
	            </s:if>
	            
	            <s:else>
	                 var s="<%=path %>/myOrder.action";
	                 window.location.href=s;
	            </s:else>
	        }
	        
	        function liuyanAll()
	        {
	            <s:if test="#session.user==null">
	                  alert("请先登录");
	            </s:if>
	            
	            <s:else>
	                 var url="<%=path %>/liuyanAll.action";
	                 
	                var n="";
	                var w="800px";
	                var h="500px";
	                var s="resizable:no;help:no;status:no;scroll:yes";
				    openWin(url,n,w,h,s);
				    
	            </s:else>
	        }
      </script>
     <style rel="stylesheet" type="text/css" media="screen">
html,body {
	margin: 0;
	padding: 0;
	height: 100%;
	width: 100%;
	border: none;
	outline: none;
}

body {
	font: 12px;
	text-align: center;
	color: #444444;
	margin: 0 auto;
	background-color: #fff;
	background-image: url(images/bg.jpg);
	background-repeat: repeat-x;
	background-position: center top;
}

a:visited {
	text-decoration: none;
	color: #333;
}

a:hover {
	text-decoration: none;
	color: #f00;
}

a:active {
	text-decoration: none;
}

.jay {
	width: 100%;
	text-align: center;
	margin: 0 auto;
	background: #fff;
}

.zt {
	width: 1020px;
	text-align: center;
	margin: 0 auto;
}

#A {
	margin-top: 12px;
}

#K {
	width: 1020px;
	text-align: center;
	margin: 0 auto;
}

#P {
	width: 1000px;
	text-align: center;
	margin: 0 auto;
}

#C {
	width: 255px;
	background-image: url(http://img1.epanshi.com/8201/upload/left_bg.jpg);
}

#E {
	width: 701px;
}

#F {
	height: 80px;
	background: #26deb9;
}

.mar {
	margin-bottom: 5px;
}

.cle {
	height: 0px;
	font-size: 0px;
	line-height: 0px;
	clear: both;
}

#CMenuMultiLevel-332774-43069-2 table,#CMenuMultiLevel-332774-43069-2 td,#CMenuMultiLevel-332774-43069-2 tr,#CMenuMultiLevel-332774-43069-2 th
	{
	font-size: 12px;
	border: none;
}

#CMenuMultiLevel-332774-43069-2 table {
	border-collapse: collapse;
	border-spacing: 0;
	empty-cells: show;
	margin: 0;
	padding: 0;
	text-align: left;
	border: none;
}

#CMenuMultiLevel-332774-43069-2 th,#CMenuMultiLevel-332774-43069-2 td {
	border-collapse: collapse;
	border: none;
	margin: 0;
	padding: 0;
}

#CMenuMultiLevel-332774-43069-2 .markermenu img {
	border: none;
}

#CMenuMultiLevel-332774-43069-2 .markermenu {
	background: url(qiantai/qimg/navBg.jpg);
	border: solid 0px #D4D8D9;
	margin: 0px;
	line-height: 38px;
	clear: left;
	position: relative;
}

#CMenuMultiLevel-332774-43069-2 .markermenu table {
	margin: 0 auto;
	border: none;
}

#CMenuMultiLevel-332774-43069-2 .markermenu td a {
	padding: 0px 25px;
	line-height: 38px;
	height: 38px;
	font-weight: bold;
	font-size: 14px;
	color: #fff;
	border: solid 0px;
	display: block;
	text-decoration: none;
	vertical-align: middle;
}

#CMenuMultiLevel-332774-43069-2 .markermenu td a img {
	vertical-align: middle;
	_margin: 12px 0px;
	margin-right: 5px;
}

#CMenuMultiLevel-332774-43069-2 .markermenu td a:hover,#CMenuMultiLevel-332774-43069-2 .markermenu td a.selected
	{
	color: #ff0;
	border: dotted 0px #ffff00;
	display: block;
	vertical-align: middle;
}

#CMenuMultiLevel-332774-43069-2 .downarrowpointer,ul.ps_53675ed982ad2 .downarrowpointer
	{
	padding-left: 4px;
	border: 0;
	_margin: 0 !important;
}

#CMenuMultiLevel-332774-43069-2 .rightarrowpointer,ul.ps_53675ed982ad2 .rightarrowpointer
	{
	position: absolute;
	padding-top: 3px;
	left: 100px;
	border: 0;
	_margin: 0 !important;
}

* html ul.ps_53675ed982ad2 li {
	display: inline-block;
	width: 100px;
}

* html ul.ps_53675ed982ad2 li a {
	display: inline-block;
	width: 100px;
}

ul.ps_53675ed982ad2 li a:hover {
	color: #f00;
	border: solid 0px;
	background: #eee;
}

#CFocuspicture-499104-59408-1 {
	margin: 5px 0;
	padding: 0;
}

#CFocuspicture-499104-59408-1 {
	text-align: left;
	position: relative;
	z-index: 1;
	width: 1000px;
	height: 440px;
	border: 0px solid;
	overflow: hidden;
	font: normal 12px Georgia, Arial, Helvetica, sans-serif;
}

#CFocuspicture-499104-59408-1 dl {
	position: absolute;
	z-index: 2;
	width: 1000px;
	height: 440px;
	overflow: hidden;
}

#CFocuspicture-499104-59408-1 dt {
	position: absolute;
	z-index: 3;
	top: 0;
	left: 0;
	overflow: hidden;
}

#CFocuspicture-499104-59408-1 dt,#CFocuspicture-499104-59408-1 dt img {
	width: 1000px;
	height: 440px;
}

#CFocuspicture-499104-59408-1 dd {
	position: absolute;
	z-index: 4;
	bottom: 0;
	left: 0;
	width: 1000px;
	height: 0px;
	color: #FFF;
	overflow: hidden;
	background-color: #000;
	opacity: .7;
	-moz-opacity: .7;
	filter: alpha(opacity =     70);
}

p#nIndexCFocuspicture-499104-59408-1 {
	position: absolute;
	z-index: 5;
	bottom: 4px;
	right: 4px; 72
	height: 19px;
	text-align: right;
	overflow: hidden;
}

#CQq-337718-44295-2 {
	margin: 10px;
	border: 0px #D4D8D9 solid;
}  /*控件样式结束*/
#CQq-337718-44295-2 .numMargin {
	margin: 0px 10px;
	display: inline-block;
}

#CQq-337718-44295-2 .qqbox {
	width: 132px;
	height: auto;
	overflow: hidden;
	position: absolute;
	left: 0;
	top: 100px;
	color: #444444;
	font-size: 12px;
	letter-spacing: 0px;
	z-index: 999;
}

#CQq-337718-44295-2 .qqkf {
	width: 120px;
	height: auto;
	overflow: hidden;
	right: 0;
	top: 0px;
	z-index: 99px;
	/* border:6px solid #red;*/ /*background:#fff;*/
}

#CQq-337718-44295-2 .qqkfhm {
	width: 112px;
	overflow: hidden;
	line-height: 22px;
	padding-right: 8px;
	position: relative;
	margin: 3px 0;
}

#CQq-337718-44295-2 .bgdh {
	width: 102px;
	padding-left: 10px;
}

#CImage-332778-43073-2 {
	border: 0px #D4D8D9 solid;
}  /*控件样式结束*/
#CImage-332778-43073-2 img {
	border: 0px #D4D8D9 solid;
}

#CImage-1732217-194700-1 {
	border: 0px #D4D8D9 solid;
}  /*控件样式结束*/
#CImage-1732217-194700-1 img {
	border: 0px #D4D8D9 solid;
}

.product-listps_53675ed98982f {
	width: 998px;
	margin: 0px auto;
	border: 0px solid #ccc;
}

.product-listps_53675ed98982f ul {
	list-style: none;
	margin: 0;
	padding: 0;
	border: 0;
}

.product-listps_53675ed98982f .bgcolor-odd {
	background: #F3F3F3;
}

.product-listps_53675ed98982f .bgcolor-even {
	background: #EEF7FF;
}

/*图片设置*/
.product-listps_53675ed98982f .pimg {
	width: 150px;
	height: 120px;
	border: 1px #ccc solid;
	background: #fff;
	margin: 3px 15px;
	padding: 0px;
}

.product-listps_53675ed98982f .nopimg {
	width: 150px;
	height: 120px;
	border: 1px #ccc solid;
	background: #fff;
	margin: 3px 15px;
	padding: 0px;
}

.product-listps_53675ed98982f .pimg img {
	display: ;
	border: none;
}

.product-listps_53675ed98982f .nopimg img {
	display: ;
	border: none;
}

/*图片居中*/
.product-listps_53675ed98982f td {
	text-align: center;
}

.product-listps_53675ed98982f h3 {
	margin: 3px 15px;;
	width: 150px;;
	font-weight: normal;
	font-size: 12px !important;
	color: #999;
	text-align: center;
	word-wrap: break-word;
	overflow: hidden;
}

.product-listps_53675ed98982f a:link {
	font-size: 12px;
	color: #333;
	text-decoration: none;
}

.product-listps_53675ed98982f a:visited {
	font-size: 12px;
	color: #333;
	text-decoration: none;
}

.product-listps_53675ed98982f a:hover {
	font-size: 12px;
	color: #ff6000;
	text-decoration: underline;
}  /*鼠标经过字体颜色、下划线*/
.product-listps_53675ed98982f a:active {
	font-size: 12px;
	color: #888;
	text-decoration: none;
}

#CImage-1732255-194705-1 {
	margin: 5px 0px 0px 0px;
	border: 0px #D4D8D9 solid;
}  /*控件样式结束*/
#CImage-1732255-194705-1 img {
	border: 0px #D4D8D9 solid;
}

#CSinglePage-1732257-194707-1 {
	text-align: left;
	margin: 0px;
	padding: 5px 10px;
	font-size: 12px;
	color: #333;
	line-height: 25px;
	border: 0px #D4D8D9 solid;
}  /*控件样式结束*/
#CImage-1732259-194709-1 {
	margin: 0px 0px 5px 0px;
	border: 0px #D4D8D9 solid;
}  /*控件样式结束*/
#CImage-1732259-194709-1 img {
	border: 0px #D4D8D9 solid;
}
</style>
  </head>
  
  <body>
  
  <div id="ContainerPanel" style="display: none;">
			<div id="calendarPanel"
				style="position: absolute; display: none; z-index: 9999; background-color: #FFFFFF; border: 1px solid #CCCCCC; width: 175px; font-size: 12px; margin-left: 25px;"></div>
		</div>


		<div class="zt">
			<div id="H">
				<table width="1000" border="0" align="center" cellpadding="0"
					cellspacing="0"
					style="font-size: 12px; line-height: 23px; color: #eee;">
					<tbody>
						<tr>
							<td width="750" class="notice" align="left">
								
							</td>

						</tr>
					</tbody>
				</table>
				<div id="CImage-332778-43073-2">
					<img src="qiantai/qimg/header-1.jpg" border="0" alt="">
				</div>
			</div>
    
		
		<div id="A">
				<div id="CMenuMultiLevel-332774-43069-2">
					<div class="markermenu">
						<table>
							<tbody>
								<tr>
									<td>
										<a href="<%=path %>/qiantai/default.jsp"
											target="_self" >网站首页</a>
									</td>
									<td>
										<img src="qiantai/qimg/line.gif" width="1px" height="13px">
									</td>
									

									<td>
										<img src="qiantai/qimg/line.gif" width="1px" height="13px">
									</td>
									<td>
										<a href="goodsAllNoTejia.action"
											target="_self" rel="CMenuMultiLevel-332774-43069-213"
											class="">商品信息</a>
									</td>
								
									
									<td>
										<img src="qiantai/qimg/line.gif" width="1px" height="13px">
									</td>

									
									
									
									<td>
										<img src="qiantai/qimg/line.gif" width="1px" height="13px">
									</td>
									<td>
										<a href="#" onclick="liuyanAll()"
											target="_self">在线留言</a>
									</td>
									<td>
										<img src="qiantai/qimg/line.gif" width="1px" height="13px">
									</td>
									
									
									<td>
										<img src="qiantai/qimg/line.gif" width="1px" height="13px">
									</td>
										<td>
										<A href="#" onclick="myXinxi()" target="_self" rel="CMenuMultiLevel-332774-43069-213">我的信息</A>
									</td>
									<td>
										<img src="qiantai/qimg/line.gif" width="1px" height="13px">
									</td>
									
									<td>
										<img src="qiantai/qimg/line.gif" width="1px" height="13px">
									</td>
										<td>
										<A href="#" onclick="myCart()" target="_self" rel="CMenuMultiLevel-332774-43069-213">购物车</A>
									</td>
									<td>
										<img src="qiantai/qimg/line.gif" width="1px" height="13px">
									</td>
									
									<td>
										<img src="qiantai/qimg/line.gif" width="1px" height="13px">
									</td>
										<td>
										<A href="#" onclick="myOrder()" target="_self" rel="CMenuMultiLevel-332774-43069-213">我的订单</A>
									</td>
									<td>
										<img src="qiantai/qimg/line.gif" width="1px" height="13px">
									</td>
									
										<td>
										<img src="qiantai/qimg/line.gif" width="1px" height="13px">
									</td>
									<td>
										<a href="qiantai/lianxi/lianxi.jsp"
											target="_self">联系我们</a>
									</td>
									
									
								
									
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

		
		<form id="searchForm" action="<%=path %>/goodSearch.action" method="post">
			<div class="topsearch">
				<div class="title"></div>
				<div id="page_search_left">
					<input class="inputText" id="goodsName" size="16" onkeypress="if(event.keyCode==13){searchFormSubmit();return false;}" name="goodsName" type="text" />
				</div>
				 
				<div id="page_search_btn">
					<input type="submit" value="商品搜索">&nbsp;&nbsp;&nbsp;    </b>
				</div>
				
				<div id="page_search_right">
				  
					
				</div>
				<div style="clear: both"></div>
			</div>
		</form>
		 
  </body>
</html>
