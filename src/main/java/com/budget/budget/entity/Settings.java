package com.budget.budget.entity;

import org.seasar.doma.Entity;

@Entity
public class Settings extends AbstractEntity{

	public int startDate; // 1 = 月の始め 2～31 その日付 32 = 月末
	public int defaultPayment; // 新規登録時のデフォルトの支払方法 0 = 現金,それ以外
	public String groupName; // グループ名表示のみ使用
}
