<%@ page contentType="text/html; charset=utf-8"%>
<tr>
	<td valign="top" bgcolor="#FFFFFF">
		<table width="766" border="0" cellspacing="0" cellpadding="5"
			align="center">
			<tr>
				<td>
					管理选项：
					<a href="${pageContext.request.contextPath}/leibie?path=adminSel">管理首页</a> |
					<a href="${pageContext.request.contextPath}/leibie?path=select">添加文件</a> |
					<a href="${pageContext.request.contextPath}/adminfile.jsp">管理文件</a> |
					<a href="${pageContext.request.contextPath}/systems?path=select">系统设置</a> |
					
					<a href="${pageContext.request.contextPath}/modifypsw.jsp">修改密码</a> |
					<a href="../adminServlet?path=exit">退出管理</a>
				</td>
			</tr>
		</table>
	</td>
</tr>