package com.ldp.itcast.service.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldp.itcast.dao.TeacherDao;
import com.ldp.itcast.domain.Course;
import com.ldp.itcast.domain.Teacher;
import com.ldp.itcast.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Resource
	private TeacherDao dao;
	
	public Teacher findTeacherById(Map map) {
		// TODO Auto-generated method stub
		return this.dao.findTeacherById(map);
	}

	public List<Course> findTeacherCourseById(Integer t_id) {
		// TODO Auto-generated method stub
		return this.dao.findTeacherCourseById(t_id);
	}

}
