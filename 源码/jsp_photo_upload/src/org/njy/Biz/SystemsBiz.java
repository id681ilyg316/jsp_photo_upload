package org.njy.Biz;

import org.njy.db.ControlDB;
import org.njy.beans.Systems;

public class SystemsBiz {
	private static SystemsBiz systemsbiz = null;
	private ControlDB control = null;

	private SystemsBiz() {
		control = ControlDB.getInstance();
	}

	/**
	 * �÷������һ��SystemsBizʵ��
	 * 
	 * @return systemsbiz
	 */
	public static SystemsBiz getInstance() {
		if (systemsbiz == null) {
			systemsbiz = new SystemsBiz();
		}
		return systemsbiz;
	}

	/**
	 * ��ѯ��ǰ��վ��������Ϣ
	 * 
	 * @return
	 */
	public Systems select() {
		Systems systems = new Systems();
		String sql = "SELECT * FROM systems";
		try {
			systems = control.selectSystemInfo(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return systems;
	}

	/**
	 * �޸���վ������Ϣ
	 * 
	 * @return
	 */
	public boolean update(Systems systems) {
		boolean flag = false;
		String sql = "UPDATE systems SET name='" + systems.getName()
				+ "',logopath='" + systems.getLogopath() + "',gonggao='"
				+ systems.getGonggao() + "' WHERE id=" + systems.getId() + "";
		flag = this.executeUpdate(sql);
		return flag;
	}

	/**
	 * �������������޸���վ��Ϣ�ķ���
	 * 
	 * @param sql
	 * @return
	 */
	private boolean executeUpdate(String sql) {
		boolean flag = false;
		try {
			flag = control.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
