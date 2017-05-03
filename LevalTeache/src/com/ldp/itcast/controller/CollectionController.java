package com.ldp.itcast.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldp.itcast.domain.Course;
import com.ldp.itcast.domain.Courtyard;
import com.ldp.itcast.domain.Grade;
import com.ldp.itcast.service.CourseService;
import com.ldp.itcast.service.CourtyardService;
import com.ldp.itcast.service.StudentService;

@Controller
public class CollectionController {

	@Resource
	private CourtyardService service;
	
	@Resource
	private CourseService courseService;
	
	@Resource
	private StudentService studentService;
	
	/**
	 * 
	 * 调用院级信息跳转教师和课程链接的页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/conllection/toTeacheAndCourse.action")
	public String toTeacheAndCourse(Model model){
		List<Courtyard> courtyards = this.service.findCourtyardAll();
		for(Courtyard courtyard:courtyards){
			System.out.println(courtyard.toString());
		}
		model.addAttribute("courtyard", courtyards);
		System.out.println("成功跳转TeacherAndCourse页面!");
		return "/collection/CollectionTeacheAndCourse.jsp";	
	}
	
	/**
	 * 
	 * Ajax请求得到课程信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/conllection/t_id.action", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public List<Course> findT_id(Integer t_id){
		System.out.println(t_id);
		List<Course> courses = this.courseService.findCourseAll();
		for(Course course:courses){
			System.out.println(course.toString());
		}
		return courses;
	}
	
	/**
	 * 
	 * Ajax请求得到是否存在关系
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/conllection/ErrorCollection.action", method=RequestMethod.POST,produces="text/plain;charset=UTF-8")
	public boolean findErrorCollection(Integer t_id,Integer c_id){
		System.out.println("检测数据:"+t_id+"--"+c_id);
		Map map = new HashMap();
		map.put("t_id", t_id);
		map.put("c_id", c_id);
		int result = this.courseService.CollectionTeacherCourseResult(map);
		System.out.println("结果数:"+result);
		if(result==1){
			return true;
		}
		return false;
	}
	
	
	
	/**
	 * 
	 * 页面得到并建立关系
	 * @param t_id
	 * @param c_id
	 * @return
	 */
	@RequestMapping("/collection/conllection.action")
	public String TeacherCourse(Integer t_id,Integer c_id){
		System.out.println("页面得到教师ID及课程ID："+t_id+"--"+c_id);
		Map map = new HashMap();
		map.put("t_id", t_id);
		map.put("c_id", c_id);
		this.courseService.CollectionTeacheCourse(map);
		System.out.println("成功建立关系!");
		return "redirect:/conllection/toTeacheAndCourse.action";
	}
	
	
	
	/**
	 * 
	 * 查询出院级信息，并且重定向到CollectionGradeAndCourse.jsp
	 * @param model
	 * @return
	 */
	@RequestMapping("/collection/toGradeCourse.action")
	public String toGradeCourse(Model model){
		/*List<Grade> grades = this.studentService.findStudentGrade();
		for(Grade grade:grades){
			System.out.println(grade.toString());
		}*/
		List<Courtyard> courtyards = this.service.findCourtyardAll();
		for(Courtyard courtyard:courtyards){
			System.out.println(courtyard.toString());
		}
		model.addAttribute("courtyard", courtyards);
		System.out.println("成功跳转GradeAndCourse页面!");
		return "/collection/CollectionGradeAndCourse.jsp";
	}
	
	
	/**
	 * 
	 * Ajax请求得到班级信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/conllection/findGrade.action", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public List<Grade> findGrade(Integer i_id){
		System.out.println(i_id);
		/*List<Grade> grades = this.studentService.findStudentGrade();*/
		List<Grade> grades = this.studentService.findGradeI_id(i_id);
		for(Grade grade:grades){
			System.out.println(grade.toString());
		}
		return grades;
	}
	
	
	/**
	 * 
	 * Ajax请求得到是否存在关系
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/conllection/ErrorCollection1.action", method=RequestMethod.POST,produces="text/plain;charset=UTF-8")
	public boolean findErrorCollection(String t_id,Integer c_id){
		System.out.println("检测数据:"+t_id+"--"+c_id);
		Map map = new HashMap();
		map.put("grade", t_id);
		map.put("c_id", c_id);
		int result = this.studentService.findStudentGradeResult(map);
		System.out.println("结果数:"+result);
		if(result==1){
			return true;
		}
		return false;
	}
	
	@RequestMapping("/collection/StudentAndCourse.action")
	public String StudentAndCourse(String t_id,Integer c_id){
		System.out.println("检测数据:"+t_id+"--"+c_id);
		Map map = new HashMap();
		map.put("grade", t_id);
		map.put("c_id", c_id);
		this.studentService.CollectionStudentAndCourse(map);
		System.out.println("成功建立学生和课程的关系");
		return "redirect:/collection/toGradeCourse.action";
	}
	
}
