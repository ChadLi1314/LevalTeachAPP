package com.ldp.itcast.service;

import java.util.List;

import com.ldp.itcast.domain.Course;
import com.ldp.itcast.domain.Student;

public interface StudentCourseService {
	public List<Course> findLonginCourse(Integer c_id);
	public boolean updatePersonStudent(Student student);
}
