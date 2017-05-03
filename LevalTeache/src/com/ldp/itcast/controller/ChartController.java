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
	 * �������۱�õ����յ�Analyzes����Ĵ������
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/teacher/toShowPieChartjsp.action")
	@ResponseBody
	public List<Analyzes> toShowPieChartjsp() throws IOException{
		//��շ������е����ݣ���ϸ���µ�����
		this.chartService.deleteOneTeacher(585652);
		//�õ��пγ̽�ʦ��ID
		List<Integer> integers = this.chartService.findAllTeacher();
		for(Integer integer:integers){
			System.out.println(integer);
		}
		//ת��Ϊ����
		/*Integer[] t_id = integers.toArray(new Integer[integers.size()]);*/
		//����ÿһ����ʦID�Ŀγ̳ɼ�
		for(Integer integer:integers){
			//�õ���ʦID���ܿγ�ID
			List<Integer> c_ids = this.chartService.findCourseC_id(integer);
			for(Integer integer2:c_ids){
				System.out.println(integer+"�Ŀγ̺�Ϊ:"+integer2);
			}
			//���γ���IDת��������
			Integer[] a = c_ids.toArray(new Integer[c_ids.size()]);
			//�õ�ÿһ�ſγ̵�ƽ���ɼ�
			List<Double> doubles = this.chartService.findDealCourse(a);
			int count=0;
			double sum=0.0;
			double lastSum=0.0;
			for(Double double1:doubles){
				System.out.print(integer+"�Ŀγ̳ɼ�Ϊ:"+double1);
				if(double1!=null){
					sum=sum+double1;
					count++;
				}
			}
			
			lastSum=sum/count;
			
			//���ݼ���ʵ�壬���������Ƿ��иý�ʦ��¼������ɾ��
			String iname = this.chartService.findT_idToIname(integer);
			Analyzes analyzes = new Analyzes();
			analyzes.setA_id(integer);
			analyzes.setIname(iname);
			analyzes.setResult(lastSum);
			
			//���������ݣ���ͬ��ʦID��Ժ������analyzes�����
			this.chartService.saveAnalyzes(analyzes);
		}
		
		//���������е�����ȫ��������ͼ����
		List<Analyzes> analyzes = this.chartService.findAllAnalyzesCondition(null);
		for(Analyzes analyzes2:analyzes){
			System.out.println("analyzes��"+analyzes2.toString());
		}
		/*ChartUtil util = new ChartUtil();
		util.PieChart(analyzes);*/
		return analyzes;
	}
	
	/**
	 * 
	 * �õ���ʦ��¼��session
	 * �������Ժϵ�е�����
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/teacher/toShowCourtyardPieChartjsp.action")
	@ResponseBody
	public List<Analyzes> toShowCourtyardPieChartjsp(Integer t_id,HttpSession session) throws IOException{
		//ͨ����¼���ʦ��ID�ŵõ�����Ժ��
		/*Teacher teacher = (Teacher)session.getAttribute("teacher");*/
		String iname = this.chartService.findT_idToIname(t_id);
		//ͨ��Ժ�����Ժ�е�����
		Map map = new HashMap();
		map.put("iname", iname);
		List<Analyzes> analyzes = this.chartService.findAllAnalyzesCondition(map);
		for(Analyzes analyzes2:analyzes){
			System.out.println("���Ժ������:"+analyzes2.toString());
		}
		//�������ȷ�����
		/*ChartUtil util = new ChartUtil();
		util.PieChart(analyzes);*/
		return analyzes;
	}
}
