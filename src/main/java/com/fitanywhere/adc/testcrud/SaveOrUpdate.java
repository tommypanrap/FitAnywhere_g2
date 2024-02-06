package com.fitanywhere.adc.testcrud;

import org.hibernate.Session;

import com.fitanywhere.adcarouselorder.model.AdCarouselOrderVO;
import com.util.HibernateUtil;

public class SaveOrUpdate {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			
			AdCarouselOrderVO adcVO = new AdCarouselOrderVO();
//			adcVO.set
			
		}catch(Exception e) {
			
			
		}
	}
}
