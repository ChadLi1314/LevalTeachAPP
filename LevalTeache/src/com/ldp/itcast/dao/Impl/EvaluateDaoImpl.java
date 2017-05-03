package com.ldp.itcast.dao.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.ldp.itcast.dao.EvaluateDao;
import com.ldp.itcast.domain.Course;
import com.ldp.itcast.domain.Evaluate;
import com.ldp.itcast.mapper.EvaluateMapper;
import com.ldp.itcast.mapper.StudentMapper;

@Repository
public class EvaluateDaoImpl extends SqlSessionDaoSupport implements EvaluateDao {

	
	/**
	 * mybatis3.0.0+mybatis-spring1.0.0无需自己注入，底层给你注入
	 * mybatis3.2.2+mybatis-spring1.2.0去除了这个，需要自己注入sqlsessionFactory
	 * 
	 */
	
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public void saveEvaluate(Evaluate evaluate) {
		// TODO Auto-generated method stub
		EvaluateMapper evaluateMapper = this.getSqlSession().getMapper(EvaluateMapper.class);
		evaluateMapper.saveEvaluate(evaluate);
		System.out.println("--Into Dao saveEvaluate--");
	}

	public Course findCourseCondition(Map map) {
		// TODO Auto-generated method stub
		StudentMapper studentMapper = this.getSqlSession().getMapper(StudentMapper.class);
		Course course = studentMapper.findCourseCondition(map);
		System.out.println("--Into Dao findCourseCondition--");
		return course;
	}

	public List<Evaluate> findEvaluateCondition(Map map) {
		// TODO Auto-generated method stub
		EvaluateMapper evaluateMapper = this.getSqlSession().getMapper(EvaluateMapper.class);
		List<Evaluate> evaluates = evaluateMapper.findEvaluateCondition(map);
		System.out.println("--Into Dao findEvaluateCondition--");
		return evaluates;
	}

}
