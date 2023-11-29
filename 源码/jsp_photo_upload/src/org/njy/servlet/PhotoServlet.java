package org.njy.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.njy.Biz.LeiBieBiz;
import org.njy.Biz.PhotoBiz;
import org.njy.Biz.PinglunBiz;
import org.njy.Biz.SystemsBiz;
import org.njy.beans.LeiBie;
import org.njy.beans.Photo;
import org.njy.beans.Pinglun;
import org.njy.beans.Systems;
import org.njy.util.ConvertUtil;

@SuppressWarnings("serial")
public class PhotoServlet extends HttpServlet {

	public void destroy() {
		super.destroy();
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
		String pt = request.getParameter("path");
		PhotoBiz phobiz = PhotoBiz.getInstance();
		PinglunBiz pinglunbiz = PinglunBiz.getInstance();
		ConvertUtil convert = ConvertUtil.getInstance();
		SystemsBiz systembiz = SystemsBiz.getInstance();
		Photo photo = new Photo();
		List<Photo> list = null;
		HttpSession session = request.getSession();
		boolean flag = false;
		String toUrl = "";
		if (pt.equals("selAll")) {// 查询所有的照片到main.jsp页面
			list = phobiz.selectAllPhoto(0, 0);
			request.setAttribute("selAllList", list);
			Systems systems = systembiz.select();
			session.setAttribute("systems", systems);
			toUrl = "main.jsp";
		} else if (pt.equals("selOne")) {// 根据照片的id查询出该照片的信息和评论
			int id = convert.strToInt(request.getParameter("id"));
			String str = request.getParameter("str");
			String msg = request.getParameter("msg");
			if (str.equals("adm")) {// 跳到后面的的showOne.jsp
				toUrl = "admin/showOne.jsp";
			} else if (str.equals("edit")) {
				toUrl = "admin/editorImg.jsp";
			} else if (str.equals("aa")) {
				photo.setId(id);
				// 只有在客户端点击图片其点击数才增加
				flag = phobiz.update(0, photo);
				toUrl = "display.jsp";
			}
			request.setAttribute("msg", msg);
			list = phobiz.selectAllPhoto(id, 2);
			request.setAttribute("selOneList", list);

			List<Pinglun> listpinglun = pinglunbiz.searchById(id, 0);
			request.setAttribute("listpinglun", listpinglun);
		} else if (pt.equals("add")) {// 上传图片
			String name = request.getParameter("name").trim();
			String filepath = request.getParameter("filepath").trim();
			int lid = convert.strToInt(request.getParameter("typeid").trim());
			String shuoming = request.getParameter("shuoming").trim();
			String str = "";
			if (name.equals("")) {
				str = "[ 提示：图片名称不能为空! ]";
			} else if (filepath.equals("")) {
				str = "[ 提示：请选择要上传的图片! ]";
			} else {
				photo.setName(name);
				photo.setPath(filepath);
				photo.setLid(lid);
				shuoming = shuoming.equals("") ? "暂无说明" : shuoming;
				photo.setShuoming(shuoming);
				flag = phobiz.add(photo);
				str = "[ 提示：图片上传成功! ]";
			}
			toUrl = "leibie?path=select&msg=" + str;
		} else if (pt.equals("selAllById")) {// 根据分类的id查询相关的照片
			int id = convert.strToInt(request.getParameter("id"));
			list = phobiz.selectAllPhoto(id, 1);// 根据分类查询相关照片
			request.setAttribute("selAllById", list);
			List<LeiBie> tempList = LeiBieBiz.getInstance().selectLiebie(id, 1);
			String typeName = tempList.get(0).getName();// 得到分类的名称
			request.setAttribute("typeName", typeName);
			toUrl = "admin/showByName.jsp";
		} else if (pt.equals("selectByRadio")) {// 根据不同的收索方式查找图片
			String keyName = request.getParameter("key");
			int typeId = convert.strToInt(request.getParameter("radiobutton"));
			list = phobiz.selectAllPhotoByRadio(keyName, typeId);
			request.setAttribute("selAllList", list);
			toUrl = "main.jsp";
		} else if (pt.equals("update")) {// 修改图片的信息
			photo.setName(request.getParameter("name"));
			int id = convert.strToInt(request.getParameter("typeid"));
			photo.setLid(id);
			photo.setShuoming(request.getParameter("shuoming"));
			photo.setId(convert.strToInt(request.getParameter("pid")));
			phobiz.update(1, photo);
			toUrl = "photo?path=selOne&str=adm&id=" + id;
		} else if (pt.equals("del")) {// 根据指定的id删除图片和文件夹中的图片
			int id = convert.strToInt(request.getParameter("id"));
			Photo ph = phobiz.selectAllPhoto(id, 2).get(0);// 得到一个photo的实体
			String filepath_min = "/uploadimg/" + ph.getPath();// 得到缩略图的路径
			String filepath_max = "/uploadimg/"
					+ ph.getPath().replace("_min.", ".");// 得到原图片的路径
			boolean tempFlag = phobiz.del(id);// 删除数据库中指定的图片的记录
			pinglunbiz.delete(id, 1);// 根据图片id删除相关的评论
			if (tempFlag) {
				String filepath = config.getServletContext().getRealPath("/");
				flag = new File(filepath + filepath_min).delete();// 根据路径删除小图片
				flag = new File(filepath + filepath_max).delete();// 根据路径删除大图片
				String str = "[ 提示：成功删除图片!]";
				toUrl = "leibie?path=selAllLB&msg=" + str;
			}
		}
		request.getRequestDispatcher(toUrl).forward(request, response);
	}

	private ServletConfig config;

	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

}
