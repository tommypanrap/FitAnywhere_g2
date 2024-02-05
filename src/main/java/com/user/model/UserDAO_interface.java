package com.user.model;

import java.util.List;


public interface UserDAO_interface {
	public void insert(UserVo uservo);
	public void update(UserVo uservo);
	public UserVo findByPrimaryKey(Integer uId);
	public List<UserVo> getAll();
	public void delete(Integer uId);
}
