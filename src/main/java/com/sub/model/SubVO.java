package com.sub.model;
import java.sql.Date;

public class SubVO implements java.io.Serializable{
	private Integer suId;
	private Integer uId;
	private Integer coachId;
	private Integer subStatus;
	

	public SubVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public SubVO(Integer suId, Integer uId, Integer coachId, Integer subStatus) {
		super();
		this.suId = suId;
		this.uId = uId;
		this.coachId = coachId;
		this.subStatus = subStatus;
	}



	public Integer getSuId() {
		return suId;
	}

	public void setSuId(Integer suId) {
		this.suId = suId;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public Integer getCoachId() {
		return coachId;
	}

	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
	}

	public Integer getSubStatus() {
		return subStatus;
	}

	public void setSubStatus(Integer subStatus) {
		this.subStatus = subStatus;
	}
	
	
	
	
}
	
	
	
	