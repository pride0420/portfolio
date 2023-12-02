package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.porderMapper;
import com.example.demo.dao.shopMapper;
import com.example.demo.vo.member;
import com.example.demo.vo.porder;
import com.example.demo.vo.shopcart;

import jakarta.servlet.http.HttpSession;

//商城及購物車的Controller

@Controller
public class shopController {

	@Autowired()
	public porderMapper pordermapper;
	@Autowired()
	public shopMapper shopmapper;
	@Autowired()
	public HttpSession session;
	//切換到手機頁
	@RequestMapping("phone")
	public String gotoPhone() {
		return "market/indexPhone";
	}
	//切換到電腦頁
	@RequestMapping("cpu")
	public String gotoCpu() {
		return "market/indexCpu";
	}
	//切換到電動頁
	@RequestMapping("gmb")
	public String gotoGmb() {
		return "market/indexGmb";
	}
	//切換到其他頁
	@RequestMapping("other")
	public String gotoOther() {
		return "market/indexOther";
	}

	/*
	 * 切換到購物車
	 * 利用session保存購物車內容
	 */
	@GetMapping("queryshopcart")
	public String gotoshopcart() {
		member m = (member) session.getAttribute("M");
		List<shopcart> s = shopmapper.queryCar(m.getUsername());
		session.setAttribute("Spcar", s);

		return "market/car";

	}

	//用於從留言板進入商城，或進入其他商城分頁
	@GetMapping("gophone")
	public String gotophone(String items) {
		member m = (member) session.getAttribute("M");
		//根據網頁傳來的items 找出其分類項目
		List<porder> l = pordermapper.quetyItems(items);
		//找出購物車收藏的資料
		List<shopcart> s = shopmapper.queryshop(m.getMemberNo());
		//將兩者比對
		if(!s.isEmpty()) {
		for (shopcart o : s) {
			for (porder c : l) {
				//如果購物車內有的話 儲存其數量
				if (o.getPorderNo().equals(c.getPorderNo())) {
					c.setToto(o.getShop_num());
				}//沒有的話存0
				if (c.getToto() == null) {
					c.setToto(0);
				}
			}
		}
		}else {
			for (porder c : l) {
				c.setToto(0);
			}
		}//將更新好的商品資料存成session
		session.setAttribute("Porder", l);
		if(items.equals("手機")) {
			return "market/indexPhone";
		}else if(items.equals("電腦")){
			return "market/indexCpu";
		}else if(items.equals("電動")){
			return "market/indexGmb";
		}else if(items.equals("其他")){
			return "market/indexOther";
		}else {
			return null;
		}
		
	}
	
	
	//shop
	//新增商品進購物車
	@GetMapping("addshop")
	public String addShopcart(String memberNo, String porderNo,String items) {
		boolean x = false;
		//判斷商品是否存在購物車
		List<shopcart> s = shopmapper.queryshop(memberNo);
		for (shopcart o : s) {
			if (o.getPorderNo().equals(porderNo)) {
				x = true;
			}
		}
		//如果已存在 更新購物車內的數量及金額
		if (x) {
			shopcart spt = new shopcart();
			spt = shopmapper.queryshopPorderNo(porderNo, memberNo);
			spt.setShop_num(spt.getShop_num() + 1);
			spt.setShop_sum(spt.getShop_amount() * spt.getShop_num());
			spt.getId();
			shopmapper.update(spt);
			
			//如果不存在 及新增商品進購物車中
		} else {
			porder p = pordermapper.queryporderNo(porderNo);
			shopcart sp = new shopcart(memberNo, porderNo, p.getAmount(), 1, p.getAmount());
			shopmapper.addShop(sp);			
		}
		//再次比對購物車 存成session 用於更新畫面
		s = shopmapper.queryshop(memberNo);
		List<porder> l = pordermapper.quetyItems(items);
		for (shopcart o : s) {
			for (porder c : l) {
				if (o.getPorderNo().equals(c.getPorderNo())) {
					c.setToto(o.getShop_num());
				}
				if (c.getToto() == null) {
					c.setToto(0);
				}
			}
		}
		session.setAttribute("Porder", l);
		
		String ul=items;
		session.setAttribute("UL", ul);
		return "porder/addChatSuccess";
		

	}

	//car
	//在購物車內更新數量
	@GetMapping("updateNum")
	public String updateNum(String xx, Integer id) {
		//根據接收的xx 增加或減少
		if (xx.equals("增加")) {
			//利用ID調出需更新的產品
			shopcart s = shopmapper.queryId(id);
			//在原數量上+1
			s.setShop_num(s.getShop_num() + 1);
			//更新單品項總金額
			s.setShop_sum(s.getShop_amount() * s.getShop_num());
			s.getId();
			shopmapper.update(s);
			
		} else if (xx.equals("減少")) {
			//如果數量-1後=0 則直接刪除  否則數量-1
			shopcart s = shopmapper.queryId(id);
			if (s.getShop_num() - 1 == 0) {
				shopmapper.deleteAll(id);
			} else {
				s.setShop_num(s.getShop_num() - 1);
				s.setShop_sum(s.getShop_amount() * s.getShop_num());
				s.getId();
				shopmapper.update(s);
			}//刪除整筆
		} else if (xx.equals("刪除")) {
			shopmapper.deleteAll(id);
		}
		//更新session
		member m = (member) session.getAttribute("M");
		List<shopcart> l = shopmapper.queryCar(m.getUsername());
		session.setAttribute("Spcar", l);

		String ul="upnum";
		session.setAttribute("UL", ul);
		return "porder/addChatSuccess";
	}

	
}
