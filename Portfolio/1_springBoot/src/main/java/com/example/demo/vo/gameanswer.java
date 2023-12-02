package com.example.demo.vo;


//遊戲_答案的vo

public class gameanswer {
	
	private Integer id;
	private String answernub;
	public gameanswer(String answernub) {
		super();
		this.answernub = answernub;
	}
	public gameanswer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAnswernub() {
		return answernub;
	}
	public void setAnswernub(String answernub) {
		this.answernub = answernub;
	}
	
	




}