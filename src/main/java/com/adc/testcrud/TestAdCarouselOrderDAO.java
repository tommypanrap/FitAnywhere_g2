package com.adc.testcrud;

import com.adcarouselorder.model.AdCarouselOrderDAO;
import com.adcarouselorder.model.AdCarouselOrderDAOImpl;
import com.adcarouselorder.model.AdCarouselOrderVO;

public class TestAdCarouselOrderDAO {
	public static void main(String[] args) {
		

		   
		AdCarouselOrderDAO dao = new AdCarouselOrderDAOImpl();
		
		// 新增
		AdCarouselOrderVO adcVO = new AdCarouselOrderVO();
//		adcVO.setAdcId(4);
//		adcVO.setAdId(4);
//		adcVO.setuId(4);
//		adcVO.setCrId(4);
		adcVO.setAdcStartDate(java.sql.Timestamp.valueOf("2023-01-15 10:00:00"));
		adcVO.setAdcEndDate(java.sql.Timestamp.valueOf("2023-03-15 10:12:00"));
		adcVO.setAdcTotalPrice(500);
		adcVO.setAdcUpdatePic(null);
		adcVO.setAdcStatus(1);
		adcVO.setAdcOrderEnddate(java.sql.Timestamp.valueOf("2023-03-15 10:12:00"));
		dao.insert(adcVO);
		
	}

}
