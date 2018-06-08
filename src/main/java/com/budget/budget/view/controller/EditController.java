/**
 * 
 */
package com.budget.budget.view.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.budget.budget.entity.Budget;
import com.budget.budget.entity.BudgetDetail;
import com.budget.budget.entity.User;

/**
 * @author Jiro
 *
 */
@Controller
@RequestMapping("/edit")
public class EditController {

	@RequestMapping(value = {"","/","/index"}, method = RequestMethod.GET)
	public ModelAndView index(@AuthenticationPrincipal User user, ModelAndView mv) {
		mv.setViewName("edit/index");
		Budget b = new Budget();
		List<BudgetDetail> bd = new ArrayList<BudgetDetail>();
		mv.addObject("budget", b);
		mv.addObject("budgetDetail", bd);
		return mv;
	}
}
