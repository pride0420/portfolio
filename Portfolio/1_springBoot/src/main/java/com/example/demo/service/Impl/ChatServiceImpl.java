package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ChatMapper;
import com.example.demo.dao.LikeChatMapper;
import com.example.demo.service.ChatService;
import com.example.demo.vo.Chat;
import com.example.demo.vo.LikeChat;

@Service
public class ChatServiceImpl implements ChatService {

	@Autowired
	public ChatMapper cm;

	@Autowired
	public LikeChatMapper lcm;

	@Override
	public List<Chat> can(String username) {
		// 先找出收藏的內容
		List<LikeChat> LC = lcm.queryLikeChatUsername(username);
		// 判斷哪些為收藏
		List<Chat> ct = cm.queryChatAll();
		for (Chat p : ct) {
			for (LikeChat o : LC) {
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
