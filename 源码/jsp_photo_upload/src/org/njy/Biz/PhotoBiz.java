package org.njy.Biz;

import java.util.*;
import org.njy.db.ControlDB;
import org.njy.util.ConvertUtil;
import org.njy.beans.Photo;

public class PhotoBiz {

	private static PhotoBiz photobiz = null;
	private ControlDB control = null;

	private PhotoBiz() {
		control = ControlDB.getInstance();
	}

	/**
	 * 该方法获得一个PhotoBiz实例
	 * 
	 * @return photobiz
	 */
	public static PhotoBiz getInstance() {
		if (photobiz == null) {
			photobiz = new PhotoBiz();
		}
		return photobiz;
	}

	/**
	 * 根据不同的条件查询图片的信息
	 * 
	 * @return
	 */
	public List<Photo> selectAllPhoto(int id, int b) {
		String sql = "";
		List<Photo> list = null;
		if (b == 0) {// 查询所有的图片信息
			sql = "SELECT id,name,path,dianji,contentTime,shuoming,lid FROM photo";
		} else if (b == 1) {// 根据分类的id查
			sql = "SELECT id,name,path,dianji,contentTime,shuoming,lid FROM photo WHERE lid="
					+ id;
		} else if (b == 2) {// 根据分类的id查
			sql = "SELECT id,name,path,dianji,contentTime,shuoming,lid FROM photo WHERE id="
					+ id;
		}
		list = this.executerQuery(sql);
		return list;
	}

	/**
	 * 根据不同的收索条件查找图片(模糊查询)
	 * 
	 * @return
	 */
	public List<Photo> selectAllPhotoByRadio(String keyName, int b) {
		String sql = "";
		List<Photo> list = null;
		if (b == 2) {// 根据照片的名字模糊查询
			sql = "SELECT id,name,path,dianji,contentTime,shuoming,lid FROM photo WHERE name like '%"
					+ keyName + "%'";
		} else if (b == 1) {// 根据分类的名称模糊查询
			sql = "SELECT id,name,path,dianji,contentTime,shuoming,lid FROM photo WHERE lid=(select id from leibie WHERE name like '%"
					+ keyName + "%')";
		} else if (b == 3) {// 根据点击率查询
			sql = "SELECT id,name,path,dianji,contentTime,shuoming,lid FROM photo order by dianji DESC";
		}
		list = this.executerQuery(sql);
		return list;
	}

	/**
	 * 该方法执行所有的查询
	 * 
	 * @param sql
	 * @return
	 */
	private List<Photo> executerQuery(String sql) {
		List<Photo> list = null;
		try {
			list = control.selectPhoto(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 添加一张照片
	 * 
	 * @param photo
	 * @return
	 */
	public boolean add(Photo photo) {
		boolean flag = false;
		ConvertUtil convert = ConvertUtil.getInstance();
		String sql = "INSERT INTO photo(name,path,dianji,contentTime,shuoming,lid) values('"
				+ photo.getName()
				+ "','"
				+ photo.getPath()
				+ "',"
				+ photo.getDianji()
				+ ",'"
				+ convert.getTime()
				+ "','"
				+ photo.getShuoming() + "'," + photo.getLid() + ")";
		flag = this.executeUpdate(sql);
		return flag;
	}

	/**
	 * 删除一张照片
	 * 
	 * @param id
	 * @return
	 */
	public boolean del(int id) {
		boolean flag = false;
		String sql = "DELETE FROM photo WHERE id=" + id;
		flag = this.executeUpdate(sql);
		return flag;
	}

	/**
	 * 更改图片的信息
	 * 
	 * @param id
	 * @return
	 */
	public boolean update(int num, Photo photo) {
		boolean flag = false;
		String sql = "";
		if (num == 0) {// 修改点击率
			sql = "UPDATE photo SET dianji=dianji+1 where id=" + photo.getId();
		} else if (num == 1) {// 修改图片的信息
			sql = "UPDATE photo SET name='" + photo.getName() + "',shuoming='"
					+ photo.getShuoming() + "',lid=" + photo.getLid()
					+ " where id=" + photo.getId();
		}

		flag = this.executeUpdate(sql);
		return flag;
	}

	/**
	 * 用来操作所有的修改
	 * 
	 * @param sql
	 * @return
	 */
	@SuppressWarnings("unused")
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
