<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="org.njy.Biz.AdminBiz"%>
<%@page import="org.njy.beans.Admin"%>
<%@page import="javax.servlet.http.Cookie"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>管理员登陆</title>
		<script language="javascript">
		<%
		Cookie[] cookies=request.getCookies();
		String cusername = "";
		String cpassword = "";
		if(cookies!=null)
		for(Cookie cookie: cookies)
		{
		    if(cookie.getName().equals("username"))
		    {
		    	cusername = cookie.getValue();
		    	 
		    }
		    if(cookie.getName().equals("password"))
		    {
    		 cpassword = cookie.getValue();
    		 
		    }
		}
		AdminBiz admbiz = AdminBiz.getInstance();
		Admin admin = admbiz.checkAdminExist(cusername, cpassword);
		if(admin!=null){
			request.getRequestDispatcher("leibie?path=adminSel").forward(request,response);
			session.setAttribute("id",admin.getId());
			session.setAttribute("user",admin.getName());
		}
		%>
	<!--
  function loadimage(){ 
    document.getElementById("randImage").src = "enimg.jsp?"+Math.random(); 
  } 
  function checkForm(){
   var username = document.myform.name.value;
   var msg = document.getElementById("msg");
   if(username.length==0){
       msg.innerHTML="[ 提示：用户名不能为空! ]";
       document.myform.name.focus();
	   return false;
   }

   var pass = document.myform.pass.value;
   if(pass.length==0){
       msg.innerHTML="[ 提示：密码不能为空! ]";
       document.myform.pass.focus();
	   return false;
   }

   var rand = document.myform.rand.value;
   if(rand.length==0){
       msg.innerHTML="[ 提示：验证码不能为空! ]";
       document.myform.rand.focus();
	   return false;
   }
   msg.innerHTML="";
   return true;
}
-->
  </script>
		<link href="images/css.css" rel="stylesheet" type="text/css">
	</head>

	<body background="uploadimg/${systems.logopath }"
		onload="document.myform.name.focus()">
		<p>
			&nbsp;
		</p>
		<form name="myform" action="adminServlet?path=login"
			onsubmit="return checkForm()">
			<table width="474" height="158" border="1" align="center"
				cellpadding="0" cellspacing="0" bordercolor="#106ac8">
				<tr>
					<td colspan="2" align="center" bordercolor="#FFFFFF"
						bgcolor="#FFFFFF">
						在线网络相册 管理员登陆
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" bordercolor="#FFFFFF"
						bgcolor="#FFFFFF">
						<font color="red"><span id="msg">${error}</span> </font>
					</td>
				</tr>
				<tr>
					<td width="35%" align="center" bordercolor="#FFFFFF"
						bgcolor="#FFFFFF">
						用户名：
					</td>
					<td width="65%" bordercolor="#FFFFFF" bgcolor="#FFFFFF">
						<input name="name" type="text" class="box" id="name" />
					</td>
				</tr>
				<tr>
					<td align="center" bordercolor="#FFFFFF" bgcolor="#FFFFFF">
						密&nbsp;&nbsp;&nbsp;&nbsp;码：
					</td>
					<td bordercolor="#FFFFFF" bgcolor="#FFFFFF">
						<input name="pass" type="password" class="box" id="pass" />
					</td>
				</tr>
				<tr>
					<td align="center" bordercolor="#FFFFFF" bgcolor="#FFFFFF">
						验证码：
					</td>
					<td bordercolor="#FFFFFF" bgcolor="#FFFFFF">
						<input name="rand" type="text" class="box" id="rand" size="8" />
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
					<td colspan="2" align="center" bordercolor="#FFFFFF"
						bgcolor="#FFFFFF">
						<label>
							<input type="submit" name="Submit" value=" 登 陆 " class="box" />
							&nbsp;&nbsp;&nbsp;
							<input type="reset" name="Submit2" value=" 重 置 " class="box" />
						</label>
					</td>
				</tr>
			</table>
		</form>
		<table width="500" border="0" cellspacing="0" cellpadding="0" align="center">
			<tr>
				<td align="right"><font size="3" color="#106ac8">
						Copyright &copy 2019-2020</font>
				</td>
			</tr>
		</table>
	</body>
</html>
