package org.njy.tld;

import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

/**
 * ��Ȩ��Ϣ
 * 
 * @author ������
 * 
 */
public class HelloTld extends BodyTagSupport {
	public int doAfterBody() {
		try {
			// ��ñ�ǩ�������
			BodyContent bodyContent = super.getBodyContent();
			// String bodyString = bodyContent.getString();
			// ��ȡ���������
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
					.println("<a href=\"#\">��������</a>&nbsp;|&nbsp;<a href=\"#\">��������</a>&nbsp;|&nbsp;<a href=\"#\">������</a>&nbsp;|&nbsp;<a href=\"#\">�ͷ�����</a>&nbsp;|&nbsp;<a href=\"#\">��վ����</a>");
			out.println("<br />");
			out.println("<br />	CopyRight: 2019-2020 &nbsp;��Ȩ����");
			out.println("</td></tr></table></td></tr></table>");
			bodyContent.clear();
		} catch (IOException e) {
			System.out.println("BodyContentTag.doAfterBody() �г��ִ���"
					+ e.getMessage());
			e.printStackTrace();
		}
		return this.SKIP_BODY;
	}
}
