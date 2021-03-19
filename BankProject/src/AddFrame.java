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

public class AddFrame extends JFrame {

	public JPanel contentPane;
	private JTextField textField;
	
	
	public BankFrame b1;
	public SavFrame s1;
	public CurFrame c1;
	
	
	public void goB(BankFrame b)
	{
		b.setVisible(true);
		dispose();
	}
	
	public void goeS(SavFrame sf)
	{
		sf.setVisible(true);
		dispose();
	}
	
	public void goeC(CurFrame cf)
	{
		cf.setVisible(true);
		dispose();
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
	public AddFrame() {
		setTitle("Account Select Window");
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
		
		JLabel lblNewLabel = new JLabel("Select Account Type");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(240, 230, 140));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(70, 11, 272, 40);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Savings");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goeS(s1);
			}
		});
		btnNewButton.setForeground(new Color(211, 211, 211));
		btnNewButton.setBackground(new Color(46, 139, 87));
		btnNewButton.setBounds(36, 73, 117, 53);
		panel.add(btnNewButton);
		
		JButton btnCurrent = new JButton("Current");
		btnCurrent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goeC(c1);
			}
		});
		btnCurrent.setForeground(new Color(211, 211, 211));
		btnCurrent.setBackground(new Color(46, 139, 87));
		btnCurrent.setBounds(256, 73, 117, 53);
		panel.add(btnCurrent);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goB(b1);
			}
		});
		btnBack.setForeground(new Color(211, 211, 211));
		btnBack.setBackground(new Color(255, 69, 0));
		btnBack.setBounds(145, 162, 117, 53);
		panel.add(btnBack);
	}
}
