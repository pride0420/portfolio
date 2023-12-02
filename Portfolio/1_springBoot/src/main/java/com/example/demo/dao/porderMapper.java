package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.porder;

@Mapper
public interface porderMapper {

	@Select("select * from portfolio.porder")
	List<porder> queryAll();
	
	@Select("select * from portfolio.porder where porderNo=#{porderNo}")
	porder queryporderNo(String porderNo);
	
	@Select("select * from portfolio.porder where items=#{items}")
	List<porder> quetyItems(String items);
}
