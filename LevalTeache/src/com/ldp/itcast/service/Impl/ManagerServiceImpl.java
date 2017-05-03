package com.ldp.itcast.service.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldp.itcast.dao.ManagerDao;
import com.ldp.itcast.domain.Manager;
import com.ldp.itcast.domain.Question;
import com.ldp.itcast.service.ManagerService;


@Service
public class ManagerServiceImpl implements ManagerService{

	@Resource
	private ManagerDao dao;
	
	public Manager findManagerById(Manager manager) {
		// TODO Auto-generated method stub
		return this.dao.findManagerById(manager);
	}

	public List<String> findQuestions() {
		// TODO Auto-generated method stub
		return this.dao.findQuestions();
	}

	public List<Question> findAllQuestions(Map map) {
		// TODO Auto-generated method stub
		return this.dao.findAllQuestions(map);
	}

	public void addQuestion(String content) {
		// TODO Auto-generated method stub
		this.dao.addQuestion(content);
	}

	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		this.dao.deleteQuestion(id);
	}

	public void updateQuestion(Question question) {
		// TODO Auto-generated method stub
		this.dao.updateQuestion(question);
	}

}
