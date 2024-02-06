package com.fitanywhere.course.model;

import java.util.List;

import com.fitanywhere.user.model.UserVO;

public interface Course_interface {
	public Integer insert(CourseVO courseVO);
	public void update(CourseVO courseVO);
	public CourseVO findByPrimaryKey(Integer crId);
	public List<CourseVO> getAll();
}
