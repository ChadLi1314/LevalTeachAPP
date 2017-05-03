package com.ldp.itcast.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ldp.itcast.domain.Analyzes;
import com.ldp.itcast.service.ChartService;
import com.ldp.itcast.util.ExcelDesk;

@Controller
public class EmaiController {
	
	@Resource
	private ChartService chartService;

	/**
	 * 
	 * 将分析表中的数据生成Excel表格
	 * @return
	 */
	@RequestMapping("/sendemail/toemail.action")
	public String toemailjsp(){
		List<Analyzes> analyzes = this.chartService.findAllAnalyzesCondition(null);
		ExcelDesk desk = new ExcelDesk();
		desk.createExcelWithOldVersion(analyzes);
		return "/sendemail/SendEmail.jsp";
	}
	
}
