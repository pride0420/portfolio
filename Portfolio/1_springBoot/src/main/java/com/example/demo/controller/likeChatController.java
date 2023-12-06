package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.chatMapper;
import com.example.demo.dao.likeChatMapper;
import com.example.demo.service.Impl.chatServiceImpl;
import com.example.demo.vo.chat;
import com.example.demo.vo.likeChat;
import com.example.demo.vo.member;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class likeChatController {
	
	@Autowired
	public chatServiceImpl csi;

	@Autowired()
	public likeChatMapper likechatmapper;

	@Autowired()
	public HttpSession session;

	@Autowired()
	public chatMapper chatmapper;
	
	
	
	// 新增或刪除收藏
	@RequestMapping("addlike")
	public String addlike(int id, HttpServletRequest request) {
		//session.removeAttribute("All");
		member m = (member) session.getAttribute("M");
		
		// 接收傳回來的貼文id 比對以收藏內容 查看是否收藏過
		chat cn = chatmapper.queryId(id);
		List<likeChat> l = likechatmapper.queryUsername(m.getUsername());
		boolean x = false;
		for (likeChat o : l) {
			if (o.getChatId() == id) {
				x = true;
				break;
			}
		}//有的話就刪除
		if (x) {
			likechatmapper.delete(cn.getId());

		} else {
			//沒有的話就新增
			likeChat lCh = new likeChat(m.getUsername(), cn.getchatNo(), cn.getId());
			likechatmapper.add(lCh);
		}
		//比對收藏 存成session
		List<chat> ct = csi.can(m.getUsername());
		session.setAttribute("All", ct);
		
		String ul="LIKECHAT";
		session.setAttribute("UL", ul);
		return "porder/addChatSuccess";
	}
	//查看帳號收藏名單內容
	@RequestMapping("querylike")
	public String queryLike() {
		member m=(member) session.getAttribute("M");
		List<likeChat> l = likechatmapper.queryAll(m.getUsername());
		for(likeChat o:l) {
			o.setLike("取消收藏");
		}
		session.setAttribute("LC", l);
		return "likechat/indexlike";
	}
	//刪除帳號收藏內容
	@RequestMapping("deletelike")
	public String delete(int id) {
		likeChat lc=likechatmapper.queryId(id);
		
		likechatmapper.delete(lc.getChatId());
		member m=(member) session.getAttribute("M");
		List<likeChat> l = likechatmapper.queryAll(m.getUsername());
		for(likeChat o:l) {
			o.setLike("取消收藏");
		}
		session.setAttribute("LC", l);
		
		
		// 判斷哪些為收藏
		List<chat> ct = csi.can(m.getUsername());
		
		// 存成session
		session.setAttribute("All", ct);
		
		String ul="dlechat";
		session.setAttribute("UL", ul);
		return "porder/addChatSuccess";
	}
	
	
	

}
