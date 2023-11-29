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
	 * 该方法获得一个PinglunBiz实例
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
	 * 该方法用来删除一条评论
	 * 
	 * @param id
	 *            要删除的评论编号
	 * @return flag=true为删除成功
	 */
	public boolean delete(int id, int num) {
		String sql = "";
		if (num == 0) {
			sql = "delete from pinglun where id=" + id;// 删除单条评论
		} else if (num == 1) {
			sql = "delete from pinglun where pid=" + id;// 删除某张图片的所有评论
		}
		boolean flag = this.executeUpdate(sql);
		return flag;
	}

	/**
	 * 查询评论
	 * 
	 * @param flag
	 *            查询的条件
	 * @param pid
	 *            照片的id
	 * @return 编号为pid照片的所有评论
	 */
	public List<Pinglun> searchById(int id, int num) {
		List<Pinglun> list = null;
		String sql = "";
		if (num == 0) {// 根据图片id查询对应的所有评论
			sql = "select * from pinglun where pid=" + id + " order by id desc";
		} else if (num == 1) {// 根据id查询单条评论
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
	 * 添加新的评论
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
	 * 修改一条评论
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
	 * 该方法用来执行所有修改的操作
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
