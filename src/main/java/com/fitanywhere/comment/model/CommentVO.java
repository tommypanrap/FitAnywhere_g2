package com.fitanywhere.comment.model;

import java.util.Date;

public class CommentVO implements java.io.Serializable {

	private Integer cmId;
	private Integer crId;
	private String cmContent;
	private Date cmDate;
	private Integer cmStar;
	private Integer cmStatus;
	private Integer uId;

	public CommentVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentVO(Integer cmId, Integer crId, String cmContent, Date cmDate, Integer cmStar, Integer cmStatus,
			Integer uId) {
		super();
		this.cmId = cmId;
		this.crId = crId;
		this.cmContent = cmContent;
		this.cmDate = cmDate;
		this.cmStar = cmStar;
		this.cmStatus = cmStatus;
		this.uId = uId;
	}

	public Integer getCmId() {
		return cmId;
	}

	public void setCmId(Integer cmId) {
		this.cmId = cmId;
	}

	public Integer getCrId() {
		return crId;
	}

	public void setCrId(Integer crId) {
		this.crId = crId;
	}

	public String getCmContent() {
		return cmContent;
	}

	public void setCmContent(String cmContent) {
		this.cmContent = cmContent;
	}

	public Date getCmDate() {
		return cmDate;
	}

	public void setCmDate(Date cmDate) {
		this.cmDate = cmDate;
	}

	public Integer getCmStar() {
		return cmStar;
	}

	public void setCmStar(Integer cmStar) {
		this.cmStar = cmStar;
	}

	public Integer getCmStatus() {
		return cmStatus;
	}

	public void setCmStatus(Integer cmStatus) {
		this.cmStatus = cmStatus;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

}
