package org.njy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.njy.Biz.SystemsBiz;
import org.njy.beans.Systems;
import org.njy.util.ConvertUtil;

@SuppressWarnings("serial")
public class SystemsServlet extends HttpServlet {

	public void destroy() {

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getParameter("path");
		if (path.equals("select")) {// 查询网站的设置信息
			this.select(request, response);
		} else if (path.equals("update")) {// 修改网站的设置信息
			this.update(request, response);
		}
	}

	/**
	 * 查询网站的设置信息到界面
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = request.getParameter("msg");
		SystemsBiz systembiz = SystemsBiz.getInstance();
		Systems systems = systembiz.select();
		request.setAttribute("systems", systems);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("admin/setup.jsp").forward(request,
				response);
	}

	/**
	 * 修改网站的设置信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Systems sys = new Systems();
		SystemsBiz systembiz = SystemsBiz.getInstance();
		ConvertUtil convert = ConvertUtil.getInstance();
		int id = convert.strToInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String logopath = request.getParameter("filepath");
		String gonggao = request.getParameter("gonggao");
		String str = "";
		if (name.equals("") || gonggao.equals("")) {
			str = "[ 提示：网站信息不能为空! ]";
		} else {
			sys.setId(id);
			sys.setName(name);
			sys.setLogopath(logopath);
			sys.setGonggao(gonggao);
			boolean flag = systembiz.update(sys);
			str = "[ 提示：网站信息设置成功! ]";
		}
		String url = "systems?path=select&msg=" + str;
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void init() throws ServletException {
	}
}
