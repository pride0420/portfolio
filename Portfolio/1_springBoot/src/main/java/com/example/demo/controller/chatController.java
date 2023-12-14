package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.chatMapper;
import com.example.demo.dao.likeChatMapper;
import com.example.demo.dao.memberMapper;
import com.example.demo.service.Impl.chatServiceImpl;
import com.example.demo.vo.chat;
import com.example.demo.vo.likeChat;
import com.example.demo.vo.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class chatController {
	@Autowired
	public chatServiceImpl csi;

	@Autowired()
	public likeChatMapper likechatmapper;

	@Autowired()
	public memberMapper membermapper;

	@Autowired()
	public chatMapper chatmapper;

	@Autowired()
	public HttpSession session;

	@Autowired()
	public HttpServletRequest request;
	@Autowired()
	public HttpServletResponse response;

	// 前往設定
	@RequestMapping("setting")
	public String getToSettingChat() {
		return "porder/settingChat";
	}

	// 前往更新貼文
	@RequestMapping("updateSubject")
	public String getToSubject(int id) {
		chat c = chatmapper.queryChatId(id);

		session.setAttribute("subject", c);

		return "porder/setSubject";
	}

	// 前往首頁
	@RequestMapping("index")
	public String getToLoginSuccess() {
		member m = (member) session.getAttribute("M");

		// 比對收藏方法 ServiceImpl
		List<chat> ct = csi.can(m.getUsername());

		// 存成session
		session.setAttribute("All", ct);
		return "porder/loginSuccess";
	}

	// 新增貼文
	@RequestMapping("addchat")
	public String addChat(String chatNo, String subject, String content) {
		member m = (member) session.getAttribute("M");
		chat c = new chat(chatNo, subject, content);

		chatmapper.addChat(c);

		List<chat> ct = csi.can(m.getUsername());
		// 存成session
		session.setAttribute("All", ct);
		String ul = "chat";
		session.setAttribute("UL", ul);
		return "porder/empty";
	}

	// 查看帳號貼文
	@RequestMapping("queryName")
	public String queryName() {
		member m = (member) session.getAttribute("M");

		List<chat> p = chatmapper.queryChatName(m.getName());
		session.setAttribute("Name", p);

		return "porder/chatUser";
	}

	// 修改貼文
	@RequestMapping("update")
	public String update(String subject, String content, int id) {
		chat c = chatmapper.queryChatId(id);
		c.setSubject(subject);
		c.setContent(content);
		chatmapper.updateChat(c);

		member m = (member) session.getAttribute("M");

		List<chat> n = chatmapper.queryChatName(m.getName());
		session.setAttribute("Name", n);

		List<chat> ct = csi.can(m.getUsername());
		session.setAttribute("All", ct);

		return "porder/chatUser";
	}

	// 刪除貼文
	@RequestMapping("deleteSubject")
	public String delete(int id) {
		chatmapper.deleteChat(id);
		member m = (member) session.getAttribute("M");

		List<chat> p = chatmapper.queryChatName(m.getName());
		session.setAttribute("Name", p);

		return "porder/chatUser";
	}

}
