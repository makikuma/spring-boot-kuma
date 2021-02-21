package com.kuma.domain.api.user;

import java.util.List;

public interface UserService {
	
	public List<User> getUserList();
	
	public boolean insertUser(User user);

}
