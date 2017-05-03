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
	 * 显示教师的所课程信息
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/teacher/toTeacherShowCourse.action")
	@ResponseBody
	public List<Course> toTeacherShowCourse(Model model,Integer username,String password,HttpSession session){
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		System.out.println("获取用户信息:"+username);
		List<Course> courses = this.teacherService.findTeacherCourseById(username);
		for(Course course:courses){
			System.out.println(course.toString());
		}
		/*model.addAttribute("courses", courses);*/
		return courses;
	}
	
	/**
	 * 
	 * 根据教师登陆后展示的课程，显示相应课程的评价
	 * @param c_id
	 * @param model
	 * @return
	 */
	@RequestMapping("/teacher/toshowEvaluatejsp.action")
	@ResponseBody
	public List<Evaluate> toshowEvaluatejsp(Integer c_id,Model model){
		System.out.println("得到课程号:"+c_id);
		Map map = new HashMap();
		map.put("c_id", c_id);
		/*Course course = this.evaluateService.findCourseCondition(map);
		System.out.println("取出课程信息:"+course.toString());*/
		//得到课程相关的评价
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
