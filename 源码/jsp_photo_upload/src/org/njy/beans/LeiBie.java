package org.njy.beans;

import java.io.Serializable;

public class LeiBie implements Serializable {

	/** ������ı�� */
	private int id = 0;
	/** ����������� */
	private String name = "";
	/** �÷��ഴ����ʱ�� */
	private String contenttime = "";
	/** �÷���Ľӽ��� */
	private String shuoming = "";
	/** �÷������Ƭ���� */
	private int num;

	public LeiBie() {
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

	public String getContenttime() {
		return contenttime;
	}

	public void setContenttime(String contenttime) {
		this.contenttime = contenttime;
	}

	public String getShuoming() {
		return shuoming;
	}

	public void setShuoming(String shuoming) {
		this.shuoming = shuoming;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
