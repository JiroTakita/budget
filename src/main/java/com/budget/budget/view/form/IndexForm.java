package com.budget.budget.view.form;


import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

/**
 * IndexControllerで使用するForm
 * @author Jiro
 *
 */
@Getter
@Setter
public class IndexForm {
	@NotEmpty
	private String userId;
	@NotEmpty
	private String password;
	
}
