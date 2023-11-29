<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.tagdemo.com" prefix="njy"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="images/css.css" rel="stylesheet" type="text/css" />
		<title>图片名</title>
		<script language="javascript"> 
		<!--
		function loadimage(){ 
          document.getElementById("randImage").src = "enimg.jsp?"+Math.random(); 
        } 

-->
</script>
	</head>

	<body background="uploadimg/${systems.logopath }">
		<jsp:include page="top.jsp" /><br />
		<table width="900" border="0" align="center" cellpadding="1"
			cellspacing="1" bgcolor="#108ac6">
			<tr>
				<td width="100%" align="center" bgcolor="#FFFFFF">
					<c:forEach var="photo" items="${selOneList}">
						<table width="890" border="0" align="center" cellpadding="8"
							cellspacing="0">
							<tr>
								<td bgcolor="#FFFFFF">
									<table width='870' border='0' cellspacing='0' cellpadding='5'
										align='center'>
										<tr>
											<td align='left'>
												您当前的位置：
											</td>
										</tr>
									</table>
									<table width='100%' border='0' cellspacing='0' cellpadding='5'
										align='center'>
										<tr>
											<td align='center'>
												<table align=center border=0 cellpadding=5 cellspacing=0
													style='table-layout: fixed; word-break: break-all'>
													<tr>
														<td align='center'>
															<c:set var="str" value="uploadimg/${photo.path}" />
															<c:set var="str2" value="_min." />
															<img src="${fn:replace(str,str2,'.')}" />
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
									<table width='855' border='0' cellspacing='0' cellpadding='3'
										align='center'>
										<tr>
											<td width='746'>
												照片名称：${photo.name} &nbsp; | &nbsp;点击次数：
												<font color="#666666">${photo.dianji}</font> &nbsp; |
												&nbsp;上传时间：${photo.contentTime }
												<br>
												照片说明：${photo.shuoming}
											</td>
											<td width='91' class='z'>
												<a href="down.jsp?path=uploadimg/${photo.path}"> 下 载</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<c:set var="id" value="${photo.id}" scope="page" />
					</c:forEach>
				</td>
			</tr>
		</table>
		<br />
		<table width="900" border="0" align="center" cellpadding="1"
			cellspacing="1" bgcolor="#108ac6">
			<tr bgcolor="#FFFFFF">
				<td align="left" colspan="4">
					&nbsp;所&nbsp;&nbsp;有&nbsp;&nbsp;评&nbsp;&nbsp;论：
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF">
					<c:set var="flag" value="${listpinglun==null}" scope="page" />
					<c:if test="${fn:length(listpinglun)<=0}">
						<font color="red"><span>&nbsp;&nbsp;暂无评论!</span> </font>
					</c:if>
					<c:forEach var="pinglun" items="${listpinglun}" varStatus="status">

						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0" bordercolor="#FF0000">
							<tr>
								<td width="8%" align="center" valign="middle" bgcolor="#FFFFFF">
									<font color="#666666">${status.count}</font>&nbsp;&nbsp;楼：
								</td>
								<td width="25%" align="left" valign="middle" bgcolor="#FFFFFF">
									&nbsp;&nbsp;&nbsp;昵称：
									<font color="#666666">${pinglun.name}</font>
								</td>
								<td width="24%" align="left" valign="middle" bgcolor="#FFFFFF">
									&nbsp;&nbsp;发表时间：
									<font color="#666666">${pinglun.contentTime }</font>
								</td>
								<td width="43%" align="left" valign="middle" bgcolor="#FFFFFF">&nbsp;
									
								</td>
							</tr>
							<tr align="center">
								<td align="right" bgcolor="#FFFFFF">
									内&nbsp;&nbsp;容：
								</td>
								<td colspan="3" align="left" bgcolor="#FFFFFF">
									<font color="#666666">${pinglun.contentText }</font>
								</td>
							</tr>
						</table>
						<hr />
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="4" bgcolor="#FFFFFF">
					<form name="form1" action="pinglun?path=add">
						<table width="100%" height="163" border="0" cellpadding="0"
							cellspacing="0">
							<tr>
								<td height="1" align="right" bgcolor="#FFFFFF" colspan="2"></td>
							</tr>
							<tr>
								<td align="left" bgcolor="#FFFFFF">
									&nbsp;&nbsp;&nbsp;&nbsp;我 要 评 论：
								</td>
								<td bgcolor="#FFFFFF" align="center">
									<font color="red"><span>${msg}</span> </font>
								</td>
							</tr>
							<tr>
								<td width="11%" align="right" bgcolor="#FFFFFF">
									昵&nbsp;&nbsp;&nbsp;称：
								</td>
								<td width="89%" bgcolor="#FFFFFF">
									<input name="nickname" type="text" class="box" id="nickname">
									<input name="pid" type="hidden" id="pid" value="${id}">
								</td>
							</tr>
							<tr>
								<td align="right" bgcolor="#FFFFFF">
									内&nbsp;&nbsp;&nbsp;容：
								</td>
								<td valign="middle" bgcolor="#FFFFFF">
									<textarea name="pinglun" cols="30" rows="5" class="box"
										id="pinglun"></textarea>
									*注意：评论内容不能大于255个字符.
								</td>
							</tr>

							<tr>
								<td align="right" valign="middle" bgcolor="#FFFFFF">
									验证码：
								</td>
								<td valign="middle" bgcolor="#FFFFFF">
									<input name="randnum" type="text" class="box" id="randnum">
									&nbsp;
									<img src="enimg.jsp" alt="code..." name="randImage" width="55"
										height="16" border="1" align="absmiddle" class="box"
										id="randImage" />
									&nbsp;
									<a href="javascript:loadimage();"><font color="#808080">看不清,换一张</font>
									</a>
								</td>
							</tr>
							<tr>
								<td valign="middle" bgcolor="#FFFFFF">&nbsp;
									
								</td>
								<td valign="bottom" bgcolor="#FFFFFF">
									<input name="Submit" type="submit" class="box" id="Submit"
										value="  提  交  ">
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input name="reset" type="reset" class="box" id="reset"
										value="  重  置  ">
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
		<br />
		<njy:hello>版权信息</njy:hello>
	</body>
</html>