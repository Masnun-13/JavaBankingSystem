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

public class CurFrame extends JFrame {

	public JPanel contentPane;
	private JTextField textField;
	
	public Bank c;
	
	public AddFrame a;
	private JTextField nameField;
	private JTextField balField;
	private JTextField licField;
	
	
	public void goA(AddFrame a)
	{
		a.setVisible(true);
		dispose();
	}
	
	
	public void addAcc()
	{
		String bal=balField.getText();
		String t=licField.getText();
		String n=nameField.getText();
		Double bl=Double.parseDouble(bal);
		c.addAccount(n, bl, t);
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
	public CurFrame() {
		setTitle("Current Window");
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
		
		JLabel lblNewLabel = new JLabel("Name: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setForeground(new Color(240, 230, 140));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(77, 10, 47, 29);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAcc();
			}
		});
		btnNewButton.setForeground(new Color(211, 211, 211));
		btnNewButton.setBackground(new Color(46, 139, 87));
		btnNewButton.setBounds(49, 187, 117, 53);
		panel.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goA(a);
			}
		});
		btnBack.setForeground(new Color(211, 211, 211));
		btnBack.setBackground(new Color(255, 69, 0));
		btnBack.setBounds(253, 187, 117, 53);
		panel.add(btnBack);
		
		nameField = new JTextField();
		nameField.setBounds(124, 11, 246, 29);
		panel.add(nameField);
		nameField.setColumns(10);
		
		balField = new JTextField();
		balField.setColumns(10);
		balField.setBounds(124, 51, 246, 29);
		panel.add(balField);
		
		licField = new JTextField();
		licField.setColumns(10);
		licField.setBounds(124, 93, 246, 29);
		panel.add(licField);
		
		JLabel lblBalance = new JLabel("Balance: ");
		lblBalance.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBalance.setForeground(new Color(240, 230, 140));
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBalance.setBounds(49, 50, 75, 29);
		panel.add(lblBalance);
		
		JLabel lblWithdrawLimit = new JLabel("Trade License: ");
		lblWithdrawLimit.setHorizontalAlignment(SwingConstants.TRAILING);
		lblWithdrawLimit.setForeground(new Color(240, 230, 140));
		lblWithdrawLimit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWithdrawLimit.setBounds(10, 93, 114, 29);
		panel.add(lblWithdrawLimit);
	}
}
