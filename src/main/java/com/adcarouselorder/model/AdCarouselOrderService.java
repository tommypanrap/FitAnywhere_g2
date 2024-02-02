package com.adcarouselorder.model;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class AdCarouselOrderService {

	private AdCarouselOrderDAO_interface dao;

	public AdCarouselOrderService() {
		dao = new AdCarouselOrderDAO();
	}

	public AdCarouselOrderVO addAdc(Integer adId, Integer uId, Integer crId,
			java.sql.Timestamp adcStartDate, java.sql.Timestamp adcEndDate, Integer adcTotalPrice, byte[] adcUpdatePic,
			Integer adcStatus, java.sql.Timestamp adcOrderEnddate) {

		AdCarouselOrderVO adCarouselOrderVO = new AdCarouselOrderVO();

		adCarouselOrderVO = new AdCarouselOrderVO();

//		adCarouselOrderVO.setAdId(adcId);
		adCarouselOrderVO.setAdId(adId);
		adCarouselOrderVO.setuId(uId);
		adCarouselOrderVO.setCrId(crId);
		adCarouselOrderVO.setAdcStartDate(adcStartDate);
		adCarouselOrderVO.setAdcEndDate(adcEndDate);
		adCarouselOrderVO.setAdcTotalPrice(adcTotalPrice);
		adCarouselOrderVO.setAdcUpdatePic(adcUpdatePic);
		adCarouselOrderVO.setAdcStatus(adcStatus);
		adCarouselOrderVO.setAdcOrderEnddate(adcOrderEnddate);
		dao.insert(adCarouselOrderVO);

		return adCarouselOrderVO;
	}

	public void addAdc(AdCarouselOrderVO adCarouselOrderVO) {
		dao.insert(adCarouselOrderVO);
	}

	public AdCarouselOrderVO updateAdc(Integer adcId, Integer adId, Integer uId, Integer crId,
			java.sql.Timestamp adcStartDate, java.sql.Timestamp adcEndDate, Integer adcTotalPrice, byte[] adcUpdatePic,
			Integer adcStatus, java.sql.Timestamp adcOrderEnddate) {

		AdCarouselOrderVO adCarouselOrderVO = new AdCarouselOrderVO();

		adCarouselOrderVO = new AdCarouselOrderVO();

		adCarouselOrderVO.setAdcId(adcId);
		adCarouselOrderVO.setAdId(adId);
		adCarouselOrderVO.setuId(uId);
		adCarouselOrderVO.setCrId(crId);
		adCarouselOrderVO.setAdcStartDate(adcStartDate);
		adCarouselOrderVO.setAdcEndDate(adcEndDate);
		adCarouselOrderVO.setAdcTotalPrice(adcTotalPrice);
		adCarouselOrderVO.setAdcUpdatePic(adcUpdatePic);
		adCarouselOrderVO.setAdcStatus(adcStatus);
		adCarouselOrderVO.setAdcOrderEnddate(adcOrderEnddate);
		dao.update(adCarouselOrderVO);

		return dao.findByPrimaryKey(adcId);
	}

	public void updateAdc(AdCarouselOrderVO adCarouselOrderVO) {
	    dao.update(adCarouselOrderVO);
	}

	public void deleteAdc(Integer adcId) {
		dao.delete(adcId);
	}

	
	
	public AdCarouselOrderVO getOneAdc(Integer adcId) {

		return dao.findByPrimaryKey(adcId);
	}

	public List<AdCarouselOrderVO> getAll() {
		return dao.getAll();
	}

}
