package com.fitanywhere.main.usercollectlist.model;

public class UserclVO {
	private Integer crid;
	private Integer uid;
	private Integer cstatus;
	
	public Integer getCrid() {
		return crid;
	}
	public void setCrid(Integer crid) {
		this.crid = crid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getCstatus() {
		return cstatus;
	}
	public void setCstatus(Integer cstatus) {
		System.out.println("vo cstatus"+cstatus);
		this.cstatus = cstatus;
	}
	
	
}
