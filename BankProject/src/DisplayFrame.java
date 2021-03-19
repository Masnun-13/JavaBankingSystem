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
import java.awt.ScrollPane;
import java.awt.TextArea;

import net.miginfocom.swing.MigLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

public class DisplayFrame extends JFrame {

	public JPanel contentPane;
	public JTextField textField;
	public JTextArea textArea = new JTextArea();
	public Bank c;
	
	public BankFrame b1;
	
	
	public void goB(BankFrame b)
	{
		b.setVisible(true);
		dispose();
	}
	
	
	
	public void doit()
	{
		c.display();
		textArea.setText(c.outside());
		
	}
	
	public void killhim()
	{
		String num=textField.getText();
		c.display(num);
		textArea.setText(c.outside(num));
	}
	
	public TextArea crasher;
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
	public DisplayFrame() {
		setTitle("Display Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.GRAY);
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_1.setBackground(new Color(119, 136, 153));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnSpecific = new JButton("Specific");
		btnSpecific.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				killhim();
			}
		});
		btnSpecific.setForeground(new Color(230, 230, 250));
		
		btnSpecific.setBackground(new Color(46, 139, 87));
		btnSpecific.setBounds(30, 72, 116, 69);
		panel_1.add(btnSpecific);
		
		JButton btnTransaction = new JButton("Display All");
		btnTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doit();
			}
		});
		btnTransaction.setForeground(new Color(230, 230, 250));
		btnTransaction.setBackground(new Color(46, 139, 87));
		btnTransaction.setBounds(226, 72, 132, 69);
		panel_1.add(btnTransaction);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				goB(b1);
			
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.setForeground(new Color(230, 230, 250));
		btnExit.setBackground(new Color(255, 69, 0));
		btnExit.setBounds(443, 70, 116, 69);
		panel_1.add(btnExit);
		
		JLabel lblAccountNumber = new JLabel("Account Number:");
		lblAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAccountNumber.setForeground(new Color(238, 232, 170));
		lblAccountNumber.setBounds(20, 11, 116, 50);
		panel_1.add(lblAccountNumber);
		
		textField = new JTextField();
		textField.setBounds(132, 21, 334, 40);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(78, 160, 436, 81);
		panel_1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		panel_2.add(scrollPane);
	
		
		
		
		
		
		
	
		
		
	}
}
