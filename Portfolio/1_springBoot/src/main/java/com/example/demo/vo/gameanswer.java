package com.example.demo.vo;


//遊戲_答案的vo

public class GameAnswer {
	
	private Integer id;
	private String answernub;
	public GameAnswer(String answernub) {
		super();
		this.answernub = answernub;
	}
	public GameAnswer() {
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