package com.ldp.itcast.mapper;

import java.util.List;
import java.util.Map;

import com.ldp.itcast.domain.Analyzes;

public interface ChartMapper {

	public List<Integer> findAllTeacher();
	public List<Double> findDealCourse(Integer[] a);
	public List<Integer> findCourseC_id(Integer t_id);
	public void deleteOneTeacher(Integer t_id);
	public String findT_idToIname(Integer t_id);
	public void saveAnalyzes(Analyzes analyzes);
/*	public Integer findAnalyzesT_id(Integer t_id);*/
	public List<Analyzes> findAllAnalyzesCondition(Map map);
}
