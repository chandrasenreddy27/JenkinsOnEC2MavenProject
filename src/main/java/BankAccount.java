package com.bogotobogo;
public class Program
{
    public static void main(String[] args)
    {
        System.out.println("Hello world");
    }
}
public class BankAccount {

	  private double balance;
	
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
