package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.chatMapper;
import com.example.demo.dao.likeChatMapper;
import com.example.demo.service.chatService;
import com.example.demo.vo.chat;
import com.example.demo.vo.likeChat;

@Service
public class chatServiceImpl implements chatService {

	@Autowired
	public chatMapper cm;

	@Autowired
	public likeChatMapper lcm;

	@Override
	public List<chat> can(String username) {
		// 先找出收藏的內容
		List<likeChat> LC = lcm.queryLikeChatUsername(username);
		// 判斷哪些為收藏
		List<chat> ct = cm.queryChatAll();
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
		return ct;
	}

}
