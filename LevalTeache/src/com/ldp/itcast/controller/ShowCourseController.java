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
import com.ldp.itcast.domain.Student;
import com.ldp.itcast.service.StudentCourseService;
import com.ldp.itcast.service.StudentService;
import com.ldp.itcast.util.BeanUtil;

@Controller
public class ShowCourseController {
	
	@Resource
	private StudentCourseService service;
	
	@Resource
	private StudentService studentService;

	/**
	 * 
	 * 显示当前登录学生所有的课程
	 * @param model
	 * @return
	 */
	@RequestMapping("/showcourse/toshowcourse.action")
	@ResponseBody
	public List<Course> toShowCourse(Model model,Integer username,String password,HttpSession session){
		Student student = (Student)session.getAttribute("student");
		System.out.println("获取用户信息:"+username);
		List<Course> strings = this.service.findLonginCourse(username);
		for(Course string:strings){
			System.out.println(string.toString());
		}
		/*model.addAttribute("courses", strings);*/
		return strings;
	}
	
	/**
	 * 
	 * 更新学生个人信息
	 * @param student
	 * @return
	 */
	@RequestMapping("/showcourse/updateStudentLogin.action")
	@ResponseBody
	public Object updateStudentLogin(Student student){
		System.out.println("android:"+student.toString());
		boolean result =  this.service.updatePersonStudent(student);
		System.out.println("更新成功:"+result);
		BeanUtil beanUtil = new BeanUtil();
		beanUtil.setLoginState(1);
		return beanUtil;
	}
	
	/**
	 * 
	 * 得到学生登录的session，得到个人信息后跳转信息页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/showcourse/toupdateStudent.action")
	@ResponseBody
	public Student toupdateStudent(Model model,Integer id){
		Map map = new HashMap();
		map.put("id", id);
		System.out.println("ID:"+id);
		List<Student> students = this.studentService.findStudent(map);
		Student student = students.get(0);
		System.out.println("list中拿到的:"+student.toString());
		/*model.addAttribute("student", student);*/
		return student;
	}
}
