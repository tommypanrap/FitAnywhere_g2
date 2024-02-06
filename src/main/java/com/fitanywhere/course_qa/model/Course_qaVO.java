package com.fitanywhere.course_qa.model;

import java.util.Date;

public class Course_qaVO implements java.io.Serializable {
	private Integer qaId;
	private Integer qaStatus;
	private String qaTitle;
	private Integer uId;
	private Date qaDate;
	private byte[] qaPhoto;
	private Integer crId;

	public Course_qaVO(Integer qaId, Integer qaStatus, String qaTitle, Integer uId, Date qaDate, byte[] qaPhoto,
			Integer crId) {
		super();
		this.qaId = qaId;
		this.qaStatus = qaStatus;
		this.qaTitle = qaTitle;
		this.uId = uId;
		this.qaDate = qaDate;
		this.qaPhoto = qaPhoto;
		this.crId = crId;
	}

	public Course_qaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getQaId() {
		return qaId;
	}

	public void setQaId(Integer qaId) {
		this.qaId = qaId;
	}

	public Integer getQaStatus() {
		return qaStatus;
	}

	public void setQaStatus(Integer qaStatus) {
		this.qaStatus = qaStatus;
	}

	public String getQaTitle() {
		return qaTitle;
	}

	public void setQaTitle(String qaTitle) {
		this.qaTitle = qaTitle;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public Date getQaDate() {
		return qaDate;
	}

	public void setQaDate(Date qaDate) {
		this.qaDate = qaDate;
	}

	public byte[] getQaPhoto() {
		return qaPhoto;
	}

	public void setQaPhoto(byte[] qaPhoto) {
		this.qaPhoto = qaPhoto;
	}

	public Integer getCrId() {
		return crId;
	}

	public void setCrId(Integer crId) {
		this.crId = crId;
	}

}
