package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.likeChat;

@Mapper
public interface likeChatMapper {
	//create
	@Insert("insert into likechat(username,chatNo,chatId)"
			+ " values(#{username},#{chatNo},#{chatId})" )
	void add(likeChat l);
	
	//read
	@Select("select * from portfolio.like where username=#{username} order by id desc")
	List<likeChat> queryAll(String username);
	
	@Select("select * from likechat where id=#{id}")
	likeChat queryId(int id);
	
	//找出這個帳號的收藏內容
	@Select("select * from portfolio.likechat where username=#{username} order by id desc")
	List<likeChat> queryUsername(String username);
	//update
	
	
	//delete
	@Delete("delete from likechat where chatId=#{chatId}")
	void delete(int id);
}
