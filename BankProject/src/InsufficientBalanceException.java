import javax.swing.JOptionPane;
public class InsufficientBalanceException extends Exception{
	public InsufficientBalanceException(String message) {
		super("");
	}
	public InsufficientBalanceException(double minimum, double given)
	{
		JOptionPane.showMessageDialog(null, "Minimum is " + minimum  + ", balance cannot be " + given);
	}
	public InsufficientBalanceException(double amt) {
		JOptionPane.showMessageDialog(null, "Can't withdraw more than " + amt + " taka.");
	}	

}
