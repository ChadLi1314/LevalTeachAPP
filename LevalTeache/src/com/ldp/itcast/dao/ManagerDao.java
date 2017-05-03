package com.ldp.itcast.dao;

import java.util.List;
import java.util.Map;

import com.ldp.itcast.domain.Manager;
import com.ldp.itcast.domain.Question;

public interface ManagerDao {
	public Manager findManagerById(Manager manager);
	public List<String> findQuestions();
	public List<Question> findAllQuestions(Map map);
	public void addQuestion(String content);
	public void deleteQuestion(int id);
	public void updateQuestion(Question question);
}
