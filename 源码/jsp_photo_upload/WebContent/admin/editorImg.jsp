<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.tagdemo.com" prefix="njy"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>编辑图片</title>
		<link href="${pageContext.request.contextPath}/images/css.css"
			rel="stylesheet" type="text/css">
		<script type="text/javascript">
			<!--
			function checkForm(){
				var name=document.getElementById("name").value;
				var shuoming=document.getElementById("shuoming").value;
				
				if(name.length==0){
					alert("照片名称不能为空!");
					document.getElementById("name").focus();
					return false;
				}
				if(shuoming.length>=100){
					alert("评论内容不能大于100个字符!");
					document.getElementById("shuoming").focus();
					return false;
				}
				window.close();
				return true;			
			}
			-->
			</script>
	</head>

	<body background="../uploadimg/${systems.logopath }">
		<table width="320" border="0" align="center" cellpadding="1"
			cellspacing="1" bgcolor="#108ac6">
			<tr>
				<td width="100%" align="center" bgcolor="#FFFFFF">
					<c:forEach var="photo" items="${selOneList}">
						<table width="100%" border="0" align="center" cellpadding="8"
							cellspacing="0">
							<tr>
								<td bgcolor="#FFFFFF">
									<table width='100%' border='0' cellspacing='0' cellpadding='3'
										align='center'>
										<tr>
											<td colspan="2" align="center" valign="middle"
												bgcolor="#FFFFFF">
												编辑图片信息
											</td>
										</tr>
										<tr>
											<td>
												<form name="form1" method="post"
													onsubmit="return checkForm()"
													action="${pageContext.request.contextPath}/photo?path=update">
													<table width="100%" height="155" border="0" cellpadding="0"
														cellspacing="0">
														<tr>
															<td height="1" align="right" bgcolor="#FFFFFF"
																colspan="2"></td>
														</tr>
														<tr>
															<td width="32%" height="38" align="center"
																valign="middle" bgcolor="#FFFFFF">
																图片名称：
															</td>
															<td width="68%" bgcolor="#FFFFFF">
																<input name="name" type="text" class="box" id="name"
																	value="${photo.name}">
																<input name="pid" type="hidden" id="pid"
																	value="${photo.id}">
															</td>
														</tr>
														<tr>
															<td align="center" valign="middle" bgcolor="#FFFFFF">
																图片分类：
															</td>
															<td valign="middle" bgcolor="#FFFFFF">
																<select name="typeid" class="cp">
																	<c:forEach var="leibie" items="${lbList}">
																		<c:choose>
																			<c:when test="${leibie.id==photo.lid}">
																				<option value="${leibie.id}" selected="selected">
																					${leibie.name}
																				</option>
																			</c:when>
																			<c:otherwise>
																				<option value="${leibie.id}">
																					${leibie.name}
																				</option>
																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
																</select>
															</td>
														</tr>
														<tr>
															<td align="center" valign="middle" bgcolor="#FFFFFF">
																图片说明：
															</td>
															<td valign="middle" bgcolor="#FFFFFF">
																<textarea name="shuoming" cols="25" rows="4" class="box"
																	id="shuoming">${photo.shuoming}</textarea>
															</td>
														</tr>
														<tr>
															<td colspan="2" valign="middle" bgcolor="#FFFFFF"
																align="center">
																<input name="Submit" type="submit" class="box"
																	id="Submit" value="  提  交  ">
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
								</td>
							</tr>
						</table>
					</c:forEach>
				</td>
			</tr>
		</table>
	</body>
</html>