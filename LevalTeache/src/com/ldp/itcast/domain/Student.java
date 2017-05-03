package com.ldp.itcast.domain;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{

	private Integer s_id;
	private String sname;
	private String sex;
	private String grade;
	private Integer status;
	private Date date;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getS_id() {
		return s_id;
	}
	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", sname=" + sname + ", sex=" + sex
				+ ", grade=" + grade + ", status=" + status + ", date=" + date
				+ ", password=" + password + "]";
	}

	
	


}
