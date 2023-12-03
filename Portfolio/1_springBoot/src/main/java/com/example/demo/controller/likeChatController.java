package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.chatMapper;
import com.example.demo.dao.likeChatMapper;
import com.example.demo.vo.chat;
import com.example.demo.vo.likeChat;
import com.example.demo.vo.member;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class likeChatController {

	@Autowired()
	public likeChatMapper likechatmapper;

	@Autowired()
	public HttpSession session;

	@Autowired()
	public chatMapper chatmapper;
	
	
	
	// 新增或刪除收藏
	@RequestMapping("addlike")
	public String addlike(int id, HttpServletRequest request) {
		session.removeAttribute("All");
		member m = (member) session.getAttribute("M");
		// 接收傳回來的貼文id 比對以收藏內容 查看是否收藏過
		Integer c = Integer.parseInt(request.getParameter("id"));
		chat cn = chatmapper.queryId(c);
		List<likeChat> l = likechatmapper.queryUsername(m.getUsername());
		boolean x = false;
		for (likeChat o : l) {
			if (o.getChatId() == c) {
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
		//比對全部的內容更新收藏詞
		List<likeChat> LC = likechatmapper.queryUsername(m.getUsername());
		List<chat> ct = chatmapper.queryAll();
		for (chat p : ct) {
			for (likeChat o : LC) {
				if (p.getId() == o.getChatId()) {
					p.setLike("取消收藏");
					break;
				} else {
					p.setLike("收藏");
				}
			}
		}
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
		
		List<likeChat> LC = likechatmapper.queryUsername(m.getUsername());
		List<chat> c = chatmapper.queryAll();
		// 判斷哪些為收藏
		for (chat p : c) {
			for (likeChat o : LC) {
				if (p.getId() == o.getChatId()) {
					p.setLike("取消收藏");
					break;
				} else {
					p.setLike("收藏");
				}
			}
		}

		// 存成session
		session.setAttribute("All", c);
		String ul="dlechat";
		session.setAttribute("UL", ul);
		return "porder/addChatSuccess";
	}
	
	
	

}
