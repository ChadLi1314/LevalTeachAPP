package com.ldp.itcast.service.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldp.itcast.dao.EvaluateDao;
import com.ldp.itcast.domain.Course;
import com.ldp.itcast.domain.Evaluate;
import com.ldp.itcast.service.EvaluateService;



@Service
public class EvaluateServiceImpl implements EvaluateService {

	@Resource
	private EvaluateDao dao;
	
	public void saveEvaluate(Evaluate evaluate) {
		// TODO Auto-generated method stub
		this.dao.saveEvaluate(evaluate);
	}

	public Course findCourseCondition(Map map) {
		// TODO Auto-generated method stub
		return this.dao.findCourseCondition(map);
	}

	public List<Evaluate> findEvaluateCondition(Map map) {
		// TODO Auto-generated method stub
		return this.dao.findEvaluateCondition(map);
	}

}
