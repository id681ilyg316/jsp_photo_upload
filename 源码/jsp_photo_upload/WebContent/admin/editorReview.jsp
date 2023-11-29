<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>编辑评论</title>
		<link href="${pageContext.request.contextPath}/images/css.css"
			rel="stylesheet" type="text/css">
		<script type="text/javascript">
			<!--
			function checkForm(){
				var pinglun=document.getElementById("pinglun").value;
				var msg=document.getElementById("msg");
				
				if(pinglun.length==0){
					msg.innerHTML="[ 提示：评论内容不能为空! ]";
					document.getElementById("pinglun").focus();
					return false;
				}
				if(pinglun.length>=100){
					msg.innerHTML="[ 提示：评论内容不能大于100个字符! ]";
					document.getElementById("pinglun").focus();
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
					<table width="100%" border="0" align="center" cellpadding="8"
						cellspacing="0">
						<tr>
							<td bgcolor="#FFFFFF">
								<table width='100%' border='0' cellspacing='0' cellpadding='3'
									align='center'>
									<tr>
										<td colspan="2" align="center" valign="middle"
											bgcolor="#FFFFFF">
											编辑评论信息
										</td>
									</tr>
									<tr>
										<td align="center">
											<font color="#FF0000"><span id="msg"></span> </font>
										</td>
									</tr>
									<tr>

										<td>
											<form name="form1" method="post"
												onsubmit="return checkForm()" action="pinglun?path=update">
												<table width="100%" height="155" border="0" cellpadding="0"
													cellspacing="0">
													<tr>
														<td height="1" align="right" bgcolor="#FFFFFF" colspan="2"></td>
													</tr>
													<tr>
														<td width="32%" height="38" align="center" valign="middle"
															bgcolor="#FFFFFF">
															昵称：
														</td>
														<td width="68%" bgcolor="#FFFFFF">
															<input name="name" type="text" class="box" id="name"
																value="${pinglun.name}">
															<input name="id" type="hidden" id="pid"
																value="${pinglun.id}">
														</td>
													</tr>
													<tr>
														<td align="center" valign="middle" bgcolor="#FFFFFF">
															评论：
														</td>
														<td valign="middle" bgcolor="#FFFFFF">
															<textarea name="pinglun" cols="25" rows="4" class="box"
																id="pinglun">${pinglun.contentText}</textarea>
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
				</td>
			</tr>
		</table>
	</body>
</html>