package com.budget.budget.entity;

import java.util.ArrayList;
import java.util.Collection;

import org.seasar.doma.Entity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends AbstractEntity implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userId; // userId
	private String name; // 名前
	private String password; // パスワード
	private String email; // e-mail
	private String role; // USER OR ADMIN
	private int settingId; // 設定Id
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorityList = new ArrayList<>();
		authorityList.add(new SimpleGrantedAuthority("ROLE_" + this.role));
		return authorityList;
	}
	@Override
	public String getUsername() {
		return userId;
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
}
