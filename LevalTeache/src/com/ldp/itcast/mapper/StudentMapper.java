package com.ldp.itcast.mapper;

import java.util.List;
import java.util.Map;

import com.ldp.itcast.domain.Course;
import com.ldp.itcast.domain.Grade;
import com.ldp.itcast.domain.Student;

public interface StudentMapper {
	public List<Student> findAllStudent(Map map);
	public boolean saveStudent(Student student);
	public void saveCourse(Course course);
	public int findCourseName(String cname);
	public int findStudentCount(Integer c_id);
	public List<Course> findCourseAll();
	public void CollectionTeacheCourse(Map map);
	public int CollectionTeacherCourseResult(Map map);
	public List<Grade> findStudentGrade();
	public List<Grade> findGradeI_id(Integer i_id);
	public int findStudentGradeResult(Map map);
	public void CollectionStudentAndCourse(Map map);
	public List<Course> findLonginCourse(Integer c_id);
	public boolean updatePersonStudent(Student student);
	public Course findCourseCondition(Map map);
}
