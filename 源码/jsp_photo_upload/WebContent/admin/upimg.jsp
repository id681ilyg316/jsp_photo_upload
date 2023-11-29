<%@page import="org.njy.util.ConvertUtil"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	import="com.jspsmart.upload.*,java.util.*,com.sun.image.codec.jpeg.JPEGCodec"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="com.sun.image.codec.jpeg.JPEGImageEncoder"%>
<%@page import="java.awt.Image"%>
<%@page import="java.awt.Color"%>
<%@page import="org.njy.util.ConvertUtil"%>
<script language="javascript">
function uppic(){
    window.opener.document.getElementById('filepath').value=document.getElementById('newpath').value;
    window.close();
}
function closewindow(){
	window.opener.document.getElementById('filepath').value=document.getElementById('newpath').value;
    //关闭窗口时,把上传后的图片名称放到父窗口的图片路径中
}
</script>
<%
	SmartUpload mySmartUpload = new SmartUpload();
	long file_size_max = 4000000;
	String ext = "";
	String url = "uploadimg/"; //应保证在根目录中有此目录的存在
	//初始化
	mySmartUpload.initialize(pageContext);
	//只允许上载此类文件
	try {
		mySmartUpload.setAllowedFilesList("jpg,gif");
		//上载文件 
		mySmartUpload.upload();
		out.println("<p align=\"center\">上传成功!</p>");
		out
		.println("<p align=\"center\"><input name=\"close\" type=\"submit\" value=\" 关 闭 \" onclick=\"uppic()\"/></p>");
	} catch (Exception e) {
%>
<SCRIPT language=javascript>
  alert("只允许上传.jpg和.gif类型图片文件");
  window.location='upload.jsp';
  </script>
<%
	}
	try {
		File myFile = mySmartUpload.getFiles().getFile(0);
		if (myFile.isMissing()) {
%>
<SCRIPT language=javascript>
   alert("请先选择要上传的文件");
   window.location='upload.jsp';
</script>
<%
			} else {
			//String myFileName=myFile.getFileName(); //取得上载的文件的文件名
			ext = myFile.getFileExt(); //取得后缀名
			int file_size = myFile.getSize(); //取得文件的大小  
			String saveurl = "";
			if (file_size < file_size_max) {
		//更改文件名，取得当前上传时间的毫秒数值
		Calendar calendar = Calendar.getInstance();
		String filename = String.valueOf(calendar
				.getTimeInMillis());
		saveurl = request.getRealPath("/") + url;
		saveurl += filename + "." + ext; //保存路径
		myFile.saveAs(saveurl, mySmartUpload.SAVE_PHYSICAL);
		ConvertUtil.mark(saveurl, saveurl, Color.red, session.getAttribute("user")+"");
		//-----------------------上传完成，开始生成缩略图-------------------------    
		java.io.File file = new java.io.File(saveurl); //读入刚才上传的文件
		String newurl = request.getRealPath("/") + url
				+ filename + "_min." + ext; //新的缩略图保存地址
		String newpath = filename + "_min." + ext;//获得生成后的小图的名称
		//out.println(newpath);
		out
				.print("<input name=\"newpath\" type=\"hidden\" id=\"newpath\" value=\""
				+ newpath + "\" />");//输出缩略图的名字
		Image src = javax.imageio.ImageIO.read(file); //构造Image对象
		float tagsize = 200;
		int old_w = src.getWidth(null); //得到源图宽
		int old_h = src.getHeight(null);
		int new_w = 0;
		int new_h = 0; //得到源图长
		int tempsize;
		float tempdouble;
		if (old_w > old_h) {
			tempdouble = old_w / tagsize;
		} else {
			tempdouble = old_h / tagsize;
		}
		new_w = Math.round(old_w / tempdouble);
		new_h = Math.round(old_h / tempdouble);//计算新图长宽
		BufferedImage tag = new BufferedImage(new_w, new_h,
				BufferedImage.TYPE_INT_RGB);
		tag.getGraphics().drawImage(src, 0, 0, new_w, new_h,
				null); //绘制缩小后的图
		FileOutputStream newimage = new FileOutputStream(newurl); //输出到文件流
		JPEGImageEncoder encoder = JPEGCodec
				.createJPEGEncoder(newimage);
		encoder.encode(tag); //近JPEG编码
		newimage.close();

			} else {
		out.print("<SCRIPT language=''javascript''>");
		out.print("alert(''上传文件大小不能超过" + (file_size_max / 1000)
				+ "K'');");
		out.print("window.location=''upload.jsp;''");
		out.print("</SCRIPT>");
			}
		}
	} catch (Exception e) {
		e.toString();
	}
%>