package com.ldp.itcast.domain;

import java.io.Serializable;

public class Teacher implements Serializable{
	private Integer t_id;   	//ID号
	private String tname;   	//姓名
	private String sex;     	//性别
	private String date;		//出生日期
	private String Idcard;  	//身份证号
	private String census;		//户籍
	private String nation;		//民族
	private String politics;	//政治面貌
	private String background;	//学历
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*private Integer i_id;*/
	public Integer getT_id() {
		return t_id;
	}
	public void setT_id(Integer t_id) {
		this.t_id = t_id;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getIdcard() {
		return Idcard;
	}
	public void setIdcard(String idcard) {
		Idcard = idcard;
	}
	public String getCensus() {
		return census;
	}
	public void setCensus(String census) {
		this.census = census;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getPolitics() {
		return politics;
	}
	public void setPolitics(String politics) {
		this.politics = politics;
	}
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
	}
/*	public Integer getI_id() {
		return i_id;
	}
	public void setI_id(Integer i_id) {
		this.i_id = i_id;
	}*/
	@Override
	public String toString() {
		return "Teacher [t_id=" + t_id + ", tname=" + tname + ", sex=" + sex
				+ ", date=" + date + ", Idcard=" + Idcard + ", census="
				+ census + ", nation=" + nation + ", politics=" + politics
				+ ", background=" + background + ", password=" + password + "]";
	}
	
	
	
}
