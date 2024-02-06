package com.user.model;

import java.util.List;


public interface UserDAO_interface {
	public void insert(UserVO uservo);
	public void update(UserVO uservo);
	public UserVO findByPrimaryKey(Integer uId);
	public List<UserVO> getAll();
	public void delete(Integer uId);
}
