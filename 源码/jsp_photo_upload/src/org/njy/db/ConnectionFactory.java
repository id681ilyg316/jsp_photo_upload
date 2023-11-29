/*
 * Created on 2008-6-14
 */
package org.njy.db;

import java.io.*;
import java.sql.*;
import java.util.Properties;

/**
 * Connection Factory.
 * 
 * @author 聂靖宇
 * @version 1.2
 */
public class ConnectionFactory {
	/** database driver class name */
	private String driver = "";

	/** database URL associated with the URL */
	private String dbURL = "";

	/** user name of the database */
	private String user = "";

	/** password for the current user */
	private String password = "";

	/** factory instance */
	private static ConnectionFactory factory = null;

	/**
	 * constructor
	 * 
	 * @throws Exception
	 */
	private ConnectionFactory() throws Exception {
		Properties prop = new Properties();

		// 方法链
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("jdbc.properties");
		try {
			// 从输入流中的数据加载成键值对
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("加载配置文件出错");
		}
		
		this.driver = (String) prop.get("driver");
		this.dbURL = (String) prop.get("url");
		this.user = (String) prop.get("user");
		this.password = (String) prop.get("password");
	}

	/**
	 * @return database dbURL
	 */
	public String getDbURL() {
		return dbURL;
	}

	/**
	 * @return database driver class name
	 */
	public String getDriver() {
		return driver;
	}

	/**
	 * @return password of the current user
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the database user
	 */
	public String getUser() {
		return user;
	}

	public static Connection getConnection() {
		Connection conn = null;
		if (factory == null) {
			try {
				factory = new ConnectionFactory();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				return null;
			}
		}

		try {
			Class.forName(factory.getDriver());
			conn = DriverManager.getConnection(factory.getDbURL(), factory
					.getUser(), factory.getPassword());
		} catch (ClassNotFoundException e) {
			System.out.println(" No class " + factory.getDriver()
					+ " found error");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Failed to get connection :" + e.getMessage());
			e.printStackTrace();
		}

		return conn;
	}
}