package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.FinancialManager;
import Controller.UserManager;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class OutcomeManager extends JFrame {

	private JPanel contentPane;
	private static double balance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OutcomeManager frame = new OutcomeManager();
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
	public OutcomeManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 553);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InsertOutcomeForm insertOutcome = new InsertOutcomeForm();
				insertOutcome.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setIcon(new ImageIcon(OutcomeManager.class.getResource("/View/images/outcome1.png")));
		btnNewButton.setFont(new Font("Pristina", Font.BOLD, 14));
		btnNewButton.setBounds(251, 118, 141, 88);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DisplayAllOutcomes doutcome = new DisplayAllOutcomes();
				doutcome.setVisible(true);

			}
		});
		btnNewButton_1.setBackground(new Color(230, 230, 250));
		btnNewButton_1.setIcon(new ImageIcon(OutcomeManager.class.getResource("/View/images/money.png")));
		btnNewButton_1.setFont(new Font("Pristina", Font.BOLD, 14));
		btnNewButton_1.setBounds(251, 228, 141, 96);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Get specific income");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DisplayFilteredOutcome dfoutcome = new DisplayFilteredOutcome();
				dfoutcome.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(230, 230, 250));
		btnNewButton_2.setIcon(new ImageIcon(OutcomeManager.class.getResource("/View/images/funnel.png")));
		btnNewButton_2.setBounds(262, 349, 119, 137);
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("Insert Outcome");
		lblNewLabel.setFont(new Font("Pristina", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(441, 149, 91, 38);
		contentPane.add(lblNewLabel);

		JLabel lblShowAllIncomes = new JLabel("Show All Outcomes");
		lblShowAllIncomes.setFont(new Font("Pristina", Font.BOLD, 15));
		lblShowAllIncomes.setForeground(new Color(255, 255, 255));
		lblShowAllIncomes.setBounds(424, 268, 108, 38);
		contentPane.add(lblShowAllIncomes);

		JLabel lblShowFilteredIncomes = new JLabel("Show Filtered Outcomes");
		lblShowFilteredIncomes.setFont(new Font("Pristina", Font.BOLD, 15));
		lblShowFilteredIncomes.setForeground(new Color(255, 255, 255));
		lblShowFilteredIncomes.setBounds(402, 396, 130, 44);
		contentPane.add(lblShowFilteredIncomes);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 239, 573);
		contentPane.add(panel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(OutcomeManager.class.getResource("/View/images/user.png")));
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setBounds(80, 11, 71, 70);
		panel.add(label);

		JLabel label_1 = new JLabel("Current balance :");
		label_1.setForeground(new Color(0, 250, 154));
		label_1.setFont(new Font("Pristina", Font.PLAIN, 18));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(0, 135, 104, 50);
		panel.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setForeground(new Color(0, 250, 154));
		label_2.setFont(new Font("Pristina", Font.PLAIN, 18));
		label_2.setBounds(80, 92, 86, 26);
		panel.add(label_2);
		label_2.setText(UserManager.instance.getCurrentUser().getName());

		JLabel label_3 = new JLabel("0.0 $");
		label_3.setFont(new Font("Pristina", Font.BOLD, 14));
		label_3.setBounds(119, 152, 61, 14);
		panel.add(label_3);
		try {
			balance = FinancialManager.instance.getBalance();
			label_3.setText(balance + " $");
			
			JLabel label_5 = new JLabel("");
			label_5.setIcon(new ImageIcon(OutcomeManager.class.getResource("/View/images/cash.png")));
			label_5.setBounds(106, 181, 86, 41);
			panel.add(label_5);

			JButton button = new JButton("");
			button.setIcon(new ImageIcon(OutcomeManager.class.getResource("/View/images/left-arrow.png")));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					Mainmenu mu = new Mainmenu();
					mu.setVisible(true);
				}
			});
			button.setBounds(237, 0, 54, 40);
			contentPane.add(button);

			JLabel label_4 = new JLabel("Back");
			label_4.setForeground(Color.WHITE);
			label_4.setFont(new Font("Pristina", Font.BOLD, 14));
			label_4.setBounds(249, 43, 32, 32);
			contentPane.add(label_4);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
