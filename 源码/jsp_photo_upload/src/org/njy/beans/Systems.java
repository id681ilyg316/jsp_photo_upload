package org.njy.beans;

/**
 * ������ϵͳ���Ե�Bean
 * 
 * @author Administrator
 * 
 */
public class Systems {

	private int id = 0;
	/** ��վ���� */
	private String name = "";
	/** ��վlogo��ַ */
	private String logopath = "";
	/** ��վ���� */
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
