package com.example.demo.vo;


//遊戲_玩家的vo

public class GamePlayer {

	private Integer id;
	private String playernub;
	private Integer reno;
	public Integer getReno() {
		return reno;
	}
	public void setReno(Integer reno) {
		this.reno = reno;
	}
	private Integer a;
	private Integer b;
	
	public GamePlayer(String playernub) {
		super();
		this.playernub = playernub;
	}
	public GamePlayer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getA() {
		return a;
	}
	public void setA(Integer a) {
		this.a = a;
	}
	public Integer getB() {
		return b;
	}
	public void setB(Integer b) {
		this.b = b;
	}
	public String getPlayernub() {
		return playernub;
	}
	public void setPlayernub(String playernub) {
		this.playernub = playernub;
	}
	
}
