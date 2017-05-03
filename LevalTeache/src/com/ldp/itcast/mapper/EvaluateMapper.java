package com.ldp.itcast.mapper;

import java.util.List;
import java.util.Map;

import com.ldp.itcast.domain.Evaluate;

public interface EvaluateMapper {
	public void saveEvaluate(Evaluate evaluate);
	public List<Evaluate> findEvaluateCondition(Map map);
}
