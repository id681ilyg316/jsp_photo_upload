package org.njy.beans;

import java.io.Serializable;

public class Photo implements Serializable {
	/** ��Ƭ��� */
	private int id = 0;
	/** ��Ƭ���� */
	private String name = "";
	/** ��Ƭ��ŵ�·�� */
	private String path = "";
	/** ��Ƭ�ĵ���� */
	private int dianji = 0;
	/** ��Ƭ���ϴ�ʱ�� */
	private String contentTime = "";
	/** ��Ƭ��˵�� */
	private String shuoming = "";
	/** ��Ƭ��Ӧ������� */
	private int lid = 0;
	/** ���е���Ƭ���� */
	private int count = 0;

	public Photo() {
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getDianji() {
		return dianji;
	}

	public void setDianji(int dianji) {
		this.dianji = dianji;
	}

	public String getContentTime() {
		return contentTime;
	}

	public void setContentTime(String contentTime) {
		this.contentTime = contentTime;
	}

	public String getShuoming() {
		return shuoming;
	}

	public void setShuoming(String shuoming) {
		this.shuoming = shuoming;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}
}
