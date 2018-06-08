package com.budget.budget.entity;

import org.seasar.doma.Entity;

@Entity
public class Payments extends AbstractEntity{
	public int type; // 支払い方法 0 = 現金,1 = card
	public String paymentName; // 支払い方法わかるように独自に記入
	public int discountRate; // 割引率 %整数
	public int settingId; // 設定ＩＤ
}
