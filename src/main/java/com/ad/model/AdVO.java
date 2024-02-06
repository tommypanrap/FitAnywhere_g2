package com.ad.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.adrecommandorder.model.AdRecommandOrderVO;

@Entity
@Table(name = "ad")
public class AdVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ad_id")
	private Integer adId;
	
	@Column(name = "ad_name")
	private String adName;
	
	@Column(name = "ad_vaild_date")
	private Timestamp adVaildDate;
	
	@Column(name = "ad_day_price")
	private Integer adDayPrice;

	@OneToMany(mappedBy = "adVO", cascade = CascadeType.ALL)
	private Set<AdRecommandOrderVO> adrs;
	
	
	public AdVO() {
		super();
	}

	public AdVO(Integer adId, String adName, Timestamp adVaildDate, Integer adDayPrice) {
		super();
		this.adId = adId;
		this.adName = adName;
		this.adVaildDate = adVaildDate;
		this.adDayPrice = adDayPrice;
	}

	public Integer getAdId() {
		return adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public Timestamp getAdVaildDate() {
		return adVaildDate;
	}

	public void setAdVaildDate(Timestamp adVaildDate) {
		this.adVaildDate = adVaildDate;
	}

	public Integer getAdDayPrice() {
		return adDayPrice;
	}

	public void setAdDayPrice(Integer adDayPrice) {
		this.adDayPrice = adDayPrice;
	}

	@Override
	public String toString() {
		return "adVO [adId=" + adId + ", adName=" + adName + ", adVaildDate=" + adVaildDate + ", adDayPrice="
				+ adDayPrice + "]";
	}

	
}
