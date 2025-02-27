package com.user.service;

public class CreditCardPayment implements PaymentService{

	@Override
	public String makePayment() {
		return "Payment Done by Credit card";
	}

}
