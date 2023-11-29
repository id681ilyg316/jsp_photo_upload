<%@ page contentType="text/html; charset=utf-8"%>
<link href="images/css.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
#Layer1 {
	position: absolute;
	left: 785px;
	top: 35px;
	width: 176px;
	height: 50px;
	z-index: 1;
}
-->
</style>
<table width="900" border="0" align="center" cellpadding="5"
	cellspacing="1" bgcolor="#108ac6">
	<tr>
		<td align="center" bgcolor="#FFFFFF">
			<table width="100%" height="100" border="0" align="center"
				cellpadding="5" cellspacing="1" bgcolor="#FFFFFF" class="sx">
				<tr bgcolor="FFFFFF">
					<th width="100%" align="left" valign="bottom"
						background="images/top_01.gif" bgcolor="FFFFFF" class="y">
						<h2>
							<font color="#FFFFFF">&nbsp;&nbsp;${systems.name }</font>
						</h2>
					</th>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td align="center" bgcolor="#FFFFFF">
			<table width="100%" height="25" border="0" align="center"
				cellpadding="5" cellspacing="1" bgcolor="#FFFFFF" class="sx">
				<tr bgcolor="#FFFFFF">
					<td width="224" valign="middle" bgcolor="#FFFFFF" class="y">
						<a href="index.jsp">相册首页</a> |&nbsp;
 						<a href="login.jsp">管 理</a>
					</td>
					<td width="641" align="right" valign="middle">
						<form name="form1" action="photo?path=selectByRadio">
							<table border="0" cellspacing="0" cellpadding="3">
								<tr>
									<td>
										搜索&nbsp;
									</td>
									<td>
										<input name="key" type="text" class="box" size="15">
										<input name="radiobutton" type="radio" value="1" />
										相册分类
										<input type="radio" name="radiobutton" value="2" />
										照片名称
										<input type="radio" name="radiobutton" value="3"
											checked="checked" />
										点击率
										<input name="Submit" type="submit" class="box" value="GO">
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
