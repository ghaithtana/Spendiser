package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controller.AccountManager;
import Controller.FinancialManager;
import Controller.IncomeManager;
import Controller.Utils;
import Model.Account;
import Model.Income;
import javax.swing.UIManager;

public class DisplayFilteredIncome extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static JTable table;
	private JButton button;
	private JLabel label;
	private static String sdate;
	private static String edate;
	private static int id;
	private static String listener;
	private JTable table_1;
	private JTable table_2;
	private static JTable table_3;
	private static double balance;

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

	public static void addRowToTable() {

		try {
			Date ssdate = Utils.stringToDate(sdate);
			Date eedate = Utils.stringToDate(edate);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			ArrayList<Income> incomes = new ArrayList<Income>();
			incomes = IncomeManager.instance.getIncomes(id, ssdate, eedate);
			Object rowdata[] = new Object[20];
			for (int i = 0; i < incomes.size(); i++) {
				rowdata[0] = incomes.get(i).getAmount();
				rowdata[1] = incomes.get(i).getDescription();
				rowdata[2] = incomes.get(i).getDate();
				rowdata[3] = incomes.get(i).getA_ID();

				model.addRow(rowdata);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayFilteredIncome frame = new DisplayFilteredIncome();
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
	public DisplayFilteredIncome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 729);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter start Date :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Pristina", Font.BOLD, 14));
		lblNewLabel.setBounds(221, 112, 104, 20);
		contentPane.add(lblNewLabel);

		JLabel lblEnterEndDate = new JLabel("Enter End Date :");
		lblEnterEndDate.setForeground(new Color(255, 255, 255));
		lblEnterEndDate.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterEndDate.setBounds(221, 183, 104, 20);
		contentPane.add(lblEnterEndDate);

		JLabel lblEnterAccountId = new JLabel("Enter Account ID :");
		lblEnterAccountId.setForeground(new Color(255, 255, 255));
		lblEnterAccountId.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterAccountId.setBounds(212, 259, 104, 20);
		contentPane.add(lblEnterAccountId);

		textField = new JTextField();
		textField.setBounds(326, 107, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sdate = textField.getText();

			}
		});

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(326, 178, 146, 26);
		contentPane.add(textField_1);
		textField_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				edate = textField_1.getText();

			}
		});

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(326, 254, 146, 26);
		contentPane.add(textField_2);
		textField_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener = textField_2.getText();
				id = Integer.parseInt(textField_2.getText().trim());
			}
		});

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column" }));
		table.setFont(new Font("Pristina", Font.BOLD, 14));
		table.setBounds(501, 105, 354, 235);
		contentPane.add(table);

		JButton btnShowi = new JButton("");
		btnShowi.setIcon(new ImageIcon(DisplayFilteredIncome.class.getResource("/View/images/show.png")));
		btnShowi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sdate != null && edate != null && listener != null) {
					addRowToTable();
					listener = null;

				}

			}
		});
		btnShowi.setBackground(new Color(230, 230, 250));
		btnShowi.setBounds(640, 351, 82, 29);
		contentPane.add(btnShowi);

		button = new JButton("");
		button.setIcon(new ImageIcon(DisplayFilteredIncome.class.getResource("/View/images/left-arrow.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IncomeManagerForm im = new IncomeManagerForm();
				im.setVisible(true);
			}
		});
		button.setBounds(212, 0, 54, 38);
		contentPane.add(button);

		label = new JLabel("Back");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Pristina", Font.BOLD, 14));
		label.setBounds(222, 49, 32, 32);
		contentPane.add(label);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 214, 690);
		contentPane.add(panel);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(DisplayFilteredIncome.class.getResource("/View/images/user.png")));
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setBounds(65, 11, 71, 70);
		panel.add(label_1);

		JLabel label_2 = new JLabel("Current balance :");
		label_2.setForeground(new Color(0, 250, 154));
		label_2.setFont(new Font("Pristina", Font.PLAIN, 18));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(0, 148, 104, 50);
		panel.add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setForeground(new Color(0, 250, 154));
		label_3.setFont(new Font("Pristina", Font.PLAIN, 18));
		label_3.setBounds(53, 92, 86, 26);
		panel.add(label_3);

		JLabel label_7 = new JLabel("0.0 $");
		label_7.setFont(new Font("Pristina", Font.BOLD, 14));
		label_7.setBounds(114, 165, 61, 14);
		panel.add(label_7);
		try {
			balance = FinancialManager.instance.getBalance();
			label_7.setText(balance + " $");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JLabel lblShow = new JLabel("Show\r\n");
		lblShow.setForeground(Color.WHITE);
		lblShow.setFont(new Font("Pristina", Font.BOLD, 14));
		lblShow.setBounds(667, 381, 32, 32);
		contentPane.add(lblShow);

		table_1 = new JTable();
		table_1.setBackground(new Color(0, 250, 154));
		table_1.setForeground(new Color(255, 255, 255));
		table_1.setFont(new Font("Pristina", Font.BOLD, 14));
		table_1.setModel(new DefaultTableModel(new Object[][] { { " Amount", " Description", " Date", " AccountID" }, },
				new String[] { "New column", "New column", "New column", "New column" }));
		table_1.setBounds(501, 78, 354, 16);
		contentPane.add(table_1);

		JLabel label_4 = new JLabel("Filtered Incomes");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Pristina", Font.BOLD, 14));
		label_4.setBounds(599, 26, 123, 20);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("Financial Accounts\r\n");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Pristina", Font.BOLD, 17));
		label_5.setBounds(290, 351, 151, 20);
		contentPane.add(label_5);

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(new Object[][] { { " Account ID", " Account Name", "User ID" }, },
				new String[] { "New column", "New column", "New column" }));
		table_2.setForeground(Color.WHITE);
		table_2.setFont(new Font("Pristina", Font.BOLD, 14));
		table_2.setBackground(new Color(0, 250, 154));
		table_2.setBounds(235, 388, 268, 16);
		contentPane.add(table_2);

		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "New column", "New column", "New column" }));
		table_3.setFont(new Font("Pristina", Font.BOLD, 14));
		table_3.setColumnSelectionAllowed(true);
		table_3.setCellSelectionEnabled(true);
		table_3.setBorder(UIManager.getBorder("DesktopIcon.border"));
		table_3.setBounds(235, 410, 268, 157);
		contentPane.add(table_3);

		JLabel label_6 = new JLabel("Show\r\n");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Pristina", Font.BOLD, 14));
		label_6.setBounds(347, 603, 32, 32);
		contentPane.add(label_6);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAccounts();
			}
		});
		btnNewButton.setIcon(new ImageIcon(DisplayFilteredIncome.class.getResource("/View/images/show.png")));
		btnNewButton.setBounds(326, 578, 69, 23);
		contentPane.add(btnNewButton);
	}
}
