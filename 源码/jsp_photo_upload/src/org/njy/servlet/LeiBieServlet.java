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
		if (path.equals("select")) {// ��ѯ���еķ���
			String msg = request.getParameter("msg");
			list = lbiz.selectLiebie(0, 0);
			// flag = list.size() == 0 ? false : true;
			request.setAttribute("leibieList", list);
			request.setAttribute("msg", msg);
			toUrl = "admin/addfile.jsp";
		} else if (path.equals("add")) {// ������
			LeiBie leibie = new LeiBie();
			String str = "";
			String name = request.getParameter("name").trim();
			String shuoming = request.getParameter("shuoming").trim();
			if (name.length() == 0 || name.equals("")) {
				str = "[ ��ʾ�����������Ʋ���Ϊ��! ]";
				flag = true;
			} else {
				shuoming = shuoming.length() == 0 ? "����˵��" : shuoming;
				leibie.setName(name);
				leibie.setShuoming(shuoming);
				leibie.setContenttime(convert.getTime());
				flag = lbiz.add(leibie);
				str = "[ ��ʾ������������ѳɹ�! ]";
			}
			toUrl = "leibie?path=adminSel&msg=" + str;
		} else if (path.equals("adminSel")) {// ��̨��ѯ���е�ͼƬ��Ϣ
			String msg = request.getParameter("msg");
			list = lbiz.selectLiebie(0, 0);
			// flag = list.size() == 0 ? false : true;
			session.setAttribute("lbList", list);
			request.setAttribute("msg", msg);
			toUrl = "admin/admin.jsp";
		} else if (path.equals("update")) {// �޸���������
			String typeid = request.getParameter("typeid").trim();
			String cz = request.getParameter("cz").trim();
			String newname = request.getParameter("newname").trim();
			String str = "";
			if (cz.equals("editclass")) {// �޸��������
				if (newname.length() == 0 || newname.equals("")) {
					str = "[ ��ʾ����������Ʋ���Ϊ��! ]";
					// flag = true;
				} else {
					flag = lbiz.update(newname, convert.strToInt(typeid));
					str = "[ ��ʾ���޸��������ѳɹ�! ]";
				}
			} else {// ɾ�����
				int id = convert.strToInt(typeid);
				PhotoBiz photobiz =PhotoBiz.getInstance();
				List listph = photobiz.selectAllPhoto(id, 1);
				boolean hasMore = listph.size() != 0 ? true : false;
				if (hasMore) {
					str = "[ ��ʾ���÷��಻Ϊ�գ��ݲ���ɾ��! ]";
				} else {
					flag = lbiz.del(id);
					str = flag == true ? "[ ��ʾ��ɾ���������ѳɹ�! ]"
							: "[ ��ʾ��ɾ��������ʧ��! ]";
				}
			}
			toUrl = "leibie?path=adminSel&msg=" + str;
		} else if (path.equals("selAllLB")) {// �����ļ�
			String msg = request.getParameter("msg");
			list = lbiz.selectLiebie(0, 0);
			// flag = list.size() == 0 ? false : true;
			request.setAttribute("liebieInfo", list);
			request.setAttribute("msg", msg);
			toUrl = "admin/adminfile.jsp";
		} else if (path.equals("dele")) {// ɾ�������༰��Ӧ����Ƭ
			int id = convert.strToInt(request.getParameter("id"));
			int num = convert.strToInt(request.getParameter("num"));
			boolean hasMore = num > 0 ? true : false;// �ж�Ҫɾ���ķ������Ƿ����ͼƬ
			String str = "";
			if (hasMore) {
				str = "[ ��ʾ���÷��಻Ϊ�գ��ݲ���ɾ��! ]";
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
