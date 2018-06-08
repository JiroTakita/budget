package com.budget.budget.entity;

import org.seasar.doma.Entity;

@Entity
public class Categories extends AbstractEntity{
	public String mainName; // カテゴリ名
	public int parentId; // 親カテゴリid
	public int orderNumber; // 並び順
	public boolean type; // true -> 収入, false -> 支出
	public boolean deletable; // 削除できるかどうか
	public int settingId; // 設定ID
	
}
