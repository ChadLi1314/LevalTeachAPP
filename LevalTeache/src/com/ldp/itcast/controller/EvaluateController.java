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

	//获取问题选项，转到评价页面
	@RequestMapping("/evaluate/toEvaluateJsp.action")
	@ResponseBody
	public List<String> toEvaluateJsp(Model model,Integer c_id){
		System.out.println("android-c_id:"+c_id);
		List<String> strings = this.managerService.findQuestions();
		for(int i=0;i<strings.size();i++){
			StringBuffer sb = new StringBuffer(strings.get(i));
			sb.insert(0, (i+1)+".");
			strings.set(i, sb.toString());
			//效率比str的subString方法效率高得多
		}
		return strings;
	}
	
	
	
	
	//获取学生的评价
	@RequestMapping("/evaluate/saveEvaluate.action")
	@ResponseBody
	public String saveEvaluate(Integer result,Integer username,String content,Integer c_id,HttpSession session){
		System.out.println(result+"  "+c_id+"  "+content+"  "+username);
		/*Student student = (Student)session.getAttribute("student");*/
		Map map = new HashMap();
		map.put("id", username);
		List<Student> listStudents = studentService.findStudent(map);
		Student student = listStudents.get(0);
		System.out.println("session值:"+student.toString());
		Map map1 = new HashMap();
		map1.put("c_id", c_id);
		Course course = this.evaluateService.findCourseCondition(map1);
		System.out.println("根据c_id获得课程:"+course.toString());
		//将数据全部放到Evaluate对象中
		Evaluate evaluate = new Evaluate();
		evaluate.setC_id(c_id);
		evaluate.setCname(course.getCname());
		evaluate.setContent(content);
		evaluate.setGrade(student.getGrade());
		evaluate.setResult(result);
		evaluate.setS_id(student.getS_id());
		//评论插入数据库
		this.evaluateService.saveEvaluate(evaluate);
		return "提交成功";
	}
	
	//获取问题的选项，进入选项管理页面
	@RequestMapping("/evaluate/toManageEvaluateJsp.action")
	public String toManageEvaluateJsp(Model model){
		List<Question> questions = this.managerService.findAllQuestions(null);
		for(Question question:questions){
			System.out.println(question.toString());
		}
		model.addAttribute("questions", questions);
		return "/all/Question.jsp";
	}
	
	//转向添加问题选项页面
	@RequestMapping("/evaluate/toAddQuestionJsp.action")
	public String toAddQuestionJsp(){
		return "/all/AddQuestion.jsp";
	}
	
	//保存添加问题选项的信息到数据库，并转向到选项管理页面
	@RequestMapping("/evaluate/AddQuestion.action")
	public String AddQuestion(String content){
		System.out.println(content);
		this.managerService.addQuestion(content);
		return "redirect:/evaluate/toManageEvaluateJsp.action";
	}
	
	//根据ID号删除扩展问题
	@RequestMapping("/evaluate/deleteQuestion.action")
	public String deleteQuestion(int id){
		System.out.println(id);
		this.managerService.deleteQuestion(id);
		return "redirect:/evaluate/toManageEvaluateJsp.action";
	}
	
	//得到编辑ID号，并转到编辑页面
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
	
	//得到需要更新的信息，保存数据，并转向选项管理界面
	@RequestMapping("/evaluate/UpdateSaveQuestion.action")
	public String UpdateSaveQuestion(Question question){
		System.out.println(question.toString());
		this.managerService.updateQuestion(question);
		return "redirect:/evaluate/toManageEvaluateJsp.action";
	}
	
}
