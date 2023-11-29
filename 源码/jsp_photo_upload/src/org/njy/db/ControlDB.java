/*
 * Created on 2008-6-14
 */
package org.njy.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.njy.beans.Admin;
import org.njy.beans.LeiBie;
import org.njy.beans.Photo;
import org.njy.beans.Pinglun;
import org.njy.beans.Systems;
import org.njy.util.ConvertUtil;

/**
 * ControlDB.
 * 
 * @author 聂靖宇
 * @version 1.2
 */
public class ControlDB {
	// 创建一个私有的ControlDB对象
	private static ControlDB control = null;

	private ControlDB() {
		// 私有的构造方法，为下面实现单利模式做准备
	}

	/**
	 * 获得一个ControlDB对象的实例
	 * 
	 * @return
	 */
	public static ControlDB getInstance() {
		if (control == null) {
			control = new ControlDB();
		}
		return control;
	}

	/**
	 * 执行select语句
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public ResultSet executeQuery(String sql) throws Exception {
		ResultSet rs = null;
		Connection con = null;
		Statement stmt = null;
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			throw e;
		}
		return rs;
	}

	/**
	 * 该方法用来查询当前网站的设置信息
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public Systems selectSystemInfo(String sql) throws Exception {
		Systems sys = new Systems();
		ResultSet rs = this.executeQuery(sql);
		if (rs.next()) {
			int i = 1;
			sys.setId(rs.getInt(i++));
			sys.setName(rs.getString(i++));
			sys.setLogopath(rs.getString(i++));
			sys.setGonggao(rs.getString(i++));
		}
		return sys;
	}

	/**
	 * 该方法用来检测管理员帐号和密码是否正确
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public Admin checkAdmin(String sql) throws Exception {
		Admin admin = new Admin();
		ResultSet rs = this.executeQuery(sql);
		if (rs.next()) {
			int i = 1;
			admin.setId(rs.getInt(i++));
			admin.setName(rs.getString(i++));
			admin.setPass(rs.getString(i++));
		}
		return admin;
	}
	
	public Admin checkAdminExist(String sql) throws Exception {
		Admin admin = null;
		ResultSet rs = this.executeQuery(sql);
		if (rs.next()) {
			admin = new Admin();
			int i = 1;
			admin.setId(rs.getInt(i++));
			admin.setName(rs.getString(i++));
			admin.setPass(rs.getString(i++));
		}
		return admin;
	}

	/**
	 * 查询所有的照片分类信息
	 * 
	 * @return
	 */
	public List<LeiBie> selectLiebie(String sql) throws Exception {
		List<LeiBie> list = new ArrayList<LeiBie>();
		ResultSet rs = executeQuery(sql);
		ConvertUtil convert = ConvertUtil.getInstance();
		while (rs.next()) {
			int i = 1;
			LeiBie leibie = new LeiBie();
			leibie.setId(rs.getInt(i++));
			leibie.setName(rs.getString(i++));
			leibie.setShuoming(rs.getString(i++));
			leibie.setNum(convert.strToInt(rs.getString(i++)));
			leibie.setContenttime(rs.getString(i++));
			list.add(leibie);
		}
		return list;
	}

	/**
	 * 根据分类的名称查询所有相关的照片
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public List<LeiBie> selectAllPhotoById(String sql) throws Exception {
		List<LeiBie> list = new ArrayList<LeiBie>();
		ResultSet rs = executeQuery(sql);
		ConvertUtil convert = ConvertUtil.getInstance();
		while (rs.next()) {
			int i = 1;
			LeiBie leibie = new LeiBie();
			leibie.setId(rs.getInt(i++));
			leibie.setName(rs.getString(i++));
			leibie.setShuoming(rs.getString(i++));
			leibie.setNum(convert.strToInt(rs.getString(i++)));
			leibie.setContenttime(rs.getString(i++));
			list.add(leibie);
		}
		return list;
	}

	/**
	 * 查询所有的照片信息
	 * 
	 * @return
	 */
	public List<Photo> selectPhoto(String sql) throws Exception {
		List<Photo> list = new ArrayList<Photo>();
		ResultSet rs = executeQuery(sql);
		while (rs.next()) {
			int i = 1;
			Photo photo = new Photo();
			photo.setId(rs.getInt(i++));
			photo.setName(rs.getString(i++));
			photo.setPath(rs.getString(i++));
			photo.setDianji(rs.getInt(i++));
			photo.setContentTime(rs.getString(i++));
			photo.setShuoming(rs.getString(i++));
			photo.setLid(rs.getInt(i++));
			list.add(photo);
		}
		return list;
	}

	/**
	 * 根据传过来的Sql语句查询相关的评论
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public List<Pinglun> executeQueryPinglun(String sql) throws Exception {
		List<Pinglun> list = new ArrayList<Pinglun>();
		ResultSet rs = executeQuery(sql);
		while (rs.next()) {
			int i = 1;
			Pinglun pinglun = new Pinglun();
			pinglun.setId(rs.getInt(i++));
			pinglun.setContentText(rs.getString(i++));
			pinglun.setContentTime(rs.getString(i++));
			pinglun.setName(rs.getString(i++));
			pinglun.setPid(rs.getInt(i++));
			list.add(pinglun);
		}
		return list;
	}

	/**
	 * 执行所有修改的操作
	 * 
	 * @param sql
	 * @throws Exception
	 */
	public boolean executeUpdate(String sql) throws Exception {
		boolean flag = false;
		Connection con = null;
		Statement stmt = null;
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement();
			int row = stmt.executeUpdate(sql);
			flag = row > 0 ? true : false;
		} catch (SQLException ex) {
			ex.printStackTrace();
			flag = false;
		} finally {
			DatabaseUtils.closeObject(stmt, con);
		}
		return flag;
	}
}
