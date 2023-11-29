package org.njy.beans;

/**
 * 该类是系统属性的Bean
 * 
 * @author Administrator
 * 
 */
public class Systems {

	private int id = 0;
	/** 网站名称 */
	private String name = "";
	/** 网站logo地址 */
	private String logopath = "";
	/** 网站公告 */
	private String gonggao = "";

	public Systems() {

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

	public String getLogopath() {
		return logopath;
	}

	public void setLogopath(String logopath) {
		this.logopath = logopath;
	}

	public String getGonggao() {
		return gonggao;
	}

	public void setGonggao(String gonggao) {
		this.gonggao = gonggao;
	}
}
