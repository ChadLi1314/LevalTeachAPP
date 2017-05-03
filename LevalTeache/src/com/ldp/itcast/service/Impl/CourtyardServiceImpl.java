package com.ldp.itcast.service.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldp.itcast.dao.CourtyardDao;
import com.ldp.itcast.domain.Courtyard;
import com.ldp.itcast.domain.Teacher;
import com.ldp.itcast.service.CourtyardService;

@Service
public class CourtyardServiceImpl implements CourtyardService {

	@Resource
	private CourtyardDao dao;
	
	public boolean insertCourtyard(Courtyard courtyard) {
		// TODO Auto-generated method stub
		return this.dao.insertCourtyard(courtyard);
	}

	public boolean saveTeacher(Map map) {
		// TODO Auto-generated method stub
		return this.dao.saveTeacher(map);
	}

	public List<Courtyard> findCourtyardAll() {
		// TODO Auto-generated method stub
		return this.dao.findCourtyardAll();
	}

	public Teacher findTeacherId(Integer t_id) {
		// TODO Auto-generated method stub
		return this.dao.findTeacherId(t_id);
	}

	public List<Teacher> findTeacherList(Integer i_id) {
		// TODO Auto-generated method stub
		return this.dao.findTeacherList(i_id);
	}

	public boolean updateTeacherT_id(Teacher teacher) {
		// TODO Auto-generated method stub
		return this.dao.updateTeacherT_id(teacher);
	}

}
