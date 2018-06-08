package com.budget.budget.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;

import com.budget.budget.entity.Settings;

@ConfigAutowireable
@Dao
public interface SettingsDao {
	
	@Select
	Settings getSettings();
	
	@Insert
	@Transactional
	int insert(Settings settings);

}
