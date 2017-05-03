package com.ldp.itcast.service;

import java.util.List;
import java.util.Map;

import com.ldp.itcast.domain.Course;
import com.ldp.itcast.domain.Evaluate;

public interface EvaluateService {
	public void saveEvaluate(Evaluate evaluate);
	public Course findCourseCondition(Map map);
	public List<Evaluate> findEvaluateCondition(Map map);
}
