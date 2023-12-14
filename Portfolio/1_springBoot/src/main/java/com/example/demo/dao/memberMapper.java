package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import com.example.demo.vo.Member;


//會員的SQL語法

@Mapper
public interface MemberMapper {
	//create
	//新增會員帳號
	@Insert("insert into member(memberNo,username,password,name,phone)"
			+ "values(#{memberNo},#{username},#{password},#{name},#{phone})")
	void addMember(Member m);
	//生成會員編號並新增
	@Insert("insert into member(memberNo) values(#{memberNo})")
	void addMemberNo(Member m);
	
	//read
	//查詢帳號及密碼，用於登入
	@Select("select * from member where username=#{username} and password=#{password}")
	Member queryMember(String username,String password);
	
	//查詢帳號，檢查是否重複
	@Select("select * from member where username=#{username}")
	Member queryMemberUser(String username);
	
	//查最新的帳號ID，用於搭配生成會員編號
	@Select("select if(max(id) is null,0,max(id)) as maxid from portfolio.member")
	Integer queryMemberId();
	
	
	//update
	//更改會員姓名及電話
	@Update("update member set name=#{name},phone=#{phone} where username=#{username}")
	void updateMember(Member m);
	
	//用於新增對應的會員編號
	@Update("update member set memberNo=#{memberNo} where username=#{username}")
	void updateMemberNo(Member m);
	
	//delete
	//刪除會員
	@Delete("delete from member where id=#{id}")
	void deleteMember(int id);
}
