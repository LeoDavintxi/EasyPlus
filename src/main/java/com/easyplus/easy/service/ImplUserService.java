package com.easyplus.easy.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.easyplus.easy.entity.AppUser;
import com.easyplus.easy.repository.UserRepository;

@Service
public class ImplUserService implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public List<AppUser> getAllusers() {
		return repository.findAll();
	}

	@Override
	public AppUser getUserByID(Long id) {
		return repository.findById(id).orElseThrow();
	}

	@Override
	public AppUser createUser(AppUser user) {
		return repository.save(user);
	}

	@Override
	public AppUser updateUser(Long id, Map<String, Object> userActualizado) {
		AppUser appUser = repository.findById(id).orElseThrow();
		userActualizado.forEach((key, value) -> {
			Field field;
			try {
				field = appUser.getClass().getDeclaredField(key);
				field.setAccessible(true);
				field.set(appUser, value);
			} catch (Exception e) {
				throw new IllegalArgumentException();
			}
		});
		return repository.save(appUser);
	}

	@Override
	public void deleteUser(Long id) {
		if(!repository.existsById(id)) {
			throw new NoSuchElementException();
		}
		repository.deleteById(id);
	}
}
