<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="http://www.tagdemo.com" prefix="njy"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>管理文件</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="${pageContext.request.contextPath}/images/css.css"
			rel="stylesheet" type="text/css">
		<SCRIPT language=javascript>
function checkExit()
{
   if(confirm("确认退出管理？"))
     return true;
   else
     return false;
}
function checkDel()
{
   if(confirm("确认删除该分类？"))
     return true;
   else
     return false;
}
</SCRIPT>
	</head>

	<body background="${pageContext.request.contextPath}/uploadimg/${systems.logopath }">
		<jsp:include page="top.jsp" /><br />
		<table width="900" border="0" align="center" cellpadding="5"
			cellspacing="1" bgcolor="#108ac6">
			<tr>
				<td height="5" bgcolor="#FFFFFF" align="center">
					<font color="red">${msg}</font>
				</td>
			</tr>
			<tr>
				<td valign="top" bgcolor="#FFFFFF">
					<table width="766" border="0" cellspacing="0" cellpadding="5"
						align="center">
						<tr>
							<td>
								管理选项：
								<a
									href="${pageContext.request.contextPath}/leibie?path=adminSel">管理首页</a>
								|
								<a href="${pageContext.request.contextPath}/leibie?path=select">添加文件</a>
								|
								<a
									href="${pageContext.request.contextPath}/leibie?path=selAllLB">管理文件</a>
								|
								<a href="${pageContext.request.contextPath}/systems?path=select">系统设置</a>
								|
								
								<a href="admin/modifypsw.jsp">修改密码</a> |
								<a
									href="${pageContext.request.contextPath}/adminServlet?path=exit"
									onClick="return checkExit()">退出管理</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF">
					<table width="100%" border="0" align="center" cellpadding="5"
						cellspacing="1" bordercolor="red" bgcolor="#108ac6">
						<tr align="center" bgcolor="#FFFFFF">
							<td width="14%">
								编&nbsp;号
							</td>
							<td width="17%">
								分类名称
							</td>
							<td width="16%">
								照片数量(张)
							</td>
							<td width="23%">
								相册说明
							</td>
							<td width="21%">
								创建时间
							</td>
							<td width="9%">
								删&nbsp;除
							</td>
						</tr>
						<c:set var="i" value="0" />
						<c:forEach var="leibie" items="${liebieInfo}" varStatus="status">
							<tr align="center" bgcolor="#FFFFFF">
								<td>
									${status.count}
								</td>
								<td>
									<a href="photo?path=selAllById&id=${leibie.id}"><font color="#106ac0">${leibie.name}</font></a>
								</td>
								<td>
									${leibie.num}
								</td>
								<td align="left">
									&nbsp;&nbsp;${leibie.shuoming}
								</td>
								<td>
									${leibie.contenttime}
								</td>
								<td>
									<a onclick="checkDel()"
										href="leibie?path=dele&num=${leibie.num}&id=${leibie.id}">删&nbsp;除</a>
								</td>
							</tr>
						</c:forEach>
					</table>
					<table width='100%' border='0' cellspacing='0' cellpadding='5'>
						<tr>
							<td height='20'>
								&nbsp;查询到
								<font color="#FF0000">12</font>条记录&nbsp; 共
								<font color="#FF0000">4</font> 页 &nbsp;第
								<font color="#FF0000">1</font> 页&nbsp;
								<a href="#">首页&nbsp;</a>
								<a href="#">上一页</a>&nbsp;&nbsp;
								<a href="#">下一页&nbsp;</a>
								<a href="#">尾页</a> &nbsp;第
								<input name="requestPage" type="text" id="requestPage" size="3" />
								页
								<input name="button" type="button" id="button" value="GO" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<br />
		<njy:hello>版权信息</njy:hello>
	</body>
</html>