package com.user.model;

import java.sql.Date;
import java.util.Arrays;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.adrecommandorder.model.AdRecommandOrderVO;

@Entity
@Table(name = "user")
public class UserVO {
	 @Id
	 @Column(name = "u_id")
	 private Integer uId;
	 @Column(name = "mood_id")
	 private Integer moodId;
	 @Column(name = "u_nickname")
	 private String uNickname;
	 @Column(name = "u_name")
	 private String uName;
	 @Column(name = "u_mail")
	 private String uMail;
	 @Column(name = "u_password")
	 private String uPassword;
	 @Column(name = "u_phone")
	 private String uPhone;
	 @Column(name = "u_verified")
	 private Integer uVerified;
	 @Column(name = "u_coach")
	 private Integer uCoach;
	 @Column(name = "u_gender")
	 private String uGender;
	 @Column(name = "u_age")
	 private Integer uAge;
	 @Column(name = "u_headshot", columnDefinition = "longblob")
	 private byte[] uHeadshot;
	 @Column(name = "u_birth")
	 private Date uBirth;
	 @Column(name = "u_status")
	 private Integer uStatus;

	 @Transient
	 @Column(name = "c_intro")
	 private String cIntro;
	 
	 @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	 @OrderBy("adr_id asc")
	 private Set<AdRecommandOrderVO> adrs;

	public UserVO() {
		super();
	}

	public UserVO(Integer uId, Integer moodId, String uNickname, String uName, String uMail, String uPassword,
			String uPhone, Integer uVerified, Integer uCoach, String uGender, Integer uAge, byte[] uHeadshot,
			Date uBirth, Integer uStatus, String cIntro) {
		super();
		this.uId = uId;
		this.moodId = moodId;
		this.uNickname = uNickname;
		this.uName = uName;
		this.uMail = uMail;
		this.uPassword = uPassword;
		this.uPhone = uPhone;
		this.uVerified = uVerified;
		this.uCoach = uCoach;
		this.uGender = uGender;
		this.uAge = uAge;
		this.uHeadshot = uHeadshot;
		this.uBirth = uBirth;
		this.uStatus = uStatus;
		this.cIntro = cIntro;
	}

	@Override
	public String toString() {
		return "UserVO [uId=" + uId + ", moodId=" + moodId + ", uNickname=" + uNickname + ", uName=" + uName
				+ ", uMail=" + uMail + ", uPassword=" + uPassword + ", uPhone=" + uPhone + ", uVerified=" + uVerified
				+ ", uCoach=" + uCoach + ", uGender=" + uGender + ", uAge=" + uAge + ", uHeadshot="
				+ Arrays.toString(uHeadshot) + ", uBirth=" + uBirth + ", uStatus=" + uStatus + ", cIntro=" + cIntro
				+ "]";
	}

	public Integer getUId() {
		return uId;
	}

	public void setUId(Integer uId) {
		this.uId = uId;
	}

	public Integer getMoodId() {
		return moodId;
	}

	public void setMoodId(Integer moodId) {
		this.moodId = moodId;
	}

	public String getUNickname() {
		return uNickname;
	}

	public void setUNickname(String uNickname) {
		this.uNickname = uNickname;
	}

	public String getUName() {
		return uName;
	}

	public void setUName(String uName) {
		this.uName = uName;
	}

	public String getUMail() {
		return uMail;
	}

	public void setUMail(String uMail) {
		this.uMail = uMail;
	}

	public String getUPassword() {
		return uPassword;
	}

	public void setUPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getUPhone() {
		return uPhone;
	}

	public void setUPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	public Integer getUVerified() {
		return uVerified;
	}

	public void setUVerified(Integer uVerified) {
		this.uVerified = uVerified;
	}

	public Integer getUCoach() {
		return uCoach;
	}

	public void setUCoach(Integer uCoach) {
		this.uCoach = uCoach;
	}

	public String getUGender() {
		return uGender;
	}

	public void setUGender(String uGender) {
		this.uGender = uGender;
	}

	public Integer getUAge() {
		return uAge;
	}

	public void setUAge(Integer uAge) {
		this.uAge = uAge;
	}

	public byte[] getUHeadshot() {
		return uHeadshot;
	}

	public void setUHeadshot(byte[] uHeadshot) {
		this.uHeadshot = uHeadshot;
	}

	public Date getUBirth() {
		return uBirth;
	}

	public void setUBirth(Date uBirth) {
		this.uBirth = uBirth;
	}

	public Integer getUStatus() {
		return uStatus;
	}

	public void setUStatus(Integer uStatus) {
		this.uStatus = uStatus;
	}

	public String getCIntro() {
		return cIntro;
	}

	public void setCIntro(String cIntro) {
		this.cIntro = cIntro;
	}
	
}
