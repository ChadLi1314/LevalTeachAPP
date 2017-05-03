package com.ldp.itcast.dao;

import java.util.List;
import java.util.Map;

import com.ldp.itcast.domain.Courtyard;
import com.ldp.itcast.domain.Teacher;

public interface CourtyardDao {
	public boolean insertCourtyard(Courtyard courtyard);
	public boolean saveTeacher(Map map);
	public List<Courtyard> findCourtyardAll();
	public Teacher findTeacherId(Integer t_id);
	public List<Teacher> findTeacherList(Integer i_id);
	public boolean updateTeacherT_id(Teacher teacher);
}
