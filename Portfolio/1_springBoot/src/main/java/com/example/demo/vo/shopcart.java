package com.example.demo.vo;

import java.sql.Timestamp;

//商城的vo

public class shopcart {

	private Integer id;
	private String memberNo;
	private String porderNo;
	private Integer shop_amount;
	private Integer shop_num;
	private Integer shop_sum;
	private Timestamp firsttime;
	private Timestamp updatetime;
	private String mode;
	private String items;
	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	private String username;
	private String name;
	private String product;
	private String imgNo;
	

	public String getImgNo() {
		return imgNo;
	}

	public void setImgNo(String imgNo) {
		this.imgNo = imgNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Integer getShop_amount() {
		return shop_amount;
	}

	public void setShop_amount(Integer shop_amount) {
		this.shop_amount = shop_amount;
	}

	public shopcart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getPorderNo() {
		return porderNo;
	}

	public void setPorderNo(String porderNo) {
		this.porderNo = porderNo;
	}

	public Integer getShop_num() {
		return shop_num;
	}

	public void setShop_num(Integer shop_num) {
		this.shop_num = shop_num;
	}
	
	public Integer getShop_sum() {
		return shop_sum;
	}

	public void setShop_sum(Integer shop_sum) {
		this.shop_sum = shop_sum;
	}

	public shopcart(String memberNo, String porderNo, Integer shop_amount, Integer shop_num, Integer shop_sum) {
		super();
		this.memberNo = memberNo;
		this.porderNo = porderNo;
		this.shop_amount = shop_amount;
		this.shop_num = shop_num;
		this.shop_sum = shop_sum;
	}

	public Timestamp getFirsttime() {
		return firsttime;
	}

	public void setFirsttime(Timestamp firsttime) {
		this.firsttime = firsttime;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	
}
