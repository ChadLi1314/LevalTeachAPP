package com.ldp.itcast.dao;

import java.util.List;
import java.util.Map;

import com.ldp.itcast.domain.Course;
import com.ldp.itcast.domain.Teacher;

public interface TeacherDao {
	public Teacher findTeacherById(Map map);
	public List<Course> findTeacherCourseById(Integer t_id);
}
