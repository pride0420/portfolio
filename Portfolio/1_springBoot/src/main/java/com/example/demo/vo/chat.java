package com.example.demo.vo;

import java.sql.Timestamp;


//留言的vo

public class Chat {

	private Integer id;
	private String name;
	private String chatNo;
	private String subject;
	private String content;
	private Timestamp firsttime; 
	public Timestamp getFirsttime() {
		return firsttime;
	}
	public void setFirsttime(Timestamp firsttime) {
		this.firsttime = firsttime;
	}
	private String like;
	public Chat(String chatNo, String subject, String content) {
		super();
		this.chatNo = chatNo;
		this.subject = subject;
		this.content = content;
	}
	public Chat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getchatNo() {
		return chatNo;
	}
	public void setchatNo(String chatNo) {
		this.chatNo = chatNo;
	}
	public String getSubject() {
		return subject;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	
}
