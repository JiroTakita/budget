package com.budget.budget.entity;

import java.util.Date;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;

@Entity
public abstract class AbstractEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	public Date createDate;
	public Date updateDate;
	public boolean valid; // true = 有効, false= 無効
	
	public void setUp() {
		this.createDate = new Date();
		this.updateDate = new Date();
		this.valid = true;
	}
	
	
}
