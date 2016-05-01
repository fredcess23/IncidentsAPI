package com.maranatha.dao;

import java.util.List;

import com.maranatha.model.User;

public interface UserDAO {

	public void save(User p);
    public List<User> list();
	public boolean addUser(User person);
	public User  getUser(String person);
	public void removeUser(Integer personId);
	public List<User>  search(String name);
	public boolean login(User person);

}
