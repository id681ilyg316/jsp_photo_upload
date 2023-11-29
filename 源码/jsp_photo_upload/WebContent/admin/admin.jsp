<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="http://www.tagdemo.com" prefix="njy"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>管理中心</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="${pageContext.request.contextPath}/images/css.css"
			rel="stylesheet" type="text/css">
		<SCRIPT language=javascript>
		<!--
function checkExit()
{
   if(confirm("确认退出管理？"))
     return true;
   else
     return false;
}
function checkForm1(){

   var name=document.getElementById("name").value;
   var msg = document.getElementById("msg");
   if(name.length==0){
       msg.innerHTML="[ 提示：分类名称不能为空! ]";
       document.getElementById("name").focus();
	   return false;
   }  
   var shuoming=document.getElementById("shuoming").value;
   if(shuoming.length==0){
       msg.innerHTML="[ 提示：分类说明不能为空! ]";
       document.getElementById("shuoming").focus();
	   return false;
   }
   if(shuoming.length>100){
       msg.innerHTML="[ 提示：分类说明不能大于100个字符! ]";
	   return false;
   }
   msg.innerHTML="";
   return true;
}

function checkForm2(){
	var selectText=document.getElementById("caozuo");
	var key=selectText.options[selectText.selectedIndex].text;
	var value=selectText.options[selectText.selectedIndex].value;

	var newname=document.getElementById("newname").value;
    var msg = document.getElementById("msg");
	if(value=="editclass"){
		if(newname.length==0){
			msg.innerHTML="[ 提示：分类新名称不能为空! ]";
			document.getElementById("newname").focus();
	   		return false;
		}
	}
   msg.innerHTML="";
   return true;
}
-->
</SCRIPT>
		<link href="${pageContext.request.contextPath}/images/css.css"
			rel="stylesheet" type="text/css">
	</head>

	<body background="${pageContext.request.contextPath}/uploadimg/${systems.logopath }"
		onLoad="document.getElementById('name').focus()">
		<jsp:include page="top.jsp" /><br />
		<table width="900" border="0" align="center" cellpadding="5"
			cellspacing="1" bgcolor="#108ac6">
			<tr align="center">
				<td bgcolor="#FFFFFF" height="5">
					<font color="red"><span id="msg">${msg}</span> </font>
				</td>
			</tr>
			<tr align="center">
				<td valign="top" bgcolor="#FFFFFF">
					<table width="766" border="0" cellspacing="0" cellpadding="5"
						align="center">
						<tr>
							<td valign="middle" bgcolor="#FFFFFF">
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
									onClick="return checkExit();">退出管理</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF">
					<form name="form1" method="post"
						action="${pageContext.request.contextPath}/leibie?path=add"
						onsubmit="return checkForm1()">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td valign="middle" bgcolor="#FFFFFF">
									&nbsp;&nbsp;添 加 分 类：
									<input type="text" name="name" class="box" size="15" id="name"
										maxlength="20">
									&nbsp;&nbsp; 分 类 简 介：
									<input name="shuoming" type="text" class="box" id="shuoming"
										size="15" maxlength="100">
									<input type="submit" name="Submit" value="添加" class="box">
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" valign="middle">
					<form name="form2" action="leibie?path=update"
						onsubmit="return checkForm2()">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td bgcolor="#FFFFFF" class="table-xia">
									&nbsp;&nbsp;管 理 分 类：
									<select name="typeid" class="cp" id="typeid">
										<c:forEach var="leibie" items="${lbList}">
											<option value="${leibie.id}">
												${leibie.name}
											</option>
										</c:forEach>
									</select>
									<select name="cz" class="cp" id="caozuo">
										<option value="delclass">
											删除
										</option>
										<option value="editclass" selected>
											修改
										</option>
									</select>
									<input type="submit" name="Submit2" value="确定" class="box">
									&nbsp;新名称：
									<input type="text" name="newname" class="box" maxlength="50"
										id="newname" size="15">
									* 注意：修改时新名称必填,删除则不必,删除请慎重!!
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
			<tr>
				<td height="30" bgcolor="#FFFFFF">
					欢迎您使用本程序(在线网络相册),上传文件时,注意图片不要过大,建议先进行处理。
				</td>
			</tr>
		</table>
		<br />
		<njy:hello>版权信息</njy:hello>
	</body>
</html>