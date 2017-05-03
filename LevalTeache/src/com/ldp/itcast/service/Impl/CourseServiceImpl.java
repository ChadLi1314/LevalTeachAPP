package com.ldp.itcast.service.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldp.itcast.dao.CourseDao;
import com.ldp.itcast.domain.Course;
import com.ldp.itcast.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Resource
	private CourseDao dao;

	public void saveCourse(Course course) {
		// TODO Auto-generated method stub
		this.dao.saveCourse(course);
	}

	public int findCourseName(String cname) {
		// TODO Auto-generated method stub
		return this.dao.findCourseName(cname);
	}

	public List<Course> findCourseAll() {
		// TODO Auto-generated method stub
		return this.dao.findCourseAll();
	}

	public void CollectionTeacheCourse(Map map) {
		// TODO Auto-generated method stub
		this.dao.CollectionTeacheCourse(map);
	}

	public int CollectionTeacherCourseResult(Map map) {
		// TODO Auto-generated method stub
		return this.dao.CollectionTeacherCourseResult(map);
	}

}
