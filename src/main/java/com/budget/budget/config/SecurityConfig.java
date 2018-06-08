/**
 * 
 */
package com.budget.budget.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.budget.budget.config.handler.FailureHandler;
import com.budget.budget.config.handler.SuccessHandler;
import com.budget.budget.service.AuthService;

/**
 * @author Jiro
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthService service;
	
	@Autowired
	private FailureHandler failureHandler;
	
	@Autowired
	private SuccessHandler successHandler;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/fonts/**", "/imges/**", "/static/**","/js/**", "/json/**","/h2-console/**");
	}
	
	/**
	 * HttpSecurityの設定
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//認可の設定
		http.authorizeRequests()
			//認証無しでアクセスできるURLを設定
			.antMatchers("/", "/index/**","/logout","/login").permitAll()
			//上記以外は認証が必要にする設定
			.anyRequest().authenticated().and();

		//ログイン設定
		http.formLogin()
			//認証処理のパスを設定
			.loginProcessingUrl("/login")
			//ログインフォームのパスを設定
			.loginPage("/index")
			//認証成功時にリダイレクトするURLを設定
			.defaultSuccessUrl("/summary/")
			//認証失敗時にforwardするURLを設定
			.failureForwardUrl("/")
			//認証成功時にforwardするURLを設定
			.successForwardUrl("/")
			//認証成功時に呼ばれるハンドラクラスを設定
			.successHandler(successHandler)
			//認証失敗時にリダイレクトするURLを設定
			.failureUrl("/summary/")
			//認証失敗時に呼ばれるハンドラクラスを設定
			.failureHandler(failureHandler)
			//ユーザー名、パスワードのパラメータ名を設定
			.usernameParameter("userId").passwordParameter("password").and();
		// ログアウト設定	
		http.logout()
			.invalidateHttpSession(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))
			.logoutSuccessUrl("/index").permitAll().and();
	}
	
	/**
	 * 設定
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
}
