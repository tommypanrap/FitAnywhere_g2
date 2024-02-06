package com.fitanywhere.main.usercollectlist.model;

import java.util.*;


public interface UserclDAO_interface {
	public void insert(UserclVO userclVO);
	public void update(UserclVO userclVO);
	public void delete(Integer crid, Integer uid);
	public UserclVO findByPrimaryKey(Integer crid, Integer uid);
	public List<UserclVO> getAll();
}
