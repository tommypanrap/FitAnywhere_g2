package com.user.model;

import java.sql.Date;
import java.util.List;


public class UserService {

	private UserDAO_interface dao;

	public UserService() {
		dao = new UserDAO();
	}

	public UserVO addUser(Integer uId, Integer moodId, String uNickname, String uName, String uMail, String uPassword,
			String uPhone, Integer uVerified, Integer uCoach, String uGender, Integer uAge, byte[] uHeadshot,
			Date uBirth, Integer uStatus, String cIntro) {

		UserVO userVo = new UserVO();

		userVo.setuId(uId);
		userVo.setmoodId(moodId);
		userVo.setuNickname(uNickname);
		userVo.setuName(uName);
		userVo.setuMail(uMail);
		userVo.setuPassword(uPassword);
		userVo.setuPhone(uPhone);
		userVo.setuVerified(uVerified);
		userVo.setuCoach(uCoach);
		userVo.setuGender(uGender);
		userVo.setuAge(uAge);
		userVo.setuHeadshot(uHeadshot);
		userVo.setuBirth(uBirth);
		userVo.setuStatus(uStatus);
		userVo.setcIntro(cIntro);

		dao.insert(userVo);
		return userVo;
	}

	public UserVO updateUser(Integer uId, Integer moodId, String uNickname, String uName, String uMail, String uPassword,
			String uPhone, Integer uVerified, Integer uCoach, String uGender, Integer uAge, byte[] uHeadshot,
			Date uBirth, Integer uStatus, String cIntro) {

		UserVO userVo = new UserVO();

		userVo.setuId(uId);
		userVo.setmoodId(moodId);
		userVo.setuNickname(uNickname);
		userVo.setuName(uName);
		userVo.setuMail(uMail);
		userVo.setuPassword(uPassword);
		userVo.setuPhone(uPhone);
		userVo.setuVerified(uVerified);
		userVo.setuCoach(uCoach);
		userVo.setuGender(uGender);
		userVo.setuAge(uAge);
		userVo.setuHeadshot(uHeadshot);
		userVo.setuBirth(uBirth);
		userVo.setuStatus(uStatus);
		userVo.setcIntro(cIntro);

		dao.update(userVo);

		return userVo;
	}

	public UserVO getOneUser(Integer uId) {
		return dao.findByPrimaryKey(uId);
	}

	public void deleteUser(Integer uId) {
		dao.delete(uId);
	}

	public List<UserVO> getAll() {
		return dao.getAll();
	}
}
