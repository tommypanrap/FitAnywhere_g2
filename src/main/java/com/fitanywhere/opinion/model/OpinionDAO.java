package com.fitanywhere.opinion.model;

import java.util.List;

public interface OpinionDAO {

    // 依據 uID 讀取 uNickName
    String getNickNameByUserID(int userID);

    // 用戶新增意見
    void createOpinion(OpinionVO opinion);
    
    // 計算用戶ID計算總筆數
    public int countOpinionsByUserID(int userID);

    // 根據用戶ID檢視所有意見
    List<OpinionVO> getAllOpinionsByUserID(int userID, int pageNo, int pageSize);
    

    // 站方回覆意見
    void replyToOpinion(int opinionID, String replyContent);

    // 取得一件相關的所有資料
    OpinionVO getOpinionDetails(int opinionID);
}

