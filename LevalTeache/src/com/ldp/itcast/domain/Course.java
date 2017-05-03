package com.ldp.itcast.domain;

import java.io.Serializable;

public class Course implements Serializable{
 
	private Integer c_id;
	private String cname;
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Course [c_id=" + c_id + ", cname=" + cname + "]";
	}
	
	
}
