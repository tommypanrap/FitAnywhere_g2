package com.user.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserVO implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="u_id")
	private Integer uId;
	@Column(name="mood_id")
	private Integer moodId;
	@Column(name="u_nickname")
	private String uNickname;
	@Column(name="u_name")
	private String uName;
	@Column(name="u_mail")
	private String uMail;
	@Column(name="u_password")
	private String uPassword;
	@Column(name="u_phone")
	private String uPhone;
	@Column(name="u_verified")
	private Integer uVerified;
	@Column(name="u_coach")
	private Integer uCoach;
	@Column(name="u_gender")
	private String uGender;
	@Column(name="u_age")
	private Integer uAge;
	@Column(name="u_headshot",columnDefinition = "longblob")
	private byte[] uHeadshot;
	@Column(name="u_birth")
	private Date uBirth;
	@Column(name="u_status")
	private Integer uStatus;
	@Column(name="c_intro")
	private String cIntro;

	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
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


	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public Integer getmoodId() {
		return moodId;
	}

	public void setmoodId(Integer moodId) {
		this.moodId = moodId;
	}

	public String getuNickname() {
		return uNickname;
	}

	public void setuNickname(String uNickname) {
		this.uNickname = uNickname;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuMail() {
		return uMail;
	}

	public void setuMail(String uMail) {
		this.uMail = uMail;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuPhone() {
		return uPhone;
	}

	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	public Integer getuVerified() {
		return uVerified;
	}

	public void setuVerified(Integer uVerified) {
		this.uVerified = uVerified;
	}

	public Integer getuCoach() {
		return uCoach;
	}

	public void setuCoach(Integer uCoach) {
		this.uCoach = uCoach;
	}

	public String getuGender() {
		return uGender;
	}

	public void setuGender(String uGender) {
		this.uGender = uGender;
	}

	public Integer getuAge() {
		return uAge;
	}

	public void setuAge(Integer uAge) {
		this.uAge = uAge;
	}

	public byte[] getuHeadshot() {
		return uHeadshot;
	}

	public void setuHeadshot(byte[] uHeadshot) {
		this.uHeadshot = uHeadshot;
	}

	public Date getuBirth() {
		return uBirth;
	}

	public void setuBirth(Date uBirth) {
		this.uBirth = uBirth;
	}

	public Integer getuStatus() {
		return uStatus;
	}

	public void setuStatus(Integer uStatus) {
		this.uStatus = uStatus;
	}

	public String getcIntro() {
		return cIntro;
	}

	public void setcIntro(String cIntro) {
		this.cIntro = cIntro;
	}

}

