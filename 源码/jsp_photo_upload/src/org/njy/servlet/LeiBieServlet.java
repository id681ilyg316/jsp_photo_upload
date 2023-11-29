package org.njy.servlet;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.njy.Biz.LeiBieBiz;
import org.njy.Biz.PhotoBiz;
import org.njy.beans.LeiBie;
import org.njy.util.ConvertUtil;

@SuppressWarnings("serial")
public class LeiBieServlet extends HttpServlet {

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
		LeiBieBiz lbiz = LeiBieBiz.getInstance();
		boolean flag = false;
		ConvertUtil convert = ConvertUtil.getInstance();
		HttpSession session = request.getSession();
		String toUrl = "";
		List<LeiBie> list = new ArrayList<LeiBie>();
		if (path.equals("select")) {// 查询所有的分类
			String msg = request.getParameter("msg");
			list = lbiz.selectLiebie(0, 0);
			// flag = list.size() == 0 ? false : true;
			request.setAttribute("leibieList", list);
			request.setAttribute("msg", msg);
			toUrl = "admin/addfile.jsp";
		} else if (path.equals("add")) {// 添加类别
			LeiBie leibie = new LeiBie();
			String str = "";
			String name = request.getParameter("name").trim();
			String shuoming = request.getParameter("shuoming").trim();
			if (name.length() == 0 || name.equals("")) {
				str = "[ 提示：相册分类名称不能为空! ]";
				flag = true;
			} else {
				shuoming = shuoming.length() == 0 ? "暂无说明" : shuoming;
				leibie.setName(name);
				leibie.setShuoming(shuoming);
				leibie.setContenttime(convert.getTime());
				flag = lbiz.add(leibie);
				str = "[ 提示：添加相册分类已成功! ]";
			}
			toUrl = "leibie?path=adminSel&msg=" + str;
		} else if (path.equals("adminSel")) {// 后台查询所有的图片信息
			String msg = request.getParameter("msg");
			list = lbiz.selectLiebie(0, 0);
			// flag = list.size() == 0 ? false : true;
			session.setAttribute("lbList", list);
			request.setAttribute("msg", msg);
			toUrl = "admin/admin.jsp";
		} else if (path.equals("update")) {// 修改类别的名字
			String typeid = request.getParameter("typeid").trim();
			String cz = request.getParameter("cz").trim();
			String newname = request.getParameter("newname").trim();
			String str = "";
			if (cz.equals("editclass")) {// 修改类别名称
				if (newname.length() == 0 || newname.equals("")) {
					str = "[ 提示：相册新名称不能为空! ]";
					// flag = true;
				} else {
					flag = lbiz.update(newname, convert.strToInt(typeid));
					str = "[ 提示：修改相册分类已成功! ]";
				}
			} else {// 删除类别
				int id = convert.strToInt(typeid);
				PhotoBiz photobiz =PhotoBiz.getInstance();
				List listph = photobiz.selectAllPhoto(id, 1);
				boolean hasMore = listph.size() != 0 ? true : false;
				if (hasMore) {
					str = "[ 提示：该分类不为空，暂不能删除! ]";
				} else {
					flag = lbiz.del(id);
					str = flag == true ? "[ 提示：删除相册分类已成功! ]"
							: "[ 提示：删除相册分类失败! ]";
				}
			}
			toUrl = "leibie?path=adminSel&msg=" + str;
		} else if (path.equals("selAllLB")) {// 管理文件
			String msg = request.getParameter("msg");
			list = lbiz.selectLiebie(0, 0);
			// flag = list.size() == 0 ? false : true;
			request.setAttribute("liebieInfo", list);
			request.setAttribute("msg", msg);
			toUrl = "admin/adminfile.jsp";
		} else if (path.equals("dele")) {// 删除相册分类及对应的照片
			int id = convert.strToInt(request.getParameter("id"));
			int num = convert.strToInt(request.getParameter("num"));
			boolean hasMore = num > 0 ? true : false;// 判断要删除的分类中是否存在图片
			String str = "";
			if (hasMore) {
				str = "[ 提示：该分类不为空，暂不能删除! ]";
			} else {
				flag = lbiz.del(id);

			}
			toUrl = "leibie?path=selAllLB&msg=" + str;
		}
		request.getRequestDispatcher(toUrl).forward(request, response);
	}

	public void init() throws ServletException {
	}

}
