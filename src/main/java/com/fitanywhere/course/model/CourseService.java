package com.fitanywhere.course.model;

public class CourseService {
	CourseHibernate coursehibernate = new CourseHibernate();
	
	public CourseVO getOneCourse(Integer crId) {
		return coursehibernate.findByPrimaryKey(crId);
	}
	
	public CourseVO addCourse(CourseVO coursevo) {
		
		return null;
	}
	
}
