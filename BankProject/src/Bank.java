import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.security.auth.login.AccountException;
import javax.swing.JOptionPane;

public class Bank {

	ArrayList<BankAcc> banks;
	public Bank()
	{
		banks = new ArrayList<BankAcc>();
	}
	
	private void addAccount(BankAcc acc)
	{
		banks.add(acc);
	}
	
	void addAccount(String name, double bal, double max) 
	{
		try
		{
			SavingAcc s=new SavingAcc(name, bal, max);
			addAccount(s);
			JOptionPane.showMessageDialog(null, "Savings account added for " +name);
		}
		catch(InsufficientBalanceException e)
		{
			return;
		}
	}
	
	
	void addAccount(String name, double balance, String tradeLicense)
	{
		try
		{
			CurrentAcc c=new CurrentAcc(name, balance, tradeLicense);
			addAccount(c);
			JOptionPane.showMessageDialog(null, "Current account added for " +name);
		}
		catch(InsufficientBalanceException e)
		{
			return;
		}
		
	}
	
	private BankAcc findAcc(String accNum)
	{
		for(BankAcc b: banks)
		{
			if(accNum.equals(b.getAccountNumber()))
			{
				return b;
			}
		}
		return null;
	}
	
	void deposit(String accNum, double amount)
	{
		BankAcc targetAcc=findAcc(accNum);
		if(targetAcc==null)
		{
			JOptionPane.showMessageDialog(null,"account not found");
			return;
		}
		targetAcc.deposit(amount);
	}
	
	void withdraw(String accNum, double amount) throws InsufficientBalanceException
	{
		BankAcc targetAcc = findAcc(accNum);
		if(targetAcc==null)
		{
			JOptionPane.showMessageDialog(null,"account not found");
			return;
		}
		targetAcc.withdraw(amount);
	}
	
	double getBalance(String accNum)
	{
		BankAcc targetAcc = findAcc(accNum);
		if(targetAcc==null)
		{
			JOptionPane.showMessageDialog(null,"account not found");
			return 0;
		}
		if(targetAcc instanceof SavingAcc)
		{
			SavingAcc targetAcc2 = (SavingAcc)targetAcc;
			return targetAcc2.getNetBalance();
		}
		return targetAcc.getAccountBalance();
	}
	
	void display(String accNum) 
	{
		BankAcc targetAcc = findAcc(accNum);
		if(targetAcc==null)
		{
			return;
		}
		targetAcc.display();
	}
	
	void display() 
	{
		for(BankAcc b: banks)
		{
			b.display();
		}
	}
	
	String outside()
	{
		String soup="";
		for(BankAcc b: banks)
		{
			soup=soup+""+b.outside() +"\n";
		}
		return soup;
	}
	
	String outside(String accNum)
	{
		String soup="";
		BankAcc targetAcc = findAcc(accNum);
		if(targetAcc==null)
		{
			JOptionPane.showMessageDialog(null,"account not found");
			return ("");
		}
		soup=soup+""+targetAcc.outside();
		return soup;
	}
	
	void save() throws FileNotFoundException, IOException
	{
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Banksave.txt"));
		int i =0;
		for(BankAcc b: banks)
		{
			o.writeObject(b);
			i++;
		}
		o.close();
		PrintStream p = new PrintStream(new FileOutputStream("numofob.txt"));
		p.println(i);
	}
	
	void load() throws FileNotFoundException, IOException, ClassNotFoundException, EOFException
	{
		Scanner scan = new Scanner(new File("numofob.txt"));
		String si = scan.nextLine();
		int d= Integer.parseInt(si);
		ObjectInputStream o = new ObjectInputStream(new FileInputStream("Banksave.txt"));
		boolean cond=true;
		int x=0;
		while(x!=d)
		{
			BankAcc b = (BankAcc)o.readObject();
			addAccount(b);
		}
		o.close();
	}
	
	
	
}
