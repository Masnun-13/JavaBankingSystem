import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

public class TraFrame extends JFrame {

	public JPanel contentPane;
	private JTextField textField;
	
	public Bank c;

	private JTextField numField;
	private JTextField amtField;
	
	
	public BankFrame b1;
	
	
	public void goB(BankFrame b)
	{
		b.setVisible(true);
		dispose();
	}
	
	public void depAcc()
	{
		String bal=amtField.getText();
		String n=numField.getText();
		Double bl=Double.parseDouble(bal);
		c.deposit(n, bl);
	}
	
	public void withAcc() throws InsufficientBalanceException
	{
		String bal=amtField.getText();
		String n=numField.getText();
		Double bl=Double.parseDouble(bal);
		c.withdraw(n, bl);
	}
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayFrame frame = new DisplayFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TraFrame() {
		setTitle("Transaction Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(119, 136, 153));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account Number: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setForeground(new Color(240, 230, 140));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 10, 114, 29);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Deposit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				depAcc();
			}
		});
		btnNewButton.setForeground(new Color(211, 211, 211));
		btnNewButton.setBackground(new Color(46, 139, 87));
		btnNewButton.setBounds(49, 106, 117, 53);
		panel.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goB(b1);
			}
		});
		btnBack.setForeground(new Color(211, 211, 211));
		btnBack.setBackground(new Color(255, 69, 0));
		btnBack.setBounds(153, 187, 117, 53);
		panel.add(btnBack);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					withAcc();
				} 
				catch (Exception e2) {
					
				}
			}
		});
		btnWithdraw.setForeground(new Color(211, 211, 211));
		btnWithdraw.setBackground(new Color(46, 139, 87));
		btnWithdraw.setBounds(253, 106, 117, 53);
		panel.add(btnWithdraw);
		
		numField = new JTextField();
		numField.setBounds(124, 11, 246, 29);
		panel.add(numField);
		numField.setColumns(10);
		
		amtField = new JTextField();
		amtField.setColumns(10);
		amtField.setBounds(124, 51, 246, 29);
		panel.add(amtField);
		
		JLabel lblBalance = new JLabel("Trx Amount: ");
		lblBalance.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBalance.setForeground(new Color(240, 230, 140));
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBalance.setBounds(20, 50, 104, 29);
		panel.add(lblBalance);
		
		
	}
}
