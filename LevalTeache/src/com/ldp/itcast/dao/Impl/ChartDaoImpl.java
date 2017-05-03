package com.ldp.itcast.dao.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.ldp.itcast.dao.ChartDao;
import com.ldp.itcast.domain.Analyzes;
import com.ldp.itcast.mapper.ChartMapper;

@Repository
public class ChartDaoImpl extends SqlSessionDaoSupport implements ChartDao {

	/**
	 * mybatis3.0.0+mybatis-spring1.0.0无需自己注入，底层给你注入
	 * mybatis3.2.2+mybatis-spring1.2.0去除了这个，需要自己注入sqlsessionFactory
	 * 
	 */
	
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	
	public List<Integer> findAllTeacher() {
		// TODO Auto-generated method stub
		ChartMapper chartMapper = this.getSqlSession().getMapper(ChartMapper.class);
		List<Integer> integers = chartMapper.findAllTeacher();
		return integers;
	}


	public List<Double> findDealCourse(Integer[] a) {
		// TODO Auto-generated method stub
		ChartMapper chartMapper = this.getSqlSession().getMapper(ChartMapper.class);
		List<Double> doubles = chartMapper.findDealCourse(a);
		return doubles;
	}


	public List<Integer> findCourseC_id(Integer t_id) {
		// TODO Auto-generated method stub
		ChartMapper chartMapper = this.getSqlSession().getMapper(ChartMapper.class);
		List<Integer> integers = chartMapper.findCourseC_id(t_id);
		return integers;
	}


	public void deleteOneTeacher(Integer t_id) {
		// TODO Auto-generated method stub
		ChartMapper chartMapper = this.getSqlSession().getMapper(ChartMapper.class);
		chartMapper.deleteOneTeacher(t_id);
	}


	public String findT_idToIname(Integer t_id) {
		// TODO Auto-generated method stub
		ChartMapper chartMapper = this.getSqlSession().getMapper(ChartMapper.class);
		return chartMapper.findT_idToIname(t_id);
	}


	public void saveAnalyzes(Analyzes analyzes) {
		// TODO Auto-generated method stub
		ChartMapper chartMapper = this.getSqlSession().getMapper(ChartMapper.class);
		chartMapper.saveAnalyzes(analyzes);
	}


	public List<Analyzes> findAllAnalyzesCondition(Map map) {
		// TODO Auto-generated method stub
		ChartMapper chartMapper = this.getSqlSession().getMapper(ChartMapper.class);
		List<Analyzes> analyzes = chartMapper.findAllAnalyzesCondition(map);
		return analyzes;
	}


/*	public Integer findAnalyzesT_id(Integer t_id) {
		// TODO Auto-generated method stub
		ChartMapper chartMapper = this.getSqlSession().getMapper(ChartMapper.class);
		return chartMapper.findAnalyzesT_id(t_id);
	}*/

}
