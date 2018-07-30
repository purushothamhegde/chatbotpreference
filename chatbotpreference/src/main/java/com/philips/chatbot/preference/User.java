package com.philips.chatbot.preference;

public class User {
	private String userid ="";
	private String username="";
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String userid, String username) {
		super();
		this.userid = userid;
		this.username = username;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + "]";
	}	

}
