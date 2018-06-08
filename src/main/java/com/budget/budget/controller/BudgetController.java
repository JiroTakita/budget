package com.budget.budget.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.budget.budget.entity.Budget;
import com.budget.budget.service.BudgetService;

@RestController
public class BudgetController {

	@Autowired
	BudgetService service;
	
	@RequestMapping(value = "/budget/all", method = RequestMethod.GET)
	public List<Budget> getEntities(){
		return service.getAllEntities();
	}

	@RequestMapping(value = "/budget/month", method = RequestMethod.GET)
	public List<Budget> getMonthEntities(@RequestParam("year") int year, @RequestParam("month") int month){
		return service.getMonthEntities(year, month);
	}
}
