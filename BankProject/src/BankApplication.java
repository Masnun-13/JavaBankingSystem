import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.sun.org.apache.bcel.internal.generic.GOTO;

import jdk.javadoc.internal.doclets.toolkit.taglets.ThrowsTaglet;
public class BankApplication {
public static void main(String[] args) 
{
	BankFrame banke = new BankFrame();
	Bank bankk = new Bank();
	int check= 0, op=-1;
	String name, license, number;
	double balance, maxWithLim, amount;
	
	BankFrame fame = new BankFrame();
	DisplayFrame display= new DisplayFrame();
	AddFrame ad = new AddFrame();
	SavFrame sad = new SavFrame();
	CurFrame cad = new CurFrame();
	TraFrame tad = new TraFrame();
	
	fame.d1=display;
	fame.a1=ad;
	fame.t1=tad;
	fame.c=bankk;
	
	display.b1=fame;
	display.c=bankk;
	
	ad.b1=fame;
	ad.c1=cad;
	ad.s1=sad;
	
	sad.a=ad;
	sad.c=bankk;
	
	cad.a=ad;
	cad.c=bankk;
	
	tad.b1=fame;
	tad.c=bankk;
	
	
	fame.setVisible(true);
	if(fame.quit)
	{
	return;
	}
}
}

