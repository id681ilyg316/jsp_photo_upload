package org.njy.beans;

import java.io.Serializable;

public class Admin implements Serializable {

	/** ����Ա��� */
	private int id = 0;
	/** ����Ա���ʺ� */
	private String name = "";
	/** ����Ա���� */
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
