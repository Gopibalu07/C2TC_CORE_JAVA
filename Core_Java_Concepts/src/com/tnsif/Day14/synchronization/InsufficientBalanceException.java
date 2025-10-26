package com.tnsif.Day14.synchronization;

public class InsufficientBalanceException {
	public InsufficientBalanceException() {
		super("Insufficient balance in your account");
	}

	public InsufficientBalanceException(String message) {
		super(message);
	}
}
