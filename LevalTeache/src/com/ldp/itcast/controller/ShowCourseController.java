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
	 * ��ʾ��ǰ��¼ѧ�����еĿγ�
	 * @param model
	 * @return
	 */
	@RequestMapping("/showcourse/toshowcourse.action")
	@ResponseBody
	public List<Course> toShowCourse(Model model,Integer username,String password,HttpSession session){
		Student student = (Student)session.getAttribute("student");
		System.out.println("��ȡ�û���Ϣ:"+username);
		List<Course> strings = this.service.findLonginCourse(username);
		for(Course string:strings){
			System.out.println(string.toString());
		}
		/*model.addAttribute("courses", strings);*/
		return strings;
	}
	
	/**
	 * 
	 * ����ѧ��������Ϣ
	 * @param student
	 * @return
	 */
	@RequestMapping("/showcourse/updateStudentLogin.action")
	@ResponseBody
	public Object updateStudentLogin(Student student){
		System.out.println("android:"+student.toString());
		boolean result =  this.service.updatePersonStudent(student);
		System.out.println("���³ɹ�:"+result);
		BeanUtil beanUtil = new BeanUtil();
		beanUtil.setLoginState(1);
		return beanUtil;
	}
	
	/**
	 * 
	 * �õ�ѧ����¼��session���õ�������Ϣ����ת��Ϣҳ��
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
		System.out.println("list���õ���:"+student.toString());
		/*model.addAttribute("student", student);*/
		return student;
	}
}
