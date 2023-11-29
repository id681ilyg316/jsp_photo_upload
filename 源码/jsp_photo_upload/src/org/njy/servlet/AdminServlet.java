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
		if ("login".equals(path)) {// 管理员登陆
			this.login(request, response);
		} else if ("uppass".equals(path)) {// 修改密码
			this.updatePass(request, response);
		} else if ("exit".equals(path)) {// 退出管理
			this.exit(request, response);
		}
	}

	/**
	 * 该方法用来实现管理员退出管理
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
	 * 该方法用来操作管理员登陆
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
		String toUrl = "";// 要跳转到的url地址
		String strError = "";// 错误信息
		String name = request.getParameter("name").trim();// 输入的帐号
		String pass = request.getParameter("pass").trim();// 输入的密码
		String rand = request.getParameter("rand").trim();// 输入的验证码
		HttpSession session = request.getSession();
		String rand2 = (String) session.getAttribute("rand");// 生成的验证码值
		if (rand.equalsIgnoreCase(rand2)) {// 判断验证码是否正确
			Admin admin = admbiz.checkAdmin(name, pass);
			if (admin.getName().equals(name) && admin.getPass().equals(pass)) {// 验证该用户名和对应的密码是否存在
				session.setAttribute("id", admin.getId());// 把用户名放到session中
				session.setAttribute("user", admin.getName());// 把用户名放到session中
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
				strError = "[ 提示：用户名或密码有误! ]";
				toUrl = "login.jsp";
			}
		} else {
			strError = "[ 提示：验证码有误! ]";
			toUrl = "login.jsp";
		}
		request.setAttribute("error", strError);
		request.getRequestDispatcher(toUrl).forward(request, response);
	}

	/**
	 * 该方法用来实现管理员修改密码
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	public void updatePass(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		AdminBiz admbiz = AdminBiz.getInstance();
		String strError = "";// 错误信息
		String name = request.getParameter("username").trim();// 输入的用户名
		String oldpass = request.getParameter("oldpass").trim();// 输入的原密码
		String pass1 = request.getParameter("pass").trim();// 输入的新密码
		String pass2 = request.getParameter("pass2").trim();// 输入的确认密码
		Admin admin = admbiz.checkAdmin(name, oldpass);
		if (name.equals(admin.getName()) && oldpass.equals(admin.getPass())) {// 验证管理员帐号和密码是否正确
			if (pass1.equals(pass2)) {// 验证新密码和确认密码是否相同
				boolean flag = admbiz.updatePass(name, pass2);
				strError = flag == true ? "[ 提示：恭喜,密码修改成功! ]"
						: "[ 提示：恭喜,密码修改成功! ]";
			} else {
				strError = "[ 提示：新密码和确认密码不一致! ]";
			}
		} else {
			strError = "[ 提示：用户名或原密码有误! ]";
		}
		request.setAttribute("msgerror", strError);
		request.getRequestDispatcher("admin/modifypsw.jsp").forward(request,
				response);
	}

	public void init() throws ServletException {
	}

}
