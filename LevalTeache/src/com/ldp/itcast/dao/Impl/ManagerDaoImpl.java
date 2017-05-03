package com.ldp.itcast.dao.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.ldp.itcast.dao.ManagerDao;
import com.ldp.itcast.domain.Manager;
import com.ldp.itcast.domain.Question;
import com.ldp.itcast.mapper.ManagerMapper;

@Repository
public class ManagerDaoImpl extends SqlSessionDaoSupport implements ManagerDao {

	

	/**
	 * mybatis3.0.0+mybatis-spring1.0.0无需自己注入，底层给你注入
	 * mybatis3.2.2+mybatis-spring1.2.0去除了这个，需要自己注入sqlsessionFactory
	 * 
	 */
	
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public Manager findManagerById(Manager manager) {
		// TODO Auto-generated method stub
		System.out.println("Dao:  "+manager.toString());
		ManagerMapper managerMapper = this.getSqlSession().getMapper(ManagerMapper.class);
		Manager manager2 = managerMapper.findManagerById(manager); 
		System.out.println("--Into Dao findManagerById!!!--");
		return manager2;
	}

	public List<String> findQuestions() {
		// TODO Auto-generated method stub
		ManagerMapper managerMapper = this.getSqlSession().getMapper(ManagerMapper.class);
		List<String> strs = managerMapper.findQuestions();
		System.out.println("--Into Dao findQuestions --");
		return strs;
	}

	public List<Question> findAllQuestions(Map map) {
		// TODO Auto-generated method stub
		ManagerMapper managerMapper = this.getSqlSession().getMapper(ManagerMapper.class);
		List<Question> questions = managerMapper.findAllQuestions(map);
		System.out.println("--Into Dao findAllQuestions --");
		return questions;
	}

	public void addQuestion(String content) {
		// TODO Auto-generated method stub
		ManagerMapper managerMapper = this.getSqlSession().getMapper(ManagerMapper.class);
		managerMapper.addQuestion(content);
		System.out.println("--Into Dao addQuestion --");
	}

	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		ManagerMapper managerMapper = this.getSqlSession().getMapper(ManagerMapper.class);
		managerMapper.deleteQuestion(id);
		System.out.println("--Into Dao deleteQuestion --");
	}

	public void updateQuestion(Question question) {
		// TODO Auto-generated method stub
		ManagerMapper managerMapper = this.getSqlSession().getMapper(ManagerMapper.class);
		managerMapper.updateQuestion(question);
		System.out.println("--Into Dao updateQuestion --");
	}

}
