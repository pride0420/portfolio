package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.GameAnswer;
import com.example.demo.vo.GamePlayer;

//遊戲的SQL語法 包含gameanswer(題目) 及 gameplayer(玩家方)的table

@Mapper
public interface GameMapper {

	//ANSWER
	//create
	//新增題目
	@Insert("insert into gameanswer(answernub)"
			+ " values(#{answernub})")
	void addGame(GameAnswer g);
	

	//read
	//查詢最新一筆題目ID，用在開新遊戲時
	@Select("select if(max(id) is null,0,max(id)) as maxid from portfolio.gameanswer")
	Integer queryAnswerId();
	
	//搭配ID查詢其內容
	@Select("select * from gameanswer where id=#{id}")
	GameAnswer queryAnswer(int id);
	
	//儲存題目
	@Select("select * from gameanswer where id=#{id}")
	List<Integer> queryAnswerList(int id);
	
	

	//PLAYER
	//create
	//接收玩家輸入的數字
	@Insert("insert into gameplayer(playernub)"
			+ "values(#{playernub})")
	void addPlayer(GamePlayer p);
	
	
	//read
	//將資料由新到舊儲存
	@Select("select * from gameplayer order by id desc")
	List<GamePlayer> queryPlayerAll();
	
	//查詢最新一筆資料ID
	@Select("select if(max(id) is null,0,max(id)) as maxid from portfolio.gameplayer")
	Integer queryPlayerId();
	
	//搭配ID獲取最新一筆資料
	@Select("select * from portfolio.gameplayer where id=#{id}")
	GamePlayer queryPlayer(int id);
	
	//delete
	//刪除歷史猜題記錄，用於結束時
	@Delete("delete from portfolio.gameplayer where id<=#{id}")
	void deletePlayer(int id);
	
	//update
	//更新比對後的A、B數量
	@Update("update gameplayer set a=#{a},b=#{b},reno=#{reno} where id=#{id}")
	void updatePlayer(GamePlayer gp);
}
