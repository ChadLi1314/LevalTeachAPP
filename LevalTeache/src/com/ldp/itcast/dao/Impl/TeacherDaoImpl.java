package com.ldp.itcast.dao.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.ldp.itcast.dao.TeacherDao;
import com.ldp.itcast.domain.Course;
import com.ldp.itcast.domain.Teacher;
import com.ldp.itcast.mapper.CourtyardMapper;

@Repository
public class TeacherDaoImpl extends SqlSessionDaoSupport implements TeacherDao {

	
	/**
	 * mybatis3.0.0+mybatis-spring1.0.0无需自己注入，底层给你注入
	 * mybatis3.2.2+mybatis-spring1.2.0去除了这个，需要自己注入sqlsessionFactory
	 * 
	 */
	
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	
	public Teacher findTeacherById(Map map) {
		// TODO Auto-generated method stub
		CourtyardMapper courtyardMapper = this.getSqlSession().getMapper(CourtyardMapper.class);
		Teacher teacher = courtyardMapper.findTeacherById(map);
		System.out.println("--Into Dao findTeacherById!!!--");
		return teacher;
	}


	public List<Course> findTeacherCourseById(Integer t_id) {
		// TODO Auto-generated method stub
		CourtyardMapper courtyardMapper = this.getSqlSession().getMapper(CourtyardMapper.class);
		List<Course> courses = courtyardMapper.findTeacherCourseById(t_id);
		System.out.println("--Into Dao findTeacherCourseById!!!--");
		return courses;
	}

}
