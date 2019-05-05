package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAccount frame = new AddAccount();
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
	public AddAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccountManager = new JLabel("Account Manager");
		lblAccountManager.setBounds(188, 16, 411, 20);
		contentPane.add(lblAccountManager);
		
		JLabel lblNewLabel = new JLabel("Enter Account Name");
		lblNewLabel.setBounds(78, 186, 146, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(239, 183, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAddAccount = new JButton("Add Account");
		btnAddAccount.setBounds(235, 325, 146, 29);
		contentPane.add(btnAddAccount);
		
		JButton button = new JButton("<Back");
		button.setBounds(15, 499, 115, 29);
		contentPane.add(button);
	}
}
