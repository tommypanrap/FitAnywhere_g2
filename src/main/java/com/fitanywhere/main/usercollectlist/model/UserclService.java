package com.fitanywhere.main.usercollectlist.model;

import java.util.List;

public class UserclService {
	
	private UserclDAO_interface dao;
	
	public UserclService() {
		dao = new UserclDAO();
	}
	
	public UserclVO addCollect(Integer crid, Integer uid, Integer cstatus) {
		
		UserclVO userclVO = new UserclVO();
		
		userclVO.setCrid(crid);
		userclVO.setUid(uid);
		userclVO.setCstatus(crid);
		dao.insert(userclVO);
		
		return userclVO;
	}
	
	public UserclVO updateCollect(Integer crid, Integer uid, Integer cstatus) {
		
		UserclVO userclVO = new UserclVO();
		
		userclVO.setCrid(crid);
		userclVO.setUid(uid);
		userclVO.setCstatus(cstatus);
			
		dao.update(userclVO);
		
		return userclVO;
	}
	
	public void deleteCollect(Integer crid, Integer uid) {
		dao.delete(crid,uid);
	}
	
	public UserclVO getOneCollect(Integer crid, Integer uid) {
		return dao.findByPrimaryKey(crid,uid);
	}
	
	public List<UserclVO> getAll(){
		return dao.getAll();
	}
	
	
}
