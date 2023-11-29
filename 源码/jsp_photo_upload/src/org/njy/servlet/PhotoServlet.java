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
		if (pt.equals("selAll")) {// ��ѯ���е���Ƭ��main.jspҳ��
			list = phobiz.selectAllPhoto(0, 0);
			request.setAttribute("selAllList", list);
			Systems systems = systembiz.select();
			session.setAttribute("systems", systems);
			toUrl = "main.jsp";
		} else if (pt.equals("selOne")) {// ������Ƭ��id��ѯ������Ƭ����Ϣ������
			int id = convert.strToInt(request.getParameter("id"));
			String str = request.getParameter("str");
			String msg = request.getParameter("msg");
			if (str.equals("adm")) {// ��������ĵ�showOne.jsp
				toUrl = "admin/showOne.jsp";
			} else if (str.equals("edit")) {
				toUrl = "admin/editorImg.jsp";
			} else if (str.equals("aa")) {
				photo.setId(id);
				// ֻ���ڿͻ��˵��ͼƬ������������
				flag = phobiz.update(0, photo);
				toUrl = "display.jsp";
			}
			request.setAttribute("msg", msg);
			list = phobiz.selectAllPhoto(id, 2);
			request.setAttribute("selOneList", list);

			List<Pinglun> listpinglun = pinglunbiz.searchById(id, 0);
			request.setAttribute("listpinglun", listpinglun);
		} else if (pt.equals("add")) {// �ϴ�ͼƬ
			String name = request.getParameter("name").trim();
			String filepath = request.getParameter("filepath").trim();
			int lid = convert.strToInt(request.getParameter("typeid").trim());
			String shuoming = request.getParameter("shuoming").trim();
			String str = "";
			if (name.equals("")) {
				str = "[ ��ʾ��ͼƬ���Ʋ���Ϊ��! ]";
			} else if (filepath.equals("")) {
				str = "[ ��ʾ����ѡ��Ҫ�ϴ���ͼƬ! ]";
			} else {
				photo.setName(name);
				photo.setPath(filepath);
				photo.setLid(lid);
				shuoming = shuoming.equals("") ? "����˵��" : shuoming;
				photo.setShuoming(shuoming);
				flag = phobiz.add(photo);
				str = "[ ��ʾ��ͼƬ�ϴ��ɹ�! ]";
			}
			toUrl = "leibie?path=select&msg=" + str;
		} else if (pt.equals("selAllById")) {// ���ݷ����id��ѯ��ص���Ƭ
			int id = convert.strToInt(request.getParameter("id"));
			list = phobiz.selectAllPhoto(id, 1);// ���ݷ����ѯ�����Ƭ
			request.setAttribute("selAllById", list);
			List<LeiBie> tempList = LeiBieBiz.getInstance().selectLiebie(id, 1);
			String typeName = tempList.get(0).getName();// �õ����������
			request.setAttribute("typeName", typeName);
			toUrl = "admin/showByName.jsp";
		} else if (pt.equals("selectByRadio")) {// ���ݲ�ͬ��������ʽ����ͼƬ
			String keyName = request.getParameter("key");
			int typeId = convert.strToInt(request.getParameter("radiobutton"));
			list = phobiz.selectAllPhotoByRadio(keyName, typeId);
			request.setAttribute("selAllList", list);
			toUrl = "main.jsp";
		} else if (pt.equals("update")) {// �޸�ͼƬ����Ϣ
			photo.setName(request.getParameter("name"));
			int id = convert.strToInt(request.getParameter("typeid"));
			photo.setLid(id);
			photo.setShuoming(request.getParameter("shuoming"));
			photo.setId(convert.strToInt(request.getParameter("pid")));
			phobiz.update(1, photo);
			toUrl = "photo?path=selOne&str=adm&id=" + id;
		} else if (pt.equals("del")) {// ����ָ����idɾ��ͼƬ���ļ����е�ͼƬ
			int id = convert.strToInt(request.getParameter("id"));
			Photo ph = phobiz.selectAllPhoto(id, 2).get(0);// �õ�һ��photo��ʵ��
			String filepath_min = "/uploadimg/" + ph.getPath();// �õ�����ͼ��·��
			String filepath_max = "/uploadimg/"
					+ ph.getPath().replace("_min.", ".");// �õ�ԭͼƬ��·��
			boolean tempFlag = phobiz.del(id);// ɾ�����ݿ���ָ����ͼƬ�ļ�¼
			pinglunbiz.delete(id, 1);// ����ͼƬidɾ����ص�����
			if (tempFlag) {
				String filepath = config.getServletContext().getRealPath("/");
				flag = new File(filepath + filepath_min).delete();// ����·��ɾ��СͼƬ
				flag = new File(filepath + filepath_max).delete();// ����·��ɾ����ͼƬ
				String str = "[ ��ʾ���ɹ�ɾ��ͼƬ!]";
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
