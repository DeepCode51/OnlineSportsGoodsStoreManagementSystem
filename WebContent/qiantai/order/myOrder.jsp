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

		<link href="<%=path%>/css/layout.css" type="text/css" rel="stylesheet" />

		<script language="JavaScript" src="<%=path%>/js/public.js"
			type="text/javascript">
		</script>
		<script type="text/javascript">
function orderDel(orderId) {
	var url = "<%=path%>/orderDel.action?orderId=" + orderId;
	window.location.href = url;
}

function orderShouhuo(orderId) {
	var url = "<%=path%>/orderShouhuo.action?orderId=" + orderId;
	window.location.href = url;
}

function orderPing(order_id) {
	var url = "<%=path%>/orderDetailPing.action?orderId=" + order_id;
	var n = "";
	var w = "600px";
	var h = "500px";
	var s = "resizable:no;help:no;status:no;scroll:yes";
	openWin(url, n, w, h, s);
	window.location.reload(); 
}

function orderDetail(orderId) {
	var url = "<%=path%>/orderDetail.action?orderId=" + orderId;
	var n = "";
	var w = "700px";
	var h = "700px";
	var s = "resizable:no;help:no;status:no;scroll:yes";
	openWin(url, n, w, h, s);
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
						<div class="list_bar">
							&nbsp;我的订单
						</div>
						<table width="99%" border="0" cellpadding="2" cellspacing="1"
							bgcolor="#FFFFFF" align="center" style="margin-top: 8px">
							<tr align="center" bgcolor="#FAFAF1" height="22">
								<td>
									订单编号
								</td>
								<td>
									金额
								</td>
								<td>
									下单日期
								</td>
								<td>
									订单状态
								</td>
								<td>
									编辑
								</td>
							</tr>
							<s:iterator value="#request.orderList" id="order">
								<tr align='center' bgcolor="#FFFFFF" height="22">
									<td>
										<s:property value="#order.orderBianhao" />
									</td>
									<td>
										￥
										<s:property value="#order.orderJine" />
										<br />
									</td>
									<td>
										<s:property value="#order.orderDate" />
									</td>
									<td>


										<s:if test="#order.orderZhuangtai=='no'">
												         未受理
										</s:if>
										<s:if test="#order.orderZhuangtai=='yes'">
												        已受理
											</s:if>
										<s:if test="#order.orderZhuangtai=='shou'">
												        已收货
												     </s:if>
										<s:if test="#order.orderZhuangtai=='ping'">
												        已评价
												     </s:if>
										<s:if test="#order.orderZhuangtai=='hui'">
												     双方已评
										</s:if>
									</td>
									<td>
										<a href="#"
											onclick="orderDetail(<s:property value="#order.orderId"/>)">订单明细</a>
										&nbsp;&nbsp;
										<!-- a href="#"
											onclick="orderDel(<s:property value="#order.orderId"/>)">删除</a -->
										<s:if test="#order.orderZhuangtai=='yes'">
											<input value="收货" type="button"
												onclick="orderShouhuo(<s:property value="#order.orderId"/>)" />
										</s:if>
										<s:if test="#order.orderZhuangtai=='shou'">
											<input value="评价" type="button"
												onclick="orderPing(<s:property value="#order.orderId"/>)" />
										</s:if>

									</td>
								</tr>
							</s:iterator>
						</table>
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
								<jsp:include flush="true"
									page="/qiantai/userlogin/userlogin.jsp"></jsp:include>
							</div>
						</div>
					</div>
				</div>
				<div class="left_row">
					<div class="list">
						<div class="list_bar">
							商品分类
						</div>
						<div class="list_content">
							<div id="div">
								<div style="overflow: hidden;">
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
						<div class="list_bar">
							网站公告
						</div>
						<div class="list_content">
							<div id="div">
								<div style="overflow: hidden;">
									<div id="roll-orig-1607838439">
										<s:action name="gonggaoQian5" executeResult="true"
											flush="true"></s:action>
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
