package com.example.demo.vo;

public class likeChat {

	private Integer id;
	private String username;
	private String chatNo;
	private Integer chatId;
	private String name;
	private String like;
	private String subject;
	private String content;
	public String getSubject() {
		return subject;
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
	public likeChat(String username, String chatNo, Integer chatId) {
		super();
		this.username = username;
		this.chatNo = chatNo;
		this.chatId = chatId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	public likeChat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getchatNo() {
		return chatNo;
	}
	public void setchatNo(String chatNo) {
		this.chatNo = chatNo;
	}
	public Integer getChatId() {
		return chatId;
	}
	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}
	
	
}
