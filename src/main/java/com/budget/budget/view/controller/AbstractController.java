/**
 * 
 */
package com.budget.budget.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.budget.budget.service.BudgetService;
import com.budget.budget.service.CategoriesService;

/**
 * @author Jiro
 *
 */
@Controller
public abstract class AbstractController {

	@Autowired
	BudgetService budgetS;
	
	@Autowired
	CategoriesService categoriesS;
	
}
