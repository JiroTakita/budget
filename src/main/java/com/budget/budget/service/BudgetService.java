package com.budget.budget.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.budget.budget.dao.BudgetDao;
import com.budget.budget.dao.SettingsDao;
import com.budget.budget.entity.Budget;
import com.budget.budget.entity.Settings;

@Service
@Transactional
public class BudgetService {
	
	@Autowired
	BudgetDao budgetDao;
	@Autowired
	SettingsDao settingsDao;
	
	public List<Budget> getAllEntities(){
		return budgetDao.selectAll();	
	}

	public List<Budget> getMonthEntities(int year, int month){
		Settings st = settingsDao.getSettings();
		int day = st.startDate;
		LocalDateTime start = LocalDateTime.of(year, month, day,0,0,0);
		LocalDateTime end = start.plusMonths(1);
		return budgetDao.selectMonth(Date.from(start.atZone(ZoneId.systemDefault()).toInstant()),Date.from(end.atZone(ZoneId.systemDefault()).toInstant()),true);
	}
}
