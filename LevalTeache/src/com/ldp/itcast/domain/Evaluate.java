package com.ldp.itcast.domain;

import java.io.Serializable;

public class Evaluate implements Serializable{
	private Integer e_id;
	private Integer result;
	private Integer s_id;
	private Integer c_id;
	private String content;
	private String grade;
	private String cname;
	public Integer getE_id() {
		return e_id;
	}
	public void setE_id(Integer e_id) {
		this.e_id = e_id;
	}
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	public Integer getS_id() {
		return s_id;
	}
	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Evaluate [e_id=" + e_id + ", result=" + result + ", s_id="
				+ s_id + ", c_id=" + c_id + ", content=" + content + ", grade="
				+ grade + ", cname=" + cname + "]";
	}
	
}
