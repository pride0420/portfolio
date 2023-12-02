package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import com.example.demo.vo.member;

@Mapper
public interface memberMapper {
	//create
	@Insert("insert into member(memberNo,username,password,name,phone)"
			+ "values(#{memberNo},#{username},#{password},#{name},#{phone})")
	void add(member m);
	@Insert("insert into member(memberNo) values(#{memberNo})")
	void addNo(member m);
	
	//read
	@Select("select * from member")
	List<member> queryAll();
	
	@Select("select * from member where username=#{username} and password=#{password}")
	member querymember(String username,String password);
	
	@Select("select * from member where username=#{username}")
	member queryUser(String username);
	
	@Select("select if(max(id) is null,0,max(id)) as maxid from portfolio.member")
	Integer queryId();
	
	
	//update
	@Update("update member set name=#{name},phone=#{phone} where username=#{username}")
	void update(member m);
	
	@Update("update member set memberNo=#{memberNo} where username=#{username}")
	void updateNo(member m);
	//delete
	@Delete("delete from member where id=#{id}")
	void delete(int id);
}
