package com.ldp.itcast.domain;

import java.io.Serializable;

public class Analyzes implements Serializable{

	private Integer a_id;
	private double result;
	private String iname;
	public Integer getA_id() {
		return a_id;
	}
	public void setA_id(Integer a_id) {
		this.a_id = a_id;
	}

	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Analyzes [a_id=" + a_id + ", result=" + result + ", iname="
				+ iname + "]";
	}

	
}
