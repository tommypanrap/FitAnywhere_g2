package com.adcarouselorder.model;

import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ad_carousel_order")
public class AdCarouselOrderVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adc_id")
	private Integer adcId;
	
	@Column(name = "ad_id", updatable = false)
	private Integer adId;
	
	@Column(name = "u_id", updatable = false)
	private Integer uId;
	
	@Column(name = "cr_id", updatable = false)
	private Integer crId;
	
	@Column(name = "adc_start_date")
	private Timestamp adcStartDate;
	
	@Column(name = "adc_end_date")
	private Timestamp adcEndDate;
	
	@Column(name = "adc_total_price")
	private Integer adcTotalPrice;
	
	@Column(name = "adc_update_pic" ,columnDefinition = "longblob")
	private byte[] adcUpdatePic;
	
	@Column(name = "adc_status")
	private Integer adcStatus;
	
	@Column(name = "adc_order_enddate")
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

	@Override
	public String toString() {
		return "AdCarouselOrderVO [adcId=" + adcId + ", adId=" + adId + ", uId=" + uId + ", crId=" + crId
				+ ", adcStartDate=" + adcStartDate + ", adcEndDate=" + adcEndDate + ", adcTotalPrice=" + adcTotalPrice
				+ ", adcUpdatePic=" + Arrays.toString(adcUpdatePic) + ", adcStatus=" + adcStatus + ", adcOrderEnddate="
				+ adcOrderEnddate + "]";
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

	public Integer getUId() {
		return uId;
	}

	public void setUId(Integer uId) {
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
	
	

}
