package com.fitanywhere.announcement.model;

import java.sql.Date;

public class AnnouncementVO implements java.io.Serializable {
	private Integer anId;
	private Integer crId;
	private Date anDate;
	private Date anEditDate;
	private String anTitle;
	private String anContent;

	public AnnouncementVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnnouncementVO(Integer anId, Integer crId, Date anDate, Date anEditDate, String anTitle, String anContent) {
		super();
		this.anId = anId;
		this.crId = crId;
		this.anDate = anDate;
		this.anEditDate = anEditDate;
		this.anTitle = anTitle;
		this.anContent = anContent;
	}

	public Integer getAnId() {
		return anId;
	}

	public void setAnId(Integer anId) {
		this.anId = anId;
	}

	public Integer getCrId() {
		return crId;
	}

	public void setCrId(Integer crId) {
		this.crId = crId;
	}

	public Date getAnDate() {
		return anDate;
	}

	public void setAnDate(Date anDate) {
		this.anDate = anDate;
	}

	public Date getAnEditDate() {
		return anEditDate;
	}

	public void setAnEditDate(Date anEditDate) {
		this.anEditDate = anEditDate;
	}

	public String getAnTitle() {
		return anTitle;
	}

	public void setAnTitle(String anTitle) {
		this.anTitle = anTitle;
	}

	public String getAnContent() {
		return anContent;
	}

	public void setAnContent(String anContent) {
		this.anContent = anContent;
	}

}
