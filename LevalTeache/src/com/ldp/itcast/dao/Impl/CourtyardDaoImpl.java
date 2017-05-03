package com.ldp.itcast.dao.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.ldp.itcast.dao.CourtyardDao;
import com.ldp.itcast.domain.Courtyard;
import com.ldp.itcast.domain.Teacher;
import com.ldp.itcast.mapper.CourtyardMapper;

@Repository
public class CourtyardDaoImpl extends SqlSessionDaoSupport implements CourtyardDao {

	
	/**
	 * mybatis3.0.0+mybatis-spring1.0.0无需自己注入，底层给你注入
	 * mybatis3.2.2+mybatis-spring1.2.0去除了这个，需要自己注入sqlsessionFactory
	 * 
	 */
	
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public boolean insertCourtyard(Courtyard courtyard) {
		// TODO Auto-generated method stub
		CourtyardMapper courtyardMapper = this.getSqlSession().getMapper(CourtyardMapper.class);
		courtyardMapper.insert(courtyard);
		System.out.println("--Into Dao Method of insertCourtyard!!!--");
		return true;
	}

	public boolean saveTeacher(Map map) {
		// TODO Auto-generated method stub
		CourtyardMapper courtyardMapper = this.getSqlSession().getMapper(CourtyardMapper.class);
		courtyardMapper.saveTeacher(map);
		System.out.println("--Into Dao Method of saveTeacher!!!--");
		return true;
	}

	public List<Courtyard> findCourtyardAll() {
		// TODO Auto-generated method stub
		CourtyardMapper courtyardMapper = this.getSqlSession().getMapper(CourtyardMapper.class);
		List<Courtyard> courtyards = courtyardMapper.findCourtyardAll();
		System.out.println("--Into Dao Method of findCourtyardAll!!!--");
		return courtyards;
	}

	public Teacher findTeacherId(Integer t_id) {
		// TODO Auto-generated method stub
		CourtyardMapper courtyardMapper = this.getSqlSession().getMapper(CourtyardMapper.class);
		Teacher teacher = courtyardMapper.findTeacherId(t_id);
		System.out.println("--Into Dao Method of findTeacherId!!!--");
		return teacher;
	}

	public List<Teacher> findTeacherList(Integer i_id) {
		// TODO Auto-generated method stub
		CourtyardMapper courtyardMapper = this.getSqlSession().getMapper(CourtyardMapper.class);
		List<Teacher> teachers = courtyardMapper.findTeacherList(i_id);
		System.out.println("--Into Dao Method of findTeacherList!!!--");
		return teachers;
	}

	public boolean updateTeacherT_id(Teacher teacher) {
		// TODO Auto-generated method stub
		CourtyardMapper courtyardMapper = this.getSqlSession().getMapper(CourtyardMapper.class);
		courtyardMapper.updateTeacherT_id(teacher);
		System.out.println("--Into Dao Method of updateTeacherT_id!!!--");
		return true;
	}

}
