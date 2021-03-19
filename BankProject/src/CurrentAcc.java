import java.io.Serializable;

public class CurrentAcc extends BankAcc implements Serializable{
private String tradeLicenseNumber;

public CurrentAcc(String a, double b, String d) throws InsufficientBalanceException
{
	super(a, b, 2000);
	this.tradeLicenseNumber=d;
}

public String getTradeLicenseNumber()
{
	return this.tradeLicenseNumber;
}

public void setTradeLicenseNumber(String t)
{
	this.tradeLicenseNumber=t;
}

public void display()
{
	super.display();
	System.out.printf("; Trade License: %s\n", this.tradeLicenseNumber);
}

public String outside()
{
	String s=super.outside();
	String f = String.format("; Trade License: %s\n", this.tradeLicenseNumber);
	String g=(s+" "+f);
	return g;
}

}
