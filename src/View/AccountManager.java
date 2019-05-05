package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.UIManager;

public class AccountManager {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountManager window = new AccountManager();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AccountManager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1059, 633);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account Manager");
		lblNewLabel.setBounds(453, 28, 130, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Account");
		btnNewButton.setBounds(434, 157, 168, 78);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.setForeground(new Color(0, 0, 0));
		btnDeleteAccount.setBackground(new Color(255, 228, 181));
		btnDeleteAccount.setBounds(434, 313, 168, 74);
		frame.getContentPane().add(btnDeleteAccount);
	}
}
