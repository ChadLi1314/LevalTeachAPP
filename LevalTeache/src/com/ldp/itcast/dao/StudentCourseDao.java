package com.ldp.itcast.dao;

import java.util.List;

import com.ldp.itcast.domain.Course;
import com.ldp.itcast.domain.Student;

public interface StudentCourseDao {
	public List<Course> findLonginCourse(Integer c_id);
	public boolean updatePersonStudent(Student student);
}
