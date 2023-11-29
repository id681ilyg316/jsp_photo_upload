package org.njy.Biz;

import org.njy.beans.Admin;
import org.njy.db.ControlDB;

public class AdminBiz {
	private static AdminBiz adminbiz = null;
	private ControlDB control = null;

	private AdminBiz() {
		control = ControlDB.getInstance();
	}

	/**
	 * �÷�������һ��AdminBiz����
	 * 
	 * @return adminbiz
	 */
	public static AdminBiz getInstance() {
		if (adminbiz == null) {
			adminbiz = new AdminBiz();
		}
		return adminbiz;
	}

	/**
	 * �÷�������������Ա���ʺź������Ƿ���ȷ
	 * 
	 * @param admin
	 * @return
	 */
	public Admin checkAdmin(String name, String pass) {
		Admin admin = new Admin();
		String sql = "SELECT * FROM admin WHERE name='" + name + "' and pass='"
				+ pass + "'";
		try {
			admin = control.checkAdmin(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
	
	public Admin checkAdminExist(String name, String pass) {
		Admin admin = null;
		String sql = "SELECT * FROM admin WHERE name='" + name + "' and pass='"
				+ pass + "'";
		try {
			admin = control.checkAdminExist(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

	/**
	 * �÷��������޸Ĺ���Ա����
	 * 
	 * @return
	 */
	public boolean updatePass(String name, String newpass) {
		boolean flag = false;
		String sql = "UPDATE admin SET pass='" + newpass + "' WHERE name='"
				+ name + "'";
		try {
			flag = control.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
