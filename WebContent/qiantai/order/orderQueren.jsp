<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		
		<link href="<%=path %>/css/layout.css" type="text/css" rel="stylesheet" />
		
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		<script type="text/javascript">
            function back1()
	        {
	           window.history.go(-1);
	        }
        </script>
	</head>

	<body>
		<jsp:include flush="true" page="/qiantai/inc/incTop.jsp"></jsp:include>
		<div class="page_row">
			<!--左边的 -->
			<div class="page_main_msg left">		
		        <div class="left_row">
		            <div class="list pic_news">
		  	                <div class="list_bar">&nbsp;订单确认</div>
						  	<form action="<%=path %>/orderSubmit.action" name="f" method="post">
		                        <table width="99%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF" align="center" style="margin-top:8px">
					              <tr align='center' bgcolor="#FFFFFF" height="22">
					                  <td>收货人帐号：</td>
					                  <td>
					                      <input type="text" readonly="readonly" value="<s:property value="#session.user.userName"/>"/>
					                  </td>
					              </tr>
					              <tr align='center' bgcolor="#FFFFFF" height="22">
					                  <td>收货人姓名：</td>
					                  <td>
					                      <input type="text" readonly="readonly" value="<s:property value="#session.user.userRealname"/>"/>
					                  </td>
					              </tr>
					              <tr align='center' bgcolor="#FFFFFF" height="22">
					                  <td>收货人联系电话：</td>
					                  <td>
					                      <input type="text"  value="<s:property value="#session.user.userTel"/>"/>
					                  </td>
					              </tr>
					              
					              <tr align='center' bgcolor="#FFFFFF" height="22">
					                  <td>送货地址：</td>
					                  <td><input type="text" name="odderSonghuodizhi" value="<s:property value="#session.user.userAddress"/>"/></td>
					              </tr>
					              <tr align='center' bgcolor="#FFFFFF" height="22">
					                  <td>付款方式：</td>
					                  <td>
		   		                          <select name="odderFukuangfangshi" style="width:155px;">
		   		                               <option value="货到付款">货到付款</option>
		   		                               <option value="支付宝付款">支付宝付款</option>
		   		                          </select>
		                              </td>
					              </tr>
		        				</table>
		        				<table>
		        				   <tr height="7"><td></td></tr>
				                   <tr>
				                       <td width="120"></td>
				                       <td><a href="#" onclick="back1()"><img border="0" src="<%=path %>/images/Car_icon_back.gif"/></a></td>
				                       <td><img border="0" src="<%=path %>/images/Car_icon_06.gif" onclick="javascript:document.f.submit();"/></td>
				                   </tr>
				               </table>
				            </form>
		             </div>
		         </div>	
	        </div>
			<!--左边的 -->
			<!-- 右边的用户登录。留言。投票 -->
			<div class="page_other_msg right">
				<div class="left_row">
					<div class="list">
						<div class="list_bar">
							用户登录
						</div>
						<div class="list_content">
							<div id="div">
								<jsp:include flush="true" page="/qiantai/userlogin/userlogin.jsp"></jsp:include>
							</div>
						</div>
					</div>
				</div>
                <div class="left_row">
				    <div class="list">
				        <div class="list_bar">商品分类</div>
				        <div class="list_content">
				            <div id="div"> 
				                   <div style="overflow:hidden;height:150px;">
							             <div id="roll-orig-1607838439">
										     <s:action name="catelogAll" executeResult="true" flush="true"></s:action>
							             </div>
						                 <div id="roll-copy-1607838439"></div>
				                   </div>
					        </div>
					    </div>
				    </div>
				</div>
				<div class="left_row">
				    <div class="list">
				        <div class="list_bar">网站公告</div>
				        <div class="list_content">
				            <div id="div"> 
				                   <div style="overflow:hidden;height:150px;">
							             <div id="roll-orig-1607838439">
										 <s:action name="gonggaoQian5" executeResult="true" flush="true"></s:action>
							             </div>
						                 <div id="roll-copy-1607838439"></div>
				                   </div>
					        </div>
					    </div>
				    </div>
				</div>
			</div>
			<div style="clear: both"></div>
			<!-- 右边的用户登录。留言。投票 -->
		</div>
		
		<div>
		   <jsp:include flush="true" page="/qiantai/inc/incFoot.jsp"></jsp:include>
	    </div>
	</body>
</html>
