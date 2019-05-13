package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.UserManager;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Mainmenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainmenu frame = new Mainmenu();
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
	public Mainmenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IncomeManagerForm inf = new IncomeManagerForm();
				inf.setVisible(true);

			}
		});
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setIcon(new ImageIcon(Mainmenu.class.getResource("/View/images/income.png")));
		btnNewButton.setBounds(370, 57, 150, 135);
		contentPane.add(btnNewButton);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				OutcomeManager om = new OutcomeManager();
				om.setVisible(true);

			}
		});
		button.setBackground(new Color(230, 230, 250));
		button.setIcon(new ImageIcon(Mainmenu.class.getResource("/View/images/outcome.png")));
		button.setBounds(370, 263, 150, 135);
		contentPane.add(button);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AccountManagerForm af = new AccountManagerForm();
				af.setVisible(true);
			}
		});
		button_1.setBackground(new Color(230, 230, 250));
		button_1.setIcon(new ImageIcon(Mainmenu.class.getResource("/View/images/financial.png")));
		button_1.setBounds(609, 57, 150, 135);
		contentPane.add(button_1);

		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (UserManager.instance.checkPremium(UserManager.instance.getCurrentUser()) == false) {

						dispose();
						UpgradeUser up = new UpgradeUser();
						up.setVisible(true);
					} else if (UserManager.instance.checkPremium(UserManager.instance.getCurrentUser()) == true) {

						dispose();
						StatisticsForm sf = new StatisticsForm();
						sf.setVisible(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_2.setBackground(new Color(230, 230, 250));
		button_2.setIcon(new ImageIcon(Mainmenu.class.getResource("/View/images/presentation.png")));
		button_2.setBounds(609, 263, 150, 135);
		contentPane.add(button_2);

		JLabel lblNewLabel = new JLabel("OutcomeManager");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Pristina", Font.BOLD, 14));
		lblNewLabel.setBounds(391, 238, 91, 14);
		contentPane.add(lblNewLabel);

		JLabel lblIncomeManager = new JLabel("Income Manager\r\n");
		lblIncomeManager.setForeground(Color.WHITE);
		lblIncomeManager.setFont(new Font("Pristina", Font.BOLD, 14));
		lblIncomeManager.setBounds(391, 32, 91, 14);
		contentPane.add(lblIncomeManager);

		JLabel lblFinancialAccountManager = new JLabel("Financial Account Manager");
		lblFinancialAccountManager.setForeground(Color.WHITE);
		lblFinancialAccountManager.setFont(new Font("Pristina", Font.BOLD, 14));
		lblFinancialAccountManager.setBounds(609, 32, 150, 14);
		contentPane.add(lblFinancialAccountManager);

		JLabel lblStatistics = new JLabel("Financial Statistics");
		lblStatistics.setForeground(Color.WHITE);
		lblStatistics.setFont(new Font("Pristina", Font.BOLD, 14));
		lblStatistics.setBounds(622, 238, 117, 14);
		contentPane.add(lblStatistics);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 293, 562);
		contentPane.add(panel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Mainmenu.class.getResource("/View/images/SpendiserLogo2.png")));
		label.setBounds(40, 55, 200, 212);
		panel.add(label);

		JLabel label_1 = new JLabel("Welcome To \r\n$pendiser");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Pristina", Font.BOLD, 30));
		label_1.setBounds(20, 289, 263, 104);
		panel.add(label_1);

		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SignInForm sif = new SignInForm();
				sif.setVisible(true);
			}
		});
		button_3.setIcon(new ImageIcon(Mainmenu.class.getResource("/View/images/exit.png")));
		button_3.setBackground(new Color(230, 230, 250));
		button_3.setBounds(545, 445, 46, 37);
		contentPane.add(button_3);

		JLabel lblLogout = new JLabel("Logout");
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setFont(new Font("Pristina", Font.BOLD, 14));
		lblLogout.setBounds(545, 493, 46, 14);
		contentPane.add(lblLogout);
	}
}
