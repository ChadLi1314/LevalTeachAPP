package com.ldp.itcast.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldp.itcast.dao.StudentCourseDao;
import com.ldp.itcast.domain.Course;
import com.ldp.itcast.domain.Student;
import com.ldp.itcast.service.StudentCourseService;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

	@Resource
	private StudentCourseDao dao;
	
	public List<Course> findLonginCourse(Integer c_id) {
		// TODO Auto-generated method stub
		return this.dao.findLonginCourse(c_id);
	}

	public boolean updatePersonStudent(Student student) {
		// TODO Auto-generated method stub
		return this.dao.updatePersonStudent(student);
	}

}
