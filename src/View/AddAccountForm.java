package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.bcel.internal.generic.BALOAD;

import Controller.AccountManager;
import Controller.FinancialManager;
import Controller.UserManager;
import Model.Account;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddAccountForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static String accountName;
	private static double balance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAccountForm frame = new AddAccountForm();
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
	public static void infoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

	public AddAccountForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 373);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter Account Name :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Pristina", Font.BOLD, 14));
		lblNewLabel.setBounds(221, 93, 126, 20);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(357, 88, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				accountName = textField.getText();
			}
		});

		JButton btnAddAccount = new JButton("");
		btnAddAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Account account = new Account(accountName, UserManager.instance.getCurrentUser().getU_ID());
				try {
					AccountManager.instance.insertAccount(account);
					infoBox("Congrats Financial Account added succesfully!", "");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAddAccount.setIcon(new ImageIcon(AddAccountForm.class.getResource("/View/images/plus.png")));
		btnAddAccount.setBounds(440, 194, 49, 38);
		contentPane.add(btnAddAccount);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AccountManagerForm ac = new AccountManagerForm();
				ac.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(AddAccountForm.class.getResource("/View/images/left-arrow.png")));
		button.setBounds(221, 0, 54, 38);
		contentPane.add(button);

		JLabel lblAddAccount = new JLabel("Add Account");
		lblAddAccount.setForeground(new Color(255, 255, 255));
		lblAddAccount.setFont(new Font("Pristina", Font.PLAIN, 15));
		lblAddAccount.setBounds(430, 245, 73, 38);
		contentPane.add(lblAddAccount);

		JLabel lblBack = new JLabel("Back");
		lblBack.setForeground(new Color(255, 255, 255));
		lblBack.setFont(new Font("Pristina", Font.BOLD, 14));
		lblBack.setBounds(231, 49, 32, 32);
		contentPane.add(lblBack);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(-2, 0, 204, 336);
		contentPane.add(panel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddAccountForm.class.getResource("/View/images/user.png")));
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setBounds(61, 11, 71, 70);
		panel.add(label);

		JLabel label_1 = new JLabel("Current balance :");
		label_1.setBackground(new Color(255, 255, 255));
		label_1.setForeground(new Color(0, 250, 154));
		label_1.setFont(new Font("Pristina", Font.PLAIN, 18));
		label_1.setBounds(0, 135, 104, 50);
		panel.add(label_1);

		JLabel lbl2 = new JLabel("");
		lbl2.setForeground(new Color(0, 250, 154));
		lbl2.setFont(new Font("Pristina", Font.PLAIN, 18));
		lbl2.setBounds(61, 87, 61, 26);
		lbl2.setText(UserManager.instance.getCurrentUser().getName());
		panel.add(lbl2);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Pristina", Font.BOLD, 14));
		lblNewLabel_1.setBounds(114, 152, 61, 14);
		panel.add(lblNewLabel_1);
		try {
			balance = FinancialManager.instance.getBalance();
			lblNewLabel_1.setText(balance + " $");

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
}
