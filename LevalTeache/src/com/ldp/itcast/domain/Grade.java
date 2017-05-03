package com.ldp.itcast.domain;

import java.io.Serializable;

public class Grade implements Serializable{
	private String grade;
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Grade [grade=" + grade + "]";
	}
	

}
