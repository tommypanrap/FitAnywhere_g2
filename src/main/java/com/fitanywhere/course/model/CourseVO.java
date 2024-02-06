package com.fitanywhere.course.model;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fitanywhere.adrecommandorder.model.AdRecommandOrderVO;

@Entity
@Table(name = "course")
public class CourseVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cr_id")
	private Integer crId;

	@Column(name = "u_id")
	private Integer uId;

	@Column(name = "cr_class")
	private String crClass;

	@Column(name = "cr_status")
	private Integer crStatus;

	@Column(name = "cr_subtitle")
	private String crSubtitle;

	@Transient
	@Column(name = "cr_intro", columnDefinition = "longtext")
	private String crIntro;

	@Column(name = "cr_cover", columnDefinition = "longblob")
	private byte[] crCover;

	@Column(name = "cr_price")
	private Integer crPrice;

	@Column(name = "cr_create_date")
	private Timestamp crCreateDate;

	@Column(name = "cr_edit_date")
	private Timestamp crEditDate;

	@Column(name = "cr_cm_quan")
	private Integer crCmQuan;

	@Column(name = "cr_tot_star")
	private Integer crTotStar;

	@Column(name = "cr_purpose_1")
	private String crPurpose1;

	@Column(name = "cr_purpose_2")
	private String crPurpose2;

	@Column(name = "cr_purpose_3")
	private String crPurpose3;

	@Column(name = "cr_pre")
	private String crPre;

	@Column(name = "cr_target_1")
	private String crTarget1;

	@Column(name = "cr_hello_msg", columnDefinition = "longtext")
	private String crHelloMsg;

	@Column(name = "cr_cong", columnDefinition = "longtext")
	private String crCong;

	@Column(name = "cr_level")
	private String crLevel;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private Set<AdRecommandOrderVO> adr;

	public CourseVO() {
		super();
	}

	public CourseVO(Integer crId, Integer uId, String crClass, Integer crStatus, String crSubtitle, String crIntro,
			byte[] crCover, Integer crPrice, Timestamp crCreateDate, Timestamp crEditDate, Integer crCmQuan,
			Integer crTotStar, String crPurpose1, String crPurpose2, String crPurpose3, String crPre, String crTarget1,
			String crHelloMsg, String crCong, String crLevel) {
		super();
		this.crId = crId;
		this.uId = uId;
		this.crClass = crClass;
		this.crStatus = crStatus;
		this.crSubtitle = crSubtitle;
		this.crIntro = crIntro;
		this.crCover = crCover;
		this.crPrice = crPrice;
		this.crCreateDate = crCreateDate;
		this.crEditDate = crEditDate;
		this.crCmQuan = crCmQuan;
		this.crTotStar = crTotStar;
		this.crPurpose1 = crPurpose1;
		this.crPurpose2 = crPurpose2;
		this.crPurpose3 = crPurpose3;
		this.crPre = crPre;
		this.crTarget1 = crTarget1;
		this.crHelloMsg = crHelloMsg;
		this.crCong = crCong;
		this.crLevel = crLevel;
	}

	@Override
	public String toString() {
		return "CourseVO [crId=" + crId + ", uId=" + uId + ", crClass=" + crClass + ", crStatus=" + crStatus
				+ ", crSubtitle=" + crSubtitle + ", crIntro=" + crIntro + ", crCover=" + Arrays.toString(crCover)
				+ ", crPrice=" + crPrice + ", crCreateDate=" + crCreateDate + ", crEditDate=" + crEditDate
				+ ", crCmQuan=" + crCmQuan + ", crTotStar=" + crTotStar + ", crPurpose1=" + crPurpose1 + ", crPurpose2="
				+ crPurpose2 + ", crPurpose3=" + crPurpose3 + ", crPre=" + crPre + ", crTarget1=" + crTarget1
				+ ", crHelloMsg=" + crHelloMsg + ", crCong=" + crCong + ", crLevel=" + crLevel + ", adr=" + adr + "]";
	}

	public Integer getCrId() {
		return crId;
	}

	public void setCrId(Integer crId) {
		this.crId = crId;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getCrClass() {
		return crClass;
	}

	public void setCrClass(String crClass) {
		this.crClass = crClass;
	}

	public Integer getCrStatus() {
		return crStatus;
	}

	public void setCrStatus(Integer crStatus) {
		this.crStatus = crStatus;
	}

	public String getCrSubtitle() {
		return crSubtitle;
	}

	public void setCrSubtitle(String crSubtitle) {
		this.crSubtitle = crSubtitle;
	}

	public String getCrIntro() {
		return crIntro;
	}

	public void setCrIntro(String crIntro) {
		this.crIntro = crIntro;
	}

	public byte[] getCrCover() {
		return crCover;
	}

	public void setCrCover(byte[] crCover) {
		this.crCover = crCover;
	}

	public Integer getCrPrice() {
		return crPrice;
	}

	public void setCrPrice(Integer crPrice) {
		this.crPrice = crPrice;
	}

	public Timestamp getCrCreateDate() {
		return crCreateDate;
	}

	public void setCrCreateDate(Timestamp crCreateDate) {
		this.crCreateDate = crCreateDate;
	}

	public Timestamp getCrEditDate() {
		return crEditDate;
	}

	public void setCrEditDate(Timestamp crEditDate) {
		this.crEditDate = crEditDate;
	}

	public Integer getCrCmQuan() {
		return crCmQuan;
	}

	public void setCrCmQuan(Integer crCmQuan) {
		this.crCmQuan = crCmQuan;
	}

	public Integer getCrTotStar() {
		return crTotStar;
	}

	public void setCrTotStar(Integer crTotStar) {
		this.crTotStar = crTotStar;
	}

	public String getCrPurpose1() {
		return crPurpose1;
	}

	public void setCrPurpose1(String crPurpose1) {
		this.crPurpose1 = crPurpose1;
	}

	public String getCrPurpose2() {
		return crPurpose2;
	}

	public void setCrPurpose2(String crPurpose2) {
		this.crPurpose2 = crPurpose2;
	}

	public String getCrPurpose3() {
		return crPurpose3;
	}

	public void setCrPurpose3(String crPurpose3) {
		this.crPurpose3 = crPurpose3;
	}

	public String getCrPre() {
		return crPre;
	}

	public void setCrPre(String crPre) {
		this.crPre = crPre;
	}

	public String getCrTarget1() {
		return crTarget1;
	}

	public void setCrTarget1(String crTarget1) {
		this.crTarget1 = crTarget1;
	}

	public String getCrHelloMsg() {
		return crHelloMsg;
	}

	public void setCrHelloMsg(String crHelloMsg) {
		this.crHelloMsg = crHelloMsg;
	}

	public String getCrCong() {
		return crCong;
	}

	public void setCrCong(String crCong) {
		this.crCong = crCong;
	}

	public String getCrLevel() {
		return crLevel;
	}

	public void setCrLevel(String crLevel) {
		this.crLevel = crLevel;
	}

	public Set<AdRecommandOrderVO> getAdr() {
		return adr;
	}

	public void setAdr(Set<AdRecommandOrderVO> adr) {
		this.adr = adr;
	}
	

}
