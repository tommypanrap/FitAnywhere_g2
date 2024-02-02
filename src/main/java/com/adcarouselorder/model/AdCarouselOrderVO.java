package com.adcarouselorder.model;

import java.sql.Timestamp;
import java.util.Arrays;

public class AdCarouselOrderVO {
	private Integer adcId;
	private Integer adId;
	private Integer uId;
	private Integer crId;
	private Timestamp adcStartDate;
	private Timestamp adcEndDate;
	private Integer adcTotalPrice;
	private byte[] adcUpdatePic;
	private Integer adcStatus;
	private Timestamp adcOrderEnddate;
	
	
	public AdCarouselOrderVO() {
		super();
	}


	public AdCarouselOrderVO(Integer adcId, Integer adId, Integer uId, Integer crId, Timestamp adcStartDate,
			Timestamp adcEndDate, Integer adcTotalPrice, byte[] adcUpdatePic, Integer adcStatus,
			Timestamp adcOrderEnddate) {
		super();
		this.adcId = adcId;
		this.adId = adId;
		this.uId = uId;
		this.crId = crId;
		this.adcStartDate = adcStartDate;
		this.adcEndDate = adcEndDate;
		this.adcTotalPrice = adcTotalPrice;
		this.adcUpdatePic = adcUpdatePic;
		this.adcStatus = adcStatus;
		this.adcOrderEnddate = adcOrderEnddate;
	}


	public Integer getAdcId() {
		return adcId;
	}


	public void setAdcId(Integer adcId) {
		this.adcId = adcId;
	}


	public Integer getAdId() {
		return adId;
	}


	public void setAdId(Integer adId) {
		this.adId = adId;
	}


	public Integer getuId() {
		return uId;
	}


	public void setuId(Integer uId) {
		this.uId = uId;
	}


	public Integer getCrId() {
		return crId;
	}


	public void setCrId(Integer crId) {
		this.crId = crId;
	}


	public Timestamp getAdcStartDate() {
		return adcStartDate;
	}


	public void setAdcStartDate(Timestamp adcStartDate) {
		this.adcStartDate = adcStartDate;
	}


	public Timestamp getAdcEndDate() {
		return adcEndDate;
	}


	public void setAdcEndDate(Timestamp adcEndDate) {
		this.adcEndDate = adcEndDate;
	}


	public Integer getAdcTotalPrice() {
		return adcTotalPrice;
	}


	public void setAdcTotalPrice(Integer adcTotalPrice) {
		this.adcTotalPrice = adcTotalPrice;
	}


	public byte[] getAdcUpdatePic() {
		return adcUpdatePic;
	}


	public void setAdcUpdatePic(byte[] adcUpdatePic) {
		this.adcUpdatePic = adcUpdatePic;
	}


	public Integer getAdcStatus() {
		return adcStatus;
	}


	public void setAdcStatus(Integer adcStatus) {
		this.adcStatus = adcStatus;
	}


	public Timestamp getAdcOrderEnddate() {
		return adcOrderEnddate;
	}


	public void setAdcOrderEnddate(Timestamp adcOrderEnddate) {
		this.adcOrderEnddate = adcOrderEnddate;
	}


	@Override
	public String toString() {
		return "AdCarouselOrderVO [adcId=" + adcId + ", adId=" + adId + ", uId=" + uId + ", crId=" + crId
				+ ", adcStartDate=" + adcStartDate + ", adcEndDate=" + adcEndDate + ", adcTotalPrice=" + adcTotalPrice
				+ ", adcUpdatePic=" + Arrays.toString(adcUpdatePic) + ", adcStatus=" + adcStatus + ", adcOrderEnddate="
				+ adcOrderEnddate + "]";
	}


}
