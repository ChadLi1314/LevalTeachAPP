package com.ldp.itcast.util;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import com.ldp.itcast.domain.Analyzes;


public class ChartUtil {
	
	public void PieChart(List<Analyzes> analyzes) throws IOException{
		String newLine = System.getProperty("line.separator"); 
		StringBuffer sBuf = new StringBuffer();
		
		int count = analyzes.size();
		if(count>10){
			count=10;
		}
		sBuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append(newLine);
		sBuf.append("<pie>").append(newLine);
		for(int i=0;i<count;i++){
			Analyzes analyzes1 = analyzes.get(i);
			sBuf.append("	<slice title=\""+analyzes1.getIname()+":"+analyzes1.getA_id()+"\">").append(analyzes1.getResult()).append
			("</slice>").append(newLine);
		}
		sBuf.append("</pie>").append(newLine);
	
		System.out.println(sBuf.toString());
		
		// 到时候将生成的路径为目标路径即可
		String tomcates=System.getProperty("user.dir");//得到:F:\tomcateFile\MyEclipse\apache-tomcat-6.0.44\bin
		String tomcate1 = tomcates.substring(0, (tomcates.length()-3));//F:\tomcateFile\MyEclipse\apache-tomcat-6.0.44\
		File destFile = new File(tomcate1+"webapps/LevalTeache/file/ampie_data.xml");
		destFile.createNewFile();
		//输出生成xml文档
 		FileOutputStream out = new FileOutputStream(destFile);
		out.write(sBuf.toString().getBytes("UTF-8"));//这里getBytes("UTF-8")处理中文乱码的问题，遇到问题了
		out.flush();
 		out.close();
	}

}

