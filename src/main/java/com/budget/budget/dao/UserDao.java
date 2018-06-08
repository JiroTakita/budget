package com.budget.budget.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.budget.budget.entity.User;

@Dao
@ConfigAutowireable
public interface UserDao {

	@Select
	public User selectedByUserId(String userId);

}
