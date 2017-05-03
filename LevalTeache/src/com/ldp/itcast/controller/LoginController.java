package com.ldp.itcast.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldp.itcast.domain.Manager;
import com.ldp.itcast.domain.Student;
import com.ldp.itcast.domain.Teacher;
import com.ldp.itcast.service.ManagerService;
import com.ldp.itcast.service.StudentService;
import com.ldp.itcast.service.TeacherService;
import com.ldp.itcast.util.BeanUtil;

@Controller
public class LoginController {
	
	@Resource
	private ManagerService managerService;

	@Resource
	private TeacherService teacherService;
	
	@Resource
	private StudentService studentService;
	
	
	/**
	 * 
	 * ѧ����¼
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/login/studentlogin.action")
	@ResponseBody
	public Object studentlogin(Model model,Integer username,String password,HttpSession session) throws ServletException, IOException{
		System.out.println("���յ�����:"+username+"---"+password);
		Map map = new HashMap();
		map.put("id", username);
		map.put("password", password);
		BeanUtil beanUtil = new BeanUtil();
		List<Student> students = this.studentService.findStudent(map);
		if(students.size()==1){
			System.out.println("������ȷ"+students.get(0).toString());
			session.setAttribute("student", students.get(0));
			beanUtil.setLoginState(1);
			return beanUtil;
		}else{
			System.out.println("�������");
			beanUtil.setLoginState(0);
			return beanUtil;
		}
	}
	
	/**
	 * 
	 * ��ʦ��¼
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping("/login/teacherlogin.action")
	@ResponseBody
	public Object teacherlogin(Model model,Integer username,String password,HttpSession session){
		System.out.println("���յ�����:"+username+"---"+password);
		Map map = new HashMap();
		map.put("t_id", username);
		map.put("password", password);
		Teacher teacher = this.teacherService.findTeacherById(map);
		BeanUtil beanUtil = new BeanUtil();
		if(teacher!=null){
			System.out.println("������ȷ");
			session.setAttribute("teacher", teacher);
			beanUtil.setLoginState(1);
			return beanUtil;
		}else{
			System.out.println("�������");
			beanUtil.setLoginState(0);
			return beanUtil;
		}
	}
	
	
	/**
	 * 
	 * ����Ա��¼
	 * @param manager
	 * @param m_id
	 * @param session
	 * @return
	 */
	@RequestMapping("/login/managerlogin.action")
	@ResponseBody
	public Object managerlogin(Model model,Integer username,String password,Manager manager,Integer m_id,HttpSession session){
		manager.setM_id(Integer.valueOf(password));
		manager.setPassword(password);
		System.out.println("���յ�����:"+manager.toString());
		Manager manager2 = this.managerService.findManagerById(manager);
		BeanUtil beanUtil = new BeanUtil();
		if(manager2!=null){
			System.out.println("������ȷ!");
			session.setAttribute("manager", manager2);
			beanUtil.setLoginState(1);
			return beanUtil;
		}else{
			System.out.println("�������!");
			beanUtil.setLoginState(0);
			return beanUtil;
		}
	}
	
	/**
	 * ע����¼
	 * @param session
	 * @return
	 */
	@RequestMapping("/outlogin/outlogin.action")
	public String outlogin(HttpSession session){
		session.removeAttribute("student");
		session.removeAttribute("teacher");
		session.removeAttribute("manager");
		return "redirect:/index.jsp";
	}
}
