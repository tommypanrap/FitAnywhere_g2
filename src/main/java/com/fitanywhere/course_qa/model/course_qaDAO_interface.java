package com.fitanywhere.course_qa.model;

import java.util.List;

public interface course_qaDAO_interface {
	public void insert(Course_qaVO course_qaVO);

	public void update(Course_qaVO course_qaVO);

	public void delete(Integer cdId);

	public Course_qaVO findByPrimaryKey(Integer cdId);

	public List<Course_qaVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
}
