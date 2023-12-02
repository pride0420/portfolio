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

@Controller
public class shopController {

	@Autowired()
	public porderMapper pordermapper;
	@Autowired()
	public shopMapper shopmapper;
	@Autowired()
	public HttpSession session;
	
	@RequestMapping("phone")
	public String gotoPhone() {
		return "market/indexPhone";
	}
	@RequestMapping("cpu")
	public String gotoCpu() {
		return "market/indexCpu";
	}
	@RequestMapping("gmb")
	public String gotoGmb() {
		return "market/indexGmb";
	}
	@RequestMapping("other")
	public String gotoOther() {
		return "market/indexOther";
	}

	@GetMapping("queryshopcart")
	public String gotoshopcart() {
		member m = (member) session.getAttribute("M");
		List<shopcart> s = shopmapper.queryCar(m.getUsername());
		session.setAttribute("Spcar", s);

		return "market/car";

	}
/*
	@GetMapping("gomarket")
	public String gotoMarket() {
		member m = (member) session.getAttribute("M");
		List<porder> l = pordermapper.queryAll();
		List<shopcart> s = shopmapper.queryshop(m.getMemberNo());

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

		return "market/indexM";
	}
*/
	@GetMapping("gophone")
	public String gotophone(String items) {
		member m = (member) session.getAttribute("M");
		List<porder> l = pordermapper.quetyItems(items);
		List<shopcart> s = shopmapper.queryshop(m.getMemberNo());
		if(!s.isEmpty()) {
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
		}else {
			for (porder c : l) {
				c.setToto(0);
			}
		}
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
	@GetMapping("addshop")
	public String addShopcart(String memberNo, String porderNo,String items) {
		boolean x = false;
		List<shopcart> s = shopmapper.queryshop(memberNo);
		for (shopcart o : s) {
			if (o.getPorderNo().equals(porderNo)) {
				x = true;
			}
		}
		System.out.println(s);
		if (x) {
			shopcart spt = new shopcart();
			spt = shopmapper.queryshopPorderNo(porderNo, memberNo);
			spt.setShop_num(spt.getShop_num() + 1);
			spt.setShop_sum(spt.getShop_amount() * spt.getShop_num());
			spt.getId();

			shopmapper.update(spt);
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

		} else {
			porder p = pordermapper.queryporderNo(porderNo);
			shopcart sp = new shopcart(memberNo, porderNo, p.getAmount(), 1, p.getAmount());
			shopmapper.addShop(sp);

			List<shopcart> ss = shopmapper.queryshop(memberNo);
			List<porder> l = pordermapper.quetyItems(items);
			for (shopcart o : ss) {
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
		}
		String ul=items;
		session.setAttribute("UL", ul);
		return "porder/addChatSuccess";
		

	}

//car
	@GetMapping("updateNum")
	public String updateNum(String xx, Integer id) {
		if (xx.equals("增加")) {
			shopcart s = shopmapper.queryId(id);
			s.setShop_num(s.getShop_num() + 1);
			s.setShop_sum(s.getShop_amount() * s.getShop_num());
			s.getId();
			shopmapper.update(s);
		} else if (xx.equals("減少")) {
			shopcart s = shopmapper.queryId(id);
			if (s.getShop_num() - 1 == 0) {
				shopmapper.deleteAll(id);
			} else {
				s.setShop_num(s.getShop_num() - 1);
				s.setShop_sum(s.getShop_amount() * s.getShop_num());
				s.getId();
				shopmapper.update(s);
			}
		} else if (xx.equals("刪除")) {
			shopmapper.deleteAll(id);
		}
		member m = (member) session.getAttribute("M");
		List<shopcart> l = shopmapper.queryCar(m.getUsername());
		session.setAttribute("Spcar", l);

		String ul="upnum";
		session.setAttribute("UL", ul);
		return "porder/addChatSuccess";
	}

	
}
