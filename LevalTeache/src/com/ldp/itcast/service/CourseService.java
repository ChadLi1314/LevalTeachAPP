package com.ldp.itcast.service;

import java.util.List;
import java.util.Map;

import com.ldp.itcast.domain.Course;

public interface CourseService {
	public void saveCourse(Course course);
	public int findCourseName(String cname);
	public List<Course> findCourseAll();
	public void CollectionTeacheCourse(Map map);
	public int CollectionTeacherCourseResult(Map map);
}
