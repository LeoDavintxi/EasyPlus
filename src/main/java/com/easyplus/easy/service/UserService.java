package com.easyplus.easy.service;

import java.util.List;
import java.util.Map;
import com.easyplus.easy.entity.AppUser;

public interface UserService {
	public List<AppUser> getAllusers();
	public AppUser getUserByID(Long id);
	public AppUser createUser(AppUser user);
	public AppUser updateUser(Long id, Map<String, Object> user);
	public void deleteUser(Long id);
}