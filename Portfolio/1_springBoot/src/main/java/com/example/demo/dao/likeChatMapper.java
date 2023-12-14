package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.likeChat;

/*
 * 收藏貼文的SQL語法
 * 搭配mysql_table likechat(被收藏的資料)
 * 及 view like(結合chat、likechat)確認收藏內容的完整資訊
 */

@Mapper
public interface likeChatMapper {

	// create
	// 新增收藏貼文(收藏者的帳號、貼文編號、貼文ID)
	@Insert("insert into likechat(username,chatNo,chatId)" + " values(#{username},#{chatNo},#{chatId})")
	void addLikeChat(likeChat l);

	// read
	// 查詢帳號收藏貼文的完整內容(view_like)
	@Select("select * from portfolio.like where username=#{username} order by id desc")
	List<likeChat> queryLikeChatAll(String username);

	// 搭配delete 使用
	@Select("select * from likechat where id=#{id}")
	likeChat queryLikeChatId(int id);

	/*
	 * 找出這個帳號的收藏貼文的代號(table_likechat) 用於之後跟全部貼文比對，確認是否收藏
	 */
	@Select("select * from portfolio.likechat where username=#{username} order by id desc")
	List<likeChat> queryLikeChatUsername(String username);

	// delete
	// 刪除已收藏的貼文
	@Delete("delete from likechat where chatId=#{chatId}")
	void deleteLikeChat(int id);
}
