package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.chatMapper;
import com.example.demo.dao.likeChatMapper;
import com.example.demo.dao.memberMapper;
import com.example.demo.vo.chat;
import com.example.demo.vo.likeChat;
import com.example.demo.vo.member;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class memberController {

	@Autowired()
	public memberMapper membermapper;

	@Autowired()
	public chatMapper chatmapper;

	@Autowired()
	public HttpSession session;

	@Autowired()
	public likeChatMapper likechatmapper;

	@RequestMapping("addError")
	public String getError() {
		return "addmember";
	}

	// 登入後
	@RequestMapping("login")
	public String login(String username, String password) {
		// 登入帳號
		member m = membermapper.querymember(username, password);
		// 成功登入的話
		if (m != null) {
			// 先找出收藏的內容
			List<likeChat> LC = likechatmapper.queryUsername(username);
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
			session.setAttribute("M", m);
			return "porder/loginSuccess";
		} else {
			return "loginError";
		}
	}

	@RequestMapping("add")
	public String add(String username, String password, String name, String phone) {

		member m1 = membermapper.queryUser(username);
		if (m1 != null) {
			return "addmemberError";
		} else {
			member m = new member(username, password, name, phone);
			membermapper.add(m);

			String v = "m" + membermapper.queryId().toString();
			m.setMemberNo(v);
			membermapper.updateNo(m);
			


			return "addmemberSuccess";
		}
	}

	@RequestMapping("loginout")
	public String loginout(HttpServletRequest request, HttpServletResponse response) {
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

	@RequestMapping("addpos")
	public String loginpos(String username, String password) {
		// 登入帳號
		// member m=membermapper.querymember(username, password);

		// 成功登入的話
		int x = 0;
		// 先找出收藏的內容
		List<likeChat> LC = likechatmapper.queryUsername(username);
		List<chat> c = chatmapper.queryAll();

		for (chat p : c) {
			for (likeChat o : LC) {
				if (p.getId() == o.getChatId()) {
					p.setLike("關注");
					// System.out.print(p.getLike());
					break;
				} else {
					p.setLike("不關注");
					// System.out.print(p.getLike());

				}
			}
			System.out.print(p.getLike());

		}

		return " ";
	}

}
