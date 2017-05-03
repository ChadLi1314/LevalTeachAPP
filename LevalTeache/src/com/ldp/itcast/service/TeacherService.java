package com.ldp.itcast.service;

import java.util.List;
import java.util.Map;

import com.ldp.itcast.domain.Course;
import com.ldp.itcast.domain.Teacher;

public interface TeacherService {
	public Teacher findTeacherById(Map map);
	public List<Course> findTeacherCourseById(Integer t_id);
}
