package com.fitanywhere.user.model;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.fitanywhere.user.model.UserDAO;
import com.fitanywhere.user.model.UserVO;
import com.util.HibernateUtil;
import java.util.Date;
import org.hibernate.query.Query;

public class UserDAOImpl implements UserDAO {

//	會員註冊方法
	@Override
	public UserVO registerUser(UserVO user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// 開始transaction
			transaction = session.beginTransaction();

			// 設置預設值
			user.setuVerified(1); // 預設已驗證 因為目前註冊時強制驗證 (0=未驗證)
			user.setuCoach(0); // 預設不是教練 (1 = 教練)
			user.setuStatus(0); // 預設會員啟動狀態 
			user.setuRegisterdate(new Date()); // 設置註冊時間為當前時間

			// 保存會員信息
			session.save(user);

			// 提交transaction
			transaction.commit();

			System.out.println("註冊成功, 會員 ID: " + user.getuID());
			return user; // 返回包含生成的 u_id 的 user 對象
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback(); 
			}
			System.out.println("註冊失敗");
			e.printStackTrace();
			return null; // 如有異常返回 null
		}
	}

//    ======================================================
//    檢查會員的註冊資料(不重複)
	@Override
	public boolean registerCheck(String uNickname, String uPhone, String uMail) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "FROM UserVO WHERE lower(uNickname) = lower(:uNickname) OR lower(uPhone) = lower(:uPhone) OR lower(uMail) = lower(:uMail)";
//			UserVO是表示用戶的實體類，將Query的類型參數指定為UserVO。
			Query<UserVO> query = session.createQuery(hql, UserVO.class);
			query.setParameter("uNickname", uNickname);
			query.setParameter("uPhone", uPhone);
			query.setParameter("uMail", uMail);

			return !query.list().isEmpty(); // 如果查詢結果不為空，表示有重複，返回 true
		} catch (Exception e) {
			e.printStackTrace();
			return true; // 如有異常，預設為存在重複，防止重複數據的註冊
		}
	}

//    ======================================================
//	以uMail查詢會員資料
	@Override
    public UserVO loginVerification(String uMail) {
        UserVO user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM UserVO WHERE uMail = :uMail";
            Query<UserVO> query = session.createQuery(hql, UserVO.class);
            query.setParameter("uMail", uMail);
            user = query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
	
//  ======================================================


}
