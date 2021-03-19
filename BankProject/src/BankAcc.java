import java.io.Serializable;
import javax.swing.JOptionPane;
import java.util.Random;

public abstract class BankAcc implements Serializable
{
	private String memberName, accountNumber;
	private double accountBalance, minBalance;
	
	public BankAcc(String name, double bal, double minBal) throws InsufficientBalanceException
	{
		this.memberName=name;
		this.accountBalance=bal;
		this.minBalance=minBal;
		Random rand = new Random();
		String stick = (10000+rand.nextInt(89999)+"");
		this.accountNumber=stick;
		if(this.accountBalance<this.minBalance)
		{
			throw new InsufficientBalanceException(this.minBalance, this.accountBalance);
		}
	}

	public void deposit(double amount)
	{
		this.accountBalance+=amount;
		JOptionPane.showMessageDialog(null, "Deposit complete. New balance is " +this.accountBalance);
	}
	
	public void withdraw(double amount) throws InsufficientBalanceException
	{
		try {
		if(this.accountBalance-amount<this.minBalance)
		{
			throw new InsufficientBalanceException(this.accountBalance-this.minBalance);
		}
		this.accountBalance-=amount;
		JOptionPane.showMessageDialog(null, "Withdraw complete. New balance is " +this.accountBalance);
		}
		catch(InsufficientBalanceException e)
		{
			
		}
	}
	
	public double getAccountBalance()
	{
		return this.accountBalance;
	}
	
	public String getAccountNumber()
	{
		return this.accountNumber;
	}
	
	public String getMemberName()
	{
		return this.memberName;
	}
	
	public double getMinBalance()
	{
		return this.minBalance;
	}
	
	public void setAccountName(String n)
	{
		this.memberName=n;
	}
	
	public void setMinBalance(double b)
	{
		this.minBalance=b;
	}
	
	public void display()
	{
		System.out.printf("Name: %s; Account Number: %s; Balance: %.2f", this.memberName, this.accountNumber, this.accountBalance);
	}
	
	public String outside()
	{
		String s = String.format("Name: %s; Account Number: %s; Balance: %.2f", this.memberName, this.accountNumber, this.accountBalance);
		return s;
	}
	

}
