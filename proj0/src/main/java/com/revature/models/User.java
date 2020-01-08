package com.revature.models;

public class User {
	private String uname;
	private String pword;
	private int employ;
	
	public User(String uname, String pword, int employ) {
		super();
		this.uname = uname;
		this.pword = pword;
		this.employ = employ;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPword() {
		return pword;
	}	
	public void setEmploy(int employ) {
		this.employ = employ;
	}
	public int getEmploy() {
		return employ;
	}
}
