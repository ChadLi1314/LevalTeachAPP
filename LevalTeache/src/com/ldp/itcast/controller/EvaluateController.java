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
import com.ldp.itcast.domain.Question;
import com.ldp.itcast.domain.Student;
import com.ldp.itcast.service.EvaluateService;
import com.ldp.itcast.service.ManagerService;
import com.ldp.itcast.service.StudentService;

@Controller
public class EvaluateController {
	
	@Resource
	private ManagerService managerService;
	
	@Resource
	private EvaluateService evaluateService;
	
	@Resource
	private StudentService studentService;

	//��ȡ����ѡ�ת������ҳ��
	@RequestMapping("/evaluate/toEvaluateJsp.action")
	@ResponseBody
	public List<String> toEvaluateJsp(Model model,Integer c_id){
		System.out.println("android-c_id:"+c_id);
		List<String> strings = this.managerService.findQuestions();
		for(int i=0;i<strings.size();i++){
			StringBuffer sb = new StringBuffer(strings.get(i));
			sb.insert(0, (i+1)+".");
			strings.set(i, sb.toString());
			//Ч�ʱ�str��subString����Ч�ʸߵö�
		}
		return strings;
	}
	
	
	
	
	//��ȡѧ��������
	@RequestMapping("/evaluate/saveEvaluate.action")
	@ResponseBody
	public String saveEvaluate(Integer result,Integer username,String content,Integer c_id,HttpSession session){
		System.out.println(result+"  "+c_id+"  "+content+"  "+username);
		/*Student student = (Student)session.getAttribute("student");*/
		Map map = new HashMap();
		map.put("id", username);
		List<Student> listStudents = studentService.findStudent(map);
		Student student = listStudents.get(0);
		System.out.println("sessionֵ:"+student.toString());
		Map map1 = new HashMap();
		map1.put("c_id", c_id);
		Course course = this.evaluateService.findCourseCondition(map1);
		System.out.println("����c_id��ÿγ�:"+course.toString());
		//������ȫ���ŵ�Evaluate������
		Evaluate evaluate = new Evaluate();
		evaluate.setC_id(c_id);
		evaluate.setCname(course.getCname());
		evaluate.setContent(content);
		evaluate.setGrade(student.getGrade());
		evaluate.setResult(result);
		evaluate.setS_id(student.getS_id());
		//���۲������ݿ�
		this.evaluateService.saveEvaluate(evaluate);
		return "�ύ�ɹ�";
	}
	
	//��ȡ�����ѡ�����ѡ�����ҳ��
	@RequestMapping("/evaluate/toManageEvaluateJsp.action")
	public String toManageEvaluateJsp(Model model){
		List<Question> questions = this.managerService.findAllQuestions(null);
		for(Question question:questions){
			System.out.println(question.toString());
		}
		model.addAttribute("questions", questions);
		return "/all/Question.jsp";
	}
	
	//ת���������ѡ��ҳ��
	@RequestMapping("/evaluate/toAddQuestionJsp.action")
	public String toAddQuestionJsp(){
		return "/all/AddQuestion.jsp";
	}
	
	//�����������ѡ�����Ϣ�����ݿ⣬��ת��ѡ�����ҳ��
	@RequestMapping("/evaluate/AddQuestion.action")
	public String AddQuestion(String content){
		System.out.println(content);
		this.managerService.addQuestion(content);
		return "redirect:/evaluate/toManageEvaluateJsp.action";
	}
	
	//����ID��ɾ����չ����
	@RequestMapping("/evaluate/deleteQuestion.action")
	public String deleteQuestion(int id){
		System.out.println(id);
		this.managerService.deleteQuestion(id);
		return "redirect:/evaluate/toManageEvaluateJsp.action";
	}
	
	//�õ��༭ID�ţ���ת���༭ҳ��
	@RequestMapping("/evaluate/toUpdateQuestionJsp.action")
	public String toUpdateQuestionJsp(Model model,int id){
		System.out.println(id);
		Map map = new HashMap();
		map.put("id", id);
		List<Question> questions = this.managerService.findAllQuestions(map);
		System.out.println(questions.get(0).toString());
		model.addAttribute("questions", questions.get(0));
		return "/all/UpdateQuestion.jsp";
	}
	
	//�õ���Ҫ���µ���Ϣ���������ݣ���ת��ѡ��������
	@RequestMapping("/evaluate/UpdateSaveQuestion.action")
	public String UpdateSaveQuestion(Question question){
		System.out.println(question.toString());
		this.managerService.updateQuestion(question);
		return "redirect:/evaluate/toManageEvaluateJsp.action";
	}
	
}
