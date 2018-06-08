package com.budget.budget;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.budget.budget.dao.BudgetDao;
import com.budget.budget.dao.SettingsDao;
import com.budget.budget.entity.Budget;

@SpringBootApplication
public class BudgetApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetApplication.class, args);
	}
	
	@Autowired
	BudgetDao budgetDao;
	@Autowired
	SettingsDao settingsDao;
	
	@Bean
	CommandLineRunner runner() {
		PasswordEncoder pe = new BCryptPasswordEncoder();
		System.err.println(pe.encode("takijiro"));
		System.err.println("4c3ed868-505a-47e9-8158-4136ebc7baa5");
		return args -> Arrays.asList("spring","spring boot","doma").forEach(s->{
			Budget b = new Budget();
			b.setUp();
			b.name = s;
			b.cost = new BigDecimal("1000");
			b.date = new Date();
			//budgetDao.insert(b);
		});
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
