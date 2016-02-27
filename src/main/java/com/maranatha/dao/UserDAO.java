package com.maranatha.dao;

import java.util.List;

import com.maranatha.model.User;

public interface UserDAO {

	public void save(User p);
    public List<User> list();
	public void addUser(User person);
	public User  getUser(String name);
	public void removeUser(Integer personId);
	public List<User>  search(String name);
	public boolean login(User person);

}
