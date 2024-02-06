package com.sub.model;

import java.util.List;
import java.util.Set;
import com.sub.model.SubVO;

public class SubService {

	private SubDAO_interface dao;

	public SubService() {
		dao = new SubDAO();
	}

	public List<SubVO> getAll() {
		return dao.getAll();
	}

	public SubVO getOneSub(Integer uId) {
		return dao.findByPrimaryKey(uId);
	}


	public void deleteSub(Integer su_id) {
		dao.delete(su_id);
	}	
	
	public SubVO updateSub(Integer suId, Integer uId, Integer coachId, Integer subStatus) {
		SubVO subVO = new SubVO();
		
		subVO.setSuId(suId);
		subVO.setuId(uId);
		subVO.setCoachId(coachId);
		subVO.setSubStatus(subStatus);
		dao.update(subVO);
		return subVO;
	}
	
	public SubVO addSub(Integer uId, Integer coachId, Integer subStatus) {
		
		SubVO subVO = new SubVO();
		subVO.setuId(uId);
		subVO.setCoachId(coachId);
		subVO.setSubStatus(subStatus);
		dao.insert(subVO);
		return subVO;		
	}		
}
