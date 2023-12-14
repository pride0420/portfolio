package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.chat;

/*
 * 貼文的SQL語法
 * 搭配 table chat(貼文資料)
 * 及 view_number(結合 member、chat)
 */

@Mapper
public interface chatMapper {
	// create
	// 新增貼文
	@Insert("insert into chat(chatNo,subject,content) values(#{chatNo},#{subject},#{content})")
	void addChat(chat c);

	// read
	// 撈出全部貼文
	@Select("select * from number order by id desc")
	List<chat> queryChatAll();

	// 找出帳號收藏得貼文
	@Select("select * from number where name=#{name} order by id desc")
	List<chat> queryChatName(String name);

	// 利用ID查詢資料
	@Select("select * from chat where id=#{id}")
	chat queryChatId(int id);

	// update
	// 搭配ID修改貼文標題及內容
	@Update("update chat set subject=#{subject},content=#{content} where id=#{id}")
	void updateChat(chat c);

	// delete
	// 刪除貼文
	@Delete("delete from chat where id=#{id}")
	void deleteChat(int id);

}
