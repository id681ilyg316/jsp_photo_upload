package org.njy.tld;

import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

/**
 * 版权信息
 * 
 * @author 聂靖宇
 * 
 */
public class HelloTld extends BodyTagSupport {
	public int doAfterBody() {
		try {
			// 获得标签体的内容
			BodyContent bodyContent = super.getBodyContent();
			// String bodyString = bodyContent.getString();
			// 获取输出流对象
			JspWriter out = bodyContent.getEnclosingWriter();
			out
					.println("<table width=\"900\" height=\"86\" border=\"0\" align=\"center\" cellpadding=\"3\" cellspacing=\"1\" bgcolor=\"#108ac6\">");
			out.println("<tr>");
			out.println("<td bgcolor=\"#FFFFFF\">");
			out
					.println("<table width=\"100%\" height=\"17\" border=\"0\" align=\"center\" cellpadding=\"5\" cellspacing=\"1\" bgcolor=\"#FFFFFF\" class=\"sx\">");
			out.println("<tr bgcolor=\"#FFFFFF\">");
			out
					.println("<td width=\"100%\" align=\"center\" class=\"y\" bgcolor=\"#FFFFFF\">");
			out
					.println("<a href=\"#\">关于我们</a>&nbsp;|&nbsp;<a href=\"#\">服务条款</a>&nbsp;|&nbsp;<a href=\"#\">广告服务</a>&nbsp;|&nbsp;<a href=\"#\">客服中心</a>&nbsp;|&nbsp;<a href=\"#\">网站导航</a>");
			out.println("<br />");
			out.println("<br />	CopyRight: 2019-2020 &nbsp;版权所有");
			out.println("</td></tr></table></td></tr></table>");
			bodyContent.clear();
		} catch (IOException e) {
			System.out.println("BodyContentTag.doAfterBody() 中出现错误"
					+ e.getMessage());
			e.printStackTrace();
		}
		return this.SKIP_BODY;
	}
}
