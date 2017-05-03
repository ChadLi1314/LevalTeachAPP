package com.ldp.itcast.domain;

import java.io.Serializable;

public class Manager implements Serializable{

	private Integer m_id;
	private String mname;
	private String password;
	
	public Integer getM_id() {
		return m_id;
	}
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Manager [m_id=" + m_id + ", mname=" + mname + ", password="
				+ password + "]";
	}
	
	
}
