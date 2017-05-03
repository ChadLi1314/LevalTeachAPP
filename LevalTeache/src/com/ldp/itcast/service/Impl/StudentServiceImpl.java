package com.ldp.itcast.service.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldp.itcast.dao.StudentDao;
import com.ldp.itcast.domain.Grade;
import com.ldp.itcast.domain.Student;
import com.ldp.itcast.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Resource
	private StudentDao dao;

	public List<Student> findStudent(Map map) {
		// TODO Auto-generated method stub
		return this.dao.findStudent(map);
	}

	public boolean saveStudentAll(Student student) {
		// TODO Auto-generated method stub
		return this.dao.saveStudentAll(student);
	}

	public int findStudentCount(Integer c_id) {
		// TODO Auto-generated method stub
		return this.dao.findStudentCount(c_id);
	}

	public List<Grade> findStudentGrade() {
		// TODO Auto-generated method stub
		return this.dao.findStudentGrade();
	}

	public List<Grade> findGradeI_id(Integer i_id) {
		// TODO Auto-generated method stub
		return this.dao.findGradeI_id(i_id);
	}

	public int findStudentGradeResult(Map map) {
		// TODO Auto-generated method stub
		return this.dao.findStudentGradeResult(map);
	}

	public void CollectionStudentAndCourse(Map map) {
		// TODO Auto-generated method stub
		this.dao.CollectionStudentAndCourse(map);
	}

}
