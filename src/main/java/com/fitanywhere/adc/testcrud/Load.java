package com.fitanywhere.adc.testcrud;

import org.hibernate.Session;

import com.fitanywhere.adcarouselorder.model.AdCarouselOrderVO;
import com.fitanywhere.util.HibernateUtil;

public class Load {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();

			AdCarouselOrderVO getAdc = session.get(AdCarouselOrderVO.class, 1);
			System.out.println(getAdc);
			
//			AdCarouselOrderVO loadAdc = session.load(AdCarouselOrderVO.class, 2);
//			Hibernate.initialize(loadAdc);
//			session.getTransaction().commit();
//			System.out.println(loadAdc);
			
			
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		
	}

}
