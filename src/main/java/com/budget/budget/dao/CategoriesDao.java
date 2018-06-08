/**
 * 
 */
package com.budget.budget.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.budget.budget.entity.Categories;

/**
 * @author Jiro
 *
 */
@ConfigAutowireable
@Dao
public interface CategoriesDao {

	@Select
	List<Categories> selectAll();
	
}
