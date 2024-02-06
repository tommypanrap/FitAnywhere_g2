package com.fitanywhere.course_detail.model;

import java.util.Arrays;

public class Course_detailVO implements java.io.Serializable {
	private Integer cdId;
	private Integer crId;
	private byte[] cdVideo;
	private byte[] saleVideo;
	private String cdUrl;
	private byte[] cdPdf;

	public Course_detailVO(Integer cdId, Integer crId, byte[] cdVideo, byte[] saleVideo, String cdUrl, byte[] cdPdf) {
		super();
		this.cdId = cdId;
		this.crId = crId;
		this.cdVideo = cdVideo;
		this.saleVideo = saleVideo;
		this.cdUrl = cdUrl;
		this.cdPdf = cdPdf;
	}

	public Course_detailVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCdId() {
		return cdId;
	}

	public void setCdId(Integer cdId) {
		this.cdId = cdId;
	}

	public Integer getCrId() {
		return crId;
	}

	public void setCrId(Integer crId) {
		this.crId = crId;
	}

	public byte[] getCdVideo() {
		return cdVideo;
	}

	public void setCdVideo(byte[] cdVideo) {
		this.cdVideo = cdVideo;
	}

	public byte[] getSaleVideo() {
		return saleVideo;
	}

	public void setSaleVideo(byte[] saleVideo) {
		this.saleVideo = saleVideo;
	}

	public String getCdUrl() {
		return cdUrl;
	}

	public void setCdUrl(String cdUrl) {
		this.cdUrl = cdUrl;
	}

	public byte[] getCdPdf() {
		return cdPdf;
	}

	public void setCdPdf(byte[] cdPdf) {
		this.cdPdf = cdPdf;
	}
}
