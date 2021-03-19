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
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;

import javax.imageio.IIOException;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.Font;

public class BankFrame extends JFrame {

	public JPanel contentPane;
	
	public boolean quit;

	public Bank c;
	
	public DisplayFrame d1;
	public AddFrame a1;
	public TraFrame t1;
	
	
	public void save() throws FileNotFoundException, IOException
	{
		c.save();
	}
	
	public void load() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		try 
		{
			c.load();
		} 
		catch (Exception e) 
		{
		
		}
		
	}
	
	public void goDi(DisplayFrame d)
	{
		d.setVisible(true);
		dispose();
	}
	
	public void goA(AddFrame a)
	{
		a.setVisible(true);
		dispose();
	}
	
	public void goaT(TraFrame t)
	{
		t.setVisible(true);
		dispose();
	}
	
	public void quit()
	{
		this.quit=true;
		dispose();
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankFrame frame = new BankFrame();
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
	public BankFrame() {
		setTitle("Banking System");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 300);
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
		
		JButton button = new JButton("Add Accounts");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goA(a1);
			}
		});
		button.setForeground(new Color(230, 230, 250));
		
		button.setBackground(new Color(46, 139, 87));
		button.setBounds(20, 25, 116, 69);
		panel_1.add(button);
		
		JButton btnTransaction = new JButton("Transaction");
		btnTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goaT(t1);
			}
		});
		btnTransaction.setForeground(new Color(230, 230, 250));
		btnTransaction.setBackground(new Color(46, 139, 87));
		btnTransaction.setBounds(161, 25, 116, 69);
		panel_1.add(btnTransaction);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goDi(d1);
			}
		});
		btnDisplay.setForeground(new Color(230, 230, 250));
		btnDisplay.setBackground(new Color(46, 139, 87));
		btnDisplay.setBounds(297, 25, 116, 69);
		panel_1.add(btnDisplay);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					save();
				} catch (FileNotFoundException ex) {
			
					ex.printStackTrace();
				} catch (IOException e1) {
			
					e1.printStackTrace();
				}
			}
		});
		btnSave.setForeground(new Color(230, 230, 250));
		btnSave.setBackground(new Color(0, 128, 0));
		btnSave.setBounds(20, 143, 116, 69);
		panel_1.add(btnSave);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				try {
					load();
				} catch (FileNotFoundException e1) {
			
					e1.printStackTrace();
				} catch (ClassNotFoundException e2) {
	
					e2.printStackTrace();
				} catch (IOException e3) {

					e3.printStackTrace();
				}
			}
		});
		btnLoad.setForeground(new Color(230, 230, 250));
		btnLoad.setBackground(new Color(0, 128, 0));
		btnLoad.setBounds(161, 143, 116, 69);
		panel_1.add(btnLoad);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.setForeground(new Color(230, 230, 250));
		btnExit.setBackground(new Color(255, 57, 20));
		btnExit.setBounds(297, 143, 116, 69);
		panel_1.add(btnExit);
	}
}
