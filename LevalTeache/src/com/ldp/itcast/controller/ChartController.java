package com.ldp.itcast.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldp.itcast.domain.Analyzes;
import com.ldp.itcast.domain.Teacher;
import com.ldp.itcast.service.ChartService;
import com.ldp.itcast.util.ChartUtil;

@Controller
public class ChartController {

	@Resource
	private ChartService chartService;

	/**
	 * 
	 * 根据评价表得到最终的Analyzes结果的处理过程
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/teacher/toShowPieChartjsp.action")
	@ResponseBody
	public List<Analyzes> toShowPieChartjsp() throws IOException{
		//清空分析表中的数据，更细最新的数据
		this.chartService.deleteOneTeacher(585652);
		//得到有课程教师的ID
		List<Integer> integers = this.chartService.findAllTeacher();
		for(Integer integer:integers){
			System.out.println(integer);
		}
		//转化为数组
		/*Integer[] t_id = integers.toArray(new Integer[integers.size()]);*/
		//处理每一个教师ID的课程成绩
		for(Integer integer:integers){
			//得到教师ID的总课程ID
			List<Integer> c_ids = this.chartService.findCourseC_id(integer);
			for(Integer integer2:c_ids){
				System.out.println(integer+"的课程号为:"+integer2);
			}
			//将课程总ID转化成数组
			Integer[] a = c_ids.toArray(new Integer[c_ids.size()]);
			//得到每一门课程的平均成绩
			List<Double> doubles = this.chartService.findDealCourse(a);
			int count=0;
			double sum=0.0;
			double lastSum=0.0;
			for(Double double1:doubles){
				System.out.print(integer+"的课程成绩为:"+double1);
				if(double1!=null){
					sum=sum+double1;
					count++;
				}
			}
			
			lastSum=sum/count;
			
			//数据加入实体，并检查表中是否含有该教师记录，有则删除
			String iname = this.chartService.findT_idToIname(integer);
			Analyzes analyzes = new Analyzes();
			analyzes.setA_id(integer);
			analyzes.setIname(iname);
			analyzes.setResult(lastSum);
			
			//将最后的数据，连同教师ID和院级插入analyzes表格中
			this.chartService.saveAnalyzes(analyzes);
		}
		
		//将分析表中的数据全部解析到图标中
		List<Analyzes> analyzes = this.chartService.findAllAnalyzesCondition(null);
		for(Analyzes analyzes2:analyzes){
			System.out.println("analyzes："+analyzes2.toString());
		}
		/*ChartUtil util = new ChartUtil();
		util.PieChart(analyzes);*/
		return analyzes;
	}
	
	/**
	 * 
	 * 得到教师登录的session
	 * 获得所在院系中的排名
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/teacher/toShowCourtyardPieChartjsp.action")
	@ResponseBody
	public List<Analyzes> toShowCourtyardPieChartjsp(Integer t_id,HttpSession session) throws IOException{
		//通过登录后教师的ID号得到所属院名
		/*Teacher teacher = (Teacher)session.getAttribute("teacher");*/
		String iname = this.chartService.findT_idToIname(t_id);
		//通过院级获得院中的排名
		Map map = new HashMap();
		map.put("iname", iname);
		List<Analyzes> analyzes = this.chartService.findAllAnalyzesCondition(map);
		for(Analyzes analyzes2:analyzes){
			System.out.println("获得院级排名:"+analyzes2.toString());
		}
		//调用评比分析类
		/*ChartUtil util = new ChartUtil();
		util.PieChart(analyzes);*/
		return analyzes;
	}
}
