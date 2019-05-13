package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import Controller.AccountManager;
import Controller.CategoryManager;
import Controller.FinancialManager;
import Controller.OutcomeManager;
import Controller.UserManager;
import Controller.Utils;
import Model.Account;
import Model.Category;
import Model.Outcome;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatisticsForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static JTable table;
	private JTable table_1;
	private static JTable table_2;
	private static JTable table_3;
	private JTable table_4;
	private JTable table_5;
	private static int aid;
	private static int cid;
	private static int mid;
	private static String listener1;
	private static String listener2;
	private static String listener3;
	private static double balance;

	/**
	 * Launch the application.
	 */
	public static void infoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void addCategory() {

		try {
			DefaultTableModel model = (DefaultTableModel) table_2.getModel();
			ArrayList<Category> categories = new ArrayList<Category>();
			categories = CategoryManager.instance.getAllCategories();
			Object rowdata[] = new Object[20];
			for (int i = 0; i < categories.size(); i++) {
				rowdata[0] = categories.get(i).getId();
				rowdata[1] = categories.get(i).getName();
				model.addRow(rowdata);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void addAccounts() {

		try {
			DefaultTableModel model = (DefaultTableModel) table_3.getModel();
			ArrayList<Account> accounts = new ArrayList<Account>();
			accounts = AccountManager.instance.getAllAccounts();
			Object rowdata[] = new Object[20];
			for (int i = 0; i < accounts.size(); i++) {
				rowdata[0] = accounts.get(i).getId();
				rowdata[1] = accounts.get(i).getName();
				rowdata[2] = accounts.get(i).getU_ID();
				model.addRow(rowdata);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void addOutcomes() {

		try {

			DefaultTableModel model = (DefaultTableModel) table.getModel();
			ArrayList<Outcome> outcomes = new ArrayList<Outcome>();
			outcomes = OutcomeManager.instance.getCurrentMonthOutcomes(cid, aid);

			Object rowdata[] = new Object[20];
			for (int i = 0; i < outcomes.size(); i++) {
				rowdata[0] = outcomes.get(i).getAmount();
				rowdata[1] = outcomes.get(i).getDescription();
				rowdata[2] = outcomes.get(i).getDate();
				rowdata[3] = outcomes.get(i).getC_id();
				rowdata[4] = outcomes.get(i).getA_id();

				model.addRow(rowdata);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatisticsForm frame = new StatisticsForm();
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
	public StatisticsForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1377, 684);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 211, 645);
		contentPane.add(panel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(StatisticsForm.class.getResource("/View/images/user.png")));
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setBounds(65, 11, 71, 70);
		panel.add(label);

		JLabel label_1 = new JLabel("Current balance :");
		label_1.setForeground(new Color(0, 250, 154));
		label_1.setFont(new Font("Pristina", Font.PLAIN, 18));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(0, 148, 104, 50);
		panel.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setForeground(new Color(0, 250, 154));
		label_2.setFont(new Font("Pristina", Font.PLAIN, 18));
		label_2.setBounds(64, 92, 86, 26);
		panel.add(label_2);
		label_2.setText(UserManager.instance.getCurrentUser().getName());

		JLabel label_3 = new JLabel("0.0 $");
		label_3.setFont(new Font("Pristina", Font.BOLD, 14));
		label_3.setBounds(114, 165, 61, 14);
		panel.add(label_3);
		try {
			balance = FinancialManager.instance.getBalance();
			label_3.setText(balance + " $");

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(StatisticsForm.class.getResource("/View/images/cash.png")));
		lblNewLabel.setBounds(114, 190, 86, 41);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(560, 59, 146, 26);
		contentPane.add(textField);
		textField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener1 = textField.getText();
				aid = Integer.parseInt(textField.getText().trim());

			}
		});

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(560, 108, 146, 26);
		contentPane.add(textField_1);
		textField_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener2 = textField_1.getText();
				cid = Integer.parseInt(textField_1.getText().trim());

			}
		});

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(404, 207, 146, 26);
		contentPane.add(textField_2);
		textField_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener3 = textField_2.getText();
				mid = Integer.parseInt(textField_2.getText().trim());

			}
		});

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column", "New column" }));
		table.setBounds(221, 289, 571, 246);
		contentPane.add(table);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
				new Object[][] { { " Amount", " Description", " Date", " Category ID", "  Account ID" }, },
				new String[] { "New column", "New column", "New column", "New column", "New column" }));
		table_1.setForeground(Color.WHITE);
		table_1.setFont(new Font("Pristina", Font.BOLD, 14));
		table_1.setBackground(new Color(0, 250, 154));
		table_1.setBounds(221, 262, 571, 16);
		contentPane.add(table_1);

		table_2 = new JTable();
		table_2.setModel(
				new DefaultTableModel(new Object[][] { { null, null }, }, new String[] { "New column", "New column" }));
		table_2.setBounds(891, 38, 268, 195);
		contentPane.add(table_2);

		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "New column", "New column", "New column" }));
		table_3.setBounds(849, 289, 364, 246);
		contentPane.add(table_3);

		table_4 = new JTable();
		table_4.setModel(new DefaultTableModel(new Object[][] { { " Account ID", " Account Name", " User ID" }, },
				new String[] { "New column", "New column", "New column" }));
		table_4.setForeground(Color.WHITE);
		table_4.setFont(new Font("Pristina", Font.BOLD, 14));
		table_4.setBackground(new Color(0, 250, 154));
		table_4.setBounds(849, 262, 364, 16);
		contentPane.add(table_4);

		table_5 = new JTable();
		table_5.setModel(new DefaultTableModel(new Object[][] { { " Category ID", " Category Name" }, },
				new String[] { "New column", "New column" }));
		table_5.setForeground(Color.WHITE);
		table_5.setFont(new Font("Pristina", Font.BOLD, 14));
		table_5.setBackground(new Color(0, 250, 154));
		table_5.setBounds(897, 11, 249, 16);
		contentPane.add(table_5);

		JLabel label_4 = new JLabel("Categories");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Pristina", Font.BOLD, 14));
		label_4.setBounds(1196, 125, 131, 20);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("Accounts");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Pristina", Font.BOLD, 14));
		label_5.setBounds(1223, 390, 131, 20);
		contentPane.add(label_5);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addCategory();
				addAccounts();
			}
		});
		button.setIcon(new ImageIcon(StatisticsForm.class.getResource("/View/images/show.png")));
		button.setBackground(new Color(230, 230, 250));
		button.setBounds(996, 546, 81, 29);
		contentPane.add(button);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (listener1 != null && listener2 != null) {
					addOutcomes();
				} else {
					infoBox("Fill the boxex!", "");
				}

			}
		});
		button_1.setIcon(new ImageIcon(StatisticsForm.class.getResource("/View/images/show.png")));
		button_1.setBackground(new Color(230, 230, 250));
		button_1.setBounds(433, 546, 81, 29);
		contentPane.add(button_1);

		JLabel lblShowAccountAnd = new JLabel("Show account and Categories");
		lblShowAccountAnd.setForeground(Color.WHITE);
		lblShowAccountAnd.setFont(new Font("Pristina", Font.BOLD, 14));
		lblShowAccountAnd.setBounds(973, 589, 186, 20);
		contentPane.add(lblShowAccountAnd);

		JLabel lblShowCurrentMonth = new JLabel("Show Current Month Outcomes");
		lblShowCurrentMonth.setForeground(Color.WHITE);
		lblShowCurrentMonth.setFont(new Font("Pristina", Font.BOLD, 14));
		lblShowCurrentMonth.setBounds(374, 586, 176, 20);
		contentPane.add(lblShowCurrentMonth);

		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Mainmenu mu = new Mainmenu();
				mu.setVisible(true);
			}
		});
		button_3.setIcon(new ImageIcon(StatisticsForm.class.getResource("/View/images/left-arrow.png")));
		button_3.setBounds(210, 0, 54, 38);
		contentPane.add(button_3);

		JLabel label_6 = new JLabel("Back");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Pristina", Font.BOLD, 14));
		label_6.setBounds(221, 38, 32, 32);
		contentPane.add(label_6);

		JLabel lblEnterAccountBy = new JLabel("Enter account by ID :");
		lblEnterAccountBy.setForeground(Color.WHITE);
		lblEnterAccountBy.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterAccountBy.setBounds(419, 58, 131, 32);
		contentPane.add(lblEnterAccountBy);

		JLabel lblEnterCategoryBy = new JLabel("Enter Category by ID :");
		lblEnterCategoryBy.setForeground(Color.WHITE);
		lblEnterCategoryBy.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterCategoryBy.setBounds(419, 107, 131, 32);
		contentPane.add(lblEnterCategoryBy);

		JLabel lblEnterMonthBy = new JLabel("Enter Month by number");
		lblEnterMonthBy.setForeground(Color.WHITE);
		lblEnterMonthBy.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterMonthBy.setBounds(267, 206, 131, 32);
		contentPane.add(lblEnterMonthBy);

		JLabel lblForCurrentMonth = new JLabel("For Current month outcomes");
		lblForCurrentMonth.setForeground(Color.WHITE);
		lblForCurrentMonth.setFont(new Font("Pristina", Font.BOLD, 14));
		lblForCurrentMonth.setBounds(711, 82, 157, 32);
		contentPane.add(lblForCurrentMonth);

		JLabel lblForMonthlyOutcomes = new JLabel("Total Outcomes in Entered  month");
		lblForMonthlyOutcomes.setForeground(Color.WHITE);
		lblForMonthlyOutcomes.setFont(new Font("Pristina", Font.BOLD, 14));
		lblForMonthlyOutcomes.setBounds(567, 164, 186, 32);
		contentPane.add(lblForMonthlyOutcomes);

		JLabel label_7 = new JLabel("");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Pristina", Font.BOLD, 14));
		label_7.setBounds(620, 201, 61, 32);
		contentPane.add(label_7);

		JButton btnNewButton = new JButton("Check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listener3 != null) {
					try {
						double totalOutcomes;

						totalOutcomes = FinancialManager.instance.TotalOutcomes(mid);
						label_7.setText(totalOutcomes + " $");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					infoBox("Enter Month number", "");
				}
			}
		});
		btnNewButton.setBounds(712, 209, 61, 23);
		contentPane.add(btnNewButton);
	}

}
