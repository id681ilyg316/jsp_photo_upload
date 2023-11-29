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
	 * 该方法获得一个SystemsBiz实例
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
	 * 查询当前网站的设置信息
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
	 * 修改网站设置信息
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
	 * 用来操作所有修改网站信息的方法
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
