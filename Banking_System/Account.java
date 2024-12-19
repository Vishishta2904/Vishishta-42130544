
import java.util.*;
public class Account {
	private String accNo;
	private String accHolderName;
	private double balance;
	private int acc_pin;
	private ArrayList<String> transaction;
	
	public Account(String accNo, String accHolderName, int acc_pin)
	{
		this.accNo = accNo;
		this.accHolderName = accHolderName;
		this.balance = 0.0;
		this.acc_pin = acc_pin;
		this.transaction = new ArrayList<>();
	}
	
	public String getaccNo()
	{
		return accNo;
	}
	public String getaccHolderName()
	{
		return accHolderName;
	}
	public int getacc_pin()
	{
		return acc_pin;
	}
	public double getbalance()
	{
		return balance;
	}
	
	public void deposit( double amount) {
		if(amount > 0)
		{
			balance += amount;
			transaction.add("Deposited: $ " +amount+ ", New Balance: $ " +balance);
			System.out.println(amount+ " Deposited Successfully");
		}
		else {
			System.out.println("Enter a valid amount to deposit");
		}
	}
	
	public void withdraw(double amount) {
		if(amount > 0 && amount <= balance)
		{
			balance -= amount;
			transaction.add("Withdrew: $ " +amount+ ", New Balance: $ " +balance);
			System.out.println(amount+ " Withdrawn Successfully");
		}
		else if(amount > balance) {
			System.out.println("Insufficient Balance");
		}
		else {
			System.out.println("Enter a valid amount to deposit");
		}
	}
	public void showTransactionHistory() {
		for(String Transaction : transaction) {
			System.out.println(Transaction);
		}
	}
}

