<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.tagdemo.com" prefix="njy"%>
<html>
	<head>
		<title>修改密码</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="${pageContext.request.contextPath}/images/css.css"
			rel="stylesheet" type="text/css">
		<script language="javascript">
		<!--
function checkForm(){
	var username=document.getElementById("username").value;
	var oldpass=document.getElementById("oldpass").value;
	var pass=document.getElementById("pass").value;
	var pass2=document.getElementById("pass2").value;
	var msg = document.getElementById("msg");
	//检测用户是否为空
	if(username.length==0){
       msg.innerHTML="[ 提示：用户名不能为空! ]";
       document.getElementById("username").focus();
	   return false;
    }
    //检测旧密码是否为空
    if(oldpass.length==0){
       msg.innerHTML="[ 提示：新密码不能为空! ]";
       document.getElementById("oldpass").focus();
	   return false;
    }
    //检测新密码是否为空
    if(pass.length==0){
       msg.innerHTML="[ 提示：新密码不能为空! ]";
       document.getElementById("pass").focus();
	   return false;
    }
    //检测新密码长度是否大于6
    if(pass.length<6){
       msg.innerHTML="[ 提示：新密码长度不能小于6位! ]";
       document.getElementById("pass").focus();
	   return false;
    }
    //检测确认密码是否为空
    if(pass2.length==0){
       msg.innerHTML="[ 提示：确认密码不能为空! ]";
       document.getElementById("pass2").focus();
	   return false;
    }
    //检测新密码和确认密码是否相同
    if(pass!=pass2){
   	   msg.innerHTML="[ 提示：新密码和确认密码必须一致! ]";
       document.getElementById("pass2").focus();
       return false;
    }
    msg.innerHTML="";
    return true;
}

//退出管理
function checkExit()
{
   if(confirm("确认退出管理？"))
     return true;
   else
     return false;
}
-->
</script>
	</head>
	<body background="../uploadimg/${systems.logopath }"
		onload="document.getElementById('username').focus()">
		<jsp:include page="top.jsp" />
		<form name="myform" onsubmit="return checkForm()"
			action="${pageContext.request.contextPath}/adminServlet?path=uppass">
			<table width="900" border="0" bgcolor="#108ac6" align="center"
				cellspacing="1" cellpadding="5">
				<tr>
					<td height="5" bgcolor="#FFFFFF" align="center">
						<font color="red"><span id="msg">${msgerror}</span> </font>
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
									<a
										href="${pageContext.request.contextPath}/systems?path=select">系统设置</a>
									|
									
									<a href="modifypsw.jsp">修改密码</a> |
									<a
										href="${pageContext.request.contextPath}/adminServlet?path=exit"
										onClick="return checkExit()">退出管理</a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="50" bgcolor="#FFFFFF">
						&nbsp;&nbsp;用 户 名：
						<input type="text" name="username" class="box" size="50"
							maxlength="50" id="name">
					</td>
				</tr>
				<tr>
					<td height="50" bgcolor="#FFFFFF">
						&nbsp;&nbsp;原 密 码：
						<input type="password" name="oldpass" class="box" size="50"
							maxlength="50">
					</td>
				</tr>
				<tr>
					<td height="50" bgcolor="#FFFFFF">
						&nbsp;&nbsp;新 密 码：
						<input type="password" name="pass" class="box" size="50"
							maxlength="50">
						<font color="red"><span id="msgpass">* 新密码不能小于六位. </span> </font>
					</td>
				</tr>
				<tr>
					<td height="50" bgcolor="#FFFFFF">
						&nbsp;&nbsp;确认密码：
						<input type="password" name="pass2" class="box" id="pass2"
							size="50" maxlength="20">
						<font color="red"><span id="msgpass2">* 两次密码必须一致.</span> </font>
					</td>
				</tr>
				<tr>
					<td height="1" colspan="2" bgcolor="#FFFFFF" align="center">
						<input name="id" type="hidden" value="#">
						<input name="Submit" type="submit" class="box" id="Submit"
							value=" 确 定 ">
						&nbsp;&nbsp;&nbsp;
						<input type="reset" name="Submit22" value=" 重 置 " class="box">
					</td>
				</tr>
			</table>
			<br />
		</form>
		<njy:hello>版权信息</njy:hello>
	</body>
</html>