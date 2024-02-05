package com.fitanywhere.course_detail.model;

import java.util.List;

import com.fitanywhere.comment.model.CommentVO;

public interface Course_detailDAO_interface {
	public void insert(Course_detailVO course_detailVO);

	public void update(Course_detailVO course_detailVO);

	public void delete(Integer cdId);

	public CommentVO findByPrimaryKey(Integer cdId);

	public List<CommentVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
}
