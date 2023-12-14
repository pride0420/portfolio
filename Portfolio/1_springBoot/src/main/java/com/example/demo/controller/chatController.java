package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.ChatMapper;
import com.example.demo.dao.LikeChatMapper;
import com.example.demo.dao.MemberMapper;
import com.example.demo.service.Impl.ChatServiceImpl;
import com.example.demo.vo.Chat;
import com.example.demo.vo.LikeChat;
import com.example.demo.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class ChatController {
	@Autowired
	public ChatServiceImpl csi;

	@Autowired()
	public LikeChatMapper likechatmapper;

	@Autowired()
	public MemberMapper membermapper;

	@Autowired()
	public ChatMapper chatmapper;

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
		Chat c = chatmapper.queryChatId(id);

		session.setAttribute("subject", c);

		return "porder/setSubject";
	}

	// 前往首頁
	@RequestMapping("index")
	public String getToLoginSuccess() {
		Member m = (Member) session.getAttribute("M");

		// 比對收藏方法 ServiceImpl
		List<Chat> ct = csi.can(m.getUsername());

		// 存成session
		session.setAttribute("All", ct);
		return "porder/loginSuccess";
	}

	// 新增貼文
	@RequestMapping("addchat")
	public String addChat(String chatNo, String subject, String content) {
		Member m = (Member) session.getAttribute("M");
		Chat c = new Chat(chatNo, subject, content);

		chatmapper.addChat(c);

		List<Chat> ct = csi.can(m.getUsername());
		// 存成session
		session.setAttribute("All", ct);
		String ul = "chat";
		session.setAttribute("UL", ul);
		return "porder/empty";
	}

	// 查看帳號貼文
	@RequestMapping("queryName")
	public String queryName() {
		Member m = (Member) session.getAttribute("M");

		List<Chat> p = chatmapper.queryChatName(m.getName());
		session.setAttribute("Name", p);

		return "porder/chatUser";
	}

	// 修改貼文
	@RequestMapping("update")
	public String update(String subject, String content, int id) {
		Chat c = chatmapper.queryChatId(id);
		c.setSubject(subject);
		c.setContent(content);
		chatmapper.updateChat(c);

		Member m = (Member) session.getAttribute("M");

		List<Chat> n = chatmapper.queryChatName(m.getName());
		session.setAttribute("Name", n);

		List<Chat> ct = csi.can(m.getUsername());
		session.setAttribute("All", ct);

		return "porder/chatUser";
	}

	// 刪除貼文
	@RequestMapping("deleteSubject")
	public String delete(int id) {
		chatmapper.deleteChat(id);
		Member m = (Member) session.getAttribute("M");

		List<Chat> p = chatmapper.queryChatName(m.getName());
		session.setAttribute("Name", p);

		return "porder/chatUser";
	}

}
