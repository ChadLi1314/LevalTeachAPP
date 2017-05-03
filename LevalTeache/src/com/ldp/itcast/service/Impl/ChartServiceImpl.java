package com.ldp.itcast.service.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldp.itcast.dao.ChartDao;
import com.ldp.itcast.domain.Analyzes;
import com.ldp.itcast.service.ChartService;

@Service
public class ChartServiceImpl implements ChartService {

	@Resource
	private ChartDao dao;
	
	public List<Integer> findAllTeacher() {
		// TODO Auto-generated method stub
		return this.dao.findAllTeacher();
	}

	public List<Double> findDealCourse(Integer[] a) {
		// TODO Auto-generated method stub
		return this.dao.findDealCourse(a);
	}

	public List<Integer> findCourseC_id(Integer t_id) {
		// TODO Auto-generated method stub
		return this.dao.findCourseC_id(t_id);
	}

	public void deleteOneTeacher(Integer t_id) {
		// TODO Auto-generated method stub
		this.dao.deleteOneTeacher(t_id);
	}

	public String findT_idToIname(Integer t_id) {
		// TODO Auto-generated method stub
		return this.dao.findT_idToIname(t_id);
	}

	public void saveAnalyzes(Analyzes analyzes) {
		// TODO Auto-generated method stub
		this.dao.saveAnalyzes(analyzes);
	}

	public List<Analyzes> findAllAnalyzesCondition(Map map) {
		// TODO Auto-generated method stub
		return this.dao.findAllAnalyzesCondition(map);
	}

/*	public Integer findAnalyzesT_id(Integer t_id) {
		// TODO Auto-generated method stub
		return this.dao.findAnalyzesT_id(t_id);
	}*/

}
