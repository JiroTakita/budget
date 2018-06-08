/**
 * 
 */
package com.budget.budget.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.budget.budget.dao.CategoriesDao;
import com.budget.budget.entity.Categories;

/**
 * @author Jiro
 *
 */
@Service
@Transactional
public class CategoriesService {
	@Autowired
	CategoriesDao categoriesDao;
	
	public List<Categories> getAllEntities(){
		return categoriesDao.selectAll();
	}

}
