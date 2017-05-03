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
	 * ����Ժ����Ϣ��ת��ʦ�Ϳγ����ӵ�ҳ��
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
		System.out.println("�ɹ���תTeacherAndCourseҳ��!");
		return "/collection/CollectionTeacheAndCourse.jsp";	
	}
	
	/**
	 * 
	 * Ajax����õ��γ���Ϣ
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
	 * Ajax����õ��Ƿ���ڹ�ϵ
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/conllection/ErrorCollection.action", method=RequestMethod.POST,produces="text/plain;charset=UTF-8")
	public boolean findErrorCollection(Integer t_id,Integer c_id){
		System.out.println("�������:"+t_id+"--"+c_id);
		Map map = new HashMap();
		map.put("t_id", t_id);
		map.put("c_id", c_id);
		int result = this.courseService.CollectionTeacherCourseResult(map);
		System.out.println("�����:"+result);
		if(result==1){
			return true;
		}
		return false;
	}
	
	
	
	/**
	 * 
	 * ҳ��õ���������ϵ
	 * @param t_id
	 * @param c_id
	 * @return
	 */
	@RequestMapping("/collection/conllection.action")
	public String TeacherCourse(Integer t_id,Integer c_id){
		System.out.println("ҳ��õ���ʦID���γ�ID��"+t_id+"--"+c_id);
		Map map = new HashMap();
		map.put("t_id", t_id);
		map.put("c_id", c_id);
		this.courseService.CollectionTeacheCourse(map);
		System.out.println("�ɹ�������ϵ!");
		return "redirect:/conllection/toTeacheAndCourse.action";
	}
	
	
	
	/**
	 * 
	 * ��ѯ��Ժ����Ϣ�������ض���CollectionGradeAndCourse.jsp
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
		System.out.println("�ɹ���תGradeAndCourseҳ��!");
		return "/collection/CollectionGradeAndCourse.jsp";
	}
	
	
	/**
	 * 
	 * Ajax����õ��༶��Ϣ
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
	 * Ajax����õ��Ƿ���ڹ�ϵ
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/conllection/ErrorCollection1.action", method=RequestMethod.POST,produces="text/plain;charset=UTF-8")
	public boolean findErrorCollection(String t_id,Integer c_id){
		System.out.println("�������:"+t_id+"--"+c_id);
		Map map = new HashMap();
		map.put("grade", t_id);
		map.put("c_id", c_id);
		int result = this.studentService.findStudentGradeResult(map);
		System.out.println("�����:"+result);
		if(result==1){
			return true;
		}
		return false;
	}
	
	@RequestMapping("/collection/StudentAndCourse.action")
	public String StudentAndCourse(String t_id,Integer c_id){
		System.out.println("�������:"+t_id+"--"+c_id);
		Map map = new HashMap();
		map.put("grade", t_id);
		map.put("c_id", c_id);
		this.studentService.CollectionStudentAndCourse(map);
		System.out.println("�ɹ�����ѧ���Ϳγ̵Ĺ�ϵ");
		return "redirect:/collection/toGradeCourse.action";
	}
	
}
