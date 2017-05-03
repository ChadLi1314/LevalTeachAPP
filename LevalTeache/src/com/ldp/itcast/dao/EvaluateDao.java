package com.ldp.itcast.dao;

import java.util.List;
import java.util.Map;

import com.ldp.itcast.domain.Course;
import com.ldp.itcast.domain.Evaluate;

public interface EvaluateDao {
	public void saveEvaluate(Evaluate evaluate);
	public Course findCourseCondition(Map map);
	public List<Evaluate> findEvaluateCondition(Map map);
}
