package org.njy.beans;

public class Pinglun {
	/** 评论的编号 */
	private int id;
	/** 评论的内容 */
	private String contentText;
	/** 评论的时间* */
	private String contentTime;
	/** 评论者姓名 */
	private String name;
	/** 评论对应的照片id */
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
