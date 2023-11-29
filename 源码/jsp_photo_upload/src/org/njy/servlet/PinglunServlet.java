package org.njy.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.njy.util.*;
import org.njy.beans.*;
import org.njy.Biz.*;

public class PinglunServlet extends HttpServlet {
	public void init() throws ServletException {
	}

	public void destroy() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getParameter("path");
		HttpSession session = request.getSession();
		ConvertUtil cutils = ConvertUtil.getInstance();
		List<Pinglun> listPinglun = null;
		PinglunBiz pinglunbiz = PinglunBiz.getInstance();
		String tourl = "";
		if ("add".equals(path)) {// 添加评论
			Pinglun pinglun = new Pinglun();
			int pid = cutils.strToInt(request.getParameter("pid"));
			String nickname = request.getParameter("nickname");
			String content = cutils.filterHtml(request.getParameter("pinglun"));
			String rand = request.getParameter("randnum");
			String str = "";
			String rand2 = (String) session.getAttribute("rand");
			if (rand2.equals(rand)) {
				if (content.equals("")) {
					str = "[ 提示：评论内容不能为空! ]";
				} else {
					if (content.length() > 255) {
						str = "[ 提示：评论内容不能大于255个字符! ]";
					} else {
						nickname = nickname.equals("") ? "匿名" : nickname;
						pinglun.setPid(pid);
						pinglun.setName(nickname);
						pinglun.setContentText(content);
						pinglun.setContentTime(cutils.getTime());
						boolean flag = pinglunbiz.add(pinglun);
						str = "[ 提示：评论已成功提交! ]";
					}
				}
			} else {
				str = "[ 提示：验证码有误! ]";
			}
			tourl = "photo?path=selOne&str=aa&msg=" + str + "&id=" + pid;
		} else if ("dele".equals(path)) {// 删除评论
			int id = cutils.strToInt(request.getParameter("id"));
			int pid = cutils.strToInt(request.getParameter("pid"));
			pinglunbiz.delete(id, 0);
			tourl = "photo?path=selOne&str=adm&id=" + pid;
		} else if ("update".equals(path)) {// 修改评论
			Pinglun pinglun = new Pinglun();
			int tmpid = cutils.strToInt(request.getParameter("id"));
			String name = request.getParameter("name").trim();
			String content = request.getParameter("pinglun").trim();
			String nickname = name.equals("") ? "匿名" : name;
			pinglun.setContentText(content);
			pinglun.setName(nickname);
			pinglun.setId(tmpid);
			pinglunbiz.update(pinglun);
			// String msg = "[ 提示：评论修改成功! ]";
			tourl = "photo?path=selOne&str=adm&id=" + tmpid;
		} else if ("toupdate".equals(path)) {// 查询一条评论到编辑页面
			int tmpid = cutils.strToInt(request.getParameter("id"));
			Pinglun pinglun = (Pinglun) pinglunbiz.searchById(tmpid, 1).get(0);
			tourl = "admin/editorReview.jsp";
			request.setAttribute("pinglun", pinglun);
		}
		request.getRequestDispatcher(tourl).forward(request, response);
	}
}
