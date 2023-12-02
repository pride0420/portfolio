package com.example.demo.vo;

public class member {

	private Integer id;
	private String memberNo;
	private String username;
	private String password;
	private String name;
	private String phone;
	public member(String username, String password, String name, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	public member(String memberNo) {
		super();
		this.memberNo = memberNo;
	}
	public member(String memberNo, String username, String password, String name, String phone) {
		super();
		this.memberNo = memberNo;
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public member() {
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
