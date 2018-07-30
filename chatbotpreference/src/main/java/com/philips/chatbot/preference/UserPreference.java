package com.philips.chatbot.preference;

public class UserPreference {

	private String userid="";
	private String prefkey="";
	private String prefvalue="";
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPrefkey() {
		return prefkey;
	}
	public void setPrefkey(String prefkey) {
		this.prefkey = prefkey;
	}
	public String getPrefvalue() {
		return prefvalue;
	}
	public void setPrefvalue(String prefvalue) {
		this.prefvalue = prefvalue;
	}
	@Override
	public String toString() {
		return "UserPreference [userid=" + userid + ", prefkey=" + prefkey + ", prefvalue=" + prefvalue + "]";
	}
	public UserPreference(String userid, String prefkey, String prefvalue) {
		super();
		this.userid = userid;
		this.prefkey = prefkey;
		this.prefvalue = prefvalue;
	}
	public UserPreference() {
		super();
	
	}
	
	
}
