package com.budget.budget.dao;

import java.util.Date;
import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;

import com.budget.budget.entity.Budget;

@ConfigAutowireable
@Dao
public interface BudgetDao {
	
	@Select
	List<Budget> selectAll();

	@Select
	List<Budget> selectMonth(Date start, Date end ,boolean valid);
	
	@Insert(excludeNull = true)
	@Transactional
	int insert(Budget reservation);
	
}
