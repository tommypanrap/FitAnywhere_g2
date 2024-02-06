package com.fitanywhere.user.model;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fitanywhere.util.HibernateUtil;

public class UserHibernate implements UserDAO_interface {

	@Override
	public void insert(UserVO userVO) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(userVO);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		}
	}

	@Override
	public void update(UserVO userVO) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(userVO);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} 
	}

	@Override
	public UserVO findByPrimaryKey(Integer uId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		UserVO userVO = null;

		try {
			session.beginTransaction();
			userVO = session.get(UserVO.class, uId);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
		}
		return userVO;
	}

	@Override
	public List<UserVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer uId) {
		// TODO Auto-generated method stub

	}
}
