package com.ldp.itcast.service;

import java.util.List;
import java.util.Map;

import com.ldp.itcast.domain.Grade;
import com.ldp.itcast.domain.Student;

public interface StudentService {
	public List<Student> findStudent(Map map);
	public boolean saveStudentAll(Student student);
	public int findStudentCount(Integer c_id);
	public List<Grade> findStudentGrade();
	public List<Grade> findGradeI_id(Integer i_id);
	public int findStudentGradeResult(Map map);
	public void CollectionStudentAndCourse(Map map);
}
