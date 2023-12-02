package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.chat;


@Mapper
public interface chatMapper {
	//create
	@Insert("insert into chat(chatNo,subject,content) values(#{chatNo},#{subject},#{content})")
	void addChat(chat c);
	
	//read
	
	
	//撈出全部貼文
	@Select("select * from number order by id desc")
	List<chat> queryAll();
	
	
	
	@Select("select * from number where name=#{name} order by id desc")
	List<chat> queryName(String name);
	
	@Select("select * from chat where id=#{id}")
	chat queryId(int id);
	
	@Select("select * from chat where name=#{name}")
	chat queryAllName(String name);
	@Select("select * from chat where name=#{name}")
	List<chat> queryUserName(String name);
	//update
	@Update("update chat set subject=#{subject},content=#{content} where id=#{id}")
	void update(chat c);
	
	@Update("update chat set name=#{name} where name=#{name}")
		void updateName(chat c);
	
	
	//delete
	@Delete("delete from chat where id=#{id}")
	void delete(int id);
	
	
	
}
