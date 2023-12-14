package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Porder;


//商品目錄的SQL語法



@Mapper
public interface PorderMapper {

	//查詢全部商品
	@Select("select * from portfolio.porder")
	List<Porder> queryPorderAll();
	
	//利用商品編號查詢對應資訊
	@Select("select * from portfolio.porder where porderNo=#{porderNo}")
	Porder queryPorderNo(String porderNo);
	
	//利用分類查詢對應資訊
	@Select("select * from portfolio.porder where items=#{items}")
	List<Porder> quetyPorderItems(String items);
}
