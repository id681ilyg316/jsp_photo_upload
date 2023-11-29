package org.njy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckRoot implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		Object id = session.getAttribute("id");
		if (id != null) {
			chain.doFilter(req, res);
		} else {
			session.setAttribute("error", "[ ��ʾ�����ȵ�½! ]");
			response.sendRedirect("/photo_upload/login.jsp");
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
