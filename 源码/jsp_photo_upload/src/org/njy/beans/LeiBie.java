package org.njy.beans;

import java.io.Serializable;

public class LeiBie implements Serializable {

	/** 相册类别的编号 */
	private int id = 0;
	/** 相册分类的名字 */
	private String name = "";
	/** 该分类创建的时间 */
	private String contenttime = "";
	/** 该分类的接介绍 */
	private String shuoming = "";
	/** 该分类的照片数量 */
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
