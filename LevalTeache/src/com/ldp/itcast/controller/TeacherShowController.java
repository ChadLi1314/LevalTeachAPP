package com.ldp.itcast.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldp.itcast.domain.Course;
import com.ldp.itcast.domain.Evaluate;
import com.ldp.itcast.domain.Teacher;
import com.ldp.itcast.service.EvaluateService;
import com.ldp.itcast.service.TeacherService;


@Controller
public class TeacherShowController {
	
	@Resource
	private TeacherService teacherService;
	
	@Resource
	private EvaluateService evaluateService;
	/**
	 * 
	 * ��ʾ��ʦ�����γ���Ϣ
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/teacher/toTeacherShowCourse.action")
	@ResponseBody
	public List<Course> toTeacherShowCourse(Model model,Integer username,String password,HttpSession session){
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		System.out.println("��ȡ�û���Ϣ:"+username);
		List<Course> courses = this.teacherService.findTeacherCourseById(username);
		for(Course course:courses){
			System.out.println(course.toString());
		}
		/*model.addAttribute("courses", courses);*/
		return courses;
	}
	
	/**
	 * 
	 * ���ݽ�ʦ��½��չʾ�Ŀγ̣���ʾ��Ӧ�γ̵�����
	 * @param c_id
	 * @param model
	 * @return
	 */
	@RequestMapping("/teacher/toshowEvaluatejsp.action")
	@ResponseBody
	public List<Evaluate> toshowEvaluatejsp(Integer c_id,Model model){
		System.out.println("�õ��γ̺�:"+c_id);
		Map map = new HashMap();
		map.put("c_id", c_id);
		/*Course course = this.evaluateService.findCourseCondition(map);
		System.out.println("ȡ���γ���Ϣ:"+course.toString());*/
		//�õ��γ���ص�����
		List<Evaluate> evaluates = this.evaluateService.findEvaluateCondition(map);
		for(Evaluate evaluate:evaluates){
			System.out.println(evaluate.toString());
		}
		/*if(evaluates.size()==0){
			model.addAttribute("evaluate", "");
		}else{
			model.addAttribute("evaluate", evaluates);
		}*/
		return evaluates;
	}
	
	
}
