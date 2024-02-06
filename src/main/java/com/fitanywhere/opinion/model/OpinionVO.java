package com.fitanywhere.opinion.model;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class OpinionVO {
    private Integer opId;
    private Integer userId;
    private String opTitle;
    private String opContent;
    private Timestamp opSendTime;
    private String opReplyContent;
    private Timestamp opReplyTime;
    private Integer opStatus;
    
    public Integer getOpId() {
        return opId;
    }
    public void setOpId(Integer opId) {
        this.opId = opId;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getOpTitle() {
        return opTitle;
    }
    public void setOpTitle(String opTitle) {
        this.opTitle = opTitle;
    }
    public String getOpContent() {
        return opContent;
    }
    public void setOpContent(String opContent) {
        this.opContent = opContent;
    }
    public Timestamp getOpSendTime() {
        return opSendTime;
    }
    public void setOpSendTime(Timestamp opSendTime) {
        this.opSendTime = opSendTime;
    }
    public Date getOpSendDate() {
    	Calendar calendar = Calendar.getInstance();
        calendar.setTime(opSendTime);
        calendar.set(Calendar.MILLISECOND, 0); // 設置毫秒為0
        return calendar.getTime();
    }
    public String getOpReplyContent() {
        return opReplyContent;
    }
    public void setOpReplyContent(String opReplyContent) {
        this.opReplyContent = opReplyContent;
    }
    public Timestamp getOpReplyTime() {
        return opReplyTime;
    }
    public void setOpReplyTime(Timestamp opReplyTime) {
        this.opReplyTime = opReplyTime;
    }
    public Date getOpReplyDate() {            
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(opReplyTime);
        calendar.set(Calendar.MILLISECOND, 0); // 設置毫秒為0
        return calendar.getTime();
    }
    public Integer getOpStatus() {
        return opStatus;
    }
    public void setOpStatus(Integer opStatus) {
        this.opStatus = opStatus;
    }
}
