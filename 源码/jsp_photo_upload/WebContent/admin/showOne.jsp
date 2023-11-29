<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.tagdemo.com" prefix="njy"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="images/css.css" rel="stylesheet" type="text/css" />
		<title>图片名</title>
		<SCRIPT language=javascript>
function checkDel()
{
   if(confirm("确定要删除？"))
     return true;
   else
     return false;
}
function openScript(url, width, height){
  var win = window.open(url,"openScript",'width=' + width + ',height=' + height + ',location=no,resizable=0,scrollbars=no,menubar=no,status=no' );
}
//打开编辑图片的页面
function openem(id)
{ 
  var path="photo?path=selOne&str=edit&id="+id;
  openScript(path,340,250);  
}
//打开编辑评论的页面
function openJsp(pid)
{ 
  var path="pinglun?path=toupdate&id="+pid;
  openScript(path,340,250);  
}
</SCRIPT>
	</head>

	<body background="../uploadimg/${systems.logopath }">
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
												<!--您当前的位置：-->
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
											<td width='637'>
												照片名称：
												<font color="#666666">${photo.name}</font> &nbsp;|
												&nbsp;点击次数：
												<font color="#666666">${photo.dianji}</font> &nbsp;|
												&nbsp;上传时间：
												<font color="#666666">${photo.contentTime }</font>
												<br>
												照片说明：
												<font color="#666666">${photo.shuoming}</font>
											</td>
											<td width='206' class='z'>
												<a href="javascript:openem(${photo.id})">编辑</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
												<a onClick="return checkDel()"
													href="photo?path=del&id=${photo.id}">删除</a>
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
					&nbsp;所&nbsp;有&nbsp;评&nbsp;论：
				</td>

			</tr>
			<c:if test="${fn:length(listpinglun)<=0}">
				<tr bgcolor="#FFFFFF">
					<td align="left">
						<font color="red"><span>&nbsp;&nbsp;&nbsp;暂无评论!</span> </font>
					</td>
				</tr>
			</c:if>
			<tr>
				<td bgcolor="#FFFFFF">
					<c:forEach var="pinglun" items="${listpinglun}" varStatus="status">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0" bordercolor="#FF0000">
							<tr>
								<td width="8%" align="center" valign="middle" bgcolor="#FFFFFF">
									<font color="#666666">${status.count}</font>&nbsp;&nbsp;楼：
								</td>
								<td width="25%" align="left" valign="middle" bgcolor="#FFFFFF">
									&nbsp;&nbsp;&nbsp;昵称
									<font color="#666666">：${pinglun.name}</font>
								</td>
								<td width="24%" align="left" valign="middle" bgcolor="#FFFFFF">
									&nbsp;&nbsp;发表时间
									<font color="#666666">：${pinglun.contentTime }</font>
								</td>
								<td width="43%" align="center" valign="middle" bgcolor="#FFFFFF">
									<a href="javascript:openJsp(${pinglun.id})">编辑</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
									<a onClick="return checkDel()"
										href="pinglun?path=dele&id=${pinglun.id}&pid=${pinglun.pid}">删除</a>
								</td>
							</tr>
							<tr align="center">
								<td align="right" bgcolor="#FFFFFF">
									内&nbsp;&nbsp;容：
								</td>
								<td colspan="3" align="left" bgcolor="#FFFFFF">
									&nbsp;
									<font color="#666666">${pinglun.contentText }</font>
								</td>
							</tr>
						</table>
						<hr>
					</c:forEach>
				</td>
			</tr>
		</table>
		<br />
		<njy:hello>版权信息</njy:hello>
	</body>
</html>