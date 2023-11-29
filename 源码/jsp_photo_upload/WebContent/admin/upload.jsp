<%@ page contentType="text/html; charset=utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>上传图片</title>
		<style type="text/css">
<!--
.style1 {
	font-size: 9pt
}
-->
</style>
		<script type="text/javascript">
 function doup(){
   form1.action="upimg.jsp";
   form1.submit();
   window.opener.document.getElementById('path').value=form1.file1.value;
 }
</script>
	</head>

	<body background="../uploadimg/${systems.logopath }" leftmargin="0" topmargin="0">
		<p>
			&nbsp;
		</p>
		<form name="form1" enctype="multipart/form-data"
			action="upimg.jsp">
			<table width="371" height="48" align="center">
				<tr align="center">
					<td>
						<font color="black">请选择要上传的照片地址:</font>
					</td>
				</tr>
				<tr>
					<td align="center">
						<input type="file" name="file1" size=15 class="an">
						&nbsp;&nbsp;
						<input type="submit" name="Submit" value="上传" class="an">
					</td>
				</tr>

			</table>
		</form>
	</body>
</html>
