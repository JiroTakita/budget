package com.budget.budget.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.seasar.doma.Entity;

@Entity
public class Budget extends AbstractEntity{

	public Date date; // 支払い日
	public String name; // 
	public BigDecimal cost; // 支払い額
	public int paymentType; // 支払い方法　0 = 現金, 1～登録している支払い方法（値引き等設定済)
	public boolean type; // 支払いカテゴリタイプ true = 家計費, false = 自分個人の支払い
	public boolean suffix; // 誤差額の記号(0=-,1=+)
	public BigDecimal differencies; // 誤差額
	public boolean add; // 計算に使用する値かどうか true = する,false = しない
	public String memo; // コメント
	public int settingId; // 設定ＩＤ
	
}
