package com.bogotobogo;

public class BankAccount {

	  private double balance;
	private double b1;
	private souble b2;

	  public BankAccount(double balance) {
	    this.balance = balance;
	  }

	  public double debit(double amount) {
	    if (balance < amount) {
	      amount = balance;
	    }

	    balance -= amount;
	    return amount;
	  }

}
