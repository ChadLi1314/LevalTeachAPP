package com.ldp.itcast.dao.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.ldp.itcast.dao.CourseDao;
import com.ldp.itcast.domain.Course;
import com.ldp.itcast.mapper.StudentMapper;

@Repository
public class CourseDaoImpl extends SqlSessionDaoSupport implements CourseDao {
	
	/**
	 * mybatis3.0.0+mybatis-spring1.0.0无需自己注入，底层给你注入
	 * mybatis3.2.2+mybatis-spring1.2.0去除了这个，需要自己注入sqlsessionFactory
	 * 
	 */
	
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public void saveCourse(Course course) {
		// TODO Auto-generated method stub
		StudentMapper studentMapper = this.getSqlSession().getMapper(StudentMapper.class);
		studentMapper.saveCourse(course);
		System.out.println("--Into Dao Method of saveCourse--");
	}

	public int findCourseName(String cname) {
		// TODO Auto-generated method stub
		StudentMapper studentMapper = this.getSqlSession().getMapper(StudentMapper.class);
		int result = studentMapper.findCourseName(cname);
		System.out.println("--Into Dao Method of findCourseName--");
		return result;
	}

	public List<Course> findCourseAll() {
		// TODO Auto-generated method stub
		StudentMapper studentMapper = this.getSqlSession().getMapper(StudentMapper.class);
		List<Course> courses = studentMapper.findCourseAll();
		System.out.println("--Into Dao Method of findCourseName--");
		return courses;
	}

	public void CollectionTeacheCourse(Map map) {
		// TODO Auto-generated method stub
		StudentMapper studentMapper = this.getSqlSession().getMapper(StudentMapper.class);
		studentMapper.CollectionTeacheCourse(map);
		System.out.println("--Into Dao Method of CollectionTeacheCourse--");
	}

	public int CollectionTeacherCourseResult(Map map) {
		// TODO Auto-generated method stub
		StudentMapper studentMapper = this.getSqlSession().getMapper(StudentMapper.class);
		int result = studentMapper.CollectionTeacherCourseResult(map);
		System.out.println("--Into Dao Method of CollectionTeacherCourseResult--");
		return result;
	}

}
