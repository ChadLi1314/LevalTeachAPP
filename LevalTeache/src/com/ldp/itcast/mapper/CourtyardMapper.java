package com.ldp.itcast.mapper;

import java.util.List;
import java.util.Map;

import com.ldp.itcast.domain.Course;
import com.ldp.itcast.domain.Courtyard;
import com.ldp.itcast.domain.Teacher;

public interface CourtyardMapper {
	public boolean insert(Courtyard courtyard);
	public boolean saveTeacher(Map map);
	public List<Courtyard> findCourtyardAll();
	public Teacher findTeacherId(Integer t_id);
	public List<Teacher> findTeacherList(Integer i_id);
	public boolean updateTeacherT_id(Teacher teacher);
	public Teacher findTeacherById(Map map);
	public List<Course> findTeacherCourseById(Integer t_id);
}
