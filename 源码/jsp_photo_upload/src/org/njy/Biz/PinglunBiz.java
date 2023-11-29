package org.njy.Biz;

import java.util.List;
import org.njy.beans.*;
import org.njy.db.*;

public class PinglunBiz {
	private static PinglunBiz pinglunbiz = null;
	private ControlDB controlDB = null;

	private PinglunBiz() {
		controlDB = ControlDB.getInstance();
	}

	/**
	 * �÷������һ��PinglunBizʵ��
	 * 
	 * @return pinglunbiz
	 */
	public static PinglunBiz getInstance() {
		if (pinglunbiz == null) {
			pinglunbiz = new PinglunBiz();
		}
		return pinglunbiz;
	}

	/**
	 * �÷�������ɾ��һ������
	 * 
	 * @param id
	 *            Ҫɾ�������۱��
	 * @return flag=trueΪɾ���ɹ�
	 */
	public boolean delete(int id, int num) {
		String sql = "";
		if (num == 0) {
			sql = "delete from pinglun where id=" + id;// ɾ����������
		} else if (num == 1) {
			sql = "delete from pinglun where pid=" + id;// ɾ��ĳ��ͼƬ����������
		}
		boolean flag = this.executeUpdate(sql);
		return flag;
	}

	/**
	 * ��ѯ����
	 * 
	 * @param flag
	 *            ��ѯ������
	 * @param pid
	 *            ��Ƭ��id
	 * @return ���Ϊpid��Ƭ����������
	 */
	public List<Pinglun> searchById(int id, int num) {
		List<Pinglun> list = null;
		String sql = "";
		if (num == 0) {// ����ͼƬid��ѯ��Ӧ����������
			sql = "select * from pinglun where pid=" + id + " order by id desc";
		} else if (num == 1) {// ����id��ѯ��������
			sql = "select * from pinglun where id=" + id + " order by id desc";
		}
		try {
			list = controlDB.executeQueryPinglun(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * ����µ�����
	 * 
	 * @param pinglun
	 * @return
	 */
	public boolean add(Pinglun pinglun) {
		String sql = "insert into pinglun(contentText,contentTime,name,pid) values('"
				+ pinglun.getContentText()
				+ "','"
				+ pinglun.getContentTime()
				+ "','" + pinglun.getName() + "'," + pinglun.getPid() + ")";
		boolean flag = this.executeUpdate(sql);
		return flag;
	}

	/**
	 * �޸�һ������
	 * 
	 * @param pinglun
	 * @return
	 */
	public boolean update(Pinglun pinglun) {
		String sql = "update pinglun set contentText='"
				+ pinglun.getContentText() + "',name='" + pinglun.getName()
				+ "' where id=" + pinglun.getId();
		boolean flag = this.executeUpdate(sql);
		return flag;
	}

	/**
	 * �÷�������ִ�������޸ĵĲ���
	 * 
	 * @param sql
	 * @return
	 */
	@SuppressWarnings("unused")
	private boolean executeUpdate(String sql) {
		boolean flag = false;
		try {
			flag = controlDB.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
