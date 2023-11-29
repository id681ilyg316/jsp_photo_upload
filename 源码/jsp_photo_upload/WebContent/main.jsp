<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="http://www.tagdemo.com" prefix="njy"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
	<head>
		<title>在线网络相册主页</title>
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
      alert("欲跳转页码必须为数字！");
      formName.requestPage.value="";
      formName.requestPage.focus();
      return false;
    }
  }
  //-->
  </script>
	</head>

	<body background="uploadimg/${systems.logopath }">
		<jsp:include page="top.jsp" /><br />
		<table width="900" align="center" cellpadding="3" cellspacing="1"
			bgcolor="#108ac6">
			<tr>
				<td align="center" bgcolor="#FFFFFF">
					<table width="100%" height="100" border="0" align="center"
						cellpadding="5" cellspacing="1" bgcolor="#FFFFFF" class="sx">
						<tr bgcolor="#FFFFFF">
							<td width="100%" align="right" class="y" bgcolor="">
								<table width='100%' border='0' cellspacing='0' cellpadding='3'>
									<tr>
										<td>
											<c:if test="${fn:length(selAllList)<=0}">
												<font color="red"><span> 对不起没有文件存在!</span> </font>
											</c:if>
										</td>
										<td width='50%'>
											<marquee scrollamount=2>
												${systems.gonggao }
											</marquee>
										</td>
									</tr>
								</table>
								<table width='100%' border='0' cellspacing='0' cellpadding='5'>
									<tr align='center'>
										<c:forEach var="photo" items="${selAllList}"
											varStatus="status">
											<c:choose>
												<c:when test="${status.count % 4 == 0}">
													<td width='25%'>
														<table border=1 align=center cellpadding=3 cellspacing=1
															bordercolor="#666666" bgcolor='#ffffff' class='bk1'>
															<tr>
																<td align="center">
																	<a href="photo?path=selOne&id=${photo.id}&str=aa"
																		target='_blank'> <img
																			src="uploadimg/${photo.path}"
																			alt="${photo.shuoming }" width=150 height=113
																			border='0' align="middle" class='bk1'> </a>
																</td>
															</tr>
														</table>
														<br>
														<a href="photo?path=selOne&id=${photo.id}&str=aa">${photo.name}</a>&nbsp;&nbsp;|&nbsp;&nbsp;点击：${photo.dianji}
													</td>
													<c:out value="</tr>" escapeXml="false" />
													<c:out value="<tr align='center'>" escapeXml="false" />
												</c:when>
												<c:otherwise>
													<td width='25%'>
														<table border=1 align=center cellpadding=3 cellspacing=1
															bordercolor="#666666" bgcolor='#ffffff' class='bk1'>
															<tr>
																<td align="center">
																		<a href="photo?path=selOne&id=${photo.id}&str=aa"
																			target='_blank'> <img
																				src="uploadimg/${photo.path}"
																				alt="${photo.shuoming }" width=150 height=113
																				border='0' align="middle"> </a>
																</td>
															</tr>
														</table>
														<br>
														<a href="photo?path=selOne&id=${photo.id}&str=aa">${photo.name}</a>&nbsp;&nbsp;|&nbsp;&nbsp;点击：${photo.dianji}
													</td>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</tr>
								</table>
								<form id="form2" name="form2" action=""
									onSubmit="return checkPage(form2)">
									<table width='100%' border='0' cellspacing='0' cellpadding='5'>
										<tr>
											<td height='20'>
												&nbsp;共有
												<font color="#FF0000">12</font>条记录 &nbsp;当前第
												<font color="#FF0000">1/4</font>页 &nbsp;
												<a href="#">首页&nbsp;</a>
												<a href="#">上一页</a>&nbsp;&nbsp;
												<a href="#">下一页&nbsp;</a>
												<a href="#">尾页</a> &nbsp;第
												<input name="requestPage" type="text" id="requestPage"
													size="3" />
												页
												<input name="submit" type="Submit" class="box" id="submit"
													value="GO" />
											</td>
										</tr>
									</table>
								</form>
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