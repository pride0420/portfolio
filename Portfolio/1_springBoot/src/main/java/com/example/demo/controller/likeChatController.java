package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.ChatMapper;
import com.example.demo.dao.LikeChatMapper;
import com.example.demo.service.Impl.ChatServiceImpl;
import com.example.demo.vo.Chat;
import com.example.demo.vo.LikeChat;
import com.example.demo.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LikeChatController {

	@Autowired
	public ChatServiceImpl csi;

	@Autowired()
	public LikeChatMapper likechatmapper;

	@Autowired()
	public HttpSession session;

	@Autowired()
	public ChatMapper chatmapper;

	// 新增或刪除收藏
	@RequestMapping("addlike")
	public String addlike(int id, HttpServletRequest request) {
		// session.removeAttribute("All");
		Member m = (Member) session.getAttribute("M");

		// 接收傳回來的貼文id 比對以收藏內容 查看是否收藏過
		Chat cn = chatmapper.queryChatId(id);
		List<LikeChat> l = likechatmapper.queryLikeChatUsername(m.getUsername());
		boolean x = false;
		for (LikeChat o : l) {
			if (o.getChatId() == id) {
				x = true;
				break;
			}
		} // 有的話就刪除
		if (x) {
			likechatmapper.deleteLikeChat(cn.getId());

		} else {
			// 沒有的話就新增
			LikeChat lCh = new LikeChat(m.getUsername(), cn.getchatNo(), cn.getId());
			likechatmapper.addLikeChat(lCh);
		}
		// 比對收藏 存成session
		List<Chat> ct = csi.can(m.getUsername());
		session.setAttribute("All", ct);

		String ul = "LIKECHAT";
		session.setAttribute("UL", ul);
		return "porder/empty";
	}

	// 查看帳號收藏名單內容
	@RequestMapping("querylike")
	public String queryLike() {
		Member m = (Member) session.getAttribute("M");
		List<LikeChat> l = likechatmapper.queryLikeChatAll(m.getUsername());
		for (LikeChat o : l) {
			o.setLike("取消收藏");
		}
		session.setAttribute("LC", l);
		return "likechat/indexlike";
	}

	// 刪除帳號收藏內容
	@RequestMapping("deletelike")
	public String delete(int id) {
		LikeChat lc = likechatmapper.queryLikeChatId(id);

		likechatmapper.deleteLikeChat(lc.getChatId());
		Member m = (Member) session.getAttribute("M");
		List<LikeChat> l = likechatmapper.queryLikeChatAll(m.getUsername());
		for (LikeChat o : l) {
			o.setLike("取消收藏");
		}
		session.setAttribute("LC", l);

		// 判斷哪些為收藏
		List<Chat> ct = csi.can(m.getUsername());

		// 存成session
		session.setAttribute("All", ct);

		String ul = "dlechat";
		session.setAttribute("UL", ul);
		return "porder/empty";
	}

}
