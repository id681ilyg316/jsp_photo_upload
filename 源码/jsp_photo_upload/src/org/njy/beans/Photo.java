package org.njy.beans;

import java.io.Serializable;

public class Photo implements Serializable {
	/** 照片编号 */
	private int id = 0;
	/** 照片名字 */
	private String name = "";
	/** 照片存放的路径 */
	private String path = "";
	/** 照片的点击数 */
	private int dianji = 0;
	/** 照片的上传时间 */
	private String contentTime = "";
	/** 照片的说明 */
	private String shuoming = "";
	/** 照片对应的类别编号 */
	private int lid = 0;
	/** 所有的照片总数 */
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
