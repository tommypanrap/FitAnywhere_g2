package com.fitanywhere.opinion.model;

import java.util.List;

public class OpinionService {
    private OpinionDAOImpl dao;

    public OpinionService() {
        dao = new OpinionDAOImpl();
    }

    public String getNickNameByUserID(int userID) {
        return dao.getNickNameByUserID(userID);
    }

    public void createOpinion(OpinionVO opinion) {
        dao.createOpinion(opinion);
    }
    
    public int countOpinionsByUserID(int userID) {
    	return dao.countOpinionsByUserID(userID);
    }

    public List<OpinionVO> getAllOpinionsByUserID(int userID, int pageNo, int pageSize) {
        return dao.getAllOpinionsByUserID(userID, pageSize, pageSize);
    }

    public void replyToOpinion(int opinionID, String replyContent) {
        dao.replyToOpinion(opinionID, replyContent);
    }

    public OpinionVO getOpinionDetails(int opinionID) {
        return dao.getOpinionDetails(opinionID);
    }
}

