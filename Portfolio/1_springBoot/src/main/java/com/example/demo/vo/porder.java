package com.example.demo.vo;

public class porder {
	
	private Integer id;
	private String product;
	private String porderNo;
	private Integer amount;
	private String imgNo;
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
	private Integer toto;
	public Integer getToto() {
		return toto;
	}
	public void setToto(Integer toto) {
		this.toto = toto;
	}
	public String getImgNo() {
		return imgNo;
	}
	public void setImgNo(String imgNo) {
		this.imgNo = imgNo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getPorderNo() {
		return porderNo;
	}
	public void setPorderNo(String porderNo) {
		this.porderNo = porderNo;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}


}