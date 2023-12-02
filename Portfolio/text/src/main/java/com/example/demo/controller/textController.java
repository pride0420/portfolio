package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.mapper.textMapper;
import com.example.demo.vo.text;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class textController {

	@Autowired()
	public textMapper textmapper;
	
	@Autowired()
	public HttpSession session;
	
	
	@GetMapping("addtext")
	public String addpporder(String porder,Integer munch,HttpServletRequest request) {
	
		String[] p=request.getParameterValues("porder");
		String Porder=Arrays.toString(p);
		Porder=Porder.substring(1,Porder.length()-1);
		String[] m=request.getParameterValues("munch");
		String Munch=Arrays.toString(m);
		Munch=Munch.substring(1,Munch.length()-1);
		
		text t=new text(Porder,Munch);
		textmapper.add(t);
		return "textindex.html";
	}
	
	@GetMapping("queryAlltext")
	public String queryAll() {
		List<text> t=textmapper.queryAll();
		session.setAttribute("T", t);
		
		int k=0;
		//找到要轉的id
		text te=textmapper.queryId(4);
		StringBuilder T=new StringBuilder(te.getPorder());
		String text;
		//找到第一個 ,
		int i=T.indexOf(",");
		//算出需要的陣列長度
		for(int j=0;j<T.length();j++) {
			char c=T.charAt(j);
			if(c==',') {
				k++;
			}
		}
		//將Builder內的,去掉 並轉化成陣列
		int s=0;
		String[] tex=new String[k+1];
		for(int j=0;j<T.length();j++) {
			i=T.indexOf(",");
			
			if(i!=-1) {
				text=T.substring(0 ,i);
				tex[j]=text;
				T.delete(0, i+2);
			}
			}
		//存最後一個
		T=new StringBuilder(te.getPorder());
		s=T.lastIndexOf(",");
		text=T.substring(s+2);
		tex[k]=text;
		
		//將陣列代號轉為文字
		for(int p=0;p<tex.length;p++) {
			switch(tex[p]) {
				case "1":
					tex[p]="蘋果";
				break;
				case "2":
					tex[p]="香蕉";
				break;
				case "3":
					tex[p]="草莓";
				break;
				case "4":
					tex[p]="鳳梨";
				break;
			}
		}
		String table=textmapper.addtable();
		System.out.println(table);
		
		//session.setAttribute("TEXT", text);
		session.setAttribute("Last", tex);
		
		
		return "text";
	}
	
	@GetMapping("")
	public String addtable() {
		
		
		return "text";
	}
}
