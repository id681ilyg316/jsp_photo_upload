<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://www.tagdemo.com" prefix="njy"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>添加照片</title>
		<script language="Javascript">
<!--
function openScript(url, width, height)
{
var Win = window.open(url,"openScript",'width=' + width + ',height=' + height + ',resizable=1,scrollbars=yes,menubar=no,status=yes' );
}

function openem()
{ 
openScript('admin/upload.jsp',350,200); 
}

function checkExit()
{
   if(confirm("确认退出管理？"))
     return true;
   else
     return false;
}
function checkForm1(){

  var name=document.getElementById("name").value;
  var msg =document.getElementById("msg");
  //图片名称
  if(name.length==0){
    msg.innerHTML="[ 提示：照片名称不能为空! ]";
    document.getElementById("name").focus();
    return false;
  }
  //图片路径
  var filepath=document.getElementById("filepath").value;
  if(filepath.length==0){
    msg.innerHTML="[ 提示：请选择您要上传的照片! ]";
    return false;
  }
  msg.innerHTML="";
  return true;
}
-->
</script>
		<link href="${pageContext.request.contextPath}/images/css.css"
			rel="stylesheet" type="text/css">
	</head>

	<body background="${pageContext.request.contextPath}/uploadimg/${systems.logopath }" onLoad="document.getElementById('name').focus()">
		<jsp:include page="top.jsp" /><br />
		<form name="form1" id="form1" method="post"
			onsubmit="return checkForm1()"
			action="${pageContext.request.contextPath}/photo?path=add">
			<table width="900" border="0" align="center" cellpadding="5"
				cellspacing="1" bgcolor="#108ac6">
				<tr align="center">
					<td height="5" colspan="2" bgcolor="#FFFFFF">
						<font color="red"><span id="msg">${msg} </span> </font>
					</td>
				</tr>
				<tr>
					<td colspan="2" valign="top" bgcolor="#FFFFFF">
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
									<a href="systems?path=select">系统设置</a> |
									
									<a href="admin/modifypsw.jsp">修改密码</a> |
									<a href="adminServlet?path=exit" onClick="return checkExit()">退出管理</a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td width="238" align="right" bgcolor="#FFFFFF" class="sxz">
						图片名称：
					</td>
					<td width="520" bgcolor="#FFFFFF" class="bk">
						<input type="text" name="name" id="name" class="box"
							maxlength="10" size="20">
						&nbsp; <font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td width="238" align="right" bgcolor="#FFFFFF" class="zx">
						所属分类：
					</td>
					<td width="520" bgcolor="#FFFFFF" class="xzy">
						<select name="typeid" class="cp">
							<c:forEach var="leibie" items="${leibieList}">
								<option value="${leibie.id}">
									${leibie.name}
								</option>
							</c:forEach>
						</select>
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td width="238" align="right" bgcolor="#FFFFFF" class="zx">
						图片地址：
					</td>
					<td width="520" bgcolor="#FFFFFF">
						<input name="filepath" id="filepath" type="text" class="box"
							id="path" readonly="readonly" size="20" maxlength="200">
						<font color="red">*</font> [
						<a href="JavaScript:openem()">上传图片</a> ]
					</td>
				</tr>
				<tr>
					<td width="238" align="right" valign="middle" bgcolor="#FFFFFF">
						图片简介：
					</td>
					<td width="520" height="83" valign="top" bgcolor="#FFFFFF"
						class="xzy">
						<textarea name="shuoming" class="box" cols="40" rows="5"></textarea>
					</td>
				</tr>
				<tr>
					<td height="1" colspan="2" bgcolor="#FFFFFF" align="center">
						<input type="submit" class="box" id="Submit" value="确 定 ">
						&nbsp;&nbsp;&nbsp;
						<input type="reset" class="box" id="reset" value=" 重 置 ">
					</td>
				</tr>
				<tr>
					<td colspan="2" bgcolor="#FFFFFF" class="bk">
						请注意：带“*”项目必须填写，上传文件时,注意图片不要过大,建议先进行处理。
					</td>
				</tr>
			</table>
		</form>
		<njy:hello>版权信息</njy:hello>
	</body>
</html>