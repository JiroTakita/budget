package com.budget.budget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.budget.budget.dao.UserDao;
import com.budget.budget.entity.User;

/**
 * 認証を扱うService
 * @author Jiro
 *
 */
@Service
public class AuthService implements UserDetailsService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		if(userId == null || userId.equals("")) {
			throw new UsernameNotFoundException("ユーザＩＤが未入力です。");
		}
		User user = userDao.selectedByUserId(userId);
		
		if(user == null) {
			throw new UsernameNotFoundException("ユーザＩＤが不正です。");
		}
		return user;
	}

}
