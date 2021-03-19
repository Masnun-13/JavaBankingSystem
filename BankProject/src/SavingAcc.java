import java.io.Serializable;

public class SavingAcc extends BankAcc implements Serializable{
	
private double interest=0.05;
private double maxWithLimit;	

public double getMaxWithLimit()
{
	return this.maxWithLimit;
}

public double getInterest()
{
	return this.interest;
}

public void setMaxWithLimit(double cash)
{
	this.maxWithLimit=cash;
}

public void setInterest(double cash)
{
	this.interest=cash;
}


public SavingAcc(String nam, double sBal, double max) throws InsufficientBalanceException
{
	super(nam, sBal, 5000);
	this.maxWithLimit=max;
}

private double calcInterest()
{
	double bala=this.getAccountBalance();
	double tot=bala*this.interest;
	return tot;
}

public double getNetBalance()
{
	double net = (this.getAccountBalance()+this.calcInterest());
	return net;
}

public void withdraw(double amount) throws InsufficientBalanceException
{
	if((amount>this.maxWithLimit))
	{
		throw new InsufficientBalanceException(this.maxWithLimit);
	}
	super.withdraw(amount);
}

public void display()
{
	super.display();
	System.out.printf(";interest: %.2f; maxWithdrawLimit %.2f;\n", this.calcInterest(), this.maxWithLimit);
}
public String outside()
{
	String s=super.outside();
	String f = String.format(";interest: %.2f; maxWithdrawLimit %.2f;\n", this.calcInterest(), this.maxWithLimit);
	String g=(s+" "+f);
	return g;
}
}
