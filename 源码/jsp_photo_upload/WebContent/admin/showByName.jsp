<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="http://www.tagdemo.com" prefix="njy"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
	<head>
		<title>分类显示photo</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="images/css.css" rel="stylesheet" type="text/css">
		<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
		<script language="javascript">
  <!--
  function checkPage(formName){
    if (formName.requestPage.value==""){
      alert("请填写欲跳转页码！");
      formName.requestPage.focus();
      return false;
    }
    if (isNaN(formName.requestPage.value)){
      alert("欲跳转页码必须为数值！");
      formName.requestPage.value="";
      formName.requestPage.focus();
      return false;
    }
  }
function checkExit()
{
   if(confirm("确认退出管理？"))
     return true;
   else
     return false;
}
function openScript(url, width, height){
  var Win = window.open(url,"openScript",'width=' + width + ',height=' + height + ',location=no,resizable=0,scrollbars=no,menubar=no,status=no' );
}

function openem(id){ //弹出编辑图片信息的editorImg.jsp
  var path="photo?path=selOne&str=edit&id="+id;
  openScript(path,340,250); 
}
		-->
		</script>
	</head>

	<body background="../uploadimg/${systems.logopath }">
		<jsp:include page="top.jsp" /><br />
		<table width="900" align="center" cellpadding="3" cellspacing="1"
			bgcolor="#108ac6">
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
									href="/photo_upload/leibie?path=adminSel">管理首页</a>
								|
								<a href="/photo_upload/leibie?path=select">添加文件</a>
								|
								<a
									href="/photo_upload/leibie?path=selAllLB">管理文件</a>
								|
								<a href="/photo_upload/systems?path=select">系统设置</a>
								|
								
								<a href="admin/modifypsw.jsp">修改密码</a> |
								<a
									href="/photo_upload/adminServlet?path=exit"
									onClick="return checkExit()">退出管理</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td align="center" bgcolor="#FFFFFF">
					<table width="100%" height="100" border="0" align="center"
						cellpadding="5" cellspacing="1" bgcolor="#FFFFFF" class="sx">
						<tr bgcolor="#FFFFFF">
							<td width="100%" align="right" class="y" bgcolor="">
								<table width='100%' border='0' cellspacing='0' cellpadding='3'
									class='x'>
									<tr>
										<td>
											<c:if test="${fn:length(selAllById)<=0}">
												<font color="red"><span> 对不起没有文件存在!</span> </font>
											</c:if>
											<font color="red">${msg}</font>
										</td>
									</tr>
									<tr>
										<td>
											您当前的位置：
											<a href="leibie?path=selAllLB">分类相册</a>&nbsp;>>&nbsp;${typeName}
										</td>
									</tr>
								</table>
								<table width='100%' border='0' cellspacing='0' cellpadding='5'>

									<tr align='center'>
										<c:forEach var="photo" items="${selAllById}"
											varStatus="status">
											<c:choose>
												<c:when test="${status.count % 4 == 0}">
													<td width='25%'>
														<table border=1 align=center cellpadding=3 cellspacing=1
															bordercolor="#666666" bgcolor='#ffffff' class='bk1'>
															<tr>
																<td>
																	<a href="photo?path=selOne&id=${photo.id}&str=adm"
																		target='_blank'> <img
																			src="uploadimg/${photo.path}"
																			alt="${photo.shuoming }" width=150 height=113
																			border='0' align="middle" class='bk1'> </a>
																</td>
															</tr>
														</table>
														<br>
														<a href="photo?path=selOne&id=${photo.id}&str=adm">${photo.name}</a>|点击:${photo.dianji}
														|
														<a href="javascript:openem(${photo.id})">编辑</a>|
														<a href="photo?path=del&id=${photo.id}">删除</a>
													</td>
													<c:out value="</tr>" escapeXml="false" />
													<c:out value="<tr align='center'>" escapeXml="false" />
												</c:when>
												<c:otherwise>
													<td width='25%'>
														<table border=1 align=center cellpadding=3 cellspacing=1
															bordercolor="#666666" bgcolor='#ffffff' class='bk1'>
															<tr>
																<td>
																	<div align="center">
																		<a href="photo?path=selOne&id=${photo.id}&str=adm"
																			target='_blank'> <img
																				src="uploadimg/${photo.path}"
																				alt="${photo.shuoming }" width=150 height=113
																				border='0' align="middle" class='bk1'> </a>
																	</div>
																</td>
															</tr>
														</table>
														<br>
														<a href="photo?path=selOne&id=${photo.id}&str=adm">${photo.name}</a>&nbsp|&nbsp;点击:${photo.dianji}&nbsp;|
														<a href="javascript:openem(${photo.id})">编辑</a> |
														<a href="photo?path=del&id=${photo.id}">删除</a>
													</td>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</tr>
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
											<input name="requestPage" type="text" id="requestPage"
												size="3" />
											页
											<input name="button" type="button" id="button" value="GO" />
										</td>
									</tr>
								</table>
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