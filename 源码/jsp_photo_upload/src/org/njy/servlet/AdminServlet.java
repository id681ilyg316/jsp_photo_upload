package org.njy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.njy.Biz.AdminBiz;
import org.njy.beans.Admin;

public class AdminServlet extends HttpServlet {

	public void destroy() {

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doService(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doService(request, response);
	}

	public void doService(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = request.getParameter("path");
		if ("login".equals(path)) {// ����Ա��½
			this.login(request, response);
		} else if ("uppass".equals(path)) {// �޸�����
			this.updatePass(request, response);
		} else if ("exit".equals(path)) {// �˳�����
			this.exit(request, response);
		}
	}

	/**
	 * �÷�������ʵ�ֹ���Ա�˳�����
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void exit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		Cookie passwordCookie = new Cookie("password", "");
		passwordCookie.setMaxAge(7 * 24 * 3600);
		passwordCookie.setPath("/");
		response.addCookie(passwordCookie);
		request.getRequestDispatcher("photo?path=selAll").forward(request,
				response);
	}

	/**
	 * �÷���������������Ա��½
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminBiz admbiz = AdminBiz.getInstance();
		String toUrl = "";// Ҫ��ת����url��ַ
		String strError = "";// ������Ϣ
		String name = request.getParameter("name").trim();// ������ʺ�
		String pass = request.getParameter("pass").trim();// ���������
		String rand = request.getParameter("rand").trim();// �������֤��
		HttpSession session = request.getSession();
		String rand2 = (String) session.getAttribute("rand");// ���ɵ���֤��ֵ
		if (rand.equalsIgnoreCase(rand2)) {// �ж���֤���Ƿ���ȷ
			Admin admin = admbiz.checkAdmin(name, pass);
			if (admin.getName().equals(name) && admin.getPass().equals(pass)) {// ��֤���û����Ͷ�Ӧ�������Ƿ����
				session.setAttribute("id", admin.getId());// ���û����ŵ�session��
				session.setAttribute("user", admin.getName());// ���û����ŵ�session��
				Cookie usernameCookie = new Cookie("username", admin.getName());
				usernameCookie.setMaxAge(7 * 24 * 3600);
				usernameCookie.setPath("/");
				response.addCookie(usernameCookie);
				Cookie passwordCookie = new Cookie("password", admin.getPass());
				passwordCookie.setMaxAge(7 * 24 * 3600);
				passwordCookie.setPath("/");
				response.addCookie(passwordCookie);
				toUrl = "leibie?path=adminSel";
			} else {
				strError = "[ ��ʾ���û�������������! ]";
				toUrl = "login.jsp";
			}
		} else {
			strError = "[ ��ʾ����֤������! ]";
			toUrl = "login.jsp";
		}
		request.setAttribute("error", strError);
		request.getRequestDispatcher(toUrl).forward(request, response);
	}

	/**
	 * �÷�������ʵ�ֹ���Ա�޸�����
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	public void updatePass(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		AdminBiz admbiz = AdminBiz.getInstance();
		String strError = "";// ������Ϣ
		String name = request.getParameter("username").trim();// ������û���
		String oldpass = request.getParameter("oldpass").trim();// �����ԭ����
		String pass1 = request.getParameter("pass").trim();// �����������
		String pass2 = request.getParameter("pass2").trim();// �����ȷ������
		Admin admin = admbiz.checkAdmin(name, oldpass);
		if (name.equals(admin.getName()) && oldpass.equals(admin.getPass())) {// ��֤����Ա�ʺź������Ƿ���ȷ
			if (pass1.equals(pass2)) {// ��֤�������ȷ�������Ƿ���ͬ
				boolean flag = admbiz.updatePass(name, pass2);
				strError = flag == true ? "[ ��ʾ����ϲ,�����޸ĳɹ�! ]"
						: "[ ��ʾ����ϲ,�����޸ĳɹ�! ]";
			} else {
				strError = "[ ��ʾ���������ȷ�����벻һ��! ]";
			}
		} else {
			strError = "[ ��ʾ���û�����ԭ��������! ]";
		}
		request.setAttribute("msgerror", strError);
		request.getRequestDispatcher("admin/modifypsw.jsp").forward(request,
				response);
	}

	public void init() throws ServletException {
	}

}
