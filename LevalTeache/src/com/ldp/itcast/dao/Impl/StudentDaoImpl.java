package com.ldp.itcast.dao.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.ldp.itcast.dao.StudentDao;
import com.ldp.itcast.domain.Grade;
import com.ldp.itcast.domain.Student;
import com.ldp.itcast.mapper.StudentMapper;

@Repository
public class StudentDaoImpl extends SqlSessionDaoSupport implements StudentDao {

	
	/**
	 * mybatis3.0.0+mybatis-spring1.0.0无需自己注入，底层给你注入
	 * mybatis3.2.2+mybatis-spring1.2.0去除了这个，需要自己注入sqlsessionFactory
	 * 
	 */
	
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	
	public List<Student> findStudent(Map map) {
		// TODO Auto-generated method stub
		StudentMapper studentMapper = this.getSqlSession().getMapper(StudentMapper.class);
		List<Student> students = studentMapper.findAllStudent(map);
		System.out.println("--Into Dao Method!!!--");
		return students;
	}


	public boolean saveStudentAll(Student student) {
		// TODO Auto-generated method stub
		StudentMapper studentMapper = this.getSqlSession().getMapper(StudentMapper.class);
		studentMapper.saveStudent(student);
		System.out.println("--Into Dao saveStudentAll!!!--");
		return true;
	}


	public int findStudentCount(Integer c_id) {
		// TODO Auto-generated method stub
		StudentMapper studentMapper = this.getSqlSession().getMapper(StudentMapper.class);
		int count = studentMapper.findStudentCount(c_id);
		System.out.println("--Into Dao findStudentCount--");
		return count;
	}


	public List<Grade> findStudentGrade() {
		// TODO Auto-generated method stub
		StudentMapper studentMapper = this.getSqlSession().getMapper(StudentMapper.class);
		List<Grade> grades = studentMapper.findStudentGrade();
		System.out.println("--Into Dao findStudentGrade--");
		return grades;
	}


	public List<Grade> findGradeI_id(Integer i_id) {
		// TODO Auto-generated method stub
		StudentMapper studentMapper = this.getSqlSession().getMapper(StudentMapper.class);
		List<Grade> grades = studentMapper.findGradeI_id(i_id);
		System.out.println("--Into Dao findGradeI_id--");
		return grades;
	}


	public int findStudentGradeResult(Map map) {
		// TODO Auto-generated method stub
		StudentMapper studentMapper = this.getSqlSession().getMapper(StudentMapper.class);
		int result = studentMapper.findStudentGradeResult(map);
		System.out.println("--Into Dao findStudentGradeResult--");
		return result;
	}


	public void CollectionStudentAndCourse(Map map) {
		// TODO Auto-generated method stub
		StudentMapper studentMapper = this.getSqlSession().getMapper(StudentMapper.class);
		studentMapper.CollectionStudentAndCourse(map);
		System.out.println("--Into Dao findStudentGradeResult--");
	}

}
