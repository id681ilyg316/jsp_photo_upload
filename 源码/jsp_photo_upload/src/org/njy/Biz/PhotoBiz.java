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
	 * �÷������һ��PhotoBizʵ��
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
	 * ���ݲ�ͬ��������ѯͼƬ����Ϣ
	 * 
	 * @return
	 */
	public List<Photo> selectAllPhoto(int id, int b) {
		String sql = "";
		List<Photo> list = null;
		if (b == 0) {// ��ѯ���е�ͼƬ��Ϣ
			sql = "SELECT id,name,path,dianji,contentTime,shuoming,lid FROM photo";
		} else if (b == 1) {// ���ݷ����id��
			sql = "SELECT id,name,path,dianji,contentTime,shuoming,lid FROM photo WHERE lid="
					+ id;
		} else if (b == 2) {// ���ݷ����id��
			sql = "SELECT id,name,path,dianji,contentTime,shuoming,lid FROM photo WHERE id="
					+ id;
		}
		list = this.executerQuery(sql);
		return list;
	}

	/**
	 * ���ݲ�ͬ��������������ͼƬ(ģ����ѯ)
	 * 
	 * @return
	 */
	public List<Photo> selectAllPhotoByRadio(String keyName, int b) {
		String sql = "";
		List<Photo> list = null;
		if (b == 2) {// ������Ƭ������ģ����ѯ
			sql = "SELECT id,name,path,dianji,contentTime,shuoming,lid FROM photo WHERE name like '%"
					+ keyName + "%'";
		} else if (b == 1) {// ���ݷ��������ģ����ѯ
			sql = "SELECT id,name,path,dianji,contentTime,shuoming,lid FROM photo WHERE lid=(select id from leibie WHERE name like '%"
					+ keyName + "%')";
		} else if (b == 3) {// ���ݵ���ʲ�ѯ
			sql = "SELECT id,name,path,dianji,contentTime,shuoming,lid FROM photo order by dianji DESC";
		}
		list = this.executerQuery(sql);
		return list;
	}

	/**
	 * �÷���ִ�����еĲ�ѯ
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
	 * ���һ����Ƭ
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
	 * ɾ��һ����Ƭ
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
	 * ����ͼƬ����Ϣ
	 * 
	 * @param id
	 * @return
	 */
	public boolean update(int num, Photo photo) {
		boolean flag = false;
		String sql = "";
		if (num == 0) {// �޸ĵ����
			sql = "UPDATE photo SET dianji=dianji+1 where id=" + photo.getId();
		} else if (num == 1) {// �޸�ͼƬ����Ϣ
			sql = "UPDATE photo SET name='" + photo.getName() + "',shuoming='"
					+ photo.getShuoming() + "',lid=" + photo.getLid()
					+ " where id=" + photo.getId();
		}

		flag = this.executeUpdate(sql);
		return flag;
	}

	/**
	 * �����������е��޸�
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
