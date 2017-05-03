package com.ldp.itcast.domain;

import java.io.Serializable;
import java.util.List;

public class Courtyard implements Serializable{

	private List<Teacher> teachers;//多的哪一方
	private Integer i_id;
	private String iname;
	
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public Integer getI_id() {
		return i_id;
	}
	public void setI_id(Integer i_id) {
		this.i_id = i_id;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	@Override
	public String toString() {
		return "Courtyard [teachers=" + teachers + ", i_id=" + i_id
				+ ", iname=" + iname + "]";
	}
	


	
}
