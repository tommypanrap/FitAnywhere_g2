package com.user.model;

import java.io.Serializable;
import java.sql.Date;

public class UserVo implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer uId;
	private Integer moodId;
	private String uNickname;
	private String uName;
	private String uMail;
	private String uPassword;
	private String uPhone;
	private Integer uVerified;
	private Integer uCoach;
	private String uGender;
	private Integer uAge;
	private byte[] uHeadshot;
	private Date uBirth;
	private Integer uStatus;
	private String cIntro;

	public UserVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserVo(Integer uId, Integer moodId, String uNickname, String uName, String uMail, String uPassword,
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
