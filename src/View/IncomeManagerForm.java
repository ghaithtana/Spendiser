package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.FinancialManager;
import Controller.IncomeManager;
import Controller.OutcomeManager;
import Controller.UserManager;
import Model.Income;
import Model.Outcome;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class IncomeManagerForm extends JFrame {

	private JPanel contentPane;
	private static double balance;
	private static double balance2;
	private static double balance1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IncomeManagerForm frame = new IncomeManagerForm();
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
	public IncomeManagerForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 553);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				InsertIncomeForm insertincome = new InsertIncomeForm();
				insertincome.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setIcon(new ImageIcon(IncomeManagerForm.class.getResource("/View/images/income1.png")));
		btnNewButton.setFont(new Font("Pristina", Font.BOLD, 14));
		btnNewButton.setBounds(251, 118, 141, 88);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				DisplayAllIncomes di = new DisplayAllIncomes();
				di.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(230, 230, 250));
		btnNewButton_1.setIcon(new ImageIcon(IncomeManagerForm.class.getResource("/View/images/money.png")));
		btnNewButton_1.setFont(new Font("Pristina", Font.BOLD, 14));
		btnNewButton_1.setBounds(251, 228, 141, 96);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Get specific income");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DisplayFilteredIncome fi = new DisplayFilteredIncome();
				fi.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(230, 230, 250));
		btnNewButton_2.setIcon(new ImageIcon(IncomeManagerForm.class.getResource("/View/images/funnel.png")));
		btnNewButton_2.setBounds(262, 349, 119, 137);
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("Insert Income");
		lblNewLabel.setFont(new Font("Pristina", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(441, 149, 91, 38);
		contentPane.add(lblNewLabel);

		JLabel lblShowAllIncomes = new JLabel("Show All Incomes");
		lblShowAllIncomes.setFont(new Font("Pristina", Font.BOLD, 15));
		lblShowAllIncomes.setForeground(new Color(255, 255, 255));
		lblShowAllIncomes.setBounds(424, 268, 108, 38);
		contentPane.add(lblShowAllIncomes);

		JLabel lblShowFilteredIncomes = new JLabel("Show Filtered Incomes");
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
		label.setIcon(new ImageIcon(IncomeManagerForm.class.getResource("/View/images/user.png")));
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
		label_2.setBounds(78, 86, 86, 26);
		panel.add(label_2);
		label_2.setText(UserManager.instance.getCurrentUser().getName());

		JLabel label_3 = new JLabel("0.0 $");
		label_3.setFont(new Font("Pristina", Font.BOLD, 14));
		label_3.setBounds(120, 152, 61, 14);
		panel.add(label_3);
		try {
			balance = FinancialManager.instance.getBalance();
			label_3.setText(balance + " $");

			ArrayList<Income> in = new ArrayList<Income>();
			in = IncomeManager.instance.getAllIncomes();
			for (int i = 0; i < in.size(); i++) {
				balance1 = 0;
				balance1 = balance1 + in.get(i).getAmount();

			}
			ArrayList<Outcome> outcomes = new ArrayList<Outcome>();
			outcomes = OutcomeManager.instance.getAllOutcomes();
			for (int i = 0; i < outcomes.size(); i++) {
				balance2 = 0;
				balance2 = balance2 + in.get(i).getAmount();

			}
			if (balance2 == 0) {
				label_3.setText(balance1 + " $");
			}

			JButton button = new JButton("");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					Mainmenu mm = new Mainmenu();
					mm.setVisible(true);
				}
			});
			button.setIcon(new ImageIcon(IncomeManagerForm.class.getResource("/View/images/left-arrow.png")));
			button.setBounds(235, 0, 54, 40);
			contentPane.add(button);

			JLabel label_4 = new JLabel("Back");
			label_4.setForeground(Color.WHITE);
			label_4.setFont(new Font("Pristina", Font.BOLD, 14));
			label_4.setBounds(245, 46, 32, 32);
			contentPane.add(label_4);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
