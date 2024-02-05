package com.fitanywhere.comment.model;

import java.util.List;

public interface CommentDAO_interface {
	public void insert(CommentVO commentVO);

	public void update(CommentVO commentVO);

	public void delete(Integer cmId);

	public CommentVO findByPrimaryKey(Integer cmId);

	public List<CommentVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//      public List<EmpVO> getAll(Map<String, String[]> map); 
}
