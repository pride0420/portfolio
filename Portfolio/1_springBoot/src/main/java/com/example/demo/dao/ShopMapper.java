package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.ShopCar;
/*
 * 商城的SQL語法
 * 配合mysql_table shopcart， view  spcar 使用
 */


@Mapper
public interface ShopMapper {
	//新增_購物車
	@Insert("insert into portfolio.shopcart(memberNo,porderNo,shop_amount,shop_num,shop_sum)"
			+ " values(#{memberNo},#{porderNo},#{shop_amount},#{shop_num},#{shop_sum})")
	void addShop(ShopCar s);
	
	
	//查詢
	//利用帳號編號 查詢購物車的商品編號及其數量
	@Select("select porderNo,shop_num from portfolio.shopcart where memberNo=#{memberNo}")
	List<ShopCar> queryShop(String memberNo);
	
	//查詢此帳號的單種商品 用於快速確認是否已存在購物車中
	@Select("select * from portfolio.shopcart where porderNo=#{porderNo} and memberNo=#{memberNo}")
	ShopCar queryShopPorderNo(String porderNo,String memberNo);
	
	//利用id編號查詢對應內容
	@Select("select * from portfolio.shopcart where id=#{id}")
	ShopCar queryShopId(int id);
	
	//查詢整個帳號購物車的內容
	@Select("select * from portfolio.spcar where username=#{username}")
	List<ShopCar> queryShopCar(String username);
	
	//配合queryId 更新購物車的數量
	@Update("update portfolio.shopcart set shop_num=#{shop_num},shop_sum=#{shop_sum} where id=#{id}")
	void updateShop(ShopCar s);
	
	//刪除購物車內容
	@Delete("delete from portfolio.shopcart where id=#{id}")
	void deleteShop(int id);
	

}
