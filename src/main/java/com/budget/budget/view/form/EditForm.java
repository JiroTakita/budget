/**
 * 
 */
package com.budget.budget.view.form;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jiro
 *
 */
@Getter
@Setter
public class EditForm {
	@NotEmpty
	private long budgetId;
	@NotEmpty
	private String name;
	@NotEmpty
	private BigDecimal cost;
	@NotEmpty
	private Date date;
	
}
