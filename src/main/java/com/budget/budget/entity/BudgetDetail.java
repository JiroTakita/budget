package com.budget.budget.entity;

import java.math.BigDecimal;

public class BudgetDetail {
	public Long budgetId; // 大本のバジェットＩＤ
	public String name; // 商品名
	public int number; // 個数
	public boolean suffix; // 0 = +, 1 = -
	public BigDecimal cost; // 商品料金
}
