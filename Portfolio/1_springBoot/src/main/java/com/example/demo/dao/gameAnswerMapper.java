package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.gameanswer;
import com.example.demo.vo.gameplayer;

@Mapper
public interface gameAnswerMapper {

	//ANSWER
	//create
	@Insert("insert into gameanswer(answernub)"
			+ " values(#{answernub})")
	void addGame(gameanswer g);
	

	//read
	@Select("select if(max(id) is null,0,max(id)) as maxid from portfolio.gameanswer")
	Integer queryId();
	@Select("select * from gameanswer where id=#{id}")
	gameanswer queryanswer(int id);
	
	@Select("select * from gameanswer where id=#{id}")
	List<Integer> queryanswerList(int id);
	
	

	//PLAYER
	//create
	@Insert("insert into gameplayer(playernub)"
			+ "values(#{playernub})")
	void addPlayer(gameplayer p);
	
	
	//read
	@Select("select * from gameplayer order by id desc")
	List<gameplayer> query();
	
	@Select("select if(max(id) is null,0,max(id)) as maxid from portfolio.gameplayer")
	Integer queryplayerId();
	
	@Select("select * from portfolio.gameplayer where id=#{id}")
	gameplayer queryplayer(int id);
	/*
	@Select("select * from gameplayer where id=#{id}")
	List<String> queryplayerList(int id);
	*/
	@Delete("delete from portfolio.gameplayer where id<=#{id}")
	void deletePlayer(int id);
	
	//update
	@Update("update gameplayer set a=#{a},b=#{b},reno=#{reno} where id=#{id}")
	void update(gameplayer gp);
}
