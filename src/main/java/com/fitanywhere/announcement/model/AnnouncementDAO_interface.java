package com.fitanywhere.announcement.model;

import java.util.List;

import com.fitanywhere.comment.model.CommentVO;

public interface AnnouncementDAO_interface {
	public void insert(AnnouncementVO announcementVO);

	public void update(AnnouncementVO announcementVO);

	public void delete(Integer anId);

	public AnnouncementVO findByPrimaryKey(Integer anId);

	public List<AnnouncementVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
}
