<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://www.tagdemo.com" prefix="njy"%>
<html>
	<head>
		<title>系统设置</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="${pageContext.request.contextPath}/images/css.css"
			rel="stylesheet" type="text/css">
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

//检测表单
function checkForm(){
    var name=document.getElementById("name").value;	
	var gonggao=document.getElementById("gonggao").value;
	var filepath=document.getElementById("filepath").value;		
	var msg=document.getElementById("msg");
	//检测网站名称
	if(name.length==0){
		msg.innerHTML="[ 提示：网站名称不能为空！ ]";
		document.getElementById("name").focus();
		return false;
	}
	//检测网站公告
	if(gonggao.length==0){
		msg.innerHTML="[ 提示：网站公告不能为空！ ]";
		document.getElementById("gonggao").focus();
		return false;
	}
	//检测网站logo
	if(filepath.length==0){
		msg.innerHTML="[ 提示：网站logo不能为空,请上传logo！ ]";
		//document.getElementById("filepath").focus();
		return false;
	}
	msg.innerHTML="";
	return true;
}
-->
</script>
		<link href="images/css.css" rel="stylesheet" type="text/css">
	</head>

	<body background="${pageContext.request.contextPath}/uploadimg/${systems.logopath }">
		<jsp:include page="top.jsp" /><br />
		<form name="form1" onsubmit="return checkForm()"
			action="${pageContext.request.contextPath}/systems?path=update">
			<table width="900" border="0" align="center" cellpadding="5"
				cellspacing="1" bgcolor="#108ac6">
				<tr>
					<td height="5" bgcolor="#FFFFFF" align="center">
						<font color="red"><span id="msg">${msg} </span>
						</font>
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
					<td height="50" bgcolor="#FFFFFF">
						&nbsp;网站名称：
						<input type="text" name="name" id="name" class="box" size="100"
							maxlength="20" value="${systems.name}">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td height="50" bgcolor="#FFFFFF">
						&nbsp;滚动公告：
						<input name="gonggao" type="text" class="box" id="gonggao"
							value="${systems.gonggao}" size="100" maxlength="50">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td height="50" bgcolor="#FFFFFF">
						&nbsp;网站Logo：
						<input type="text" name="filepath" id="filepath" class="box"
							readonly="readonly" size="85" value="${systems.logopath}">
						&nbsp; [
						<a href="JavaScript:openem()">上传图片</a>]
					</td>
				</tr>
				<tr>
					<td height="1" colspan="2" bgcolor="#FFFFFF" align="center">
						<input name="Submit" type="submit" class="" id="Submit"
							value=" 确 定 ">
						<input name="id" type="hidden" id="id" value="${systems.id }" />
						&nbsp;&nbsp;&nbsp;
						<input type="reset" name="reset" value=" 重 置 " class="box">
					</td>
				</tr>
			</table>
			<br />
		</form>
		<njy:hello>版权信息</njy:hello>
	</body>
</html>