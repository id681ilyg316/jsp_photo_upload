package org.njy.Biz;

import java.util.ArrayList;
import java.util.List;

import org.njy.beans.LeiBie;
import org.njy.db.ControlDB;

public class LeiBieBiz {
	private static LeiBieBiz leibiebiz = null;
	private ControlDB control = null;

	private LeiBieBiz() {
		control = ControlDB.getInstance();
	}

	/**
	 * 该方法返回一个LeiBieBiz对象
	 * 
	 * @return
	 */
	public static LeiBieBiz getInstance() {
		if (leibiebiz == null) {
			leibiebiz = new LeiBieBiz();
		}
		return leibiebiz;
	}

	/**
	 * 查询所有的类别信息 当num为0时查询所有的，num为1时则根据id查询一条
	 * 
	 * @param id
	 * @param num
	 * @return
	 */
	public List<LeiBie> selectLiebie(int id, int num) {
		String sql = "";
		List<LeiBie> list = new ArrayList<LeiBie>();
		if (num == 0) {
			sql = "SELECT l.id,l.name,l.shuoming,count(p.lid),l.contenttime FROM photo AS p "
					+ " RIGHT JOIN leibie AS l ON p.lid=l.id GROUP BY l.id ";
		} else if (num == 1) {
			sql = "SELECT l.id,l.name,l.shuoming,count(p.lid),l.contenttime FROM photo AS p  "
					+ " RIGHT JOIN leibie AS l ON p.lid=l.id where l.id="
					+ id
					+ " GROUP BY l.id ";
		}

		try {
			list = control.selectLiebie(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 增加一个相册类别
	 * 
	 * @param name
	 * @return
	 */
	public boolean add(LeiBie leibie) {
		boolean flag = false;
		String sql = "INSERT INTO leibie(name,shuoming,contenttime) value('"
				+ leibie.getName() + "','" + leibie.getShuoming() + "','"
				+ leibie.getContenttime() + "')";
		flag = this.executeUpdate(sql);
		return flag;
	}

	/**
	 * 删除一个相册类别
	 * 
	 * @param id
	 * @return
	 */
	public boolean del(int id) {
		boolean flag = false;
		String sql = "delete from leibie where id=" + id;
		flag = this.executeUpdate(sql);
		return flag;
	}

	/**
	 * 修改类别的名称
	 * 
	 * @param id
	 * @return
	 */
	public boolean update(String newname, int id) {
		boolean flag = false;
		String sql = "update leibie set name='" + newname + "' where id=" + id;
		flag = this.executeUpdate(sql);
		return flag;
	}

	/**
	 * 操作所有修改的方法
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
