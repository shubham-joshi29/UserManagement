package com.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.user.controller.UserController;
import com.user.repository.UserRepository;
import com.user.service.CreditCardPayment;
import com.user.service.PaymentService;
import com.user.service.UpiPayment;
import com.user.service.UserService;
import com.user.service.UserServiceImpl;



@Configuration
public class UserConfig {
	
	@Bean
	public PaymentService creditCardServices() {
		return new CreditCardPayment();
	}
	
	@Bean
	public PaymentService upiServices() {
		return new UpiPayment();
	}
}
