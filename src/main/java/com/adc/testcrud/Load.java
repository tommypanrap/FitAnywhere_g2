package com.adc.testcrud;

import org.hibernate.Session;

public class Load {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	}

}
