/**
 * 
 */
package com.budget.budget.view.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.budget.budget.entity.Budget;
import com.budget.budget.entity.User;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Jiro
 *
 */
@Controller
@RequestMapping("/menu")
@Slf4j
public class MenuController extends AbstractController{

	/**
	 * 初期表示
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public ModelAndView index(@AuthenticationPrincipal User user, ModelAndView mv) {
		mv.setViewName("menu/index");
		log.info("debug: Login as {}",user.getName());
		List<Budget> b = budgetS.getAllEntities();
		mv.addObject("budgets",b);
		return mv;
	}
}
