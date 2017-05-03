package com.ldp.itcast.dao.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.ldp.itcast.dao.StudentCourseDao;
import com.ldp.itcast.domain.Course;
import com.ldp.itcast.domain.Student;
import com.ldp.itcast.mapper.StudentMapper;

@Repository
public class StudentCourseDaoImpl extends SqlSessionDaoSupport implements StudentCourseDao {

	
	/**
	 * mybatis3.0.0+mybatis-spring1.0.0无需自己注入，底层给你注入
	 * mybatis3.2.2+mybatis-spring1.2.0去除了这个，需要自己注入sqlsessionFactory
	 * 
	 */
	
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	
	public List<Course> findLonginCourse(Integer c_id) {
		// TODO Auto-generated method stub
		StudentMapper studentMapper = this.getSqlSession().getMapper(StudentMapper.class);
		List<Course> strs = studentMapper.findLonginCourse(c_id);
		System.out.println("--Into Dao Method of findLonginCourse--");
		return strs;
	}


	public boolean updatePersonStudent(Student student) {
		// TODO Auto-generated method stub
		StudentMapper studentMapper = this.getSqlSession().getMapper(StudentMapper.class);
		studentMapper.updatePersonStudent(student);
		System.out.println("--Into Dao Method of updatePersonStudent--");
		return true;
	}

}
