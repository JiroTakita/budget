package com.budget.budget.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.budget.budget.view.form.IndexForm;

@Controller
@RequestMapping({"/","/index"})
public class IndexController {

	@ModelAttribute
	public IndexForm initForm() {
		return new IndexForm();
	}
	
	/**
	 * 初期表示
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mv) {
		mv.setViewName("index/index");
		return mv;
	}
	
	/**
	 * 認証エラー時
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute @Validated IndexForm form, BindingResult result, ModelAndView mv) {
		System.err.println("login fail");
		if(!result.hasErrors()) {
			mv.addObject("errorMessage", "ログイン情報が間違っています");
		}

		mv.setViewName("index/index");
		return mv;
	}
}
