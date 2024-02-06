package com.user.model;

import java.sql.Date;
import java.util.List;


public class UserService {

	private UserDAO_interface dao;

	public UserService() {
		dao = new UserDAO();
	}
	
	UserHibernate userHibernate = new UserHibernate();

	public UserVO addUser(Integer uId, Integer moodId, String uNickname, String uName, String uMail, String uPassword,
			String uPhone, Integer uVerified, Integer uCoach, String uGender, Integer uAge, byte[] uHeadshot,
			Date uBirth, Integer uStatus, String cIntro) {

		UserVO userVO = new UserVO();


		userVO.setuId(uId);
		userVO.setmoodId(moodId);
		userVO.setuNickname(uNickname);
		userVO.setuName(uName);
		userVO.setuMail(uMail);
		userVO.setuPassword(uPassword);
		userVO.setuPhone(uPhone);
		userVO.setuVerified(uVerified);
		userVO.setuCoach(uCoach);
		userVO.setuGender(uGender);
		userVO.setuAge(uAge);
		userVO.setuHeadshot(uHeadshot);
		userVO.setuBirth(uBirth);
		userVO.setuStatus(uStatus);
		userVO.setcIntro(cIntro);

//		dao.insert(userVo);
		userHibernate.insert(userVO);
		return userVO;
	}

	public UserVO updateUser(Integer uId, Integer moodId, String uNickname, String uName, String uMail, String uPassword,
			String uPhone, Integer uVerified, Integer uCoach, String uGender, Integer uAge, byte[] uHeadshot,
			Date uBirth, Integer uStatus, String cIntro) {

		UserVO userVO = new UserVO();

		userVO.setuId(uId);
		userVO.setmoodId(moodId);
		userVO.setuNickname(uNickname);
		userVO.setuName(uName);
		userVO.setuMail(uMail);
		userVO.setuPassword(uPassword);
		userVO.setuPhone(uPhone);
		userVO.setuVerified(uVerified);
		userVO.setuCoach(uCoach);
		userVO.setuGender(uGender);
		userVO.setuAge(uAge);
		userVO.setuHeadshot(uHeadshot);
		userVO.setuBirth(uBirth);
		userVO.setuStatus(uStatus);
		userVO.setcIntro(cIntro);

		userHibernate.update(userVO);

		return userVO;
	}

	public UserVO getOneUser(Integer uId) {
		return userHibernate.findByPrimaryKey(uId);
	}

	public void deleteUser(Integer uId) {
		dao.delete(uId);
	}

	public List<UserVO> getAll() {
		return dao.getAll();
	}
}
