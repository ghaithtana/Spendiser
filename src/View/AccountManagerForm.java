package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.bcel.internal.generic.NEW;

import Controller.FinancialManager;
import Controller.UserManager;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AccountManagerForm extends JFrame {

	private JPanel contentPane;
	private JButton btnDeleteAccount;
	private JLabel lblDeleteFinancialAccount;
	private JLabel lblAddFinancialAccount;
	private JButton button;
	private JPanel panel;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel;
	private static double balance;
	private JLabel lblNewLabel_1;
	private JButton button_1;
	private JLabel label_2;
	private JLabel label_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountManagerForm window = new AccountManagerForm();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AccountManagerForm() {
		setBounds(100, 100, 537, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnDeleteAccount = new JButton("");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				DeleteAccountForm da = new DeleteAccountForm();
				da.setVisible(true);
			}
		});
		btnDeleteAccount.setIcon(new ImageIcon(AccountManagerForm.class.getResource("/View/images/file.png")));
		btnDeleteAccount.setBounds(306, 185, 125, 131);
		btnDeleteAccount.setForeground(new Color(0, 0, 0));
		btnDeleteAccount.setBackground(new Color(255, 0, 0));
		contentPane.add(btnDeleteAccount);

		lblDeleteFinancialAccount = new JLabel("Delete Financial account");
		lblDeleteFinancialAccount.setFont(new Font("Pristina", Font.PLAIN, 15));
		lblDeleteFinancialAccount.setForeground(new Color(255, 0, 0));
		lblDeleteFinancialAccount.setBounds(306, 332, 144, 29);
		contentPane.add(lblDeleteFinancialAccount);

		lblAddFinancialAccount = new JLabel("Add Financial account");
		lblAddFinancialAccount.setForeground(new Color(255, 255, 255));
		lblAddFinancialAccount.setFont(new Font("Pristina", Font.PLAIN, 15));
		lblAddFinancialAccount.setBounds(306, 145, 159, 29);
		contentPane.add(lblAddFinancialAccount);

		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AddAccountForm ad = new AddAccountForm();
				ad.setVisible(true);

			}
		});
		button.setIcon(new ImageIcon(AccountManagerForm.class.getResource("/View/images/fileadd.png")));
		button.setForeground(Color.BLACK);
		button.setBackground(new Color(0, 250, 154));
		button.setBounds(306, 11, 125, 131);
		contentPane.add(button);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 214, 361);
		contentPane.add(panel);

		label = new JLabel("");
		label.setIcon(new ImageIcon(AccountManagerForm.class.getResource("/View/images/user.png")));
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setBounds(65, 11, 71, 70);
		panel.add(label);

		label_1 = new JLabel("Current balance :");
		label_1.setForeground(new Color(0, 250, 154));
		label_1.setFont(new Font("Pristina", Font.PLAIN, 18));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(0, 135, 104, 50);
		panel.add(label_1);

		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(0, 250, 154));
		lblNewLabel.setFont(new Font("Pristina", Font.BOLD, 14));
		lblNewLabel.setBounds(75, 90, 94, 34);
		lblNewLabel.setText(UserManager.instance.getCurrentUser().getName());
		panel.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Pristina", Font.BOLD, 14));
		lblNewLabel_1.setBounds(114, 152, 71, 14);
		panel.add(lblNewLabel_1);
		try {
			balance = FinancialManager.instance.getBalance();
			lblNewLabel_1.setText(balance + " $");
			
			label_3 = new JLabel("");
			label_3.setIcon(new ImageIcon(AccountManagerForm.class.getResource("/View/images/cash.png")));
			label_3.setBounds(114, 169, 86, 41);
			panel.add(label_3);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Mainmenu mu = new Mainmenu();
				mu.setVisible(true);
			}
		});
		button_1.setIcon(new ImageIcon(AccountManagerForm.class.getResource("/View/images/left-arrow.png")));
		button_1.setBounds(212, 0, 54, 38);
		contentPane.add(button_1);

		label_2 = new JLabel("Back");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Pristina", Font.BOLD, 14));
		label_2.setBounds(222, 39, 32, 32);
		contentPane.add(label_2);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	/*
	 * private void initialize() {
	 * 
	 * }
	 */
}
