package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class MemberController {

	@Autowired
	public ChatServiceImpl csi;

	@Autowired()
	public MemberMapper membermapper;

	@Autowired()
	public ChatMapper chatmapper;

	@Autowired()
	public HttpSession session;

	@Autowired()
	public LikeChatMapper likechatmapper;

	@RequestMapping("addError")
	public String getError() {
		return "addmember";
	}

	// 登入後
	@RequestMapping("login")
	public String Login(String username, String password) {
		// 登入帳號
		Member m = membermapper.queryMember(username, password);
		// 成功登入的話
		if (m != null) {
			// 用chatServicceImpl找出帳號已收藏的貼文 在首頁顯示
			List<Chat> ct = csi.can(username);

			// 存成session
			session.setAttribute("All", ct);
			session.setAttribute("M", m);
			return "porder/loginSuccess";
		} else {
			return "loginError";
		}
	}

	// 新增帳號
	@RequestMapping("add")
	public String addMember(String username, String password, String name, String phone) {
		// 檢查帳號有無重複
		Member m1 = membermapper.queryMemberUser(username);
		if (m1 != null) {
			return "addmemberError";
		} else {
			Member m = new Member(username, password, name, phone);
			membermapper.addMember(m);
			// 捕捉新帳號的ID 存成帳號編號
			String v = "m" + membermapper.queryMemberId().toString();
			m.setMemberNo(v);
			membermapper.updateMemberNo(m);

			return "addmemberSuccess";
		}
	}

	// 更新帳號資訊
	@RequestMapping("updatename")
	public String updateName(String name, String phone) {
		Member m1 = (Member) session.getAttribute("M");
		Member m = membermapper.queryMemberUser(m1.getUsername());
		if (name == "") {
			m.setName(m.getName());
		} else {
			m.setName(name);
		}
		if (phone == "") {
			m.setPhone(m.getPhone());
		} else {
			m.setPhone(phone);
		}
		membermapper.updateMember(m);

		List<Chat> ct = csi.can(m.getUsername());
		session.setAttribute("M", m);
		session.setAttribute("All", ct);

		return "porder/loginSuccess";
	}

	// 登出用
	@RequestMapping("loginout")
	public String loginOut(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("M");
		try {
			response.sendRedirect("index.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
