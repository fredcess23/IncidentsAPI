package com.maranatha.dao;

import com.maranatha.model.User;
import java.util.List;

public interface UserDAO {

	public void save(User p);
    public List<User> list();
	public void addUser(User person);
	public void removeUser(Integer personId);
	public List<User>  search(String name);

}
