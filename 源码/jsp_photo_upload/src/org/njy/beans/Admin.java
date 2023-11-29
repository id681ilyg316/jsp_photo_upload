package org.njy.beans;

import java.io.Serializable;

public class Admin implements Serializable {

	/** 管理员编号 */
	private int id = 0;
	/** 管理员的帐号 */
	private String name = "";
	/** 管理员密码 */
	private String pass = "";

	public Admin() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
