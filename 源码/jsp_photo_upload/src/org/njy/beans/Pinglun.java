package org.njy.beans;

public class Pinglun {
	/** ���۵ı�� */
	private int id;
	/** ���۵����� */
	private String contentText;
	/** ���۵�ʱ��* */
	private String contentTime;
	/** ���������� */
	private String name;
	/** ���۶�Ӧ����Ƭid */
	private int pid;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setContentText(String contentText) {
		this.contentText = contentText;
	}

	public String getContentText() {
		return contentText;
	}

	public void setContentTime(String contentTime) {
		this.contentTime = contentTime;
	}

	public String getContentTime() {
		return contentTime;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getPid() {
		return pid;
	}
}
